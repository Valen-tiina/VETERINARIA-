package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import controlador.Coordinador;
import modelo.dto.MascotaDTO;
import modelo.dto.PersonaDTO;

public class MascotaDAO extends ModeloDAO<MascotaDTO>{
	  
	 Connection connection =null;
	 ConexionBD conexion =null;
	 PreparedStatement preparedStatement=null;
	 ResultSet resultSet =null;
	 private Coordinador coordinador;
	 
	 //Coordinator
	 public void setCoordinador(Coordinador coordinador) {
		 this.coordinador = coordinador;
	 }
	@Override
	public String registrar(MascotaDTO dto) throws SQLException {
		Connection connection = ConexionBD.getInstancia().getConnection();
		if (connection == null) {
			return "error conexion";
		}
		try {
			String consultaDueno = "select 1 from personas where documento =?";
			preparedStatement = connection.prepareStatement(consultaDueno);
			preparedStatement.setString(1, dto.getDueno().getDocumento());
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String insertPet = "insert into mascotas (raza,nombre,sexo,IDdueno)values(?,?,?,?)";
				preparedStatement = connection.prepareStatement(insertPet);
				preparedStatement.setString(1, dto.getRaza());
				preparedStatement.setString(2, dto.getNombre());
				preparedStatement.setString(3, dto.getSexo());
				preparedStatement.setString(4, dto.getDueno().getDocumento());
				preparedStatement.execute();
				return "ok";
			} else {
				return "no hay dueno";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "falla en consultas";
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
		}
	}
	@Override
	public MascotaDTO consultar(String text) throws SQLException {
		MascotaDTO pet = null;
		Connection connection = ConexionBD.getInstancia().getConnection();
		
		if (connection==null) {
			return null;
		}
		String consulta = "select * from mascotas where IDdueno =?";
		
		try {
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, text);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				pet = new MascotaDTO();
				PersonaDTO dueno = new PersonaDTO();
				pet.setNombre(resultSet.getString("nombre"));
				pet.setRaza(resultSet.getString("raza"));
				pet.setSexo(resultSet.getString("sexo"));
				dueno.setDocumento(resultSet.getString("IDdueno"));
				pet.setDueno(dueno);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo realizar la consulta");
			return null;
		} finally {
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
			if (resultSet!=null) {
				resultSet.close();
			}
			if (connection!=null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
		}
		return pet;
	}
	@Override
	public ArrayList<MascotaDTO> consultarLista() throws SQLException {
		Connection connection = ConexionBD.getInstancia().getConnection();
		if (connection == null) {
			System.out.println("error conexion");
			return null;
		}
		ArrayList<MascotaDTO> listaMascotas = new ArrayList<MascotaDTO>();
		String consulta = "select * from mascotas";
		
		try {
			preparedStatement = connection.prepareStatement(consulta);
			resultSet = preparedStatement.executeQuery(consulta);
			
			while(resultSet.next()) {
				MascotaDTO pet = new MascotaDTO();
				PersonaDTO persona = new PersonaDTO();
				
				pet.setNombre(resultSet.getString("nombre"));
				pet.setRaza(resultSet.getString("raza"));
				pet.setSexo(resultSet.getString("sexo"));
				
				persona.setDocumento(resultSet.getString("IDdueno"));
				pet.setDueno(persona);
				
				listaMascotas.add(pet);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al consultar lista mascotas");
		} finally {
			if (connection != null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
			if (resultSet!=null) {
				resultSet.close();
			}
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
		}
		return listaMascotas;
	}
	@Override
	public String actualizar(MascotaDTO dto) throws SQLException {
		Connection connection = ConexionBD.getInstancia().getConnection();
		String resp="";
		if (connection == null) {
			return null;
		}
		String consulta = "update mascotas set raza=?, sexo=?, nombre=? where IDdueno=?";
		
		try {
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1,dto.getRaza());
			preparedStatement.setString(2, dto.getSexo());
			preparedStatement.setString(3, dto.getNombre());
			preparedStatement.setString(4, dto.getDueno().getDocumento());
			int filas = preparedStatement.executeUpdate();
			if (filas >0) {
				resp = "ok";
			} else {
				resp = "error";
			}
		} catch (Exception e) {
			System.out.println("error al actualizar datos");
			e.printStackTrace();
			resp = "no actualiza";
		} finally {
			if (connection != null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} 
		return resp;
	}
	@Override
	public String eliminar(MascotaDTO dto) throws SQLException {
		Connection connection = ConexionBD.getInstancia().getConnection();
		String resp ="";
		if (connection == null) {
			return "error al conectar";
		}
		String consulta = "delete from mascotas where IDdueno =?";
		
		try {
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, dto.getDueno().getDocumento());
			int filas = preparedStatement.executeUpdate();
			if (filas >0) {
				resp = "ok";
			} else {
				resp = "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo eliminar");
		} finally {
			if (connection != null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} return resp;
	}
	 

	 
}
