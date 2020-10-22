package comunes;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Libro;

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
	




	public void creacionLibro() {
		
		
		
		
		//Faltan comprobaciones
		System.out.println("¿Cuantos libros quiere crear?");
		
		
		Libro  lb = new Libro();
		
		
		System.out.println("Introduzca titulo del libro a crear");
		lb.setTitulo(sc.nextLine());
		System.out.println("Introduzca editorial del libro a crear");
		lb.setEditorial(sc.nextLine());
		System.out.println("Introduzca paginas del libro a crear");
		lb.setPaginas(sc.nextInt());
		System.out.println("Introduzca altura del libro a crear");
		lb.setAltura(sc.nextInt());
		System.out.println("Introduzca notas del libro a crear");
		lb.setNotas(sc.nextLine());
		System.out.println("Introduzca isbn del libro a crear");
		lb.setIsbn(sc.nextLine());
		System.out.println("Introduzca materias del libro a crear");
		lb.setMaterias(sc.nextLine());
		
		
		System.out.println("Libro añadido al Array");
		
		this.arrayBiblioteca.add(lb);
		
		
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
