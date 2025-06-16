package modelo.dto;

public class MascotaDTO {
	private String raza;
	private String nombre;
	private String sexo;
	private PersonaDTO dueno;
	public MascotaDTO() {
		
	}
	
	public MascotaDTO(String raza, String nombre, String sexo, PersonaDTO dueno) {
		super();
		this.raza = raza;
		this.nombre = nombre;
		this.sexo = sexo;
		this.dueno=dueno;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public PersonaDTO getDueno() {
		return dueno;
	}
	
	public void setDueno(PersonaDTO dueno) {
		this.dueno = dueno;
	}

	@Override
	public String toString() {
		return "MascotaDTO [raza=" + raza +", nombre=" + nombre + ", sexo=" + sexo + "id Dueño="+ dueno+"]";
	}
	
}
