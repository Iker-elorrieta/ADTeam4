package comunes;

import java.io.File;
import java.io.IOException;

import principal.Programa;

public class CrearArchivo {

	public static boolean crearArchivo(String archivo) {
		
		File fichero = new File (archivo);
		String opcion = new String();
		
		if (!fichero.exists()) {
			
			do {
				System.out.print("El archivo no existe, ¿quiere crear uno nuevo? S/N: ");
				opcion = Programa.teclado.nextLine();
				
				if (!opcion.equals("s") && (!opcion.equals("S") && (!opcion.equals("n") && (!opcion.equals("N"))))) {
					
					System.out.println("Opción no válida, vuelva a intentarlo");
				}
				
			} while ((!opcion.equals("s") && (!opcion.equals("S") && (!opcion.equals("n") && (!opcion.equals("N"))))));
					
			
			if (opcion.equals("s") || opcion.equals("S")) {
				
				try {
					fichero.createNewFile();
					System.out.println("El archivo " + archivo + " ha sido creado");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				
				System.out.println("Eligió no crear un archivo. Volviendo...");
			}
			
		}
	
		return true;
	}
}
