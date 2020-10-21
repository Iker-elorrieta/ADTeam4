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
		final String SPLIT = ": ";
		
		try {	
		File readfichero = new File(enlace);
		FileReader fr = new FileReader (readfichero);
		BufferedReader br = new BufferedReader(fr);
	
			
			String linea = "";
			Libro l1 = new Libro();
			while((linea=br.readLine())!=null) {

				String parametro = new String(); 
				
				if(!linea.contains("*****")) {
					
					parametro = linea.split(SPLIT)[1];
				}
								
				boo = true;
				if(linea.contains("Titulo")) {
					
					l1.setTitulo(parametro);
				} 
				if(linea.contains("Editorial")) {
					
					l1.setEditorial(parametro);
				}
				if(linea.contains("Paginas")) {
					
					l1.setPaginas(Integer.parseInt(parametro));
				}
				if(linea.contains("Altura")) {
					
					l1.setAltura(Integer.parseInt(parametro));
				}
				if(linea.contains("Notas")) {
					
					l1.setNotas(parametro);
				}
				if(linea.contains("Isbn")) {
					
					l1.setIsbn(parametro);
				}
				if(linea.contains("Materias")) {
					
					l1.setMaterias(parametro);
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
