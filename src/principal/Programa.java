package principal;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Libro;

public class Programa {

	public static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Libro> listaLibros = new ArrayList<Libro>();
	private static final String ARCHIVOTXT = "listalibros.txt";
	private static final String ARCHIVOXML = "listalibros.xml";
	private static final String ARCHIVOCSV = "listalibros.csv";
	private static String tipoArchivo = new String();
	private static String archivo = new String();
	private static int opcion1 = -1;
	private static int opcion2 = -1;
	private static int opcion3 = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		iniciarPrograma();
	}

	public static boolean iniciarPrograma() {

		do {

			MensajesPrograma.elegirTipoArchivo();

			switch (opcion1) {
			case 1:
			case 2:
			case 3:

				MensajesPrograma.leeroEditar();

				switch (opcion2) {
				case 1:

					MensajesPrograma.leerArchivo();

					break;
				case 2:

					MensajesPrograma.editarArchivo();

					switch (opcion3) {
					case 1:

						MensajesPrograma.anyadirLibro();

						break;
					case 2:

						MensajesPrograma.editarLibro();

						break;
					case 3:

						MensajesPrograma.borrarLibro();

						break;

					default:
						break;
					}

					break;

				default:
					break;
				}

				break;

			default:
				break;
			}

		} while (opcion1 != 0 && opcion2 != 0 && opcion3 != 0);

		System.out.println("Saliendo...");

		return true;

	}

	public static String getArchivotxt() {
		return ARCHIVOTXT;
	}

	public static String getArchivoxml() {
		return ARCHIVOXML;
	}

	public static String getArchivocsv() {
		return ARCHIVOCSV;
	}

	public static String getTipoArchivo() {
		return tipoArchivo;
	}

	public static void setTipoArchivo(String tipoArchivo) {
		Programa.tipoArchivo = tipoArchivo;
	}

	public static String getArchivo() {
		return archivo;
	}

	public static void setArchivo(String archivo) {
		Programa.archivo = archivo;
	}

	public static int getOpcion1() {
		return opcion1;
	}

	public static void setOpcion1(int opcion1) {
		Programa.opcion1 = opcion1;
	}

	public static int getOpcion2() {
		return opcion2;
	}

	public static void setOpcion2(int opcion2) {
		Programa.opcion2 = opcion2;
	}

	public static int getOpcion3() {
		return opcion3;
	}

	public static void setOpcion3(int opcion3) {
		Programa.opcion3 = opcion3;
	}

	public static ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public static void setListaLibros(ArrayList<Libro> listaLibros) {
		Programa.listaLibros = listaLibros;
	}

}