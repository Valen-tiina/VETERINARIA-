package modelo;

import java.sql.SQLException;

import controlador.Coordinador;
import modelo.dao.PersonaDAO;
import modelo.dto.EntidadesDTO;
import modelo.dto.PersonaDTO;

public class ProcesosPersona extends ProcesosGenerales {
	private Coordinador coordinador;
	//coordinador
	  public void setCoordinador(Coordinador coordinador) {
	        this.coordinador = coordinador;
	    }
	@Override
	public boolean validarTexto(String texto) {
		  if (texto == null || texto.trim().isEmpty()) {
		        return false;
		    }
		    return true;
	}
	@Override
	public boolean validarNumero(String numero) {
		boolean retorno=false;
		try {
			double num=Double.parseDouble(numero);
			
			if (num>=0) {
				retorno =true;
			}else {
				retorno=false;
			}
		} catch (Exception e) {
			retorno=false;
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return retorno;
	}
	




}
