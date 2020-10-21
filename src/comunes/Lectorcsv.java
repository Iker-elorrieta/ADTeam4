package comunes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Libro;

public class Lectorcsv {
	
	public static final String SEPARATOR=";";
	public static final String QUOTE="\"";
	   
	public static boolean lectorcsv(String archivo) {
		
		 BufferedReader br = null;
		 int cantidad = 0;
		 ArrayList <Libro> listaLibros = new ArrayList <Libro>();
	      
	      try {

			     br =new BufferedReader(new FileReader(archivo));
			     String line = br.readLine();
			     while (null!=line) {
			        String [] fields = line.split(SEPARATOR);			        
			        fields = removeTrailingQuotes(fields);
			        
			        if (!fields[0].equals("T�tulo")){
			        	cantidad = cantidad + 1;
			        	fields = removeTrailingQuotes(fields);
			        	Libro libro = new Libro();
				        libro.setTitulo(fields[0]);
				        libro.setEditorial(fields[1]);
				        libro.setPaginas(Integer.valueOf(fields[2]));
				        libro.setAltura(Integer.valueOf(fields[3]));
				        libro.setNotas(fields[4]);
				        libro.setIsbn(fields[5]);
				        libro.setMaterias(fields[6]);
				        
				        listaLibros.add(libro);
				
			        }
			        
			        line = br.readLine();
			     }
			     
			     MostrarDatos.mostrarLibros(listaLibros);
			     
			  } catch (Exception e) {
				  
				  System.out.println("Error en clase Lectorcsv");

			  } finally {
			     if (null!=br) {
			        try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Error en clase Lectorcsv");
					}
			     }
			  }
	      
	      if (cantidad == 0) {
	    	  
	    	  return false;
	    	  
	      } else {
	    	  
	    	  return true;
	      }
	      
	}
	
	private static String[] removeTrailingQuotes(String[] fields) {

	      String result[] = new String[fields.length];

	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll(QUOTE, "");
	      }
	      return result;
	   }

}
