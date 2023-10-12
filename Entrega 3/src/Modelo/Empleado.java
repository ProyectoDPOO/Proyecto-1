package Modelo;

public class Empleado extends Usuario{
	private String rol;
	private String sede;
	
	public Empleado(String nombreUsuario, String contraseña, String rol, String sede) {
		super(nombreUsuario, contraseña);
		this.rol = rol;
		this.sede = sede;
	}

	public String getRol() {
		return rol;
	}


	public String getSede() {
		return sede;
	}

	
	
	
}
