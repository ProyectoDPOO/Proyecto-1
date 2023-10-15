package Modelo;

import java.util.ArrayList;
import Procesamiento.EmpresaAlquilerVehiculo;
public class Reserva {
	
	private boolean pago30;
	private Cliente cliente;
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
	private EmpresaAlquilerVehiculo Empresa;
	
	public Reserva(EmpresaAlquilerVehiculo Empresa, Cliente cliente, String categoriaVehiculo, String sedeRecogida, String sedeEntrega, String fechaRecogida, 
			 String fechaEntrega, String rangoHorasRecogida, String rangoHorasEntrega){
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
		precioPagoAnticipado = 0;

		if (this.Empresa.categorias.containsKey(categoriaVehiculo.toUpperCase())) {
			CategoriaVehiculo categoria = this.Empresa.categorias.get(categoriaVehiculo.toUpperCase());
			int preciototal = categoria.getTarifaActual();
			precioPagoAnticipado = (int) (preciototal *0.3);
		};
		return precioPagoAnticipado;
	}
	
	public ArrayList<Object>resumen(){
		resumenReserva.add(cliente.getNombre());
		resumenReserva.add(fechaEntrega);
		resumenReserva.add(sedeRecogida);
		resumenReserva.add(setSedeEntrega());
		resumenReserva.add(costoReserva);
		resumenReserva.add(precioPagoAnticipado);
		
	}
}
