package comunes;

import modelo.Libro;
import principal.Programa;

public class RellenarLibro {
	
	public static void rellenarLibro(Libro libro) {
		
		String textoaValidar = new String();
		final String VALIDAR = "validar";
		
		do {
			
			System.out.print("Introduzca el título del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "<40>", VALIDAR)) {

				libro.setTitulo(textoaValidar);

			} else {
				
				textoaValidar = null;
			}
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca la editorial del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "<40>", VALIDAR)) {

				libro.setEditorial(textoaValidar);

			} else {

				textoaValidar = null;
			} 
		} while (textoaValidar == null);
		
		
		do {
			
			System.out.print("Introduzca las páginas del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "{-1}", VALIDAR)) {

				libro.setPaginas(Integer.valueOf(textoaValidar));

			} else {

				textoaValidar = null;
			} 
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca la altura del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "{-1}", VALIDAR)) {

				libro.setAltura(Integer.valueOf(textoaValidar));

			} else {

				textoaValidar = null;
			} 
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca las notas del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "<40>", VALIDAR)) {

				libro.setNotas(textoaValidar);

			} else {
				
				textoaValidar = null;
			}
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca el ISBN del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "VALIDARISBN", VALIDAR)) {
				
				libro.setIsbn(textoaValidar);

			} else {
				
				textoaValidar = null;
			}
			
		} while (textoaValidar == null);
		
		do {
			
			System.out.print("Introduzca las materias del libro: ");
			textoaValidar = Programa.teclado.nextLine();
			
			if (Validaciones.validarAtributo(textoaValidar, "<30>", VALIDAR)) {
				
				libro.setMaterias(textoaValidar);

			} else {
				
				textoaValidar = null;
			}
			
		} while (textoaValidar == null);
		
	}

}
