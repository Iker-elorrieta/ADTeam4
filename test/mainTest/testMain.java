package mainTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import comunes.XmlUtilidades;
import comunes.CsvUtilidades;
import comunes.TxtUtilidades;
import modelo.Libro;
import principal.Programa;

class testMain {
	
	private TxtUtilidades LT = new TxtUtilidades();
	
	XmlUtilidades LX = new XmlUtilidades();
	
	private CsvUtilidades lc = new CsvUtilidades();

	/*
	
	   _            _      _____  _______      __
	  | |          | |    / ____|/ ____\ \    / /
	  | |_ ___  ___| |_  | |    | (___  \ \  / / 
	  | __/ _ \/ __| __| | |     \___ \  \ \/ /  
	  | ||  __/\__ \ |_  | |____ ____) |  \  /   
	   \__\___||___/\__|  \_____|_____/    \/   
	
	
	*/
	@Test
	void testCsv() {
		lc = new CsvUtilidades();
		assertEquals(true, lc.obtenerLibros(Programa.getArchivocsv()) != null);
	}
	
	@Test
	void testLectorCsvFallo() {
		
		lc = new CsvUtilidades();
		assertEquals(true, lc.obtenerLibros(null) == null);

	}
	
	/*
	   _            _     _________   _________ 
	  | |          | |   |__   __\ \ / /__   __|
	  | |_ ___  ___| |_     | |   \ V /   | |   
	  | __/ _ \/ __| __|    | |    > <    | |   
	  | ||  __/\__ \ |_     | |   / . \   | |   
	   \__\___||___/\__|    |_|  /_/ \_\  |_| 
	
	
	*/
	
	
	@Test
	void testLectorTxt(){
		

			String ruta="listalibros.txt";
			assertEquals(true, LT.obtenerLibros(Programa.getArchivotxt()) != null);
		
	}
	
	@Test
	void testLectorTxtFallo(){

	 
		
			String ruta="excepcion.txt";
			assertEquals(true, LT.obtenerLibros(null).size() == 0);
		
		
		
	}
	/*
	   _            _    __   ____  __ _      
	  | |          | |   \ \ / /  \/  | |     
	  | |_ ___  ___| |_   \ V /| \  / | |     
	  | __/ _ \/ __| __|   > < | |\/| | |     
	  | ||  __/\__ \ |_   / . \| |  | | |____ 
	   \__\___||___/\__| /_/ \_\_|  |_|______|
	                                            */
	@Test
	void testLectorXML()   {
		
		assertEquals(true,LX.obtenerLibros("Libros.xml") != null);
		
	}
	
	@Test
	void testLectorXMLFallo()   {
		
		assertEquals(true,LX.obtenerLibros("Exception.xml") == null);
			 

	}
	/*
	
	   _            _     __  __       _       
	  | |          | |   |  \/  |     (_)      
	  | |_ ___  ___| |_  | \  / | __ _ _ _ __  
	  | __/ _ \/ __| __| | |\/| |/ _` | | '_ \ 
	  | ||  __/\__ \ |_  | |  | | (_| | | | | |
	   \__\___||___/\__| |_|  |_|\__,_|_|_| |_|
	
	*/
	
	@Test
	void testmain1() {
		Programa main = new Programa();
		String input = "1 \n \1 \n 0 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma()); 
	}
	
	
	@Test
	void testmain2() {
		Programa main = new Programa();
		String input = "2 \n \1 \n 0 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());
	}
	
	@Test
	void testmain3() {
		Programa main = new Programa();
		String input = "3 \n \1 \n 0 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());
	}
	
	@Test
	void testmain4() {
		Programa main = new Programa();
		String input = "a \n 0 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma()); 

	}
	
	@Test
	void testmain5() {
		Programa main = new Programa();
		String input = "3 \n 2 \n 1 \n 1 \n 1 \n 1 \n 1 \n 1 \n 1 \n 1 \n 0 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());

	}
	
	@Test
	void testmain6() {
		Programa main = new Programa();
		String input = "3 \n 2 \n 3 \n 25 \n 0 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());

	}
		

	
	/*
	   _            _     _      _ _               
	  | |          | |   | |    (_) |              
	  | |_ ___  ___| |_  | |     _| |__  _ __ ___  
	  | __/ _ \/ __| __| | |    | | '_ \| '__/ _ \ 
	  | ||  __/\__ \ |_  | |____| | |_) | | | (_) |
	   \__\___||___/\__| |______|_|_.__/|_|  \___/ 
	*/
	
	@Test
	void testConstructorLibro() {
		
		Libro libro = new Libro("ah","ah",3, 2,"ah","ah","ah");
		assertEquals("ah", libro.getEditorial()); 

	}
	
}
