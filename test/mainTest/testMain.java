package mainTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import comunes.XmlUtilidades;
import comunes.CrearArchivo;
import comunes.CsvUtilidades;
import comunes.MostrarDatos;
import comunes.RellenarLibro;
import comunes.TxtUtilidades;
import modelo.Libro;
import principal.MensajesPrograma;
import principal.Programa;

class testMain {
	
	private TxtUtilidades LT = new TxtUtilidades();	
	XmlUtilidades LX = new XmlUtilidades();
	private static CsvUtilidades lc;
	Libro libro = new Libro();
	ArrayList <Libro> listaLibros;	
	CrearArchivo crearArchivo = new CrearArchivo();

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
		
		assertEquals(true,LX.obtenerLibros("Exception.xml").size() == 0);
			 

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
		MensajesPrograma mensajesprograma = new MensajesPrograma();
		Programa main = new Programa();
		String input = "1\n 1\n 0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma()); 
	}
	
	
	@Test
	void testmain2() {
		Programa main = new Programa();
		String input = "2\n 1\n 0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());
	}
	
	@Test
	void testmain3() {
		Programa main = new Programa();
		String input = "3\n 1\n 0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());
	}
	
	@Test
	void testmain4() {
		Programa main = new Programa();
		String input = "a\n 0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma()); 

	}
	
	@Test
	void testmain5() {
		Programa main = new Programa();
		String input = "1\n a\n 0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma()); 

	}
	
	@Test
	void testmain6() {
		Programa main = new Programa();
		String input = "3\n 2\n 1\n 1\n 1\n 1\n 1\n 1\n 1\n 0\n 0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());

	}
	
	@Test
	void testmain7() {
		Programa main = new Programa();
		listaLibros = CsvUtilidades.obtenerLibros(Programa.getArchivocsv());
		String ultimo = String.valueOf(listaLibros.size());
		String input = "3\n 2\n 3\n 1\n " + ultimo + "\n 0 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());

	}
	
	@Test
	void testmain8() {
		Programa main = new Programa();
		listaLibros = CsvUtilidades.obtenerLibros(Programa.getArchivocsv());
		String input = "3\n 2\n 3\n 0\n 0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());

	}
	
	@Test
	void testmain9() {
		Programa main = new Programa();
		String input = "3\n 2\n a\n 0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, main.iniciarPrograma());

	}
	
	// Mostrar datos
	
	@Test
	void testmostrar1() {
		MostrarDatos mostrarDatos = new MostrarDatos();
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		listaLibros = CsvUtilidades.obtenerLibros(Programa.getArchivocsv());
		assertEquals(true, MostrarDatos.mostrarLibros(listaLibros));

		
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
		
		libro = new Libro("ah","ah",3, 2,"ah","ah","ah");
		assertEquals("ah", libro.getEditorial()); 

	}
	
	// rellenarLibro
	
	@Test
	void testRellenarLibro() {
		
		RellenarLibro rellenarLibro = new RellenarLibro();
		Libro libro = new Libro();
		String input = "ah\n ah\n s\n 1\n s\n 1\n ah\n ah\n ah\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	// crearArchivo
	
	@Test
	void testCrearArchivo1() {
		
		crearArchivo = new CrearArchivo();
		String input = "1\nn\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(false, CrearArchivo.crearArchivo("sdijsdfis.prueba")); 

	}
	
	@Test
	void testCrearArchivo2() {
		
		crearArchivo = new CrearArchivo();
		String input = "s\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, CrearArchivo.crearArchivo("sdijsdfis.prueba")); 

	}
}
