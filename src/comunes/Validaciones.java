package comunes;

import java.util.StringTokenizer;

public class Validaciones {

	public static boolean validarExtension(String[] extensionesValidas, String archivo) {

		archivo = obtenerExtension(archivo);

		for (int i = 0; i < extensionesValidas.length; i++) {

			if (archivo.equals(extensionesValidas[i])) {

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

	public static boolean validarAtributo(String atributo, String patron, String modo) {

		// Reglas:
		// - Si el patrón empieza con una a mayúscula el atributo debe tener la primera
		//   letra en mayúscula
		// - Si el patrón tiene un número entre <> el atributo no puede tener más length
		//   que ese número
		// - Si el patrón tiene caracteres entre [] y separados por - el atributo solo
		//   podrá tener caracteres entre ese rango ascii
		// - Si el patrón contiene una cadena entre ** el atributo debe contener esa
		//   cadena
		// - Si el patrón contiene una cadena entre == el atributo debe ser igual que esa cadena
		// - Si el patrón contiene una cadena entre {} el atributo debe ser un número de un valor igual 
		//   a esa cadena
		// - Si el patrón contiene una cadena entre {-} el atributo debe ser un número de un valor mayor 
		//   o igual a esa cadena
		// - Si el patrón contiene una cadena entre {+} el atributo debe ser un número de valor menor 
		//   o igual a esa cadena
		

		boolean validacionTotal = true;

		// Revisar length

		if (patron.contains("<")) {

			String limite = new String();
			char caracteres[] = new char[patron.indexOf(">") - 1 - patron.indexOf("<")];
			patron.getChars(patron.indexOf("<") + 1, patron.indexOf(">"), caracteres, 0);

			for (int x = 0; x <= caracteres.length - 1; x++) {

				limite = limite + caracteres[x];

			}

			if (atributo.length() > Integer.valueOf(limite)) {

				validacionTotal = false;

				if (modo.equals("validar")) {

					System.out.println("Atributo no válido, el atributo no puede tener más de " + limite + " caracteres");
					System.out.println();

				}

			}

		}


		// Revisar primera mayúscula

		if (patron.charAt(0) == 'A') {

			if (Character.isLowerCase(atributo.charAt(0))) {

				validacionTotal = false;
				if (modo.equals("validar")) {
					System.out.println("Atributo no válido, la primera letra tiene que estar en mayúscula");
					System.out.println();
				}

			}

		}

		// Revisar caracteres admitidos

		if (patron.contains("[")) {

			boolean encontrado = false;
			boolean noesta = false;
			char primero = patron.charAt(patron.indexOf("[") + 1);
			char segundo = patron.charAt(patron.indexOf("]") - 1);

			for (int i = 0; i < atributo.length(); i++) {

				for (int v = (int) primero; v <= (int) segundo; v++) {

					if (atributo.charAt(i) == (char) v) {

						encontrado = true;

					}

				}

				if (encontrado == false) {

					noesta = true;

				}

				encontrado = false;
			}

			if (noesta == true) {

				validacionTotal = false;
				if (modo.equals("validar")) {
					System.out.println("Atributo no válido, los caracteres no están dentro del rango aceptado");
					System.out.println();

				}

			}
		}

		if (patron.contains("*")) {

			String texto = new String();

			for (int i = patron.indexOf("*") + 1; i < patron.lastIndexOf("*"); i++) {

				texto = texto + patron.charAt(i);

			}

			if (!atributo.contains(texto)) {
				
				validacionTotal = false;
				if (modo.equals("validar")) {
					
					System.out.println("Atributo no válido, no contiene la cadena especificada");
					System.out.println();
				}

			}

		}
		
		if (patron.contains("=")) {

			String texto = new String();

			for (int i = patron.indexOf("=") + 1; i < patron.lastIndexOf("="); i++) {

				texto = texto + patron.charAt(i);

			}

			if (!atributo.equals(texto)) {
				
				validacionTotal = false;
				if (modo.equals("validar")) {
					
					System.out.println("Atributo no válido, no coincide con la cadena especificada");
					System.out.println();
				}

			}

		}
		
		if (patron.contains("{") && !patron.contains("{-") && !patron.contains("{+")) {
			
			try {
				Integer.valueOf(atributo);
			} catch (Exception e) {
				// TODO: handle exception
				atributo = null;
				validacionTotal = false;
				System.out.println("Atributo no válido, no es un número");
				System.out.println();
			}
			
			if (atributo != null) {
				
				String texto = new String();

				for (int i = patron.indexOf("{") + 1; i < patron.lastIndexOf("}"); i++) {

					texto = texto + patron.charAt(i);

				}

				if (Integer.valueOf(atributo) != Integer.valueOf(texto))  {
					
					validacionTotal = false;
					if (modo.equals("validar")) {
						
						System.out.println("Atributo no válido, no coincide con la cantidad especificada " + texto);
						System.out.println();
					}

				}
				
			}

		}
		
		if (patron.contains("{-")) {
			
			try {
				Integer.valueOf(atributo);
			} catch (Exception e) {
				// TODO: handle exception
				atributo = null;
				validacionTotal = false;
				System.out.println("Atributo no válido, no es un número");
				System.out.println();
			}
			
			if (atributo != null) {

				String texto = new String();
	
				for (int i = patron.indexOf("{-") + 2; i < patron.indexOf("}", patron.indexOf("{-")); i++) {
	
					texto = texto + patron.charAt(i);
	
				}
	
				if (Integer.valueOf(atributo) < Integer.valueOf(texto))  {
					
					validacionTotal = false;
					if (modo.equals("validar")) {
						
						System.out.println("Atributo no válido, la cantidad es menor al mínimo " + texto);
						System.out.println();
					}
	
				}
				
			}

		}
		
		if (patron.contains("{+")) {
			
			try {
				Integer.valueOf(atributo);
			} catch (Exception e) {
				// TODO: handle exception
				atributo = null;
				validacionTotal = false;
				System.out.println("Atributo no válido, no es un número");
				System.out.println();
			}
			
			if (atributo != null) {

				String texto = new String();
	
				for (int i = patron.indexOf("{+") + 2; i < patron.indexOf("}", patron.indexOf("{+")); i++) {
	
					texto = texto + patron.charAt(i);
	
				}
	
				if (Integer.valueOf(atributo) > Integer.valueOf(texto))  {
					
					validacionTotal = false;
					if (modo.equals("validar")) {
						
						System.out.println("Atributo no válido, la cantidad es mayor al máximo " + texto);
						System.out.println();
					}
	
				}
			
			}

		}

		return validacionTotal;

	}

}