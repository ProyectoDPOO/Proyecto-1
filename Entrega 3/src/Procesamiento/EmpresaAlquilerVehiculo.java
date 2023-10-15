package Procesamiento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import Modelo.Cliente;
import Modelo.ConductorAdicional;
import Modelo.Empleado;
import Modelo.Sede;
import Modelo.Usuario;
import Modelo.Vehiculo;
import Modelo.Seguro;
import Modelo.EstadoVehiculo;

public class EmpresaAlquilerVehiculo {
	
	private Map<String, Usuario> usuarios;
	private Map<String, Vehiculo> inventario;
	private Map<String, Sede> sedes;
	private Map<String, Empleado> empleados;
	private Map<String, Seguro> seguros;
	private Map<String, EstadoVehiculo> estadoVehiculo;
	private Map<String, Cliente> clientes;
	private Map<String, ConductorAdicional> conductorAdicional;

	
	public EmpresaAlquilerVehiculo() 
	{
		usuarios = new HashMap<>();
		this.inventario = new HashMap<>();
		sedes = new HashMap<>();
		empleados = new HashMap<>();
		seguros = new HashMap<>();
		estadoVehiculo = new HashMap<>();
		clientes = new HashMap<>();
		conductorAdicional = new HashMap<>();

	}
	
	 public boolean verificarUsuario(String usuario)
	 {
		return usuarios.containsKey(usuario);
	 }
	 
	 public Usuario inicioSesion(String usuario, String contrasena) 
	 {
		 if(usuarios.containsKey(usuario)) {
			 
			 Usuario user = usuarios.get(usuario);
			 
			 if( user.getContraseña().equals(contrasena))
			 {
				 return user;
			 }
		 }
		 
		 return null;
	 }
		
		public void registrarUsuario(String usuario, String contrasena, String rol)
		{
			{
				boolean continuar = true;
				while (continuar)
				{
				try
				{
					if(!verificarUsuario(usuario)) 
					{
						 try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.csv", true))) {
						        writer.write(usuario + "," + contrasena + "," + rol.toString() + "\n");
						    } 
						 catch (IOException e) 
						 	{
						        // Manejar cualquier excepción de E/S que pueda ocurrir al escribir en el archivo CSV
						        e.printStackTrace();
						    }
					}
					else 
					{
						System.out.println("El nombre del usuario ya existe");
						System.out.println("1. Volver a intentar");
						System.out.println("2. Salir");
						int opcionSeleccionada = Integer.parseInt(input("Digite opcion"));
						if (opcionSeleccionada == 2)
						{
							System.out.println("Saliendo de la aplicación ...");
							continuar = false;
						}
							
					}
				}

				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}
				}
			}    
		}
	 
	public String iniciarSesion()
		{
				boolean continuar = true;
				while (continuar)
				{
					try
					{
					String nombre= input("Ingresar Nombre Usuario:");
					
					if(verificarUsuario(nombre)) 
					{
						boolean ingreso = true;
						while (ingreso)
						{
						String contrasena = input("Ingresar Contraseña:");
						Usuario usuario = inicioSesion(nombre,contrasena);
						if (usuario!= null)
						{	
							String rol = "Cliente";
							if (usuario.getRol() != null) {
								rol = usuario.getRol().toString();
							}
							return rol;
						}
						else {
							System.out.println("No coincide");
							System.out.println("1. Volver a intentar");
							System.out.println("2. Salir");
							int opcionSeleccionada = Integer.parseInt(input("Digite opcion"));
							if (opcionSeleccionada == 2)
							{
								System.out.println("Saliendo de la aplicación ...");
								ingreso = false;
							}
							
						}
						}
					}
					}
					catch (NumberFormatException e)
					{
						System.out.println("Debe seleccionar uno de los números de las opciones.");
					}
				}
				return null;
		}
		

	
	public void registrarVehiculo(String placa, String marca, String modelo, String color, String transmision, 
			int capacidad, String categoria, String estado, String sedeActual, String fechadisponible) 
	{
		  Vehiculo newVehiculo = new Vehiculo(placa, marca, modelo,color,transmision,capacidad,categoria,estado, sedeActual, fechadisponible);
		  inventario.put(placa, newVehiculo);
		  
	}
	
	public void eliminarVehiculo(String placa) 
	{
	    if (inventario.containsKey(placa)) {
	        inventario.remove(placa);
	    }
	}
	
	public void trasladarVehiculo(String placa, String destino) {

	    Vehiculo vehiculo = null;
	    for (Vehiculo carro : inventario.values()) {
	        if (carro.getPlaca().equals(placa)) {
	            vehiculo = carro;
	            break;
	        }
	    }
	    if (vehiculo != null) 
	    {
	        EstadoVehiculo estadoVehiculo = vehiculo.getEstado();
	        if (estadoVehiculo != null) 
	        {
	           String sedeActual = estadoVehiculo.getsedeActual();
	            if (!sedeActual.equals(destino)) 
	            {
	                estadoVehiculo.setSedeActual(destino);
	            } 
	            else
	            {
	                System.out.println("Traslado extitoso.");
	            }
	        } 
	    } 
	    else 
	    {
	       System.out.println("No se encontró vehículo");
	    }
	}
	
	public void registrarConductorAdicional(String nombre,String identificacion, String telefono, String correo, String numeroLicencia,String paisExpedicion, String fechaLicencia, String imgLicencia)
	{
		ConductorAdicional nuevoConductorAdicional = new ConductorAdicional( nombre, identificacion,  telefono,  correo,  numeroLicencia, paisExpedicion,  fechaLicencia,  imgLicencia);
		conductorAdicional.put(identificacion, nuevoConductorAdicional);
	}
	
	public void generarReserva()
	{
		return 0;
		
	}
	
	public void generarAlquiler(){
		return 0;
		
	}
	
	public void actualizarEstado(String placa, String estadoNuevo)
	{
		Vehiculo vehiculo = inventario.get(placa);
		if (vehiculo != null)
		{
			EstadoVehiculo estadoVehiculo = vehiculo.getEstado();
			if(estadoVehiculo != null)
			{
				estadoVehiculo.actualizarEstado(estadoNuevo);
			}
		}
		else 
		{
			System.out.println("Vehículo no existe");
		}
	}

	
	public void crearSeguro(String nombre, int costo)
	{
		Seguro newSeguro = new Seguro(nombre, costo);
		seguros.put(nombre, newSeguro);	
	}
	

	public void registrarEmpleado(String nombre,String nombreUsuario, String contrasena, String rol, String sede)
	{
		if (!empleados.containsKey(nombre)) {
	        Empleado nuevoEmpleado = new Empleado(nombre, nombreUsuario, contrasena, rol, sede);
	        empleados.put(nombreUsuario, nuevoEmpleado);
	     
	    } else {
	        System.out.println("Ya existe");
	    }
	}
	
	public void mostrarEmpleado(String nombre) 
	{
		Empleado empleado = empleados.get(nombre);
		
		if (empleado != null) 
		{
		ArrayList<String> resumen = empleado.resumenEmpleado();
		System.out.println("\nInformación del empleado:\n");
			for (String detalle: resumen) 
			{
				System.out.println(detalle);
			}
			}
		else{
			System.out.println("No se encontro");
		}
	}
	
	public void registrarCliente(String nombre, String nombreUsuario, String contrasena,String fechaDeNacimiento, String telefono,
			String nacionalidad, String imgDocidentidad, String identificacion,String numeroLicencia,
			String paisExpedicion, String fechaLicencia, String imgLicencia,String tipoPago, 
			String numeroMedioPago, String fechaVencimientoMedioPago)
	{
		if (!clientes.containsKey(nombre)) {
		Cliente newCliente = new Cliente( nombre,nombreUsuario,  contrasena,  fechaDeNacimiento,  telefono,
				 nacionalidad,  imgDocidentidad,  identificacion, numeroLicencia,
				 paisExpedicion,  fechaLicencia,  imgLicencia, tipoPago, 
				 numeroMedioPago, fechaVencimientoMedioPago);
		clientes.put(nombreUsuario, newCliente);
		}else {
	        System.out.println("Ya existe");
	    }
	}
	
	public void mostrarCliente(String nombre) 
	{
		Cliente cliente = clientes.get(nombre);
		
		if (cliente != null) 
		{
		ArrayList<String> resumen = cliente.resumenCliente();
		System.out.println("\nInformación del cliente:\n");
			for (String detalle: resumen) 
			{
				System.out.println(detalle);
			}
			}
		else{
			System.out.println("No se encontro");
		}
	}
		
	public void gestionSede(String nombreSede, String ubicacion, int horarioAtencion, String adminLocal2) {
		
		Empleado adminLocal = empleados.get(adminLocal2);

		Sede newSede = new Sede(nombreSede, ubicacion, horarioAtencion, adminLocal);
		sedes.put(nombreSede, newSede);
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}


}
