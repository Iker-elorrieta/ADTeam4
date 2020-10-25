package comunes;

import java.io.File;
import java.io.IOException;

public class Archivo {

	public static boolean comprobarArchivo(String archivo) {

		Boolean existe = false;
		File fichero = new File(archivo);

		if (fichero.exists()) {

			existe = true;
		}

		return existe;
	}

	public static boolean crearArchivo(String archivo) {

		File fichero = new File(archivo);
		Boolean creado = false;

		if (!comprobarArchivo(archivo)) {

			try {
				fichero.createNewFile();
				System.out.println("El archivo " + archivo + " ha sido creado");
				creado = true;
			} catch (IOException e) {
				System.out.println("Ocurrió un error al crear el archivo");
			}

		} else {

			System.out.println("El archivo " + archivo + " ya existe");
		}

		return creado;
	}
}
