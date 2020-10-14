package comunes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import modelo.Libro;

public class Lectorcsv {
	
	public static final String SEPARATOR=";";
	public static final String QUOTE="\"";
	   
	public static boolean lectorcsv(String archivo) {
		
		 BufferedReader br = null;
		 int cantidad = 0;
	      
	      try {

			     br =new BufferedReader(new FileReader(archivo));
			     String line = br.readLine();
			     while (null!=line) {
			        String [] fields = line.split(SEPARATOR);			        
			        fields = removeTrailingQuotes(fields);
			        
			        if (!fields[0].equals("Título")){
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
				        
				        System.out.println("Libro " + cantidad);
				        System.out.println("\tTítulo: " + libro.getTitulo());	
				        System.out.println("\tPáginas: " + libro.getPaginas());
				        System.out.println("\tAltura: " + libro.getAltura());
				        System.out.println("\tNotas: " + libro.getNotas());
				        System.out.println("\tISBN: " + libro.getIsbn());
				        System.out.println("\tMaterias: " + libro.getMaterias());
				
			        }
			        
			        line = br.readLine();
			     }
			     
			  } catch (Exception e) {

			  } finally {
			     if (null!=br) {
			        try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
