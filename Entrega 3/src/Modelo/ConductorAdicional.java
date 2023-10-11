package Modelo;

public class ConductorAdicional {


	private String nombre;
	private String identificacion;
	private String telefono;
	private String correo;

	public ConductorAdicional(String nombre,String identificacion, String telefono, String correo){
		
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public String getNombre() {
	
		return this.nombre;	
	
	}
	
	public String getTelefono() {
		
		return this.telefono;	
	
	}
	
	public String getCorreo() {
		
		return this.correo;	
	
	}
	
	public String getLicencia(String identificacion) {
		
		return this.identificacion;	
	
	}

	
}
