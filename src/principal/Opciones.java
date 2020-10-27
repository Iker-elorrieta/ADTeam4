package principal;

import comunes.Archivo;
import comunes.CsvUtilidades;
import comunes.MostrarDatos;
import comunes.RellenarLibro;
import comunes.TxtUtilidades;
import comunes.XmlUtilidades;
import modelo.Libro;

public class Opciones {
	
	public static void cargarBiblioteca() {
				
		System.out.println("Ha elegido cargar biblioteca");
		
		do {
			System.out.println();
			System.out.println("Introduzca el nombre del archivo que quiere cargar en la biblioteca");
			System.out.println("Introduzca 9 para volver");
			System.out.println("Introduzca 0 para salir");
			System.out.println();
			System.out.print("Elija su opción: ");
			Programa.setArchivo(Programa.teclado.nextLine());
			if (Programa.getArchivo().contains(".") && (Programa.getArchivo()
					.substring(Programa.getArchivo().lastIndexOf(".") + 1).equals("txt")
					|| Programa.getArchivo().substring(Programa.getArchivo().lastIndexOf(".") + 1).equals("xml")
					|| Programa.getArchivo().substring(Programa.getArchivo().lastIndexOf(".") + 1).equals("csv"))) {
				
				if (Archivo.comprobarArchivo(Programa.getArchivo())) {
					
					Programa.biblioteca.getListaLibros().clear();
					Programa.setOpcion(9);

					switch (Programa.getArchivo().substring(Programa.getArchivo().lastIndexOf(".") + 1)) {
					case "txt":
						
						Programa.biblioteca.setListaLibros(TxtUtilidades.obtenerLibros(Programa.getArchivo()));
						System.out.println();
						System.out.println("Archivo " + Programa.getArchivo() + " cargado en la biblioteca");
						System.out.println();
						
						break;

					case "xml":
						
						Programa.biblioteca.setListaLibros(XmlUtilidades.obtenerLibros(Programa.getArchivo()));
						System.out.println();
						System.out.println("Archivo " + Programa.getArchivo() + " cargado en la biblioteca");
						System.out.println();
						
						break;

					case "csv":
						
						Programa.biblioteca.setListaLibros(CsvUtilidades.obtenerLibros(Programa.getArchivo()));
						System.out.println();
						System.out.println("Archivo " + Programa.getArchivo() + " cargado en la biblioteca");
						System.out.println();

						break;

					default:
						break;
						
					}
					
				} else {
					
					System.out.println();
					System.out.println("El archivo introducido no existe");
					
				}
				
			} else {

				switch (Programa.getArchivo()) {
				case "9":

					Programa.setOpcion(9);
					System.out.println();
					System.out.println("Volviendo...");
					System.out.println();

					break;

				case "0":

					Programa.setOpcion(0);

					break;

				default:

					System.out.println("Opción no válida. El archivo debe tener formato .txt, .xml o .csv");

					break;
				}

			} 
			
		} while (Programa.getOpcion() != 0 && Programa.getOpcion() != 9);
			
	}
	
	public static void mostrarBiblioteca() {
		
		
		if(Programa.biblioteca.getListaLibros().size()>0) {
			
			System.out.println("Ha elegido mostrar biblioteca");
			System.out.println();
			MostrarDatos.mostrarLibros(Programa.biblioteca.getListaLibros());
			System.out.println();
		
		}else {
			System.out.println("Necesita cargar un libro antes de leerlo");
			System.out.println();
		}
		
	}
	
	public static void editarBiblioteca() {
		
		System.out.println("Ha elegido editar Biblioteca");
		System.out.println();
		
		do {
			System.out.println("Introduzca 1 para añadir un libro a la biblioteca");
			System.out.println("Introduzca 2 para editar un libro de la biblioteca");
			System.out.println("Introduzca 3 para eliminar un libro de la biblioteca");
			System.out.println("Introduzca 9 para volver");
			System.out.println("Introduzca 0 para salir");
			System.out.println();
			System.out.print("Elija su opción: ");
			try {
				Programa.setOpcion(Programa.teclado.nextInt());
				Programa.teclado.nextLine();
			} catch (Exception e1) {
				Programa.setOpcion(-1);
				Programa.teclado.nextLine();
			}
			switch (Programa.getOpcion()) {
			case 1:
				System.out.println();
				System.out.println("Ha elegido añadir un libro a la biblioteca");
				Libro libro = new Libro();
				RellenarLibro.rellenarLibro(libro);
				Programa.biblioteca.getListaLibros().add(libro);
				System.out.println();
				System.out.println("El libro ha sido añadido a la biblioteca");
				break;

			case 2:

				if (Programa.biblioteca.getListaLibros().size() > 0) {
					int numeroaEditar = 0;
					System.out.println();
					System.out.println("Ha elegido editar un libro de la biblioteca");
					MostrarDatos.mostrarLibros(Programa.biblioteca.getListaLibros());
					System.out.println();
					System.out.print("Escriba el número del libro que desea editar: ");
					try {
						numeroaEditar = Programa.teclado.nextInt();
						Programa.teclado.nextLine();
					} catch (Exception e) {
						numeroaEditar = -1;
						Programa.teclado.nextLine();
					}
					if (numeroaEditar > Programa.biblioteca.getListaLibros().size() || numeroaEditar <= 0) {

						System.out.println("El número de libro introducido no existe");

					} else {

						RellenarLibro.rellenarLibro(Programa.biblioteca.getListaLibros().get(numeroaEditar - 1));
						System.out.println("El libro " + numeroaEditar + " ha sido editado");

					}

				} else {
					System.out.println();
					System.out.println("La biblioteca está vacia, añada algún libro para poder editarlo");
					System.out.println();

				}

				break;

			case 3:
				
				if (Programa.biblioteca.getListaLibros().size() > 0) {
					int numeroaEditar = 0;
					System.out.println("Ha elegido borrar un libro de la biblioteca");
					MostrarDatos.mostrarLibros(Programa.biblioteca.getListaLibros());
					System.out.println();
					System.out.print("Escriba el número del libro que desea borrar: ");
					try {
						numeroaEditar = Programa.teclado.nextInt();
						Programa.teclado.nextLine();
					} catch (Exception e) {
						numeroaEditar = -1;
						Programa.teclado.nextLine();
					}
					if (numeroaEditar > Programa.biblioteca.getListaLibros().size() || numeroaEditar <= 0) {

						System.out.println("El número de libro introducido no existe");

					} else {

						Programa.biblioteca.getListaLibros().remove(numeroaEditar - 1);
						System.out.println("El libro " + numeroaEditar + " ha sido borrado de la biblioteca");
						
					}
					
				} else {
					
					System.out.println();
					System.out.println("La biblioteca está vacia");
					System.out.println();

				}

				break;

			case 9:
				
				Programa.setOpcion(9);
				System.out.println();
				System.out.println("Volviendo...");
				System.out.println();

				break;

			case 0:
				
				Programa.setOpcion(0);

				break;

			default:
				
				System.out.println();
				System.out.println("Opción no válida, vuelva a intentarlo");
				System.out.println();
				
				break;
			}
			
		} while (Programa.getOpcion() != 9 && Programa.getOpcion() != 0);
		
		
	}
	
	public static void guardarBiblioteca() {
		
		System.out.println("Ha elegido guardar biblioteca");
		System.out.println();
		
		if (Programa.biblioteca.getListaLibros().size() > 0) {
			
			do {
				System.out.println("Introduzca el nombre del archivo en el que quiere guardar la biblioteca");
				System.out.println("Introduzca 9 para volver");
				System.out.println("Introduzca 0 para salir");
				System.out.println();
				System.out.print("Elija su opción: ");
				Programa.setArchivo(Programa.teclado.nextLine());
				
				switch (Programa.getArchivo()) {
				case "9":
					
					Programa.setOpcion(9);
					System.out.println();
					System.out.println("Volviendo...");
					System.out.println();
					
					break;
					
				case "0":
					
					Programa.setOpcion(0);
					
					break;

				default:
					
					if (Programa.getArchivo().contains(".") && (Programa.getArchivo()
							.substring(Programa.getArchivo().lastIndexOf(".") + 1).equals("txt")
							|| Programa.getArchivo().substring(Programa.getArchivo().lastIndexOf(".") + 1).equals("xml")
							|| Programa.getArchivo().substring(Programa.getArchivo().lastIndexOf(".") + 1).equals("csv"))) {
						
						
						String opcion = new String();
						Boolean quiere = false;
						
						if (!Archivo.comprobarArchivo(Programa.getArchivo())) {
							
							do {
								System.out.println();
								System.out.print("El archivo no existe, ¿quiere crear uno nuevo? S/N: ");
								opcion = Programa.teclado.nextLine();
								System.out.println();
								
								if(opcion.equals("s") || opcion.equals("S")) {
									
									Archivo.crearArchivo(Programa.getArchivo());
									quiere = true;
									
								} else if (opcion.equals("n") || opcion.equals("N")) {
									
									Programa.setOpcion(9);
									System.out.println("Eligió no crear un archivo, volviendo...");
									System.out.println();
															
								} else {
									
									System.out.println("Opción no válida, vuelva a intentarlo");
									
								}
								
							} while ((!opcion.equals("s") && (!opcion.equals("S") && (!opcion.equals("n") && (!opcion.equals("N"))))));
										
						} else {
							
							do {
								System.out.println();
								System.out.print("El archivo ya existe, ¿quiere sobreescribirlo? S/N: ");
								opcion = Programa.teclado.nextLine();
								System.out.println();
								
								if(opcion.equals("s") || opcion.equals("S")) {
									
									System.out.println("Se sobreescribirá el archivo " + Programa.getArchivo());				
									quiere = true;
									
								} else if (opcion.equals("n") || opcion.equals("N")) {
									
									System.out.println("Eligió no sobreescribir el archivo, volviendo...");
									Programa.setOpcion(9);
															
								} else {
									
									System.out.println("Opción no válida, vuelva a intentarlo");
									
								}
							
							} while ((!opcion.equals("s") && (!opcion.equals("S") && (!opcion.equals("n") && (!opcion.equals("N"))))));
							
						}
						
						if (Archivo.comprobarArchivo(Programa.getArchivo()) && quiere) {
							
							switch (Programa.getArchivo().substring(Programa.getArchivo().lastIndexOf(".") + 1)) {
							case "txt":
								
								Programa.setOpcion(9);
								TxtUtilidades.escribirTxt(Programa.getArchivo(), Programa.biblioteca.getListaLibros());
								System.out.println("Biblioteca guardada en el archivo " + Programa.getArchivo());
								System.out.println();
								
								break;
								
							case "xml":
								
								Programa.setOpcion(9);
								XmlUtilidades.escribirXml(Programa.getArchivo(), Programa.biblioteca.getListaLibros());
								System.out.println("Biblioteca guardada en el archivo " + Programa.getArchivo());
								System.out.println();
								
								break;
								
							case "csv":
								
								Programa.setOpcion(9);
								CsvUtilidades.escribirCsv(Programa.getArchivo(), Programa.biblioteca.getListaLibros());
								System.out.println("Biblioteca guardada en el archivo " + Programa.getArchivo());
								System.out.println();
								
							break;

							default:
								break;
							}
						}
										
					} else {
						
						System.out.println();
						System.out.println("El tipo de archivo no es válido. Debe guardar la biblioteca en un archivo .txt, .xml o .csv");
						System.out.println();
					}
					
					break;
				}
							
			} while (Programa.getOpcion() != 9 && Programa.getOpcion() != 0);

		} else {
			
			System.out.println("La biblioteca está vacia, añada algún libro antes de guardarla");
			
		}
		
	}

}