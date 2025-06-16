package conexionBD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {
	
	private static ConexionBD instancia;
	private Connection conn=null;
	
	//.properties
	private String url, usuario,password,nombreBd;
	
	public ConexionBD() {
		try {
			Properties properties = new Properties();
			FileInputStream input = new FileInputStream("C:\\Users\\VALENTINA\\Documents\\TERCER TRIMESTRE\\JAVA\\VETERINARIA\\src\\properties\\config.properties");
			properties.load(input);
			
			String driver = properties.getProperty("db.driver");
			url = properties.getProperty("db.url");
			usuario = properties.getProperty("db.usuario");
			password = properties.getProperty("db.password");
			nombreBd = properties.getProperty("db.nombreBd");
			
			//cargar dirver
			Class.forName(driver);
			
			//establecer conexion
			conn = DriverManager.getConnection(url,usuario,password);
			
			if (conn != null) {
				System.out.println("Conexion exitosa a la base de datos"+nombreBd);
			}else {
				System.out.println("ERROR al conectar con la base de datos"+nombreBd);
			}
		} catch (ClassNotFoundException e) {
            System.out.println("Error: Driver no encontrado -> " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión SQL: " + e.getMessage());
            System.out.println("¿MySQL está corriendo?");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
        }
    }
	
	public static ConexionBD getInstancia() {
		if (instancia==null) {
			instancia = new ConexionBD();
		} return instancia;
	}
	
	public Connection getConnection() {
		try {
			if (conn==null||conn.isClosed()) {
				conn= DriverManager.getConnection(url,usuario,password);
				System.out.println("Se reconecto a la base de datos"+nombreBd);
			}
		} catch (Exception e) {
			System.out.println("Error al reconectar: "+e.getMessage());
		}
		return conn;
	}
	
	public void desconectar() {
		conn =null;
	}
}
