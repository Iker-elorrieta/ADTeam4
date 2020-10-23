package comunes;

import modelo.Libro;
import principal.Programa;

public class RellenarLibro {
	
	public static void rellenarLibro(Libro libro) {
		
		System.out.print("Introduzca el título del libro: ");
		libro.setTitulo(Programa.teclado.nextLine());
		
		System.out.print("Introduzca la editorial del libro: ");
		libro.setEditorial(Programa.teclado.nextLine());
		
		do {
			System.out.print("Introduzca las páginas del libro: ");
			try {
				libro.setPaginas(Programa.teclado.nextInt());
				Programa.teclado.nextLine();
			} catch (Exception e) {
				libro.setPaginas(-1);
				Programa.teclado.nextLine();
			} 
			
			if (libro.getPaginas() < 0) {
				System.out.println();
				System.out.println("Número de páginas no válido, vuelva a intentarlo");
				System.out.println();
			}
			
		} while (libro.getPaginas() < 0);
		
		do {
			System.out.print("Introduzca la altura del libro: ");
			try {
				libro.setAltura(Programa.teclado.nextInt());
				Programa.teclado.nextLine();
			} catch (Exception e) {
				libro.setAltura(-1);
				Programa.teclado.nextLine();
			} 
			
			if (libro.getAltura() < 0) {
				System.out.println();
				System.out.println("Altura no válida, vuelva a intentarlo");
				System.out.println();
			}
			
		} while (libro.getAltura() < 0);
		
		System.out.print("Introduzca las notas del libro: ");
		libro.setNotas(Programa.teclado.nextLine());
		
		System.out.print("Introduzca el ISBN del libro: ");
		libro.setIsbn(Programa.teclado.nextLine());
		
		System.out.print("Introduzca las materias del libro: ");
		libro.setMaterias(Programa.teclado.nextLine());
		
	}

}
