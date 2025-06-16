package controlador;

import conexionBD.ConexionBD;
import modelo.ProcesosGenerales;
import modelo.ProcesosMascota;
import modelo.ProcesosPersona;
import modelo.dao.MascotaDAO;
import modelo.dao.PersonaDAO;
import vistas.VentanaGestionarMascota;
import vistas.VentanaGestionarPersona;
import vistas.VentanaPrincipal;

public class Relaciones {
	
	public Relaciones() {
		//instancia clases
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		VentanaGestionarMascota ventanaMascota = new VentanaGestionarMascota(ventanaPrincipal, true);
		VentanaGestionarPersona ventanaPersona = new VentanaGestionarPersona(ventanaPrincipal, true);
		//ProcesosGenerales procesosGenerales = new ProcesosGenerales();
		ProcesosMascota procesosMascota = new ProcesosMascota();
		ProcesosPersona procesosPersona = new ProcesosPersona();
		PersonaDAO personaDAO = new PersonaDAO();
		MascotaDAO mascotaDAO = new MascotaDAO();
		//ConexionBD conexionBD = new ConexionBD();
		Coordinador coordinador = new Coordinador();
		
		//relacion con coordinador
		coordinador.setMascotaDAO(mascotaDAO);
		coordinador.setPersonaDAO(personaDAO);
		coordinador.setProcesosMascota(procesosMascota);
		coordinador.setProcesosPersona(procesosPersona);
		coordinador.setVentanaPersona(ventanaPersona);
		coordinador.setVentanaMascota(ventanaMascota);
		coordinador.setVentanaPrincipal(ventanaPrincipal);
		//coordinador.setProcesosGenerales(procesosGenerales);
		
		//asignar ventanas al coordinador
		ventanaPrincipal.setCoordinador(coordinador);
		ventanaMascota.setCoordinador(coordinador);
		ventanaPersona.setCoordinador(coordinador);
		personaDAO.setCoordinador(coordinador);
		mascotaDAO.setCoordinador(coordinador);
		procesosMascota.setCoordinador(coordinador);
		procesosPersona.setCoordinador(coordinador);
		
		coordinador.mostrarVentanaPrincipal();
	}
}
