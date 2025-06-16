package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import modelo.ProcesosMascota;
import modelo.ProcesosPersona;
import modelo.dao.MascotaDAO;
import modelo.dao.PersonaDAO;
import vistas.VentanaGestionarMascota;
import vistas.VentanaGestionarPersona;
import vistas.VentanaPrincipal;
import modelo.dto.PersonaDTO;
import modelo.dto.MascotaDTO;
public class Coordinador {
	private VentanaPrincipal ventanaPrincipal;
	private VentanaGestionarMascota ventanaMascota;
	private VentanaGestionarPersona ventanaPersona;
	//private ProcesosGenerales procesosGenerales;
	private ProcesosMascota procesosMascota;
	private ProcesosPersona procesosPersona;
	private PersonaDAO personaDAO;
	private MascotaDAO mascotaDAO;
	private ConexionBD conexionBD;
	
	//setters de c/u
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	public void setVentanaMascota(VentanaGestionarMascota ventanaMascota) {
		this.ventanaMascota = ventanaMascota;
	}
	public void setVentanaPersona(VentanaGestionarPersona ventanaPersona) {
		this.ventanaPersona = ventanaPersona;
	}
	//public void setProcesosGenerales(ProcesosGenerales procesosGenerales) {
	//	this.procesosGenerales = procesosGenerales;
	//}
	public void setProcesosMascota(ProcesosMascota procesosMascota) {
		this.procesosMascota = procesosMascota;
	}
	public void setProcesosPersona(ProcesosPersona procesosPersona) {
		this.procesosPersona = procesosPersona;
	}
	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}
	public void setMascotaDAO(MascotaDAO mascotaDAO) {
		this.mascotaDAO = mascotaDAO;
	}
	public void setConexionBD(ConexionBD conexionBD) {
		this.conexionBD = conexionBD;
	}
	
	//mostrar ventanas
	
	public void mostrarVentanaPrincipal() {
		ventanaPrincipal.setVisible(true);
	}
	public void mostrarVentanaPersonas() {
		ventanaPersona.setVisible(true);
	}
	public void mostrarVentanaMascotas() {
		ventanaMascota.setVisible(true);
	}
	
	//validations person
	public boolean validarTextoPersona(String texto) {
		return procesosPersona.validarTexto(texto);
	}
	public boolean validarNumPersona(String numero) {
		return procesosPersona.validarNumero(numero);
	}
	
	//validations pet
	public boolean validarTextoMascota(String texto) {
		return procesosMascota.validarTexto(texto);
	}
	public boolean validarNumMascota(String numero) {
		return procesosMascota.validarNumero(numero);
	}
	
	//coordinator + crud personas
	public String guardarPersona(PersonaDTO persona)throws SQLException{
		return personaDAO.insertarPersona(persona);
	}
	public ArrayList<PersonaDTO> listaPersonas()throws SQLException{
		return personaDAO.consultarListaPersonas();
	}
	public PersonaDTO buscarPorDocumento(String documento) throws SQLException{
		return personaDAO.consultarPorDocumento(documento);
	}
	public String actualizarPersona(PersonaDTO persona)throws SQLException{
		return personaDAO.actualizarPersona(persona);
	}
	public String eliminarPersona(PersonaDTO persona)throws SQLException{
		return personaDAO.eliminarPersona(persona);
	}
	
	
	//coordinator + crud mascotas
	/*public String guardarMascota(MascotaDTO mascota)throws SQLException{
		return
	}
	public ArrayList<MascotaDTO> listaMascotas()throws SQLException{
		return
	}
	public MascotaDTO buscarMascotaPorID(String documento)throws SQLException{
		return
	}
	public String actualizarMascota(MascotaDTO mascota)throws SQLException{
		return
	}
	public String eliminarMascota(MascotaDTO mascota)throws SQLException{
		return
	}
	*/
}
