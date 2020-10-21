package principal;

import java.util.InputMismatchException;
import java.util.Scanner;
import comunes.LectorXml;
import comunes.Lectorcsv;
import comunes.Lectortxt;

public class Programa {
	
	public static Scanner teclado = new Scanner (System.in);
	private static final String ARCHIVOTXT = "listalibros.txt";
	private static final String ARCHIVOXML = "Libros.xml";
	private static final String ARCHIVOCSV = "listalibros.csv";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   
		iniciarPrograma(teclado);
	}
	
	public static boolean iniciarPrograma(Scanner teclado) {
		
		int opcion = 0;
		
		System.out.println("¿Qué tipo de fichero quiere leer?");
		
		do {
			
			System.out.println();
			System.out.println("Introduzca 1 para leer un archivo .txt");
			System.out.println("Introduzca 2 para leer un archivo .xml");
			System.out.println("Introduzca 3 para leer un archivo .csv");
			System.out.println();
			System.out.print("Elija su opción: ");
			
			try {
				opcion = teclado.nextInt();
				
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
				
			case 2:
				
				LectorXml.LeerArchivoXML(ARCHIVOXML);
			
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