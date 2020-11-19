package principal;

import java.io.File;

import comunes.Archivo;
import comunes.CsvUtilidades;
import comunes.Filtro;
import comunes.MostrarDatos;
import comunes.Permisos;
import comunes.RellenarLibro;
import comunes.TxtUtilidades;
import comunes.Validaciones;
import comunes.XmlUtilidades;
import modelo.Libro;

public class Opciones {

	public static void cargarBiblioteca() {
		
		String barra = Archivo.detectarSistema();
		File file = new File(".");
		file = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(barra)));
		File archivoacargar = new File("Z:\\Noexiste");
		String modo = "cargar";

		System.out.println("Ha elegido cargar biblioteca");
		do {
			System.out.println("El directorio actual es " + file.getAbsolutePath());
			System.out.println();
			System.out.println("Introduzca 1 para subir un nivel");
			System.out.println("Introduzca 2 para mostrar los contenidos del directorio");
			System.out.println("Introduzca 3 para explorar un nuevo directorio");
			System.out.println("Introduzca 4 para escribir el nombre del archivo a cargar");
			System.out.println("Introduzca 9 para volver");
			System.out.println("Introduzca 0 para salir");
			System.out.println();
			System.out.print("Elija su opción: ");
			try {
				Programa.setOpcion(Programa.teclado.nextInt());
				Programa.teclado.nextLine();
			} catch (Exception e) {
				Programa.setOpcion(-1);
				Programa.teclado.nextLine();
			}
			switch (Programa.getOpcion()) {
			case 1:

				file = Archivo.subirDirectorio(file);

				break;

			case 2:

				Archivo.mostrarArchivos(file);
				System.out.println();

				break;

			case 3:

				file = Archivo.elegirDirectorio(file);

				break;

			case 4:

				archivoacargar = Archivo.elegirArchivo(file, modo);
				Programa.setArchivo(archivoacargar.getAbsolutePath());

				if (Validaciones.validarExtension(Programa.getExtensiones(), Programa.getArchivo())) {

					if (Archivo.comprobarArchivo(Programa.getArchivo())) {

						Programa.setOpcion(9);

						switch (Validaciones.obtenerExtension(Programa.getArchivo())) {
						case "txt":
							Programa.getBiblioteca().anyadirLibros(TxtUtilidades.obtenerLibros(Programa.getArchivo()));
							System.out.println();
							System.out.println("Archivo " + Programa.getArchivo() + " cargado en la biblioteca");
							System.out.println();

							break;

						case "xml":

							Programa.getBiblioteca().anyadirLibros(XmlUtilidades.obtenerLibros(Programa.getArchivo()));
							System.out.println();
							System.out.println("Archivo " + Programa.getArchivo() + " cargado en la biblioteca");
							System.out.println();

							break;

						case "csv":

							Programa.getBiblioteca().anyadirLibros(CsvUtilidades.obtenerLibros(Programa.getArchivo()));
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

				System.out.println("Opción no válida, vuelva a intentarlo");
				System.out.println();

				break;
			}
			
		} while (Programa.getOpcion() != 9 && Programa.getOpcion() != 0);
	}

	public static void mostrarBiblioteca() {

		if (Programa.getBiblioteca().getListaLibros().size() > 0) {

			System.out.println("Ha elegido mostrar biblioteca");
			System.out.println();
			MostrarDatos.mostrarLibros(Programa.getBiblioteca().getListaLibros());
			System.out.println();

		} else {
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
			System.out.println("Introduzca 4 para vaciar la biblioteca");
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
				Programa.getBiblioteca().getListaLibros().add(libro);
				System.out.println();
				System.out.println("El libro ha sido añadido a la biblioteca");
				break;

			case 2:

				if (Programa.getBiblioteca().getListaLibros().size() > 0) {
					int numeroaEditar = 0;
					System.out.println();
					System.out.println("Ha elegido editar un libro de la biblioteca");
					MostrarDatos.mostrarLibros(Programa.getBiblioteca().getListaLibros());
					System.out.println();
					System.out.print("Escriba el número del libro que desea editar: ");
					try {
						numeroaEditar = Programa.teclado.nextInt();
						Programa.teclado.nextLine();
					} catch (Exception e) {
						numeroaEditar = -1;
						Programa.teclado.nextLine();
					}
					if (numeroaEditar > Programa.getBiblioteca().getListaLibros().size() || numeroaEditar <= 0) {

						System.out.println("El número de libro introducido no existe");

					} else {

						RellenarLibro.rellenarLibro(Programa.getBiblioteca().getListaLibros().get(numeroaEditar - 1));
						System.out.println("El libro " + numeroaEditar + " ha sido editado");

					}

				} else {
					System.out.println();
					System.out.println("La biblioteca está vacia, añada algún libro para poder editarlo");
					System.out.println();

				}

				break;

			case 3:

				if (Programa.getBiblioteca().getListaLibros().size() > 0) {
					int numeroaEditar = 0;
					System.out.println("Ha elegido borrar un libro de la biblioteca");
					MostrarDatos.mostrarLibros(Programa.getBiblioteca().getListaLibros());
					System.out.println();
					System.out.print("Escriba el número del libro que desea borrar: ");
					try {
						numeroaEditar = Programa.teclado.nextInt();
						Programa.teclado.nextLine();
					} catch (Exception e) {
						numeroaEditar = -1;
						Programa.teclado.nextLine();
					}
					if (numeroaEditar > Programa.getBiblioteca().getListaLibros().size() || numeroaEditar <= 0) {

						System.out.println("El número de libro introducido no existe");

					} else {

						Programa.getBiblioteca().getListaLibros().remove(numeroaEditar - 1);
						System.out.println("El libro " + numeroaEditar + " ha sido borrado de la biblioteca");

					}

				} else {

					System.out.println();
					System.out.println("La biblioteca está vacia");
					System.out.println();

				}

				break;

			case 4:

				System.out.println();
				Programa.getBiblioteca().getListaLibros().clear();
				Programa.setOpcion(9);
				System.out.println("La biblioteca ha sido vaciada");
				System.out.println();

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
		
		String barra = Archivo.detectarSistema();
		File file = new File(".");
		file = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(barra)));
		File archivoaguardar = new File("Z:\\Noexiste");
		String modo = "guardar";

		System.out.println("Ha elegido cargar biblioteca");
		
		
		
		if (Programa.getBiblioteca().getListaLibros().size() > 0) {
			do {
				System.out.println("El directorio actual es " + file.getAbsolutePath());
				System.out.println();
				System.out.println("Introduzca 1 para subir un nivel");
				System.out.println("Introduzca 2 para mostrar los contenidos del directorio");
				System.out.println("Introduzca 3 para explorar un nuevo directorio");
				System.out.println("Introduzca 4 para escribir el nombre del archivo en el que guardar la biblioteca");
				System.out.println("Introduzca 9 para volver");
				System.out.println("Introduzca 0 para salir");
				System.out.println();
				System.out.print("Elija su opción: ");
				try {
					Programa.setOpcion(Programa.teclado.nextInt());
					Programa.teclado.nextLine();
				} catch (Exception e) {
					Programa.setOpcion(-1);
					Programa.teclado.nextLine();
				}
				switch (Programa.getOpcion()) {

				case 1:

					file = Archivo.subirDirectorio(file);

					break;

				case 2:

					Archivo.mostrarArchivos(file);
					System.out.println();

					break;

				case 3:

					file = Archivo.elegirDirectorio(file);

					break;

				case 4:
					archivoaguardar = Archivo.elegirArchivo(file, modo);
					Programa.setArchivo(archivoaguardar.getAbsolutePath());
					if (Validaciones.validarExtension(Programa.getExtensiones(), Programa.getArchivo())) {

						String opcion = new String();
						Boolean quiere = false;

						if (!Archivo.comprobarArchivo(Programa.getArchivo())) {

							do {
								System.out.println();
								System.out.print("El archivo no existe, ¿quiere crear uno nuevo? S/N: ");
								opcion = Programa.teclado.nextLine();
								System.out.println();

								if (opcion.equals("s") || opcion.equals("S")) {

									Archivo.crearArchivo(Programa.getArchivo());
									quiere = true;

								} else if (opcion.equals("n") || opcion.equals("N")) {

									Programa.setOpcion(9);
									System.out.println("Eligió no crear un archivo, volviendo...");
									System.out.println();

								} else {

									System.out.println("Opción no válida, vuelva a intentarlo");

								}

							} while ((!opcion.equals("s")
									&& (!opcion.equals("S") && (!opcion.equals("n") && (!opcion.equals("N"))))));

						} else {

							do {
								System.out.println();
								System.out.print("El archivo ya existe, ¿quiere sobreescribirlo? S/N: ");
								opcion = Programa.teclado.nextLine();
								System.out.println();

								if (opcion.equals("s") || opcion.equals("S")) {

									System.out.println("Se sobreescribirá el archivo " + Programa.getArchivo());
									quiere = true;

								} else if (opcion.equals("n") || opcion.equals("N")) {

									System.out.println("Eligió no sobreescribir el archivo, volviendo...");
									Programa.setOpcion(9);

								} else {

									System.out.println("Opción no válida, vuelva a intentarlo");

								}

							} while ((!opcion.equals("s")
									&& (!opcion.equals("S") && (!opcion.equals("n") && (!opcion.equals("N"))))));

						}

						if (Archivo.comprobarArchivo(Programa.getArchivo()) && quiere) {

							switch ((Validaciones.obtenerExtension(Programa.getArchivo()))) {
							case "txt":

								Programa.setOpcion(9);
								TxtUtilidades.escribirTxt(Programa.getArchivo(),
										Programa.getBiblioteca().getListaLibros());
								System.out.println("Biblioteca guardada en el archivo " + Programa.getArchivo());
								System.out.println();

								break;

							case "xml":

								Programa.setOpcion(9);
								XmlUtilidades.escribirXml(Programa.getArchivo(),
										Programa.getBiblioteca().getListaLibros());
								System.out.println("Biblioteca guardada en el archivo " + Programa.getArchivo());
								System.out.println();

								break;

							case "csv":

								Programa.setOpcion(9);
								CsvUtilidades.escribirCsv(Programa.getArchivo(),
										Programa.getBiblioteca().getListaLibros());
								System.out.println("Biblioteca guardada en el archivo " + Programa.getArchivo());
								System.out.println();

								break;

							default:
								break;
							}
						}

					} else {

						System.out.println();
						System.out.println(
								"El tipo de archivo no es válido. Debe guardar la biblioteca en un archivo .txt, .xml o .csv");
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

					System.out.println("Opción no válida, vuelva a intentarlo");
					System.out.println();

					break;
				}

			} while (Programa.getOpcion() != 9 && Programa.getOpcion() != 0);
		
		} else {

			System.out.println("La biblioteca está vacia, añada algún libro antes de guardarla");
			System.out.println();

		}

	}

	public static void filtrarBiblioteca() {

		if (Programa.getBiblioteca().getListaLibros().size() > 0) {
			Filtro f = new Filtro(Programa.getBiblioteca().getListaLibros());
			f.AtributoAFiltrar();
		} else {
			System.out.println("No se puede filtrar algo que no existe");
		}

	}
	
	public static void opcionesArchivo() {
		
		Programa.setOpcion(-1);
		
		String barra = Archivo.detectarSistema();	
		File directorioactual = new File(".");
		directorioactual = new File(directorioactual.getAbsolutePath().substring(0, directorioactual.getAbsolutePath().lastIndexOf(barra)));
		File archivoseleccionado = new File("Z:\\Noexiste");
		String modo = "cargar";
		
		System.out.println("Eligió opciones de archivo");
		System.out.println();

		do {
			System.out.println("El directorio actual es " + directorioactual.getAbsolutePath());
			System.out.println();
			System.out.println("Introduzca 1 para subir un nivel");
			System.out.println("Introduzca 2 para mostrar los contenidos del directorio");
			System.out.println("Introduzca 3 para explorar un nuevo directorio");
			System.out.println("Introduzca 4 para seleccionar un archivo");
			System.out.println("Introduzca 5 para mover el archivo seleccionado");
			System.out.println("Introduzca 6 para cambiar los permisos del archivo seleccionado");
			System.out.println("Introduzca 7 para crear un directorio");
			System.out.println("Introduzca 9 para volver");
			System.out.println("Introduzca 0 para salir");
			System.out.println();
			System.out.print("Elija su opción: ");
			try {
				Programa.setOpcion(Programa.teclado.nextInt());
				Programa.teclado.nextLine();
			} catch (Exception e) {
				Programa.setOpcion(-1);
				Programa.teclado.nextLine();
			}
			System.out.println();
			switch (Programa.getOpcion()) {
			case 1:

				directorioactual = Archivo.subirDirectorio(directorioactual);

				break;

			case 2:

				Archivo.mostrarArchivos(directorioactual);

				break;

			case 3:

				directorioactual = Archivo.elegirDirectorio(directorioactual);

				break;

			case 4:

				archivoseleccionado = Archivo.elegirArchivo(directorioactual, modo);

				break;

			case 5:

				Archivo.moverArchivo(archivoseleccionado, directorioactual);

				break;
				
			case 6:
				Permisos p = new Permisos();
				p.cambiarPermisos(archivoseleccionado.getAbsolutePath());
				break;
				
			case 7:
				
				Archivo.crearDirectorio(directorioactual);
				
				break;
				
			case 9:
				
				System.out.println("Volviendo...");
				Programa.setOpcion(9);
				
				break;
				
			case 0:
				
				Programa.setOpcion(0);
				
				break;

			default:
				
				System.out.println("Opción no válida, vuelva a intentarlo");

				break;
			}
			
			System.out.println();
			
	
		} while (Programa.getOpcion() !=9 && Programa.getOpcion() != 0);	
		
	}

}