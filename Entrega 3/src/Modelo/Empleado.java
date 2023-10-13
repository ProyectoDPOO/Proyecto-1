package Modelo;

import java.util.ArrayList;

public class Empleado extends Usuario{
	private String rol;
	private String sede;
	private ArrayList<Object> resumen;
	public Empleado(String nombreUsuario, String contraseña, String rol, String sede) {
		super(nombreUsuario, contraseña);
		this.rol = rol;
		this.sede = sede;
	}
	
	public String getNombreEmpleado() {
		return this.getNombreUsuario();
	}
	
	public String getRol() {
		return rol;
	}

	
	public String getSede() {
		return sede;
	}

	public ArrayList<Object> resumenEmpleado() {
		resumen.add(this.getNombreUsuario());
		resumen.add(this.getContraseña());
		resumen.add(rol);
		resumen.add(sede);		
		return resumen;
	}
	
	
}
