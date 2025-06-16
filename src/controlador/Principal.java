package controlador;

import conexionBD.ConexionBD;
public class Principal {
	public static void main(String[] args) {
		new Relaciones();
		ConexionBD conexion = ConexionBD.getInstancia();
	}
}
