package principal;

import java.util.Scanner;
import modelo.Biblioteca;

public class Programa {

	public static Scanner teclado = new Scanner(System.in);
	private static Biblioteca biblioteca = new Biblioteca();
	private static String archivo = new String();
	private static int opcion = -1;
	private static final String[] EXTENSIONES = {"txt","xml","csv"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		iniciarPrograma();
	}

	public static boolean iniciarPrograma() {
				
		do {
			
			System.out.println("Introduzca 1 para cargar biblioteca");
			System.out.println("Introduzca 2 para leer biblioteca");
			System.out.println("Introduzca 3 para editar biblioteca");
			System.out.println("Introduzca 4 para guardar biblioteca");
			System.out.println("Introduzca 5 para filtrar libros de la biblioteca");
			System.out.println("Introduzca 0 para salir");
			System.out.println();
			System.out.print("Elija su opción: ");
			try {
				opcion = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				opcion = -1;
			}
			switch (opcion) {
			case 1:
				
				System.out.println();
				Opciones.cargarBiblioteca();
				
				break;
				
			case 2:
				
				System.out.println();
				Opciones.mostrarBiblioteca();
			
				break;
			
			case 3:
				
				System.out.println();
				Opciones.editarBiblioteca();
		
				break;
				
			case 4:
				
				System.out.println();
				Opciones.guardarBiblioteca();
	
				break;
				
			case 5:
				System.out.println();
				Opciones.filtrarBiblioteca();
				
				break;
				
			default:
				break;
			}
			
			if (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 0 && opcion != 9) {
				
				System.out.println();
				System.out.println("Opción no válida, vuelva a intentarlo");
				System.out.println();
			}
			
		} while (opcion != 0);
		
		System.out.println();
		System.out.println("Saliendo...");	
		
		return true;
		
	}

	public static String getArchivo() {
		return archivo;
	}

	public static void setArchivo(String archivo) {
		Programa.archivo = archivo;
	}

	public static int getOpcion() {
		return opcion;
	}

	public static void setOpcion(int opcion1) {
		Programa.opcion = opcion1;
	}

	public static String[] getExtensiones() {
		return EXTENSIONES;
	}

	public static Biblioteca getBiblioteca() {
		return biblioteca;
	}

}

