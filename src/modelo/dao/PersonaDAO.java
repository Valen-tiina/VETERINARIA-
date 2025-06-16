package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import controlador.Coordinador;
import modelo.dto.PersonaDTO;

public class PersonaDAO {
	private Coordinador coordinador;
	//coordinador
	  public void setCoordinador(Coordinador coordinador) {
	        this.coordinador = coordinador;
	    }
	  
	  Connection connection= null;
	  ConexionBD conexion = null;
	  PreparedStatement preparedStatement=null;
	  ResultSet resultSet=null;
	  
	  //metodos crud
	  //create = insert
	  public String insertarPersona(PersonaDTO persona)throws SQLException{
		  Connection connection = ConexionBD.getInstancia().getConnection();
		  if (connection==null) {
			return "error conexion";
		}
		  
		  String insert = "insert into personas (documento,telefono,nombre)values(?,?,?)";
		 try {
			preparedStatement= connection.prepareStatement(insert);
			preparedStatement.setString(1,persona.getDocumento());
			preparedStatement.setInt(2, persona.getTelefono());
			preparedStatement.setString(3, persona.getNombre());
			
			preparedStatement.execute();
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo realizar el insert"+e.getMessage());
			return "falla en insert";
		} finally {
			if (preparedStatement!=null) {
				preparedStatement.close();
			}if (connection!=null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
		}
	  }
	  
	  
	  //read = consultar
	  public PersonaDTO consultarPorDocumento(String documento)throws SQLException{
		  PersonaDTO persona = null;
		  Connection connection = ConexionBD.getInstancia().getConnection();
		  if (connection==null) {
			return null;
		}
		  String buscarID = "select * from personas where documento =?";
		  try {
			preparedStatement = connection.prepareStatement(buscarID);
			
			preparedStatement.setString(1, documento);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				persona = new PersonaDTO();
				persona.setDocumento(resultSet.getString("documento"));
				persona.setTelefono(resultSet.getInt("telefono"));
				persona.setNombre(resultSet.getString("nombre"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("no se pudo realizar la busqueda");
			return null;
		}finally {
			if (preparedStatement!=null) {
				preparedStatement.close();
			}if (connection!=null) {
				ConexionBD.getInstancia().desconectar();
			}
		}
		  return persona;
	  }
	  
	  //read all = consultar todos los registros
	  public ArrayList<PersonaDTO> consultarListaPersonas() throws SQLException{
		  Connection connection = ConexionBD.getInstancia().getConnection();
		  if (connection==null) {
			System.out.println("error conexion");
			return null;
		}
		  ArrayList<PersonaDTO> listaPersonas = new ArrayList<PersonaDTO>();
		  String consultaLista = "select * from personas";
		  
		  try {
			if (connection!=null) {
				preparedStatement = connection.prepareStatement(consultaLista);
				resultSet= preparedStatement.executeQuery(consultaLista);
				
				while(resultSet.next()) {
					PersonaDTO persona = new PersonaDTO();
					persona.setDocumento(resultSet.getString("documento"));
					persona.setNombre(resultSet.getString("nombre"));
					persona.setTelefono(resultSet.getInt("telefono"));
					
					listaPersonas.add(persona);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al buscar lista de personas");
		}finally {
			if (preparedStatement!=null) {
				preparedStatement.close();
			}if (connection!=null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
		}
		  return listaPersonas;
	  }
	  
	  //update = actualizar
	  public String actualizarPersona(PersonaDTO persona)throws SQLException{
		  Connection connection = ConexionBD.getInstancia().getConnection();
		  String resp ="";
		  if (connection==null) {
			return null;
		}
		  String actualizar ="update personas set nombre =?,telefono=? where documento=?";
		  
		  try {
			if (connection !=null) {
				preparedStatement = connection.prepareStatement(actualizar);
				
				preparedStatement.setString(1, persona.getNombre());
				preparedStatement.setInt(2, persona.getTelefono());
				preparedStatement.setString(3, persona.getDocumento());
				
				int filas = preparedStatement.executeUpdate();
		        if (filas > 0) {
		            resp = "ok";
		        } else {
		            resp = "error"; // documento no existe
		        }
			}
		} catch (Exception e) {
			System.out.println("error al actualizar datos");
			e.printStackTrace();
			resp= "error bd";
		}finally {
			if (preparedStatement!=null) {
				preparedStatement.close();
			}if (connection!=null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
		}
		  return resp;
	  }
	  
	  //delete - eliminar
	  public String eliminarPersona(PersonaDTO persona)throws SQLException{
		  Connection connection = ConexionBD.getInstancia().getConnection();
		  String resp="";
		  if (connection ==null) {
			return "error al conectar";
		}
		  String eliminar = "delete from personas where documento = ?";
		  try {
			if (connection!=null) {
				preparedStatement = connection.prepareStatement(eliminar);
				preparedStatement.setString(1, persona.getDocumento());
				int filas = preparedStatement.executeUpdate();
		        if (filas > 0) {
		            resp = "ok";
		        } else {
		            resp = "error"; // documento no existe
		        }
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al eliminar datos");
		}finally {
			if (preparedStatement!=null) {
				preparedStatement.close();
			}if (connection!=null) {
				connection.close();
				ConexionBD.getInstancia().desconectar();
			}
		}
		  return resp;
	  }
}
