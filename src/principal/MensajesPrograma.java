package principal;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;

import comunes.CrearArchivo;
import comunes.CsvUtilidades;
import comunes.MostrarDatos;
import comunes.RellenarLibro;
import comunes.TxtUtilidades;
import comunes.XmlUtilidades;
import modelo.Libro;

public class MensajesPrograma {
	
	public static void elegirTipoArchivo() {
		
		do {
			System.out.println("Introduzca 1 para trabajar con un fichero .txt");
			System.out.println("Introduzca 2 para trabajar con un fichero .xml");
			System.out.println("Introduzca 3 para trabajar con un fichero .csv");
			System.out.println("Introduzca 0 para salir");
			System.out.println();
			System.out.print("Elija su opción: ");
			try {
				Programa.setOpcion1(Programa.teclado.nextInt());
				Programa.teclado.nextLine();

			} catch (InputMismatchException e) {
				Programa.setOpcion1(-1);
				Programa.teclado.nextLine();
			}
			if (Programa.getOpcion1() != 1 && Programa.getOpcion1() != 2 && Programa.getOpcion1() != 3
					&& Programa.getOpcion1() != 0) {

				System.out.println();
				System.out.println("Opción incorrecta, vuelva a elegir");
				System.out.println();
			} 
		} while (Programa.getOpcion1() != 1 && Programa.getOpcion1() != 2 && Programa.getOpcion1() != 3
					&& Programa.getOpcion1() != 0);

	}
	
	public static void leeroEditar() {
		
		switch (Programa.getOpcion1()) {
		case 1:

			Programa.setTipoArchivo("txt");
			Programa.setArchivo(Programa.getArchivotxt());

			break;
		case 2:

			Programa.setTipoArchivo("xml");
			Programa.setArchivo(Programa.getArchivoxml());

			break;
		case 3:

			Programa.setTipoArchivo("csv");
			Programa.setArchivo(Programa.getArchivocsv());

			break;

		default:
			break;
		}
		
		System.out.println();
		System.out.println("Ha elegido trabajar con un fichero " + Programa.getTipoArchivo());
		
		do {
			System.out.println();
			System.out.println("Introduzca 1 para leer el fichero");
			System.out.println("Introduzca 2 para editar el fichero");
			System.out.println("Introduzca 0 para salir");
			System.out.println();
			System.out.print("Elija su opción: ");
			try {
				Programa.setOpcion2(Programa.teclado.nextInt());
				Programa.teclado.nextLine();

			} catch (InputMismatchException e) {
				Programa.setOpcion2(-1);
				Programa.teclado.nextLine();
			}
			if (Programa.getOpcion2() != 1 && Programa.getOpcion2() != 2 && Programa.getOpcion2() != 0) {

				System.out.println();
				System.out.println("Opción incorrecta, vuelva a elegir");
			}
			
		} while (Programa.getOpcion2() != 1 && Programa.getOpcion2() != 2 && Programa.getOpcion2() != 0);

	}

	public static void leerArchivo() {
		
		File fichero = new File(Programa.getArchivo());
		
		if (fichero.exists()) {
			
			System.out.println("Ha elegido leer el archivo " + Programa.getTipoArchivo());
			System.out.println();

			switch (Programa.getOpcion1()) {
			case 1:
				
				MostrarDatos.mostrarLibros(new ArrayList<Libro>(TxtUtilidades.obtenerLibros(Programa.getArchivo())));
				
				break;

			case 2:
				
				MostrarDatos.mostrarLibros(new ArrayList<Libro>(XmlUtilidades.obtenerLibros(Programa.getArchivo())));
				
				break;

			case 3:
				
				MostrarDatos.mostrarLibros(new ArrayList<Libro>(CsvUtilidades.obtenerLibros(Programa.getArchivo())));
				
				break;

			default:
				break;
			}
				
		} else {
			
			System.out.println();
			System.out.println("El archivo " + Programa.getArchivo() + " no existe");
			System.out.println();
			
		}
		
	}
	
	public static void editarArchivo() {
		
		System.out.println();
		System.out.println("Ha elegido editar el fichero " + Programa.getTipoArchivo());
		
		do {
			System.out.println();
			System.out.println("Introduzca 1 para añadir un libro al fichero");
			System.out.println("Introduzca 2 para editar un libro del fichero");
			System.out.println("Introduzca 3 para eliminar un libro del fichero");
			System.out.println("Introduzca 0 para salir");
			System.out.println();
			System.out.print("Elija su opción: ");
			try {
				Programa.setOpcion3(Programa.teclado.nextInt());
				Programa.teclado.nextLine();
			} catch (Exception e) {
				Programa.setOpcion3(-1);
				Programa.teclado.nextLine();
			} 
			
			if (Programa.getOpcion3() != 1 && Programa.getOpcion3() != 2 && Programa.getOpcion3() != 3 && Programa.getOpcion3() != 0) {

				System.out.println();
				System.out.println("Opción incorrecta, vuelva a elegir");
			}
			
			
		} while (Programa.getOpcion3() != 1 && Programa.getOpcion3() != 2 && Programa.getOpcion3() != 3 && Programa.getOpcion3() != 0);
	
	}
	
	public static void anyadirLibro() {
		
		System.out.println();
		System.out.println("Ha elegido añadir un libro al archivo " + Programa.getTipoArchivo());
		System.out.println();
		Libro libro = new Libro();
		RellenarLibro.rellenarLibro(libro);
		File fichero = new File(Programa.getArchivo());
		
		if (!fichero.exists()) {
			
			CrearArchivo.crearArchivo(Programa.getArchivo());
			
		}
		
		if (fichero.exists()) {
			
			switch (Programa.getOpcion1()) {
			case 1:

				if (TxtUtilidades.obtenerLibros(Programa.getArchivo()) != null) {
					
					Programa.setListaLibros(TxtUtilidades.obtenerLibros(Programa.getArchivo()));
				}

				break;
			case 2:
				
				if (XmlUtilidades.obtenerLibros(Programa.getArchivo()) != null) {
					
					Programa.setListaLibros(XmlUtilidades.obtenerLibros(Programa.getArchivo()));
				}
				
				break;
			case 3:
				
				if (CsvUtilidades.obtenerLibros(Programa.getArchivo()) != null) {
					
					Programa.setListaLibros(CsvUtilidades.obtenerLibros(Programa.getArchivo()));
				}

				break;

			default:
				break;
			}
		
				Programa.getListaLibros().add(libro);

				
			switch (Programa.getOpcion1()) {
			case 1:

				TxtUtilidades.escribirTxt(Programa.getArchivo(), Programa.getListaLibros());

				break;
			case 2:

				XmlUtilidades.escribirXml(Programa.getArchivo(), Programa.getListaLibros());

				break;
			case 3:

				CsvUtilidades.escribirCsv(Programa.getArchivo(), Programa.getListaLibros());

				break;

			default:
				break;
			}
			
			System.out.println();
			System.out.println("El nuevo libro ha sido añadido");
			System.out.println();
			
		}
	
	}
	
	public static void editarLibro() {
		
		int numeroaEditar = 0;
		System.out.println("Ha elegido editar un libro del fichero");
		ArrayList<Libro> listaLibrosEditar = new ArrayList<Libro>();
		
		switch (Programa.getOpcion1()) {
		case 1:
			listaLibrosEditar = TxtUtilidades.obtenerLibros(Programa.getArchivo());
			break;
			
		case 2:
			listaLibrosEditar = XmlUtilidades.obtenerLibros(Programa.getArchivo());
			break;
			
		case 3:
			listaLibrosEditar = CsvUtilidades.obtenerLibros(Programa.getArchivo());
			break;	

		default:
			break;
		}
	
		MostrarDatos.mostrarLibros(listaLibrosEditar);
		System.out.println();
		System.out.print("Escriba el número del libro que desea editar: ");
		numeroaEditar = Programa.teclado.nextInt();
		Programa.teclado.nextLine();
		if (numeroaEditar > listaLibrosEditar.size() || numeroaEditar < listaLibrosEditar.size()) {

			System.out.println("El número de libro introducido no existe");

		} else {

			RellenarLibro.rellenarLibro(listaLibrosEditar.get(numeroaEditar - 1));
			
			switch (Programa.getOpcion1()) {
			case 1:
				
				TxtUtilidades.escribirTxt(Programa.getArchivo(), listaLibrosEditar);
				
				break;
			case 2:
				
				XmlUtilidades.escribirXml(Programa.getArchivo(), listaLibrosEditar);
				
				break;
			case 3:
				
				CsvUtilidades.escribirCsv(Programa.getArchivo(), listaLibrosEditar);
				
				break;	

			default:
				break;
			}
			
			
			System.out.println("El libro " + numeroaEditar + " ha sido editado");
		}

		
	}
	
	public static void borrarLibro() {
		
		int numeroaBorrar = 0;
		System.out.println("Ha elegido borrar un libro del fichero");
		ArrayList<Libro> listaLibrosBorrar = new ArrayList<Libro>();
		
		switch (Programa.getOpcion1()) {
		case 1:
			
			listaLibrosBorrar = TxtUtilidades.obtenerLibros(Programa.getArchivo());
			
			break;

		case 2:
			
			listaLibrosBorrar = XmlUtilidades.obtenerLibros(Programa.getArchivo());
			
			break;
		case 3:
			
			listaLibrosBorrar = CsvUtilidades.obtenerLibros(Programa.getArchivo());
			
			break;	
		default:
			break;
		}
				
		MostrarDatos.mostrarLibros(listaLibrosBorrar);
		System.out.println();
		System.out.print("Escriba el número del libro que desea editar: ");
		numeroaBorrar = Programa.teclado.nextInt();
		Programa.teclado.nextLine();
		
		if (numeroaBorrar > listaLibrosBorrar.size() || numeroaBorrar <= 0) {

			System.out.println("El número de libro introducido no existe");

		} else {

			listaLibrosBorrar.remove(numeroaBorrar - 1);
			
			switch (Programa.getOpcion1()) {
			case 1:
				
				TxtUtilidades.escribirTxt(Programa.getArchivo(), listaLibrosBorrar);
				
				break;
			case 2:
				
				XmlUtilidades.escribirXml(Programa.getArchivo(), listaLibrosBorrar);
				
				break;
			case 3:
				
				CsvUtilidades.escribirCsv(Programa.getArchivo(), listaLibrosBorrar);
				
				break;	

			default:
				break;
			}
			
			System.out.println("El libro " + numeroaBorrar + " ha sido borrado");
		}
		
		
	}

}
