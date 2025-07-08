package modelo.dto;

public class PersonaDTO implements EntidadesDTO{
	private String documento;
	private String nombre;
	private int telefono;
	public PersonaDTO() {
		
	}
	
	public PersonaDTO(String documento, String nombre, int telefono) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "PersonaDTO [documento=" + documento + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
}
