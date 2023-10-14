package Modelo;

import java.util.ArrayList;

public class Alquiler {
	
	private String fechaRecogida;
	private String rangoHorasRecogida;
	private String sedeRecogida;
	private String fechaEntrega;
	private String rangoHorasEntrega;
	private String sedeEntrega;
	private String conductor;
	private String conductorAdicional;
	
	private ArrayList<Object> resumenAlquiler;
	
	public Alquiler(String vehiculo, String cliente, String fechaRecogida, String rangoHorasRecogida, String sedeRecogida, String fechaEntrega, String rangoHorasEntrega, String sedeEntrega, ArrayList<Seguro>segurosusados, ArrayList<ConductorAdicional>conductores){
		
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.fechaRecogida = fechaRecogida;
		this.rangoHorasRecogida = rangoHorasRecogida;
		this.sedeRecogida = sedeRecogida;
		this.fechaEntrega = fechaEntrega;
		this.rangoHorasEntrega = rangoHorasEntrega;
		this.sedeEntrega = sedeEntrega;
	}
	
	public void registroConductoresAdicionales(String conductorAdicional) {
		this.conductorAdicional = conductorAdicional;
	}
	
	public void agregarSeguros(String seguro) {
		
	}
	
	public void asignarVehiculo(String categoria) {
		
	}
	
	public String getCliente() {
		return this.getCliente();
	}
	
	public String getVehiculo() {
		return this.getVehiculo();
	}
	
	private static int numeroReserva = 1;
	public int generarNumeroAlquiler() {
		int reservaActual = numeroReserva;
	    numeroReserva++; 
	    return reservaActual;
	  }
	
	public int generarPrecioFinal() {
		if (categoriasDeVehiculos.containsKey(categoria)) {
            return categoriasDeVehiculos.get(categoria);
        }
	}
	
	public ArrayList<Object>resumen(){
		resumenAlquiler.add(registroConductoresAdicionales());
		resumenAlquiler.add(agregarSeguros());
		resumenAlquiler.add(asignarVehiculo());
		resumenAlquiler.add(getCliente());
		resumenAlquiler.add(getVehiculo());
		resumenAlquiler.add(generarNumeroAlquiler);
}
}
