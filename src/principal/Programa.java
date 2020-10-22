package principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import comunes.Biblioteca;
import comunes.CrearXml;
import comunes.LectorXml;
import comunes.Lectorcsv;
import comunes.Lectortxt;
import modelo.Libro;

public class Programa {
	
	public static Scanner teclado = new Scanner (System.in);
	private static final String ARCHIVOTXT = "listalibros.txt";
	private static final String ARCHIVOXML = "Libros.xml";
	private static final String ARCHIVOCSV = "listalibros.csv";
	private static ArrayList<Libro> arrayLibro = new ArrayList<Libro>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   
		iniciarPrograma(teclado);
	}
	
	public static boolean iniciarPrograma(Scanner teclado) {
		
		int opcion = 0;
		
		System.out.println("¿Qué tipo de fichero quiere leer?");
		
		do {
			
			System.out.println();
			System.out.println("Introduzca 1 para trabajar con un archivo .txt");
			System.out.println("Introduzca 2 para trabajar con un archivo .xml");
			System.out.println("Introduzca 3 para trabajar con un archivo .csv");
			System.out.println();
			System.out.print("Elija su opción: ");
			
			try {
				opcion = teclado.nextInt();
				teclado.nextLine();
			} catch (InputMismatchException e) {
				opcion = 0;
				teclado.nextLine();
			}
			
			if (opcion != 1 && opcion != 2 && opcion != 3) {
				
				System.out.println();
				System.out.println("Opción incorrecta, vuelva a elegir");
			}
			
			System.out.println();
			
			switch (opcion) {
			case 1:
				
				Lectortxt.lectorTxt(ARCHIVOTXT);
					
				break;
			
				
				
				
				
			case 2: //XML
				
				
				int opcionXml= 0;
				System.out.println("Que desea hacer con el archivo xml.");
				System.out.println();
				System.out.println("Introduzca 1 para leer un fichero xml.");
				System.out.println("Introduzca 2 para crear un nuevo fichero xml.");
				System.out.println("Introduzca 3 para editar un nuevo fichero xml existente.");
				System.out.println("Introduzca 4 para borrar un fichero xml existente.");
				
				try {
					opcionXml = teclado.nextInt();
					teclado.nextLine();
					
				} catch (InputMismatchException e) {
					opcion = 0;
					teclado.nextLine();
				}
				
				
				switch(opcionXml) {
				
				case 1:
				 arrayLibro=LectorXml.LeerArchivoXML(Biblioteca.verArchivosALeer("xml"));
				break;
				
				case 2:
				
				
				//CrearXml.generarXML(respuesta,arrayLb);
					
				
				break;
				
				case 3:
				CrearXml.cambiarXML();
					
				break;
				
				}
				
				
				
				
			break;	
			
			case 3:
				
				Lectorcsv.lectorcsv(ARCHIVOCSV);
					
				break;

			default:
				break;
			}
			
		} while (opcion != 1 && opcion != 2 && opcion != 3);
		
		return true;
		
	}
	
}