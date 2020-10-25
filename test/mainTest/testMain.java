package mainTest;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import comunes.XmlUtilidades;
import comunes.Archivo;
import comunes.CsvUtilidades;
import comunes.MostrarDatos;
import comunes.RellenarLibro;
import comunes.TxtUtilidades;
import modelo.Libro;
import principal.Opciones;
import principal.Programa;

class testMain {
	
	TxtUtilidades LT = new TxtUtilidades();	
	XmlUtilidades LX = new XmlUtilidades();
	CsvUtilidades lc = new CsvUtilidades();
	Libro libro = new Libro();
	Archivo archivo = new Archivo();
	File file;
	Programa main = new Programa();
	Opciones opciones = new Opciones();
	MostrarDatos mostrarDatos = new MostrarDatos();
	RellenarLibro rellenarLibro = new RellenarLibro();
	final String ARCHIVOTXT = "listalibros.txt";
	final String ARCHIVOXML = "listalibros.xml";
	final String ARCHIVOCSV = "listalibros.csv";

	/*
	
	   _            _      _____  _______      __
	  | |          | |    / ____|/ ____\ \    / /
	  | |_ ___  ___| |_  | |    | (___  \ \  / / 
	  | __/ _ \/ __| __| | |     \___ \  \ \/ /  
	  | ||  __/\__ \ |_  | |____ ____) |  \  /   
	   \__\___||___/\__|  \_____|_____/    \/   
	
	
	// Lectura de archivo csv
	
	*/
	@Test
	void testCsv() {
		assertEquals(true, CsvUtilidades.obtenerLibros(ARCHIVOCSV) != null);
	}
	
	// Al mandarle que lea un archivo nulo la lista que recoje acaba siendo nula también
	
	@Test
	void testLectorCsvFallo() {
		assertEquals(true, CsvUtilidades.obtenerLibros(null) == null);

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
			assertEquals(true, TxtUtilidades.obtenerLibros(ARCHIVOTXT) != null);
		
	}
	
	@Test
	void testLectorTxtFallo(){
			assertEquals(true, TxtUtilidades.obtenerLibros(null).size() == 0);
			
		
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
		
		assertEquals(true, XmlUtilidades.obtenerLibros("Libros.xml") != null);
		
	}
	
	@Test
	void testLectorXMLFallo()   {
		
		assertEquals(true, XmlUtilidades.obtenerLibros(null).size() == 0);
			 

	}
	/*
	
	   _            _     __  __       _       
	  | |          | |   |  \/  |     (_)      
	  | |_ ___  ___| |_  | \  / | __ _ _ _ __  
	  | __/ _ \/ __| __| | |\/| |/ _` | | '_ \ 
	  | ||  __/\__ \ |_  | |  | | (_| | | | | |
	   \__\___||___/\__| |_|  |_|\__,_|_|_| |_|
	
	*/
	
	// Menú principal. Se introduce una opción no válida
	
	@Test
	void testmain1() {
		String input = "a\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());

	}
	
	// Cargar biblioteca. Carga de archivo txt
	
	@Test
	void testmain2() {
		String input = "1\nlistalibros.txt\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
	}
	
	// Cargar biblioteca. Carga de archivo xml
	
	@Test
	void testmain3() {
		String input = "1\nlistalibros.xml\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		
	}
	
	// Cargar biblioteca. Carga de archivo csv
	
	@Test
	void testmain4() {
		String input = "1\nlistalibros.csv\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
	}
	
	// Cargar biblioteca. Intento de carga con nombre de archivo no válido, después se selecciona volver
	
	@Test
	void testmain5() {
		String input = "1\nlistalibros.no\n9\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
	}
	
	// Cargar biblioteca. Intento de carga con una extensión de archivo válida pero el archivo no existe
	
	@Test
	void testmain6() {
		String input = "1\nnoexiste.csv\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
	}
	
	// Leer biblioteca. Se carga un archivo y luego se lee
	
	@Test
	void testmain7() {
		String input = "1\nlistalibros.txt\n2\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Leer biblioteca. Se intenta leer la biblioteca sin haber cargado nada antes
	
	@Test
	void testmain8() {
		String input = "2\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Editar biblioteca. Se añade un libro a la biblioteca
	
	@Test
	void testmain9() {
		String input = "3\n1\n1\n1\n1\n1\n1\n1\n1\n3\n1\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Editar biblioteca. Se añade un libro a la biblioteca y luego se edita
	
	@Test
	void testmain10() {
		String input = "3\n1\n1\n1\n1\n1\n1\n1\n1\n2\n1\n1\n1\n1\n1\n1\n1\n1\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Editar biblioteca. Se añade un libro a la biblioteca, luego se intenta editar
	// pero se introduce un caracter no válido
	
	@Test
	void testmain11() {
		String input = "3\n1\n1\n1\n1\n1\n1\n1\n1\n3\na\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Editar biblioteca. Se añade un libro a la biblioteca, luego se intenta borrar
	// pero se introduce un número de libro que no existe, el 4
	
	@Test
	void testmain12() {
		String input = "3\n1\n1\n1\n1\n1\n1\n1\n1\n3\n4\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Editar biblioteca. Se intenta editar la biblioteca estando vacía y después
	// se introduce un caracter no válido

	@Test
	void testmain13() {
		String input = "3\n2\na\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Editar biblioteca. Carga de libro e intento de edición primero
	// poniendo un caracter no válido y después un número de libro que no existe
	
	@Test
	void testmain14() {
		String input = "1\nlistalibros.csv\n3\n2\na\n4\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		
	}
	
	// Editar biblioteca. Se intenta borrar un libro con la biblioteca vacía
	
	@Test
	void testmain15() {
		String input = "3\n3\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Editar biblioteca. Opción volver.
	
	@Test
	void testmain16() {
		String input = "3\n9\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Guardar biblioteca. Se guarda la biblioteca en un archivo txt.
	
	@Test
	void testmain17() {
		file = new File("archivoprueba.txt");
		String input = "1\nlistalibros.txt\n4\narchivoprueba.txt\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		file.delete();

	}
	
	// Guardar biblioteca. Se guarda la biblioteca en un archivo xml.
	
	@Test
	void testmain18() {
		file = new File("archivoprueba.xml");
		String input = "1\nlistalibros.txt\n4\narchivoprueba.xml\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		file.delete();

	}
	
	// Guardar biblioteca. Se guarda la biblioteca en un archivo csv.
	
	@Test
	void testmain19() {
		file = new File("archivoprueba.csv");
		String input = "1\nlistalibros.txt\n4\narchivoprueba.csv\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		file.delete();

	}
	
	// Guardar biblioteca. Se escribe un archivo con formato no válido
	// para guardar la biblioteca
	
	@Test
	void testmain20() {
		String input = "1\nlistalibros.txt\n4\narchivoprueba.test\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		
	}
	
	// Guardar biblioteca. Se escribe un archivo que no existe para guardar
	// la biblioteca y se elije no crearlo.
	
	@Test
	void testmain21() {
		String input = "1\nlistalibros.txt\n4\narchivopruebanoexiste.txt\nn\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Guardar biblioteca. Opción volver.
	
	@Test
	void testmain22() {
		String input = "1\nlistalibros.txt\n4\n9\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();

	}
	
	// Guardar biblioteca. Se intenta guardar la biblioteca sin haberla
	// cargado antes.
	
	@Test
	void testmain23() {
		String input = "4\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		
	}
	
	// Guardar biblioteca. Carga de libro y guardado en un nuevo archivo al 
	// segundo intento después de introducir un caracter no válido
	
	@Test
	void testmain24() {
		file = new File("listalibrospruebas.csv");
		String input = "1\nlistalibros.csv\n4\nlistalibrospruebas.csv\na\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		file.delete();
		
	}
	
	// Guardar biblioteca. Intento de guardado en un archivo que ya existe. Primero se introduce un caracter no válido
	// y luego se cancela la sobreescritura
	
	@Test
	void testmain25() {
		String input = "1\nlistalibros.csv\n4\nlistalibros.csv\na\nn\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		
	}
	
	// Guardar biblioteca. Se sobreescribe el archivo
	
	@Test
	void testmain26() {
		file = new File("listaprueba.csv");
		Archivo.crearArchivo("listaprueba.csv");
		String input = "1\nlistalibros.csv\n4\nlistaprueba.csv\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.biblioteca.getListaLibros().clear();
		file.delete();
		
	}
	
	// Mostrar datos
	
	// Carga de libro y muestra de datos
	
	@Test
	void testmostrar1() {
		
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		listaLibros = CsvUtilidades.obtenerLibros(ARCHIVOCSV);
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
	
	// Creación de libro usando el constructor con parámetros
	
	@Test
	void testConstructorLibro() {
		
		libro = new Libro("ah","ah",3, 2,"ah","ah","ah");
		assertEquals("ah", libro.getEditorial()); 

	}
	
	/*
	  _            _              _ _                       _     _               
	 | |_ ___  ___| |_   _ __ ___| | | ___ _ __   __ _ _ __| |   (_) |__  _ __ ___  
	 | __/ _ \/ __| __| | '__/ _ \ | |/ _ \ '_ \ / _` | '__| |   | | '_ \| '__/ _ \ 
	 | ||  __/\__ \ |_  | | |  __/ | |  __/ | | | (_| | |  | |___| | |_) | | | (_) |
	  \__\___||___/\__| |_|  \___|_|_|\___|_| |_|\__,_|_|  |_____|_|_.__/|_|  \___/ 
                                                                                                                                                                
	 */
	
	// Se crea el libro y después se rellenan sus atributos utilizando el método correspondiente
	
	@Test
	void testRellenarLibro() {
		Libro libro = new Libro();
		String input = "ah\n ah\n s\n 1\n s\n 1\n ah\n ah\n ah\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	/*
	  _            _                               _             _     _            
	 | |_ ___  ___| |_    ___ _ __ ___  __ _ _ __ / \   _ __ ___| |__ (_)_   _____  
	 | __/ _ \/ __| __|  / __| '__/ _ \/ _` | '__/ _ \ | '__/ __| '_ \| \ \ / / _ \ 
	 | ||  __/\__ \ |_  | (__| | |  __/ (_| | | / ___ \| | | (__| | | | |\ V / (_) |
	  \__\___||___/\__|  \___|_|  \___|\__,_|_|/_/   \_\_|  \___|_| |_|_| \_/ \___/ 
	                                                                                
	*/
	
	// Creación de archivo exitosa
	
	@Test
	void testCrearArchivo1() {
		file = new File("sdijsdfissas.prueba");
		file.delete();
		assertEquals(true, Archivo.crearArchivo("sdijsdfissas.prueba"));
		file.delete();

	}
	
	// No se crea el archivo porque ya existe antes
	
	@Test
	void testCrearArchivo2() {		
		file = new File("sdijsdfissas.prueba");
		Archivo.crearArchivo("sdijsdfissas.prueba");
		String input = "s\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(false, Archivo.crearArchivo("sdijsdfissas.prueba"));
		file.delete();

	}
		
}
