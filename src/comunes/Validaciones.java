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
		// - Si el patrón empieza con una a mayúscula el atributo debe tener la primera letra en mayúscula
		// - Si el patrón tiene un número entre <> el atributo no puede tener más length que ese número
		// - Si el patrón tiene caracteres entre [] y separados por - el atributo solo podrá tener caracteres
		// entre ese rango ascii
		// POR HACER
		// - Si el patrón contiene una cadena entre ** el atributo debe contener esa cadena
		// - Si el patrón contiene una a al final significa que
		
		boolean validado = true;
		
		if (patron.contains("<")) {
			
			String limite = new String();
			char caracteres[] = new char[patron.indexOf(">") - 1 - patron.indexOf("<")];
			patron.getChars(patron.indexOf("<") + 1, patron.indexOf(">"), caracteres, 0);
		
			for (int x = 0; x <= caracteres.length - 1; x++) {
				
				limite = limite + caracteres[x];
				
			}
			
			if (atributo.length() > Integer.valueOf(limite)) {
				
				System.out.println("Atributo no válido, el atributo no puede tener más de " + limite + " caracteres");
				validado = false;
				
			}
			
		}
		
		if (patron.charAt(0) == 'A') {
			
			boolean validarPrimeraMay = true;
			
			if (Character.isLowerCase(atributo.charAt(0))) {
				
				validarPrimeraMay = false;
				
			}
			
			if (validarPrimeraMay == false) {
				
				System.out.println("Atributo no válido, la primera letra tiene que estar en mayúscula");
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
				
				System.out.println("Atributo no válido, los caracteres no están dentro del rango aceptado");
				validado = false;
			}
			
			
			
		}
		
		return validado;
		
	}

}
