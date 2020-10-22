package principal;

import java.util.ArrayList;
import java.util.InputMismatchException;

import comunes.CsvUtilidades;
import comunes.MostrarDatos;
import comunes.RellenarLibro;
import comunes.TxtUtilidades;
import comunes.XmlUtilidades;
import modelo.Libro;
import principal.Programa;

public class ProgramaMensajes {
	
	public static void elegirTipoArchivo() {
		
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

		if (Programa.getOpcion1() != 1 && Programa.getOpcion1() != 2 && Programa.getOpcion1() != 3 && Programa.getOpcion1() != 0) {

			System.out.println();
			System.out.println("Opción incorrecta, vuelva a elegir");
			System.out.println();
		}
		
		System.out.println("La opción elegida es " + Programa.getOpcion1());

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
		System.out.println();
		System.out.println("Introduzca 1 para leer el fichero");
		System.out.println("Introduzca 2 para editar el fichero");
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

		System.out.println();

	}

	public static void leerArchivo() {

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
			
	}
	
	public static void editarArchivo() {
		
		System.out.println("Ha elegido editar el fichero " + Programa.getTipoArchivo());
		System.out.println();
		System.out.println("Introduzca 1 para añadir un libro al fichero");
		System.out.println("Introduzca 2 para editar un libro del fichero");
		System.out.println("Introduzca 3 para eliminar un libro del fichero");
		System.out.println();
		System.out.print("Elija su opción: ");
		Programa.setOpcion3(Programa.teclado.nextInt());
		Programa.teclado.nextLine();

			
	}
	
	public static void anyadirLibro() {
		
		System.out.println("Ha elegido añadir un libro al archivo " + Programa.getTipoArchivo());
		System.out.println();
		Libro libro = new Libro();
		RellenarLibro.rellenarLibro(libro);

		switch (Programa.getOpcion1()) {
		case 1:

			Programa.setListaLibros(TxtUtilidades.obtenerLibros(Programa.getArchivo())); 

			break;
		case 2:

			Programa.setListaLibros(XmlUtilidades.obtenerLibros(Programa.getArchivo())); 

			break;
		case 3:

			Programa.setListaLibros(CsvUtilidades.obtenerLibros(Programa.getArchivo())); 

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

		System.out.println("El nuevo libro ha sido añadido");
	
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
		
		if (numeroaBorrar > listaLibrosBorrar.size() || numeroaBorrar < listaLibrosBorrar.size()) {

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
