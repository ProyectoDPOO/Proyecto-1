package Modelo;
import java.util.ArrayList;

public class CategoriaVehiculo {
	private String nombreCategoria;
	private int tarifaTemporadaAlta;
	private int tarifaTemporadaBaja;
	private int tarifaConductorAdicional;
	private int tarifaEntregarOtraSede;
	private static boolean temporadaAlta;
	private ArrayList<Object> resumen;
	public CategoriaVehiculo(String nombreCategoria, int tarifaTemporadaAlta, int tarifaTemporadaBaja,
			int tarifaConductorAdicional, int entregarOtraSede, boolean temporadaAlta) {

		this.nombreCategoria = nombreCategoria;
		this.tarifaTemporadaAlta = tarifaTemporadaAlta;
		this.tarifaTemporadaBaja = tarifaTemporadaBaja;
		this.tarifaConductorAdicional = tarifaConductorAdicional;
		this.tarifaEntregarOtraSede = entregarOtraSede;
		CategoriaVehiculo.temporadaAlta = temporadaAlta;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}


	public int getTarifaTemporadaAlta() {
		return tarifaTemporadaAlta;
	}

	public void setTarifaTemporadaAlta(int tarifaTemporadaAlta) {
		this.tarifaTemporadaAlta = tarifaTemporadaAlta;
	}

	public int getTarifaTemporadaBaja() {
		return tarifaTemporadaBaja;
	}

	public void setTarifaTemporadaBaja(int tarifaTemporadaBaja) {
		this.tarifaTemporadaBaja = tarifaTemporadaBaja;
	}

	public int getTarifaConductorAdicional() {
		return tarifaConductorAdicional;
	}

	public void setTarifaConductorAdicional(int tarifaConductorAdicional) {
		this.tarifaConductorAdicional = tarifaConductorAdicional;
	}

	public int getTarifaOtraSede() {
		return tarifaEntregarOtraSede;
	}

	public void setTarifaOtraSede(int entregarOtraSede) {
		this.tarifaEntregarOtraSede = entregarOtraSede;
	}

	public boolean isTemporadaAlta() {
		return temporadaAlta;
	}

	public void setTemporadaAlta(boolean temporadaAlta) {
		CategoriaVehiculo.temporadaAlta = temporadaAlta;
	}
	
	public int getTarifaActual() {
		if (temporadaAlta) {
			return tarifaTemporadaAlta;}
		else {return tarifaTemporadaBaja;}
	}
	
	public ArrayList<Object> resumenCategoria() {
		resumen.add(nombreCategoria);
		resumen.add(tarifaTemporadaAlta);
		resumen.add(tarifaTemporadaBaja);
		resumen.add(tarifaConductorAdicional);
		resumen.add(tarifaEntregarOtraSede);
		resumen.add(temporadaAlta);
		return resumen;
	}
		

}
