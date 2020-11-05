package comunes;

import java.util.StringTokenizer;

public class Validaciones {
	
	public static boolean validarExtension(String[] extensionesValidas, String archivo) {
		
		archivo = obtenerExtension(archivo);
		
		for (int i = 0; i < extensionesValidas.length; i++) {
			
			if(archivo.equals(extensionesValidas[i])) {
				
				return true;
			}
		}
		
		return false;
	}
	
	public static String obtenerExtension(String cadena) {
		
		StringTokenizer st = new StringTokenizer(cadena, ".", false);
		String extension = new String();
		
		while (st.hasMoreTokens()) {
			
			extension = st.nextToken();
		}
			
		return extension;
	
	}
	
	public static boolean validarAtributo(String atributo, String patron) {
		
		// Reglas:
		// - Si el patr�n empieza con una a may�scula el atributo debe tener la primera letra en may�scula
		// - Si el patr�n tiene un n�mero entre <> el atributo no puede tener m�s length que ese n�mero
		// - Si el patr�n tiene caracteres entre [] y separados por - el atributo solo podr� tener caracteres
		// entre ese rango ascii
		// POR HACER
		// - Si el patr�n contiene una cadena entre ** el atributo debe contener esa cadena
		// - Si el patr�n contiene una a al final significa que
		
		boolean validado = true;
		
		if (patron.contains("<")) {
			
			String limite = new String();
			char caracteres[] = new char[patron.indexOf(">") - 1 - patron.indexOf("<")];
			patron.getChars(patron.indexOf("<") + 1, patron.indexOf(">"), caracteres, 0);
		
			for (int x = 0; x <= caracteres.length - 1; x++) {
				
				limite = limite + caracteres[x];
				
			}
			
			if (atributo.length() > Integer.valueOf(limite)) {
				
				System.out.println("Atributo no v�lido, el atributo no puede tener m�s de " + limite + " caracteres");
				validado = false;
				
			}
			
		}
		
		if (patron.charAt(0) == 'A') {
			
			boolean validarPrimeraMay = true;
			
			if (Character.isLowerCase(atributo.charAt(0))) {
				
				validarPrimeraMay = false;
				
			}
			
			if (validarPrimeraMay == false) {
				
				System.out.println("Atributo no v�lido, la primera letra tiene que estar en may�scula");
				validado = false;
				
			}
			
		}
		
		if (patron.contains("[")) {
			
			boolean encontrado = false;
			boolean noesta = false;
			char primero = patron.charAt(patron.indexOf("[") + 1);
			char segundo = patron.charAt(patron.indexOf("]") - 1);
			
			for (int i = 0; i <atributo.length(); i ++) {
				
				for (int v = (int)primero; v <= (int)segundo; v++) {
					
					if (atributo.charAt(i) == (char)v) {
						
						encontrado = true;
						
					}
						
				}
				
				if (encontrado == false) {
					
					noesta = true;
					
				}
				
				encontrado = false;
			}
			
			if (noesta == true) {
				
				System.out.println("Atributo no v�lido, los caracteres no est�n dentro del rango aceptado");
				validado = false;
			}
			
			
			
		}
		
		return validado;
		
	}

}
