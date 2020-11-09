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
		// - Si el patr�n empieza con una a may�scula el atributo debe tener la primera
		//   letra en may�scula
		// - Si el patr�n tiene un n�mero entre <> el atributo no puede tener m�s length
		//   que ese n�mero
		// - Si el patr�n tiene caracteres entre [] y separados por - el atributo solo
		//   podr� tener caracteres entre ese rango ascii
		// - Si el patr�n contiene una cadena entre ** el atributo debe contener esa
		//   cadena
		// - Si el patr�n contiene una cadena entre == el atributo debe ser igual que esa cadena
		// - Si el patr�n contiene una cadena entre {} el atributo debe ser un n�mero de un valor igual 
		//   a esa cadena
		// - Si el patr�n contiene una cadena entre {-} el atributo debe ser un n�mero de un valor mayor 
		//   o igual a esa cadena
		// - Si el patr�n contiene una cadena entre {+} el atributo debe ser un n�mero de valor menor 
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

					System.out.println("Atributo no v�lido, el atributo no puede tener m�s de " + limite + " caracteres");
					System.out.println();

				}

			}

		}


		// Revisar primera may�scula

		if (patron.charAt(0) == 'A') {

			if (Character.isLowerCase(atributo.charAt(0))) {

				validacionTotal = false;
				if (modo.equals("validar")) {
					System.out.println("Atributo no v�lido, la primera letra tiene que estar en may�scula");
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
					System.out.println("Atributo no v�lido, los caracteres no est�n dentro del rango aceptado");
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
					
					System.out.println("Atributo no v�lido, no contiene la cadena especificada");
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
					
					System.out.println("Atributo no v�lido, no coincide con la cadena especificada");
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
				System.out.println("Atributo no v�lido, no es un n�mero");
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
						
						System.out.println("Atributo no v�lido, no coincide con la cantidad especificada " + texto);
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
				System.out.println("Atributo no v�lido, no es un n�mero");
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
						
						System.out.println("Atributo no v�lido, la cantidad es menor al m�nimo " + texto);
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
				System.out.println("Atributo no v�lido, no es un n�mero");
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
						
						System.out.println("Atributo no v�lido, la cantidad es mayor al m�ximo " + texto);
						System.out.println();
					}
	
				}
			
			}

		}

		return validacionTotal;

	}

}