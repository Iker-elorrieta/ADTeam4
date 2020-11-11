package comunes;

import modelo.Libro;
import principal.Programa;

public class RellenarLibro {
	
	public static void rellenarLibro(Libro libro) {
		
		String textoaValidar = new String();
		
		do {
			
			System.out.print("Introduzca el título del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "<40>", "validar")) {

				libro.setTitulo(textoaValidar);

			} else {
				
				textoaValidar = null;
			}
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca la editorial del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "<40>", "validar")) {

				libro.setEditorial(textoaValidar);

			} else {

				textoaValidar = null;
			} 
		} while (textoaValidar == null);
		
		
		do {
			
			System.out.print("Introduzca las páginas del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "{-1}", "validar")) {

				libro.setPaginas(Integer.valueOf(textoaValidar));

			} else {

				textoaValidar = null;
			} 
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca la altura del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "{-1}", "validar")) {

				libro.setAltura(Integer.valueOf(textoaValidar));

			} else {

				textoaValidar = null;
			} 
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca las notas del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "<40>", "validar")) {

				libro.setNotas(textoaValidar);

			} else {
				
				textoaValidar = null;
			}
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca el ISBN del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "[0-9]", "validar")) {
				
				libro.setIsbn(textoaValidar);

			} else {
				
				textoaValidar = null;
			}
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca las materias del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "<30>", "validar")) {
				
				libro.setMaterias(textoaValidar);

			} else {
				
				textoaValidar = null;
			}
			
		} while (textoaValidar == null);
		
	}

}
