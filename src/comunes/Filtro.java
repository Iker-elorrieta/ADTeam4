package comunes;

import java.util.ArrayList;


import modelo.Libro;
import principal.Programa;

public class Filtro {

	private ArrayList<Libro> arrayLibrosFiltrados = new ArrayList<Libro>();
	 String arrayAtributos[] = {"titulo","editorial","paginas","altura","isbn","notas","materias"};
	
	public Filtro() {
		
	}
	
	public Filtro(ArrayList<Libro> arrayLibros){
		
		this.arrayLibrosFiltrados = arrayLibros;
		
	}
	
	
	
	public boolean AtributoAFiltrar() {
		
		
		Boolean exit = false;
		int opcion = 0;
		

		System.out.println("Bienvenido al filtro");
		System.out.println();


		while (!exit) {

			System.out.println("¿Por qué atributo quiere filtrar el libro?");
			System.out.println();
			System.out.println("1.-Titulo                       5.-Isbn");
			System.out.println("2.-Editorial                    6.-Notas");
			System.out.println("3.-Paginas                      7.-Materias");
			System.out.println("4.-Altura                                   ");
			System.out.println();
			System.out.println("Introduzca cualquier caracter o 0 para salir");
			System.out.println();
			
			try {

				opcion = Programa.teclado.nextInt();
				Programa.teclado.nextLine();

				if (opcion <= 7 && opcion >= 0) {

					switch (opcion) {

					case 1:		ObtenerFiltroStrings(arrayAtributos[0]);		break; 
								
					case 2:		ObtenerFiltroStrings(arrayAtributos[1]); 	break;
		
					case 3:		ObtenerFiltroIntegers(arrayAtributos[2]); 	break;
							
					case 4: 	ObtenerFiltroIntegers(arrayAtributos[3]); 	break;
					
					case 5:     ObtenerIsbn(arrayAtributos[4]); 				break;

					case 6: 	ObtenerFiltroStrings(arrayAtributos[5]); 		break;
						
					case 7: 	ObtenerFiltroStrings(arrayAtributos[6]); 	break;
						
					case 0:

						System.out.println("Ha seleccionado salir");
						exit = true;
						
					break;
						
					}

				} else {

					System.out.println("ERROR!  Introduzca un número dentro del estándar impuesto");
					System.out.println();
					
				}

			} catch (Exception e) {

				System.out.println("Volviendo al menu principal");
				Programa.teclado.nextLine();
				return false;
				
			}
		
		}
		return true;
	}

	public void ObtenerFiltroIntegers(String atributo) {

		String filtroAplicar = "";
		int subOpcionStrings = 0;
		Boolean subSalir = false;
		int numPag = 0;

		while (!subSalir) {
		
			System.out.println();
			System.out.println("¿Como quieres realizar el filtrado por " + atributo + " ?");
			System.out.println();
			System.out.println("1.-Minimo de paginas(Imprimirá " + atributo + " apartir del número dado)");
			System.out.println("2.-Busqueda exacta");
			System.out.println("3.-Busqueda máxima(Imprimirá " + atributo + " por debajo del número dado)");
			System.out.println();

			try {

				subOpcionStrings = Programa.teclado.nextInt();

				Programa.teclado.nextLine();

				switch (subOpcionStrings) {

				case 1:
					System.out.println("Introduzca el número mínimo a filtrar");
					numPag = Programa.teclado.nextInt();
					Programa.teclado.nextLine();
					filtroAplicar="{-"+numPag+"}";
					mostrarResultados(atributo,filtroAplicar,numPag+"",subOpcionStrings);
				
					break;

				case 2:
					
					System.out.println("Introduzca el número exacto a filtrar");
					numPag = Programa.teclado.nextInt();
					Programa.teclado.nextLine();
					filtroAplicar = "{"+numPag+"}";
					mostrarResultados(atributo,filtroAplicar,numPag+"",subOpcionStrings);
					break;

				case 3:
					
					System.out.println("Introduzca el número máximo a filtrar");
					numPag = Programa.teclado.nextInt();
					Programa.teclado.nextLine();
					filtroAplicar="{+"+numPag+"}";
					mostrarResultados(atributo,filtroAplicar,numPag+"",subOpcionStrings);
					break;

				case 0:
					System.out.println("Volviendo al menú de atributos, se borrarán los filtros realizados para este atributo");
					System.out.println();
					subSalir = true;

					break;

				default:

					System.out.println("Introduzca un número dentro de los parámetros");

					break;

				}

			} catch (Exception e) {
				System.out.println("Introduzca un número, carácteres no válidos");
				Programa.teclado.next();

			}

		}

	}

	

	public void ObtenerFiltroStrings(String atributo) {

		String filtroAplicar = "";
		int subOpcionStrings = 0;
		Boolean subSalir = false;
		String cadena="";
		
		while (!subSalir) {

			System.out.println();
			System.out.println("¿Como quieres realizar el filtrado por " + atributo + " ?");
			System.out.println();
			System.out.println(
	        "1.-Busqueda por sugerencia (Introduce un caracter o cadena e imprime atributos que contengan lo indicado)");
			System.out.println("2.-Busqueda exacta");
			System.out.println("3.-La busqueda contiene como primera letra una mayúscula");
			System.out.println("4.-La busqueda no tiene más longitud que el valor dado");
			System.out.println("0.-Salir");
			System.out.println();

			try {

				subOpcionStrings = Programa.teclado.nextInt();

				Programa.teclado.nextLine();

				switch (subOpcionStrings) {

				case 1:
					
					System.out.println("Introduzca la cadena que deben tener los resultados");
					cadena=Programa.teclado.nextLine();
					filtroAplicar="*"+cadena+"*";	
					mostrarResultados(atributo,filtroAplicar,cadena,subOpcionStrings);
					
					break;

				case 2:
					
					System.out.println("Introduzca la cadena exacta que deben tener los resultados");
					cadena=Programa.teclado.nextLine();
					filtroAplicar = "="+cadena+"=";
					mostrarResultados(atributo,filtroAplicar,cadena,subOpcionStrings);
					break;

				case 3:
					System.out.println("Introduzca la cadena que deben tener los resultados");
					cadena=Programa.teclado.nextLine();
					filtroAplicar= cadena.toUpperCase();
					mostrarResultados(atributo,filtroAplicar,cadena,subOpcionStrings);
					break;

				case 4:
				
					int longitud=0;
					
					System.out.println("Introduzca la longitud del atributo que esta buscando");
					try {
					longitud=Programa.teclado.nextInt();
					}catch(Exception e) {
					System.out.println("No ha introducido ningún número, se asignara 0.");	
					}
					filtroAplicar="<"+longitud+">";
					mostrarResultados(atributo,filtroAplicar,longitud+"",subOpcionStrings);
					
				break;
				case 0:
					System.out.println(
					"Volviendo al menú de atributos, se borrarán los filtros realizados para este atributo");
					System.out.println();
					subSalir = true;

					break;

				default:

					System.out.println("Introduzca un número dentro de los parámetros");
					break;

				}

			} catch (Exception e) {
				System.out.println("Introduzca un número, carácteres no válidos");
				Programa.teclado.next();

			}

	
		}

	}

	public void ObtenerIsbn(String atributo) {

		String filtroAplicar = "";
		int subOpcionStrings = 0;
		Boolean subSalir = false;
		String isbn = "";

		while (!subSalir) {

			System.out.println();
			System.out.println("¿Como quieres realizar el filtrado por isbn ?");
			System.out.println();
			System.out.println("1.-Busqueda por contenido(Introduce un número y filtra los isbn que lo contengan)");
			System.out.println("2.-Busqueda exacta");
			System.out.println("0.-Salir");
			System.out.println();

			try {

				subOpcionStrings = Programa.teclado.nextInt();

				Programa.teclado.nextLine();
				

				switch (subOpcionStrings) {

				case 1:
					System.out.println("Introduzca el número a filtrar");
					isbn = Programa.teclado.nextLine();
					
					filtroAplicar="**"+isbn+"";
					mostrarResultados(atributo,filtroAplicar,isbn,subOpcionStrings);
					
					break;
				case 2:

					System.out.println("Introduzca el número exacto a filtrar");
					isbn = Programa.teclado.nextLine();
					filtroAplicar="="+isbn+"=";
					mostrarResultados(atributo,filtroAplicar,isbn,subOpcionStrings);
					break;

				case 0:
					System.out.println(
							"Volviendo al menú de atributos, se borrarán los filtros realizados para este atributo");
					System.out.println();
					subSalir = true;

					break;

				default:

					System.out.println("Introduzca un número dentro de los parámetros");

					break;

				}

			} catch (Exception e) {
				System.out.println("Introduzca un número, carácteres no válidos");
				Programa.teclado.next();

			}

		}

	}
	


	private void mostrarResultados(String atributo,String filtro,String introducido,int opcionSwitch) {
		// TODO Auto-generated method stub
		
	System.out.println("Los libros con los atributos filtrados son: ");
	System.out.println();
	
	for(int i =0 ; i < arrayLibrosFiltrados.size();i++) {	
		
		
		
		if(atributo.equals(arrayAtributos[0])) {
		
			
				
				if(Validaciones.validarAtributo(introducido, filtro, "")) {
					
					switch(opcionSwitch) {
					
					case 1:
						System.out.println("///////////////////////////////////////////////////////////");
						   System.out.println(arrayLibrosFiltrados.get(i).getTitulo());
						   System.out.println(introducido);
						
						if(arrayLibrosFiltrados.get(i).getTitulo().contains(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
						}
						
						
					break;
					
					case 2:
						if(arrayLibrosFiltrados.get(i).getTitulo().toLowerCase().equals(introducido.toLowerCase())) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
						}
						
					break;
					
					case 3:
						
						if(arrayLibrosFiltrados.get(i).getTitulo().charAt(0)==introducido.toUpperCase().charAt(0)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
						}
					break;
					
					case 4:
						
						if(arrayLibrosFiltrados.get(i).getTitulo().length() == Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							
						}
					break;
					
					
					}
				
				
				}
				
			
			
		}
		
		
		if(atributo.equals(arrayAtributos[1])) {
		
		
				if(Validaciones.validarAtributo(introducido, filtro, "")) {
					
					
					switch(opcionSwitch) {
					
					case 1:
					   
						if(arrayLibrosFiltrados.get(i).getEditorial().contains(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Editorial : "+ arrayLibrosFiltrados.get(i).getEditorial());
						}
							
						
					break;
					
					case 2:
						if(arrayLibrosFiltrados.get(i).getEditorial().toLowerCase().equals(introducido.toLowerCase())) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Editorial : "+ arrayLibrosFiltrados.get(i).getEditorial());
						}
						
					break;
					
					case 3:
						if(arrayLibrosFiltrados.get(i).getEditorial().charAt(0)==introducido.toUpperCase().charAt(0)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Editorial : "+ arrayLibrosFiltrados.get(i).getEditorial());
						}
					break;
					
					case 4:
						if(arrayLibrosFiltrados.get(i).getEditorial().length() == Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Editorial : "+ arrayLibrosFiltrados.get(i).getEditorial());
						}
					break;
					
					
					}
				}	
				
			
			
		}
		
		
		
		if(atributo.equals(arrayAtributos[2])) {
		
			
				if(Validaciones.validarAtributo(introducido, filtro, "")) {
					
					
					switch(opcionSwitch) {
					
					case 1:
					   //minimo
						if(arrayLibrosFiltrados.get(i).getAltura() > Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Altura : "+ arrayLibrosFiltrados.get(i).getAltura());
						}
							
						
					break;
					//exacto
					case 2:
						if(arrayLibrosFiltrados.get(i).getAltura() == Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Altura : "+ arrayLibrosFiltrados.get(i).getAltura());
						}
						
					break;
						//maximo
					case 3:
						if(arrayLibrosFiltrados.get(i).getAltura() < Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Altura : "+ arrayLibrosFiltrados.get(i).getAltura());
						}
					break;
					
				
					
					
					}
				}	
			
		}
		
		
		
		if(atributo.equals(arrayAtributos[3])) {
			
			
			
				if(Validaciones.validarAtributo(introducido, filtro, "")) {
					
				
					switch(opcionSwitch) {
					
					case 1:
					   //minimo
						
						if(arrayLibrosFiltrados.get(i).getPaginas() > Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Paginas : "+ arrayLibrosFiltrados.get(i).getPaginas());
						}
							
						
					break;
					//exacto
					case 2:
						
						if(arrayLibrosFiltrados.get(i).getPaginas() == Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Paginas : "+ arrayLibrosFiltrados.get(i).getPaginas());
						}
						
					break;
						//maximo
					case 3:
						
						if(arrayLibrosFiltrados.get(i).getPaginas() < Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Paginas : "+ arrayLibrosFiltrados.get(i).getPaginas());
						}
						
					break;
					
				
					
					
					}
					
					
				}	
			
			
		}
		
			
		if(atributo.equals(arrayAtributos[4])) {
			
				
			
				
				
				if(Validaciones.validarAtributo(introducido, filtro, "")) {
				
					
					switch(opcionSwitch) {
					
					case 1:
					   
						
						if(arrayLibrosFiltrados.get(i).getIsbn().contains(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Isbn : "+ arrayLibrosFiltrados.get(i).getIsbn());
						}
							
						
					break;
					
					
					case 2:
						
						if(arrayLibrosFiltrados.get(i).getIsbn().equals(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Isbn : "+ arrayLibrosFiltrados.get(i).getIsbn());
						}
						
					break;
					
					
			
					
					
					}
				}	
			
		
		}
			
		
		if(atributo.equals(arrayAtributos[6])) {
		
		
				if(Validaciones.validarAtributo(introducido, filtro, "")) {
					
					
					switch(opcionSwitch) {
					
					case 1: 
					
						if(arrayLibrosFiltrados.get(i).getMaterias().contains(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Materias : "+ arrayLibrosFiltrados.get(i).getMaterias());
						}
							
						
					break;
					
					case 2:
						if(arrayLibrosFiltrados.get(i).getMaterias().toLowerCase().equals(introducido.toLowerCase())) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Materias : "+ arrayLibrosFiltrados.get(i).getMaterias());
						}
						
					break;
					
					case 3:
						if(arrayLibrosFiltrados.get(i).getMaterias().charAt(0)==introducido.toUpperCase().charAt(0)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Materias : "+ arrayLibrosFiltrados.get(i).getMaterias());
						}
					break;
					
					case 4:
						if(arrayLibrosFiltrados.get(i).getMaterias().length() == Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Materias : "+ arrayLibrosFiltrados.get(i).getMaterias());
						}
					break;
					
					
				}
			}	
		}
		
		
		if(atributo.equals(arrayAtributos[5])) {
			
			
				if(Validaciones.validarAtributo(introducido, filtro, "")) {
					System.out.println(arrayLibrosFiltrados.get(i).getNotas());
					
					switch(opcionSwitch) {
					
					case 1:
					   
						if(arrayLibrosFiltrados.get(i).getNotas().contains(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Notas : "+ arrayLibrosFiltrados.get(i).getNotas());
						}
							
						
					break;
					
					case 2:
						if(arrayLibrosFiltrados.get(i).getNotas().toLowerCase().equals(introducido.toLowerCase())) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Notas : "+ arrayLibrosFiltrados.get(i).getNotas());
						}
						
					break;
					
					case 3:
						if(arrayLibrosFiltrados.get(i).getNotas().charAt(0)==introducido.toUpperCase().charAt(0)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Notas : "+ arrayLibrosFiltrados.get(i).getNotas());
						}
					break;
					
					case 4:
						if(arrayLibrosFiltrados.get(i).getNotas().length() == Integer.parseInt(introducido)) {
							System.out.println("Titulo : "+ arrayLibrosFiltrados.get(i).getTitulo());
							System.out.println("Notas : "+ arrayLibrosFiltrados.get(i).getNotas());
						}
					break;
					
					
					}
					
				}	
				
			}
		
		
		
	}
	
	
	
	
	
	}
	

}
