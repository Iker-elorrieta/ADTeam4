package mainTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import comunes.LectorXml;
import comunes.Lectortxt;
import principal.Programa;

class testMain {
	
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
		assertEquals(true, comunes.Lectorcsv.lectorcsv("listalibros.csv"));
	}
	
	@Test
	void testLectorCsvFallo() {
		assertEquals(false, comunes.Lectorcsv.lectorcsv(null));
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
	void testLectorTxt() throws IOException {
		Lectortxt l1 = new Lectortxt();
		boolean resul = l1.txt("listalibros.txt");
		assertEquals(true,resul);
		
	}
	
	@Test
	void testLectorTxtFallo() throws IOException {
		Lectortxt l1 = new Lectortxt();
		boolean resul = l1.txt("listalibrosa.txt");
		assertEquals(true,resul);
		
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
		
		comunes.LectorXml lx = new LectorXml();
		
		 assertEquals(true,lx.LeerArchivoXML("Libros.xml"));
		 assertEquals(false,lx.LeerArchivoXML("Exception.xml"));
		 

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
		
		String input = "1 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, Programa.iniciarPrograma(teclado)); 
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
	
	
	
}
