package Modelo;

import java.util.ArrayList;

public class Reserva {
	
	private boolean pago30;
	private String cliente;
	private String categoriaVehiculo;
	private String sedeRecogida;
	private String sedeEntrega;
	private String fechaRecogida;
	private String fechaEntrega;
	private String rangoHorasRecogida;
	private String rangoHorasEntrega;
	private int costoReserva;
	private int precioPagoAnticipado;
	private ArrayList<Object> resumenReserva;
	
	public Reserva(String cliente, String categoriaVehiculo, String sedeRecogida, String sedeEntrega, String fechaRecogida, 
			 String fechaEntrega, String rangoHorasRecogida, String rangoHorasEntrega){
		
		this.cliente = cliente;
		this.categoriaVehiculo = categoriaVehiculo;
		this.sedeRecogida = sedeRecogida;
		this.sedeEntrega = sedeEntrega;
		this.fechaRecogida = fechaRecogida;
		this.fechaEntrega = fechaEntrega;
		this.rangoHorasRecogida = rangoHorasRecogida;
		this.rangoHorasEntrega = rangoHorasEntrega;
		this.precioPagoAnticipado = 0; 
		
	}
	
	public void setFechaRecogida(){
	}
			
	public void setSedeRecogida(){		
	}
	
	public void setFechaEntrega(){		
	}
			
	public void setSedeEntrega(){		
	}
	
	public int getCostoReserva() {		
		return costoReserva;
	}
	
	public int getprecioPagoAnticipado() {
		return precioPagoAnticipado;
	}
	
	public ArrayList<Object>resumen(){
		resumenReserva.add(setFechaRecogida());
		resumenReserva.add(setFechaEntrega());
		resumenReserva.add(setSedeRecogida());
		resumenReserva.add(setSedeEntrega());
		resumenReserva.add(costoReserva);
		resumenReserva.add(precioPagoAnticipado);
		
	}
}
