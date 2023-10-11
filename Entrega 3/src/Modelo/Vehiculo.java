package Modelo;

public class Vehiculo {


	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String transmision;
	private String estado;
	private int capacidad;
	private String categoria;

	public Vehiculo(String placa, String marca, String modelo, String color, String transmision) {
		
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.transmision = transmision;

	}

	public String getPlaca() {
		
		return this.placa;	
	
	}
	
	public String getMarca() {
		
		return this.marca;	
	
	}
	
	public String getModelo() {
		
		return this.modelo;	
	
	}
	
	public String getColor() {
		
		return this.color;	
	
	}
	
	public String getTransmision() {
		
		return this.transmision;	
	
	}
		
	public String getCategoria() {
		
		return this.categoria;	
	
	}
	
	public String getEstado() {
		
		return this.estado;	
	
	}
	
	public int getCapacidad() {
		
		return this.capacidad;	
	
	}
	
}

