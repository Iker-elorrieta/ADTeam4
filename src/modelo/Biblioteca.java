package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	static Scanner sc = new Scanner(System.in);
	 private ArrayList<Libro> arrayBiblioteca;
	 
	
	
	
	
	
	
	public Biblioteca() {
		this.arrayBiblioteca = new ArrayList<Libro>();
	}


	public void mostrarLibrosBiblioteca() {
		
		for(int temp = 0 ; temp< arrayBiblioteca.size();temp++) {
			
			System.out.println(arrayBiblioteca.get(temp).toString());
			
			
		}
		
		
	}
		
	//Metodo que devuelve en un array de Strings todos los archivos que hay en una carpeta, en base a su extension
	
	public static String verArchivosALeer(String extension){
	
	
		String ruta= "C:\\Users\\Julen\\eclipse-workspace\\Proyecto\\ADTeam4";
		String archivoEditar="";
		Boolean control;
		ArrayList<String >listadoConExtension = new ArrayList<String>(); 
		
	
	
	    String[] listado ;	
		File carpeta = new File(ruta);
		listado = carpeta.list();
		
		System.out.println("Estos son los libros de los que disponemos:");
		System.out.println();
		for(int temp=0; temp<listado.length;temp++) {
			
		if(listado[temp].endsWith(extension))	{
			System.out.println(listado[temp]);
			}
		}	
		
		System.out.println();
		System.out.println("Introduzca el archivo que quiere utilizar");
		archivoEditar = sc.nextLine();
		
		//Falta comprobacion
		
		
		return archivoEditar;
		
		
	}







	public ArrayList<Libro> getArrayBiblioteca() {
		return arrayBiblioteca;
	}







	
	
}
