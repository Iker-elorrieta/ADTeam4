package comunes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Libro;

public class TxtUtilidades {

	public static ArrayList <Libro> obtenerLibros(String enlace){

		ArrayList<Libro> listaLibros =new ArrayList<Libro>();
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

				if(linea.contains("Título")) {
					
					l1.setTitulo(parametro);
				} 
				if(linea.contains("Editorial")) {
					
					l1.setEditorial(parametro);
				}
				if(linea.contains("Páginas")) {
					
					l1.setPaginas(Integer.parseInt(parametro));
				}
				if(linea.contains("Altura")) {
					
					l1.setAltura(Integer.parseInt(parametro));
				}
				if(linea.contains("Notas")) {
					
					l1.setNotas(parametro);
				}
				if(linea.contains("ISBN")) {
					
					l1.setIsbn(parametro);
				}
				if(linea.contains("Materias")) {
					
					l1.setMaterias(parametro);
				}
				if(linea.contains("*****")) {
					listaLibros.add(l1);
					l1 = new Libro();
				}
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println("El sistema no puede encontrar el archivo especificado");

		}
		
		return listaLibros;
	}
	
	public static boolean escribirTxt(String url, ArrayList<Libro> libro) {
		
		boolean boo = false;
		File txt = new File(url);
		
		try {
			FileWriter fw = new FileWriter(txt);
			BufferedWriter bfwriter = new BufferedWriter(fw);
			for (Libro l1 : libro) {
				bfwriter.write("- Título: " + l1.getTitulo() + "\n- Editorial: " + l1.getEditorial() + "\n- Páginas: " + l1.getPaginas()
						+ "\n- Altura: " + l1.getAltura() + "\n- Notas: " + l1.getNotas() + "\n- ISBN: " 
						+ l1.getIsbn() + "\n- Materias: " + l1.getMaterias() + "\n*******************************\n");
			}
			boo=true;
			bfwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Archivo no encontrado");
			boo= false;
		}
	
		return boo;
	}
}
