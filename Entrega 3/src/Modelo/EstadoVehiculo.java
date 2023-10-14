package Modelo;

public class EstadoVehiculo {
	
	private String estado;
	private String sedeActual;
	private String fechaDisponibilidad;
	
	public EstadoVehiculo(String estado, String sedeActual, String fechaDisponibilidad){
		this.estado = estado;
		this.sedeActual = sedeActual;
		this.fechaDisponibilidad = fechaDisponibilidad;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getsedeActual() {
		return this.sedeActual;
	}
	
	public String getfechaDisponibilidad() {
		return this.fechaDisponibilidad;
	}
}
