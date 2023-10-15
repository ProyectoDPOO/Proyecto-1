package Aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Procesamiento.EmpresaAlquilerVehiculo;
	
public class SistemaEmpresa {
	
	private EmpresaAlquilerVehiculo empresa;
		
		
	public static void main(String[] args)
	{
			
		SistemaEmpresa sistema = new SistemaEmpresa();
		sistema.empresa = new EmpresaAlquilerVehiculo();
		sistema.ejecutarMenuInicial();
			
			
	}
	
	public void menuInicial()
	{
		System.out.println("\nBienvenid@\n");
		System.out.println("1. Iniciar sesion");
		System.out.println("2. Registrarse si es nuevo cliente");
		System.out.println("3. Salir del sistema\n");
	}
		
		public void ejecutarMenuInicial() {
				System.out.println("Bienvenid@\n");

				boolean continuar = true;
				while (continuar)
				{
					try
					{
						menuInicial();
					int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción "));
						
						if (opcion_seleccionada == 1)
						{ 
							System.out.println("Iniciar sesión\n");
							String rol = empresa.iniciarSesion();
							if (rol != null) 
							{
								switch(rol)
								{
								case "Administracion":
									
									ejecutarOpcionAdministracion();
									
								break;
								
								case "Administrador_sede":
									
									ejecutarOpcionAdminSede();
									
								break;
								case "Empleado":
									ejecutarOpcionEmpleado();
								break;
								
								case "Cliente":
									ejecutarOpcionCliente();
								break;
								
								default: 
								
									System.out.println("No es valido");
									break;
								
								}
							}
						
						}
							
						else if(opcion_seleccionada == 2)
						{ 
							System.out.println("Registrate si eres nuevo cliente\n");
							
							String nombreUsuario1 = input("Ingrese el nombre de usuario:");
						    String contrasena1 = input("Ingrese la contraseña:");
						    empresa.registrarUsuario(nombreUsuario1, contrasena1, "Cliente");
						    String nombre1 = input("Ingrese el nombre del cliente:");
						    String fechaDeNacimiento = input("Ingrese la fecha de nacimiento:");
						    String telefono = input("Ingrese el número de teléfono:");
						    String nacionalidad = input("Ingrese la nacionalidad:");
						    String imgDocidentidad = input("Ingrese la imagen del documento de identidad: ");
						    String identificacion = input("Ingrese el número de identificación");
						    String numeroLicencia = input("Ingrese el número de licencia de conducir");
						    String paisExpedicion = input("Ingrese el país de expedición de la licencia:");
						    String fechaLicencia = input("Ingrese la fecha de expedición de la licencia:");
						    String imgLicencia = input("Ingrese la imagen de la licencia de conducir:");
						    String tipoPago = input("Ingrese el tipo de pago:");
						    String numeroMedioPago = input("Ingrese el número de medio de pago:");
						    String fechaVencimientoMedioPago = input("Ingrese la fecha de vencimiento del medio de pago del cliente:");
						    empresa.registrarCliente(nombre1, nombreUsuario1, contrasena1, fechaDeNacimiento, telefono, nacionalidad, imgDocidentidad, identificacion, numeroLicencia,
						    						paisExpedicion, fechaLicencia, imgLicencia, tipoPago, numeroMedioPago, fechaVencimientoMedioPago);
						    continuar = false;
						break; 
						}
						
						else if (opcion_seleccionada == 3)
						{
							System.out.println("Saliendo de la aplicación ...");
							continuar = false;
						}
					}
					catch (NumberFormatException e)
					{
						System.out.println("Debe seleccionar uno de los números de las opciones.");
					}
				}
		}
		
		public static void mostrarOpcionesAdministracion()
		{
			System.out.println("\nOpciones de Administracion\n");
			System.out.println("1. Gestionar sedes");
			System.out.println("2. Gestionar vehiculo");
			System.out.println("3. Creacion seguro");
			System.out.println("4. Registrar Categoria");
			System.out.println("5. Actualizar Categoria");
			System.out.println("6. Salir del sistema\n");
		}
		
		public void ejecutarOpcionAdministracion() 
		{
			boolean continuar = true;
			while(continuar) {
				mostrarOpcionesAdministracion();
				int opcion = Integer.parseInt(input("Por favor seleccione una opción "));
				switch (opcion) {
				case 1:
					   String nombreSede = input("Ingrese el nombre de la sede:");
					   String ubicacion = input("Ingrese la ubicación de la sede:");
					   int horarioAtencion = Integer.parseInt(input("Ingrese el horario de atención (ej,8am-5pm):"));
					   String adminLocal = input("Ingrese el nombre del administrador local:");
					   empresa.gestionSede(nombreSede, ubicacion, horarioAtencion,adminLocal);
				break;
				
				case 2:
					ejecutarOpcionesVehiculo();
				break;
			
				case 3:
					 String tipoSeguro = input("Ingrese el tipo de seguro: ");
					 int costo = Integer.parseInt(input("Ingrese el costo del seguro por día: "));
					   empresa.crearSeguro(tipoSeguro, costo);
				break;
				
				case 4:
					System.out.println("completar informacion");
					String nombreCategoria = input("Nombre de la categoría:");
				    int tarifaTemporadaAlta = Integer.parseInt(input("Tarifa temporada alta:"));
				    int tarifaTemporadaBaja = Integer.parseInt(input("Tarifa temporada baja:"));
				    int tarifaConductorAdicional = Integer.parseInt(input("Tarifa conductor adicional:"));
				    int tarifaEntregarOtraSede = Integer.parseInt(input("Tarifa entregar en otra sede:"));
				    boolean temporadaAlta = Boolean.parseBoolean(input("¿Es temporada alta? (true/false):"));
				    
				    empresa.registrarCategoria(nombreCategoria, tarifaTemporadaAlta, tarifaTemporadaBaja, tarifaConductorAdicional, tarifaEntregarOtraSede, temporadaAlta);
				break;
				
				case 5:
					String nombreCategoria1 = input("Nombre de la categoría a actualizar:");
				    int tarifaTemporadaAlta1 = Integer.parseInt(input("Nueva tarifa temporada alta:"));
				    int tarifaTemporadaBaja1 = Integer.parseInt(input("Nueva tarifa temporada baja:"));
				    int tarifaConductorAdicional1 = Integer.parseInt(input("Nueva tarifa conductor adicional:"));
				    int tarifaEntregarOtraSede1 = Integer.parseInt(input("Nueva tarifa entregar en otra sede:"));
				    boolean temporadaAlta1 = Boolean.parseBoolean(input("¿Es temporada alta? (true/false):"));
				    
				    empresa.actualizarCategoria(nombreCategoria1, tarifaTemporadaAlta1, tarifaTemporadaBaja1, tarifaConductorAdicional1, tarifaEntregarOtraSede1, temporadaAlta1);
				    
				break;
				
				case 6:
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
					
				break;
					
				}
			}
	
		}
		
		
		public static void mostrarOpcionesAdminSede()
		{
			System.out.println("\nOpciones de Administrador local\n");
			System.out.println("1. Registrar empleado");
			System.out.println("2. Mostrar informacion empleado");
			System.out.println("3. Registrar cliente");
			System.out.println("4. Mostrar informacion cliente");
			System.out.println("5. Creacion seguro");
			System.out.println("6. Salir del sistema\n");
		}
		
		public void ejecutarOpcionAdminSede()
		{
			boolean continuar = true;
			while(continuar) {
				mostrarOpcionesAdminSede();
				int opcion = Integer.parseInt(input("Por favor seleccione una opción "));
				switch (opcion) {
				case 1:
					
				    String nombreUsuario = input("Ingrese el nombre de usuario:");
				    String contrasena = input("Ingrese la contraseña:");
				    empresa.registrarUsuario(nombreUsuario, contrasena, "Cliente");
				    String nombre = input("Ingrese el nombre del empleado:");
				    String rol = input("Ingrese el rol del empleado (Administracion, Administrador_sede, Empleado):");
				    String sede = input("Ingrese la sede a la que pertenece el empleado:");
				    empresa.registrarEmpleado(nombre, nombreUsuario, contrasena, rol, sede);
					
				break;
				
				case 2:
					String nombreEmpleado =input("Ingresar nombre empleado:");
					empresa.mostrarEmpleado(nombreEmpleado);
				break;

				case 3:
					
					String nombreUsuario1 = input("Ingrese el nombre de usuario:");
				    String contrasena1 = input("Ingrese la contraseña:");
				    empresa.registrarUsuario(nombreUsuario1, contrasena1, "Cliente");
				    String nombre1 = input("Ingrese el nombre del cliente:");
				    String fechaDeNacimiento = input("Ingrese la fecha de nacimiento:");
				    String telefono = input("Ingrese el número de teléfono:");
				    String nacionalidad = input("Ingrese la nacionalidad:");
				    String imgDocidentidad = input("Ingrese la imagen del documento de identidad: ");
				    String identificacion = input("Ingrese el número de identificación");
				    String numeroLicencia = input("Ingrese el número de licencia de conducir");
				    String paisExpedicion = input("Ingrese el país de expedición de la licencia:");
				    String fechaLicencia = input("Ingrese la fecha de expedición de la licencia:");
				    String imgLicencia = input("Ingrese la imagen de la licencia de conducir:");
				    String tipoPago = input("Ingrese el tipo de pago:");
				    String numeroMedioPago = input("Ingrese el número de medio de pago:");
				    String fechaVencimientoMedioPago = input("Ingrese la fecha de vencimiento del medio de pago del cliente:");
				    empresa.registrarCliente(nombre1, nombreUsuario1, contrasena1, fechaDeNacimiento, telefono, nacionalidad, imgDocidentidad, identificacion, numeroLicencia,
				    						paisExpedicion, fechaLicencia, imgLicencia, tipoPago, numeroMedioPago, fechaVencimientoMedioPago);
				break;   
				
				case 4:
					String nombreCliente =input("Ingresar nombre Cliente:");
					empresa.mostrarCliente(nombreCliente);
					
				break; 
				case 5:
					 String tipoSeguro = input("Ingrese el tipo de seguro: ");
					 int costo = Integer.parseInt(input("Ingrese el costo del seguro por día: "));
					   empresa.crearSeguro(tipoSeguro, costo);
				break;
				
				case 6:
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
					
				break;
					
				}
			}
		}
		
		public static void mostrarOpcionesCliente()
		{
			System.out.println("\nOpciones del cliente\n");
			System.out.println("1. Generar reserva");
			System.out.println("2. Mostrar informacion cliente");
			System.out.println("3. Salir del sistema\n");
		}
		public void ejecutarOpcionCliente()
		{
			boolean continuar = true;
			while(continuar) {
				mostrarOpcionesCliente();
				int opcion = Integer.parseInt(input("Por favor seleccione una opción "));
				switch (opcion) {
				case 1:
					String cliente = input("Ingrese el Id cliente:");
					String categoriaVehiculo = input("Ingrese la categoria vehiculo:");
					String sedeRecogida = input("Ingrese la sede de recogida:");
					String sedeEntrega = input("Ingrese la sede de entrega:");
					String fechaRecogida = input("Ingrese la fecha de recogida (dd/mm/yyyy):");
					String rangoHorasRecogida = input("Ingrese el rango de horas de recogida:");
					String fechaEntrega = input("Ingrese la fecha de entrega (dd/mm/yyyy):");
					String rangoHorasEntrega = input("Ingrese el rango de horas de entrega:");
					empresa.generarReserva( cliente, categoriaVehiculo, sedeRecogida, sedeEntrega,fechaRecogida,fechaEntrega,rangoHorasRecogida,rangoHorasEntrega);
					
				break;

				case 2:
					String nombreCliente =input("Ingresar nombre Cliente:");
					empresa.mostrarCliente(nombreCliente);
					
				break; 

				case 3:
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
					
				break;
				}
			}
		}
		public static void mostrarOpcionEmpleado()
		{
			System.out.println("\nOpciones del empleado\n");
			System.out.println("1. Generar alquiler");
			System.out.println("2. Registrar conductores adicionales");
			System.out.println("3. Actualizar estado vehiculo");
			System.out.println("4. Salir del sistema\n");
		}
		
		public void ejecutarOpcionEmpleado()
		{
			boolean continuar = true;
			while(continuar) {
				mostrarOpcionEmpleado();
				int opcion = Integer.parseInt(input("Por favor seleccione una opción "));
				switch (opcion) {
				case 1:
					
					String cliente = input("Ingrese el Id cliente:");
					String vehiculo = input("Ingrese la placa vehiculo:");
					String fechaRecogida = input("Ingrese la fecha de recogida (dd/mm/yyyy):");
					String rangoHorasRecogida = input("Ingrese el rango de horas de recogida:");
					String sedeRecogida = input("Ingrese la sede de recogida:");
					String fechaEntrega = input("Ingrese la fecha de entrega (dd/mm/yyyy):");
					String rangoHorasEntrega = input("Ingrese el rango de horas de entrega:");
					String sedeEntrega = input("Ingrese la sede de entrega:");
					String seguros = input("Ingrese el seguro:");
					String conductores = input("Ingrese conductores:");
					empresa.generarAlquiler(vehiculo, cliente, fechaRecogida, rangoHorasRecogida, sedeRecogida, fechaEntrega, rangoHorasEntrega, sedeEntrega, seguros, conductores);
		
				break;

				case 2:
					
					String nombre = input("Ingrese el nombre del conductor:");
				    String identificacion = input("Ingrese la identificación del conductor:");
				    String telefono = input("Ingrese el número de teléfono del conductor:");
				    String correo = input("Ingrese el correo del conductor:");
				    String numeroLicencia = input("Ingrese el número de licencia del conductor:");
				    String paisExpedicion = input("Ingrese el país de expedición de la licencia:");
				    String fechaLicencia = input("Ingrese la fecha de expedición de la licencia:");
				    String imgLicencia = input("Ingrese la imagen de la licencia:");

				    empresa.registrarConductorAdicional(nombre, identificacion, telefono, correo, numeroLicencia, paisExpedicion, fechaLicencia, imgLicencia);
					
				break; 
				
				case 3:
					String placa = input("Ingrese la placa del vehiculo:");
					String estadoNuevo = input("Ingrese estado del vehiculo: (Disponible, Ocuapdo, Limpieza, Mantenimiento)");
					empresa.actualizarEstado( placa,  estadoNuevo);
				break; 

				case 4:
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
					
				break;
				}
			}
			
		}
	
		public static void mostrarOpcionesVehiculo()
		{
			System.out.println("\nOpciones de Vehiculo\n");
			System.out.println("1. Agregar vehiculo");
			System.out.println("2. Eliminar vehiculo");
			System.out.println("3. tralsado de vehiculo");
			System.out.println("4. Salir del sistema\n");
		}
		
		public void ejecutarOpcionesVehiculo()
		{
			boolean continuar = true;
			while(continuar) {
				mostrarOpcionesVehiculo();
				
				int opcion = Integer.parseInt(input("Por favor seleccione una opción "));
				switch (opcion) {
				case 1:
					String placa = input("Ingrese la placa del vehículo: ");
				    String marca = input("Ingrese la marca del vehículo: ");
				    String modelo = input("Ingrese el modelo del vehículo: ");
				    String color = input("Ingrese el color del vehículo: ");
				    String transmision = input("Ingrese el tipo de transmisión del vehículo: ");
				    String categoria = input("Ingrese la categoría del vehículo: ");
				    int capacidad = Integer.parseInt(input("Ingrese la capacidad del vehículo: "));
				    String sedeActual = input("Ingrese el estado del vehículo: ");
				    String estado = input("Ingrese el estado del vehículo: ");
				    String fechaDisponible = input("Ingrese el estado del vehículo: ");
					empresa.registrarVehiculo(placa, marca, modelo,color,transmision,capacidad,categoria,estado, sedeActual, fechaDisponible);
					 
				case 2:
					String vehiculo = input("Ingrese la placa del vehículo que desea eliminar: ");
					empresa.eliminarVehiculo(vehiculo);
					
				break;
			
				case 3:
					String sedeDestino = input("Ingrese la sede destino: ");
					String placaVehiculo = input("Ingrese la placa del vehículo: ");
					empresa.trasladarVehiculo(placaVehiculo, sedeDestino);
					
				break;
				
				case 4:
				System.out.println("Saliendo de la aplicación ...");
				continuar = false;
				break;
					
				}
			}
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





