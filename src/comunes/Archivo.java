package comunes;

import java.io.File;
import java.io.IOException;
import principal.Programa;

public class Archivo {
	
	private static String barraWindows = "\\";
	private static String barraLinux = "/";

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

	public static File subirDirectorio(File file) {

		String barra = Archivo.detectarSistema();

		if (!file.getAbsolutePath().endsWith(barra)) {

			file = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(barra) + 1));

		} else {

			System.out.println("No es posible subir un nivel, se encuentra en el directorio raíz");
		}

		return file;

	}

	public static File elegirDirectorio(File file) {

		String barra = Archivo.detectarSistema();

		File directorioaexplorar = new File(file.getAbsolutePath());
		String carpeta = new String();

		System.out.print("Introduzca el nombre del directorio: ");
		carpeta = Programa.teclado.nextLine();

		if (!file.getAbsolutePath().endsWith(barra)) {

			directorioaexplorar = new File(file.getAbsolutePath() + barra + carpeta);

		} else {

			directorioaexplorar = new File(file.getAbsolutePath() + carpeta);
		}

		if (directorioaexplorar.isDirectory()) {

			file = new File(directorioaexplorar.getAbsolutePath());

		} else {

			System.out.println("El directorio introducido no existe");
		}

		return file;
	}

	public static File elegirArchivo(File file) {

		String barra = Archivo.detectarSistema();

		File archivoseleccionado = new File(file.getAbsolutePath());
		String archivo = new String();

		System.out.print("Introduzca el nombre del archivo: ");
		archivo = Programa.teclado.nextLine();

		if (!file.getAbsolutePath().endsWith(barra)) {

			archivoseleccionado = new File(file.getAbsolutePath() + barra + archivo);

		} else {

			archivoseleccionado = new File(file.getAbsolutePath() + archivo);
		}

		if (archivoseleccionado.isFile()) {

			System.out.println("Archivo seleccionado");
			file = new File(archivoseleccionado.getAbsolutePath());

		} else {
			System.out.println("El archivo introducido no existe");
			archivoseleccionado = new File("Z:\\Noexiste");
		}

		return file;

	}

	public static void mostrarArchivos(File file) {

		file = new File(file.getAbsolutePath());

		File[] listOfFiles = file.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()
					&& Validaciones.validarExtension(Programa.getExtensiones(), listOfFiles[i].getAbsolutePath())) {

				System.out.println("Archivo     \t" + listOfFiles[i].getName());

			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directorio\t" + listOfFiles[i].getName());
			}
		}

	}

	public static void moverArchivo(File archivoamover, File destino) {

		String barra = Archivo.detectarSistema();
		
		if (destino.getAbsolutePath().endsWith(barra)) {

			destino = new File(destino + archivoamover.getName());

		} else {

			destino = new File(destino + barra + archivoamover.getName());

		}

		if (!archivoamover.getAbsolutePath().equals("Z:\\Noexiste") && !archivoamover.equals(destino)) {
			
			archivoamover.renameTo(destino);
			System.out.println("Archivo movido");

		} else {
			
			if (archivoamover.getAbsolutePath().equals("Z:\\Noexiste")) {
				
				System.out.println("Seleccione un archivo antes de moverlo");
				
			}
			
			if (archivoamover.equals(destino)) {
				
				System.out.println("El directorio de origen coincide con el directorio de destino, elija uno distinto");
				
			}

		}

	}

	public static void crearDirectorio(File directorioactual) {
		
		String barra = Archivo.detectarSistema();
		String nombredirectorio = new String();
		File directorioacrear = new File(".");

		System.out.print("Escriba el nombre del directorio a crear: ");
		nombredirectorio = Programa.teclado.nextLine();
		
		if (!directorioactual.getAbsolutePath().endsWith(barra)) {

			directorioacrear = new File(directorioactual.getAbsolutePath() + barra + nombredirectorio);
			
		} else {
			
			directorioacrear = new File(directorioactual.getAbsolutePath() + nombredirectorio);
		}
		
		if (!directorioacrear.exists()) {

			if (directorioacrear.mkdir()) {

				System.out.println("Directorio creado");

			} else {

				System.out.println("Ocurrió un error creando el directorio");
			}

		} else {

			System.out.println("El directorio ya existe");

		}

	}

	public static String detectarSistema() {

		String barra = "";

		if (System.getProperty("os.name").contains("Windows")) {

			barra = Archivo.barraWindows;

		} else {

			barra = Archivo.barraLinux;

		}

		return barra;

	}
}
