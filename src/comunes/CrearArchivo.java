package comunes;

import java.io.File;
import java.io.IOException;

import principal.Programa;

public class CrearArchivo {

	public static boolean crearArchivo(String archivo) {
		
		File fichero = new File (archivo);
		String opcion = new String();
		Boolean creado = false;
		
		if (!fichero.exists()) {
			
			do {
				System.out.println();
				System.out.print("El archivo no existe, ¿quiere crear uno nuevo? S/N: ");
				opcion = Programa.teclado.nextLine();
				
				if (!opcion.equals("s") && (!opcion.equals("S") && (!opcion.equals("n") && (!opcion.equals("N"))))) {
					
					System.out.println("Opción no válida, vuelva a intentarlo");
				}
				
			} while ((!opcion.equals("s") && (!opcion.equals("S") && (!opcion.equals("n") && (!opcion.equals("N"))))));
					
			
			if (opcion.equals("s") || opcion.equals("S")) {
				
				try {
					fichero.createNewFile();
					System.out.println();
					System.out.println("El archivo " + archivo + " ha sido creado");
					creado = true;
				} catch (IOException e) {
					System.out.println("Ocurrió un error al crear el archivo");
				}
				
			} else {
				System.out.println();
				System.out.println("Eligió no crear un archivo. Volviendo...");
				System.out.println();
			}
			
		}
	
		return creado;
	}
}
