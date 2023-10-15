package Modelo;

import java.util.ArrayList;

import Procesamiento.EmpresaAlquilerVehiculo;

public class Alquiler {
	private Vehiculo vehiculo;
	private String fechaRecogida;
	private String rangoHorasRecogida;
	private String sedeRecogida;
	private String fechaEntrega;
	private String rangoHorasEntrega;
	private String sedeEntrega;
	private ArrayList<ConductorAdicional> conductorAdicional;
	private ArrayList<Seguro> seguros;
	private ArrayList<Object> resumenAlquiler;
	private EmpresaAlquilerVehiculo Empresa;
	
	public Alquiler(EmpresaAlquilerVehiculo Empresa,Vehiculo vehiculo, Cliente cliente, String fechaRecogida, String rangoHorasRecogida, String sedeRecogida, String fechaEntrega, String rangoHorasEntrega, String sedeEntrega, ArrayList<Seguro>segurosusados, ArrayList<ConductorAdicional>conductores){
		
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.fechaRecogida = fechaRecogida;
		this.rangoHorasRecogida = rangoHorasRecogida;
		this.sedeRecogida = sedeRecogida;
		this.fechaEntrega = fechaEntrega;
		this.rangoHorasEntrega = rangoHorasEntrega;
		this.sedeEntrega = sedeEntrega;
		this.Empresa = Empresa;
	}
	
	public void registroConductoresAdicionales(String conductorAdicional) {
		this.conductorAdicional = conductorAdicional;
	}
	
	public void agregarSeguros(Seguro seguro) {
		seguros.add(seguro);
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
		int  preciovehiculo =0;
		int precioConductorAdicional = 0;
		int otrasede = 0;
		int total = 0;
		String categoriaVehiculo = vehiculo.getCategoria();
		if (this.Empresa.categorias.containsKey(categoriaVehiculo.toUpperCase())) {
			CategoriaVehiculo categoria = this.Empresa.categorias.get(categoriaVehiculo.toUpperCase());
			preciovehiculo = categoria.getTarifaActual();
			precioConductorAdicional = categoria.getTarifaConductorAdicional();
			otrasede= categoria.getTarifaOtraSede();}
		
		
		int totalconductores = precioConductorAdicional* tamañlista condcutores adicionales
				
		int preciosSeguros = 0;
		for (ciclos seguros)
			segurocilco. utilizar metodo de seguros para retornar precio
			
		comparas si a seds es son diferentes 
			
		return total;
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
