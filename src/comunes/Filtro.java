package comunes;

import java.util.ArrayList;

import modelo.Biblioteca;
import modelo.Libro;
import principal.Programa;




public class Filtro {
	
	private ArrayList<Libro> arrayLibrosFiltrados = new ArrayList<Libro>();
	private String filtro= new String();
	private int filtroNumerico ;
	
	public void AtributoAFiltrar(ArrayList<Libro> arrayLibrosAFiltrar){
	
		Boolean exit = false;
		int opcion = 0;
		String atributoAFiltrar=null;
	
	
		
	
		System.out.println("Bienvenido al filtro");
		System.out.println();
		System.out.println("Tenga en cuenta que si selecciona más de un filtro se acumularán.");
		System.out.println();
		
	while(!exit) {
		
	
		System.out.println("¿Por qué atributo quiere filtrar el libro?");
		System.out.println();
		System.out.println("1.-Titulo                       5.-Isbn");
		System.out.println("2.-Editorial                    6.-Notas");
		System.out.println("3.-Paginas                      7.-Materias");
		System.out.println("4.-Altura                                   ");
		System.out.println();
		System.out.println("Introduzca cualquier caracter para salir");
		System.out.println();
		try {
			
		 opcion= Programa.teclado.nextInt();
		 Programa.teclado.nextLine();
		
			if(opcion <= 7 && opcion >= 0) {
				
				
				switch(opcion) {
				
				case 1:
					ObtenerFiltroStrings("titulo");
				break;
				
				
				case 2:
					ObtenerFiltroStrings("editorial");
					
				break;
				
				
				case 3:
					System.out.println("Minimo de paginas");
					System.out.println("Maximo ");
					System.out.println("Exacto");
					atributoAFiltrar = "paginas";
						
				break;
				
				
				case 4:
					System.out.println("Minimo de paginas");
					System.out.println("Maximo ");
					System.out.println("Exacto");
					atributoAFiltrar = "altura";
						
				break;
				
				
				case 5:
					System.out.println("exacto");
					System.out.println("contenga ");
					atributoAFiltrar = "isbn";
						
				break;
					
				
				case 6:
					ObtenerFiltroStrings("notas");
					
					
				break; 
				
				case 7:
					ObtenerFiltroStrings("materias");
					
				break;
				
				
				case 0 :
					
				System.out.println("Ha seleccionado salir");
				exit=true;
				break;
				
			}
				
				
			}else {
				
				System.out.println("ERROR!  Introduzca un número dentro del estándar impuesto");
				System.out.println();
			}
		
			
		}catch(Exception e) {
				
			System.out.println("Volviendo al menu principal");
			break;
		}
	}
			
	
		
		
		
	}
	
	public ArrayList<Libro> getArrayLibrosFiltrados() {
		
		
		return this.arrayLibrosFiltrados;
	}
	
	
	public String ObtenerFiltroStrings(String atributo) {
		
		String filtroAplicar ="";
		int subOpcionStrings=0;
		Boolean subSalir=false;
		
		while(!subSalir) {
			
		System.out.println();
		System.out.println("¿Como quieres realizar el filtrado por "+atributo+" ?");
		System.out.println();
		System.out.println("1.-Busqueda por sugerencia (Introduce un caracter o cadena e imprime atributos que contengan lo indicado)");
		System.out.println("2.-Busqueda exacta");
		System.out.println("3.-Letra con la que empieza el atributo del libro a buscar");
		System.out.println("0.-Salir");
		System.out.println();
		
		try {
		
		subOpcionStrings=Programa.teclado.nextInt();
		
		Programa.teclado.nextLine();
		
		
		
		switch(subOpcionStrings) {
		
		case 1:
			
			//filtroAplicar += busquedaPorSugerencia(atributo);
			mostrarResultados();
			break;
			
		case 2:
			
			//filtroAplicar += busquedaExacta(atributo);	
			mostrarResultados();
			break;
			
		case 3:
			
		//	filtroAplicar += busquedaPorPrimeraLetra(atributo);
			mostrarResultados();
			break;
			
		case 0:
			System.out.println("Volviendo al menú de atributos, se borrarán los filtros realizados para estre atributo");
			System.out.println();
			subSalir=true;
			
			break;
			
		default:
		
			System.out.println("Introduzca un número dentro de los parámetros");
		break;
			
		}
		
		}catch(Exception e) {
			System.out.println("Introduzca un número, carácteres no válidos");
			  Programa.teclado.next();
				
		}
		
		
	
		}
		return filtroAplicar;
	}

	private void mostrarResultados() {
		// TODO Auto-generated method stub
		
	}

	


	
	
}

	
