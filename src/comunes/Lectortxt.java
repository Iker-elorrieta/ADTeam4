package comunes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Libro;

public class Lectortxt {

	public static boolean lectorTxt(String enlace){
		boolean boo = false;
		ArrayList<Libro> libros =new ArrayList<Libro>();
		
		try {	
		File readfichero = new File(enlace);
		FileReader fr = new FileReader (readfichero);
		BufferedReader br = new BufferedReader(fr);
	
			
			String linea = "";
			Libro l1 = new Libro();
			while((linea=br.readLine())!=null) {
				
				boo = true;
				if(linea.contains("Titulo")) {
					String array[] = linea.split(": ");
					l1.setTitulo(array[1]);
				} 
				if(linea.contains("Editorial")) {
					String array[] = linea.split(": ");
					l1.setEditorial(array[1]);
				}
				if(linea.contains("Paginas")) {
					String array[] = linea.split(": ");
					l1.setPaginas(Integer.parseInt(array[1]));
				}
				if(linea.contains("Altura")) {
					String array[] = linea.split(": ");
					l1.setAltura(Integer.parseInt(array[1]));
				}
				if(linea.contains("Notas")) {
					String array[] = linea.split(": ");
					l1.setNotas(array[1]);
				}
				if(linea.contains("Isbn")) {
					String array[] = linea.split(": ");
					l1.setIsbn(array[1]);
				}
				if(linea.contains("Materias")) {
					String array[] = linea.split(": ");
					l1.setMaterias(array[1]);
				}
				if(linea.contains("*****")) {
					libros.add(l1);
					l1 = new Libro();
				}
			}
			MostrarDatos.mostrarLibros(libros);
			
		} catch (Exception e) {
			System.out.println("El sistema no puede encontrar el archivo especificado");
			boo=false;
		}
		
		return boo;
	}
}
