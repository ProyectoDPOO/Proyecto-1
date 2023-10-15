package Modelo;

import java.util.ArrayList;
import Procesamiento.EmpresaAlquilerVehiculo;
public class Reserva {
	
	private Cliente cliente;
	private CategoriaVehiculo categoriaVehiculo;
	private String sedeRecogida;
	private String sedeEntrega;
	private String fechaRecogida;
	private String fechaEntrega;
	private String rangoHorasRecogida;
	private String rangoHorasEntrega;
	private int costoReserva;
	private int precioPagoAnticipado;
	private ArrayList<String> resumenReserva;
	private EmpresaAlquilerVehiculo Empresa;
	
	public Reserva(EmpresaAlquilerVehiculo Empresa, Cliente cliente, CategoriaVehiculo categoriaVehiculo, String sedeRecogida, 
			String sedeEntrega, String fechaRecogida, String fechaEntrega, String rangoHorasRecogida, String rangoHorasEntrega){
		this.Empresa = Empresa;
		this.cliente = cliente;
		this.categoriaVehiculo = categoriaVehiculo;
		this.sedeRecogida = sedeRecogida;
		this.sedeEntrega = sedeEntrega;
		this.fechaRecogida = fechaRecogida;
		this.fechaEntrega = fechaEntrega;
		this.rangoHorasRecogida = rangoHorasRecogida;
		this.rangoHorasEntrega = rangoHorasEntrega;
		
		
	}
	
	public String setFechaRecogida(){
		return this.fechaRecogida;
	}
			
	public String setSedeRecogida(){	
		return this.sedeRecogida;
	}
	
	public String setFechaEntrega(){
		return this.fechaEntrega;
	}
			
	public String setSedeEntrega(){
		return this.sedeEntrega;
	}
	
	public int getCostoReserva() {		
		return costoReserva;
	}
	
	public int getprecioPagoAnticipado() {
		precioPagoAnticipado = 0;

		if (this.Empresa.categorias.containsKey(categoriaVehiculo.toUpperCase())) {
			CategoriaVehiculo categoria = this.Empresa.categorias.get(categoriaVehiculo.toUpperCase());
			int preciototal = categoria.getTarifaActual();
			precioPagoAnticipado = (int) (preciototal *0.3);
		};
		return precioPagoAnticipado;
	}
	
	public ArrayList<String> resumenReserva()
	{
		resumenReserva.add(cliente.getNombre());
		resumenReserva.add(fechaEntrega);
		resumenReserva.add(sedeRecogida);
		resumenReserva.add(sedeEntrega);
		resumenReserva.add(String.valueOf(costoReserva));
		resumenReserva.add(String.valueOf(precioPagoAnticipado));
		
		return resumenReserva;
	}
}
