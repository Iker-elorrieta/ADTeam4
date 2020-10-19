package mainTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import comunes.LectorXml;
import comunes.Lectorcsv;
import comunes.Lectortxt;
import modelo.Libro;
import principal.Programa;

class testMain {
	
	private Lectortxt LT = new Lectortxt();
	
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
		Lectorcsv Lc = new Lectorcsv();
			try {
				assertEquals(true, Lc.lectorcsv("listalibros.csv"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
	}
	
	@Test
	void testLectorCsvFallo() {
		
			try {
				Lectorcsv Lc = new Lectorcsv();
				assertEquals(false, Lc.lectorcsv(null));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
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
			assertEquals(true, LT.lectorTxt(ruta));
		
	}
	
	@Test
	void testLectorTxtFallo(){

	 
		
			String ruta="excepcion.txt";
			assertEquals(false,LT.lectorTxt(ruta));
		
		
		
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
	void testLectorXML() throws FileNotFoundException   {
		
		LectorXml LX = new LectorXml();
		assertEquals(true,LX.LeerArchivoXML(("Libros.xml")));
		assertEquals(false,LX.LeerArchivoXML("Exception.xml"));
		
		 

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
		String input = "1 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, main.iniciarPrograma(teclado)); 
	}
		
		
	@Test
	void testmain2() {
		
		String input = "2 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, Programa.iniciarPrograma(teclado)); 

	}
	
	@Test
	void testmain3() {
		
		String input = "3 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, Programa.iniciarPrograma(teclado)); 

	}
	
	@Test
	void testmain4() {
		
		String input = "a \n 1 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, Programa.iniciarPrograma(teclado)); 

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
