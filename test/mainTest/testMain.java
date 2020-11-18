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
import comunes.Filtro;
import comunes.MostrarDatos;
import comunes.Permisos;
import comunes.RellenarLibro;
import comunes.TxtUtilidades;
import comunes.Validaciones;
import modelo.Libro;
import principal.Opciones;
import principal.Programa;

class testMain {
	
	TxtUtilidades LT = new TxtUtilidades();	
	XmlUtilidades LX = new XmlUtilidades();
	CsvUtilidades lc = new CsvUtilidades();
	Libro libroCompleto = new Libro("Titulo","Editorial",2,123,"Notas","isbn","Materias");
	Libro libro= new Libro();
	Filtro f = new Filtro();
	ArrayList<Libro> arrayPruebas = new ArrayList<Libro>();
	Filtro fCompleto = new Filtro(arrayPruebas);
	Archivo archivo = new Archivo();
	File file;
	Programa main = new Programa();
	Opciones opciones = new Opciones();
	MostrarDatos mostrarDatos = new MostrarDatos();
	RellenarLibro rellenarLibro = new RellenarLibro();
	Validaciones validaciones = new Validaciones();
	final String ARCHIVOTXT = "listalibros.txt";
	final String ARCHIVOXML = "listalibros.xml";
	final String ARCHIVOCSV = "listalibros.csv";
	final String url ="C:\\Users\\Colm\\Desktop\\Pruebas\\permisos.txt";
	Permisos p = new Permisos();

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
	void testCsvLecturaCorrecta() {
		assertEquals(true, CsvUtilidades.obtenerLibros(ARCHIVOCSV) != null);
	}
	
	// Al mandarle que lea un archivo nulo la lista que recoje acaba siendo nula también
	
	@Test
	void testCsvLecturaFallida() {
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
	void testOpcionNoValida() {
		String input = "a\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());

	}
	
	// Cargar biblioteca. Carga de archivo txt
	
	@Test
	void testCargaTxt() {
		String input = "1\n4\nlistalibros.txt\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
	}
	 
	// Cargar biblioteca. Carga de archivo xml
	
	@Test
	void testCargaXml() {
		String input = "1\n4\nlistalibros.xml\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		
	}
	
	// Cargar biblioteca. Carga de archivo csv
	
	@Test
	void testCargaCsv() {
		String input = "1\n4\nlistalibros.csv\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
	}
	
	// Cargar biblioteca. Intento de carga con nombre de archivo no válido, después se selecciona volver
	
	@Test
	void testCargaNombreArchivoNoValido() {
		String input = "1\n4\nlistalibros.no\n9\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
	}
	
	// Cargar biblioteca. Intento de carga con una extensión de archivo válida pero el archivo no existe
	
	@Test
	void testCargaArchivoNoExiste() {
		String input = "1\n4\nnoexiste.csv\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
	}
	
	// Leer biblioteca. Se carga un archivo y luego se lee
	
	@Test
	void testLeerBibliotecaCargada() {
		String input = "1\n4\nlistalibros.txt\n2\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Leer biblioteca. Se intenta leer la biblioteca sin haber cargado nada antes
	
	@Test
	void testLeerBibliotecaSinCargar() {
		String input = "2\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Editar biblioteca. Se añade un libro a la biblioteca
	
	@Test
	void testAnyadirLibro() {
		String input = "3\n1\n1\n1\n1\n1\n1\n1\n1\n3\n1\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Editar biblioteca. Se añade un libro a la biblioteca y luego se edita
	
	@Test
	void testEditarLibro() {
		String input = "3\n1\n1\n1\n1\n1\n1\n1\n1\n2\n1\n1\n1\n1\n1\n1\n1\n1\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Editar biblioteca. Se añade un libro a la biblioteca, luego se intenta editar
	// pero se introduce un caracter no válido
	
	@Test
	void testEditarLibroConCaracterNoValido() {
		String input = "3\n1\n1\n1\n1\n1\n1\n1\n1\n3\na\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Editar biblioteca. Se añade un libro a la biblioteca, luego se intenta borrar
	// pero se introduce un número de libro que no existe, el 4
	
	@Test
	void testEditarLibroNoExiste() {
		String input = "3\n1\n1\n1\n1\n1\n1\n1\n1\n3\n4\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Editar biblioteca. Se intenta editar la biblioteca estando vacía y después
	// se introduce un caracter no válido

	@Test
	void testEditarBibliotecaVaciaCaracterNoValido() {
		String input = "3\n2\na\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Editar biblioteca. Carga de libro e intento de edición primero
	// poniendo un caracter no válido y después un número de libro que no existe
	
	@Test
	void testEditarCaracterNoValidoLibroNoExiste() {
		String input = "1\n4\nlistalibros.csv\n3\n2\na\n4\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		
	}
	
	// Editar biblioteca. Se intenta borrar un libro con la biblioteca vacía
	
	@Test
	void testBorrarBibliotecaVacia() {
		String input = "3\n3\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Editar biblioteca. Opción volver.
	
	@Test
	void testEditarVolver() {
		String input = "3\n9\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Guardar biblioteca. Se guarda la biblioteca en un archivo txt.
	
	@Test
	void testGuardarTxt() {
		file = new File("archivoprueba.txt");
		String input = "1\n4\nlistalibros.txt\n4\narchivoprueba.txt\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		file.delete();

	}
	
	// Guardar biblioteca. Se guarda la biblioteca en un archivo xml.
	
	@Test
	void testGuardarXml() {
		file = new File("archivoprueba.xml");
		String input = "1\n4\nlistalibros.txt\n4\narchivoprueba.xml\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		file.delete();

	}
	
	// Guardar biblioteca. Se guarda la biblioteca en un archivo csv.
	
	@Test
	void testGuardarCsv() {
		file = new File("archivoprueba.csv");
		String input = "1\n4\nlistalibros.txt\n4\narchivoprueba.csv\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		file.delete();

	}
	
	// Guardar biblioteca. Se escribe un archivo con formato no válido
	// para guardar la biblioteca
	
	@Test
	void testGuardarExtensionNoValida() {
		String input = "1\n4\nlistalibros.txt\n4\narchivoprueba.test\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		
	}
	
	// Guardar biblioteca. Se escribe un archivo que no existe para guardar
	// la biblioteca y se elije no crearlo.
	
	@Test
	void testGuardarArchivoNoExisteCrear() {
		String input = "1\n4\nlistalibros.txt\n4\narchivopruebanoexiste.txt\nn\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Guardar biblioteca. Opción volver.
	
	@Test
	void testGuardarVolver() {
		String input = "1\n4\nlistalibros.txt\n4\n9\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();

	}
	
	// Guardar biblioteca. Se intenta guardar la biblioteca sin haberla
	// cargado antes.
	
	@Test
	void testGuardarSinCargar() {
		String input = "4\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		
	}
	
	// Guardar biblioteca. Carga de libro y guardado en un nuevo archivo al 
	// segundo intento después de introducir un caracter no válido
	
	@Test
	void testGuardarSegundoIntento() {
		file = new File("listalibrospruebas.csv");
		String input = "1\n4\nlistalibros.csv\n4\nlistalibrospruebas.csv\na\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		file.delete();
		
	}
	
	// Guardar biblioteca. Intento de guardado en un archivo que ya existe. Primero se introduce un caracter no válido
	// y luego se cancela la sobreescritura
	
	@Test
	void testCancelarSobreescribir() {
		String input = "1\n4\nlistalibros.csv\n4\nlistalibros.csv\na\nn\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		
	}
	
	// Guardar biblioteca. Se sobreescribe el archivo
	
	@Test
	void testSobreescribir() {
		file = new File("listaprueba.csv");
		Archivo.crearArchivo("listaprueba.csv");
		String input = "1\n4\nlistalibros.csv\n4\nlistaprueba.csv\ns\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		file.delete();
		
	}
	
	@Test
	void testPrincipalFiltarBiblioteca() {
		
		String input = "5\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		
	}
	
	// Vaciar biblioteca
	
	@Test
	void testVaciarBiblioteca() {
		file = new File("listaprueba.csv");
		Archivo.crearArchivo("listaprueba.csv");
		String input = "1\nlistalibros.csv\n3\n4\n0\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(true, Programa.iniciarPrograma());
		Programa.getBiblioteca().getListaLibros().clear();
		file.delete();
		
	}
	
	// Mostrar datos
	
	// Carga de libro y muestra de datos
	
	@Test
	void testMostrarDatos() {
		
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
	void testCrearLibroConParametros() {
		
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
	void testRellenarLibroBien() {
		Libro libro = new Libro();
		String input = "ah\n1\n1\n1\n1\n1\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	@Test
	void testRellenarLibroTituloMal() {
		Libro libro = new Libro();
		String input = "12345678901234567890123456789012345678901234567890\nah\n1\n1\n1\n1\n1\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	@Test
	void testRellenarLibroEditorialMal() {
		Libro libro = new Libro();
		String input = "ah\n12345678901234567890123456789012345678901234567890\n1\n1\n1\n1\n1\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	@Test
	void testRellenarLibroPaginasMal() {
		Libro libro = new Libro();
		String input = "ah\n1\n-1\n1\n1\n1\n1\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	@Test
	void testRellenarLibroAlturaMal() {
		Libro libro = new Libro();
		String input = "ah\n1\n1\n-1\n1\n1\n1\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	@Test
	void testRellenarLibroNotasMal() {
		Libro libro = new Libro();
		String input = "ah\n1\n1\n1\n12345678901234567890123456789012345678901234567890\n1\n1\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	@Test
	void testRellenarLibroIsbnMal() {
		Libro libro = new Libro();
		String input = "ah\n1\n1\n1\n1\ns\n1\n1\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		RellenarLibro.rellenarLibro(libro);
		System.out.println(libro.getTitulo());
		assertEquals(true, libro.getTitulo().equals("ah")); 

	}
	
	@Test
	void testRellenarLibroMateriasMal() {
		Libro libro = new Libro();
		String input = "ah\n1\n1\n1\n1\n1\n12345678901234567890123456789012345678901234567890\n1\n";
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
	void testCrearArchivoBien() {
		file = new File("sdijsdfissas.prueba");
		file.delete();
		assertEquals(true, Archivo.crearArchivo("sdijsdfissas.prueba"));
		file.delete();

	}
	
	// No se crea el archivo porque ya existe antes
	
	@Test
	void testCrearArchivoYaExiste() {		
		file = new File("sdijsdfissas.prueba");
		Archivo.crearArchivo("sdijsdfissas.prueba");
		String input = "s\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		assertEquals(false, Archivo.crearArchivo("sdijsdfissas.prueba"));
		file.delete();

	}
	
	//test validaciones
	
	// Valida cadena exacta correcta
	
	@Test
	void testValidaCadenaExacta() {		
		assertEquals(true, Validaciones.validarAtributo("prueba", "=prueba=", "validar"));
	}
	
	// No valida cadena exacta incorrecta
	
	@Test
	void testNoValidaCadenaExacta() {		
		assertEquals(false, Validaciones.validarAtributo("noprueba", "=prueba=", "validar"));
	}
	
	// Valida condición de length
	
	@Test
	void testValidaLength() {		
		assertEquals(true, Validaciones.validarAtributo("prueba", "<6>", "validar"));
	}
	
	// No valida condición de length
	
	@Test
	void testNoValidaLength() {		
		assertEquals(false, Validaciones.validarAtributo("prueba", "<5>", "validar"));
	}
	
	// Valida primera letra en mayúscula
	
	@Test
	void testValidaPrimeraMayuscula() {		
		assertEquals(true, Validaciones.validarAtributo("Prueba", "A", "validar"));
	}
	
	// No valida primera letra al no estar en mayúscula
	
	@Test
	void testNoValidaPrimeraMayuscula() {		
		assertEquals(false, Validaciones.validarAtributo("noprueba", "A", "validar"));
	}
	
	
	// Valida caracteres dentro del rango admitido
	
	@Test
	void testValidaRango() {		
		assertEquals(true, Validaciones.validarAtributo("123", "[0-9]", "validar"));
	}
	
	// No valida caracteres al no estar dentro del rango admitido
	
	@Test
	void testNoValidaRango() {		
		assertEquals(false, Validaciones.validarAtributo("noprueba", "[0-9]", "validar"));
	}
	
	// Valida texto al contener la cadena pedida en el patrón
	
	@Test
	void testValidaContiene() {		
		assertEquals(true, Validaciones.validarAtributo("prueba", "*prueba*", "validar"));
	}
	
	// No valida texto al no contener la cadena pedida en el patrón
	
	@Test
	void testNoValidaContiene() {		
		assertEquals(false, Validaciones.validarAtributo("prueba", "*noprueba*", "validar"));
	}
	
	// Valida número al ser el mismo que en el patrón
	
	@Test
	void testValidaNumeroExacto() {		
		assertEquals(true, Validaciones.validarAtributo("2", "{2}", "validar"));
	}
	
	// No valida el número porque no ser el mismo que el del patrón
	
	@Test
	void testNoValidaNumeroExacto() {		
		assertEquals(false, Validaciones.validarAtributo("3", "{2}", "validar"));
	}
	
	// No valida porque no es un número
	
	@Test
	void testNoValidaNumeroNoEsNumero() {		
		assertEquals(false, Validaciones.validarAtributo("a", "{2}", "validar"));
	}
	
	// Valida porque el número no es menor al mínimo indicado en el patrón
	
	@Test
	void testValidaMinimo() {		
		assertEquals(true, Validaciones.validarAtributo("1", "{-1}", "validar"));
	}
	
	// No valida porque el número es menor al mínimo indicado en el patrón
	
	@Test
	void testNoValidaMinimo() {		
		assertEquals(false, Validaciones.validarAtributo("0", "{-1}", "validar"));
	}
	
	// No valida máximo porque no es un número
	
	@Test
	void testNoValidaMinimoNoEsNumero() {		
		assertEquals(false, Validaciones.validarAtributo("a", "{-1}", "validar"));
	}
	
	// Valida porque el número no es mayor al máximo indicado en el patrón
	
	@Test
	void testValidaMaximo() {		
		assertEquals(true, Validaciones.validarAtributo("2", "{+2}", "validar"));
	}
	
	// No valida porque el número es mayor al máximo indicado en el patrón
	
	@Test
	void testNoValidaMaximo() {		
		assertEquals(false, Validaciones.validarAtributo("4", "{+2}", "validar"));
	}
	
	// No valida máximo porque no es un número
	
	@Test
	void testNoValidaMaximoNoEsNumero() {		
		assertEquals(false, Validaciones.validarAtributo("a", "{+2}", "validar"));
	}
		
	
	
	/*
		  ______ _ _ _             
		 |  ____(_) | |            
		 | |__   _| | |_ _ __ ___  
		 |  __| | | | __| '__/ _ \ 
		 | |    | | | |_| | | (_) |
		 |_|    |_|_|\__|_|  \___/ 
		                           
		                           
	 */
	@Test
	void testfiltroMenu() {	
	arrayPruebas.add(libroCompleto);
	
		
	String input = "28\n e\n 0\n";
	InputStream in = new ByteArrayInputStream(input.getBytes());
	System.setIn(in);
	Programa.teclado = new Scanner(System.in);
	assertEquals(false,fCompleto.AtributoAFiltrar());
	}
	
	@Test
	void testfiltroTitulo() {	
	arrayPruebas.add(libroCompleto);
	
		
	String input = "1\n 1\ntulo\n 2\ntitulo\n 3\nt\n 4\nerror\n 4\n 6\n 8\n e\n 0\n 0\n";
	InputStream in = new ByteArrayInputStream(input.getBytes());
	System.setIn(in);
	Programa.teclado = new Scanner(System.in);
	assertEquals(true,fCompleto.AtributoAFiltrar());
	}

	@Test
	void testfiltroEditorial() {	
	arrayPruebas.add(libroCompleto);
	
		
	String input = "2\n 1\ntori\n 2\nEditorial\n 3\nE\n 4\nerror\n 4\n 9\n 8\n e\n 0\n 0\n";
	InputStream in = new ByteArrayInputStream(input.getBytes());
	System.setIn(in);
	Programa.teclado = new Scanner(System.in);
	assertEquals(true,fCompleto.AtributoAFiltrar());
	}

	@Test
	void testfiltroMaterias() {	
	arrayPruebas.add(libroCompleto);
	
		
	String input = "7\n 1\nMate\n 2\nMaterias\n 3\nM\n 4\nerror\n 4\n 8\n 8\n e\n 0\n 0\n";
	InputStream in = new ByteArrayInputStream(input.getBytes());
	System.setIn(in);
	Programa.teclado = new Scanner(System.in);
	assertEquals(true,fCompleto.AtributoAFiltrar());
	}
	
	@Test
	void testfiltroNotas() {	
	arrayPruebas.add(libroCompleto);
	
		
	String input = "6\n 1\nNota\n 2\nNotas\n 3\nN\n 4\nerror\n 4\n 5\n 8\n e\n 0\n 0\n";
	InputStream in = new ByteArrayInputStream(input.getBytes());
	System.setIn(in);
	Programa.teclado = new Scanner(System.in);
	assertEquals(true,fCompleto.AtributoAFiltrar());
	}
	
	@Test
	void testfiltroIsbn() {	
	arrayPruebas.add(libroCompleto);
	
		
	String input = "5\n 1\nsb\n e\n 8\n 2\nisbn\n 0\n 0\n";
	InputStream in = new ByteArrayInputStream(input.getBytes());
	System.setIn(in);
	Programa.teclado = new Scanner(System.in);
	assertEquals(true,fCompleto.AtributoAFiltrar());
	}
	
	@Test
	void testfiltroAltura() {	
	arrayPruebas.add(libroCompleto);
	
		
	String input = "3\n 1\n 1\n 2\n 123\n 3\n 1000\n e\n 28\n 0\n 0\n";
	InputStream in = new ByteArrayInputStream(input.getBytes());
	System.setIn(in);
	Programa.teclado = new Scanner(System.in);
	assertEquals(true,fCompleto.AtributoAFiltrar());
	}
	
	@Test
	void testfiltroPaginas() {	
	arrayPruebas.add(libroCompleto);
	
		
	String input = "4\n 1\n 1\n 2\n 2\n 3\n 1000\n e\n 28\n 0\n 0\n";
	InputStream in = new ByteArrayInputStream(input.getBytes());
	System.setIn(in);
	Programa.teclado = new Scanner(System.in);
	assertEquals(true,fCompleto.AtributoAFiltrar());
	}
	
	
	//Permisos
	


	@Test
	void testPermisosAprobados() {	
		String input = "1\nX\nF\nUser\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		
		assertEquals(true,p.Eleccion());
		
	}
	@Test
	void testPermisosRevocados() {	
		String input = "e\n2\nF\nUser\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		Programa.teclado = new Scanner(System.in);
		
		assertEquals(true,p.Eleccion());
		
	}

	

}
