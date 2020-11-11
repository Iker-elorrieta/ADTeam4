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
		// - Si el patrón contiene una a al final significa que

		boolean validacionTotal = true;
		final String VALIDAR = "validar";
		final String LENGHTABRIR = "<";
		final String LENGHTCERRAR = ">";
		final char PRIMERAMAYUSCULA = 'A';
		final String CARACTERESADMITIDOSABRIR = "[";
		final String CARACTERESADMITIDOSCERRAR = "]";
		final String CONTIENE = "*"; 
		final String EXACTO = "=";
		final String CANTIDADEXACTAABRIR = "{";
		final String CANTIDADMINIMAABRIR = "{-";
		final String CANTIDADMAXIMAABRIR = "{+";
		final String CANTIDADCERRAR = "}";

		// Revisar length

		if (patron.contains(LENGHTABRIR)) {

			String limite = new String();
			char caracteres[] = new char[patron.indexOf(LENGHTCERRAR) - 1 - patron.indexOf(LENGHTABRIR)];
			patron.getChars(patron.indexOf(LENGHTABRIR) + 1, patron.indexOf(LENGHTCERRAR), caracteres, 0);

			for (int x = 0; x <= caracteres.length - 1; x++) {

				limite = limite + caracteres[x];

			}

			if (atributo.length() > Integer.valueOf(limite)) {

				validacionTotal = false;

				if (modo.equals(VALIDAR)) {

					System.out.println("Atributo no válido, el atributo no puede tener más de " + limite + " caracteres");
					System.out.println();

				}

			}

		}


		// Revisar primera mayúscula

		if (patron.charAt(0) == PRIMERAMAYUSCULA) {

			if (Character.isLowerCase(atributo.charAt(0))) {

				validacionTotal = false;
				if (modo.equals(VALIDAR)) {
					System.out.println("Atributo no válido, la primera letra tiene que estar en mayúscula");
					System.out.println();
				}

			}

		}

		// Revisar caracteres admitidos

		if (patron.contains(CARACTERESADMITIDOSABRIR)) {

			boolean encontrado = false;
			boolean noesta = false;
			char primero = patron.charAt(patron.indexOf(CARACTERESADMITIDOSABRIR) + 1);
			char segundo = patron.charAt(patron.indexOf(CARACTERESADMITIDOSCERRAR) - 1);

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
				if (modo.equals(VALIDAR)) {
					System.out.println("Atributo no válido, los caracteres no están dentro del rango aceptado");
					System.out.println();

				}

			}
		}
		
		// Revisar que la cadena contiene la cadena pedida

		if (patron.contains(CONTIENE)) {

			String texto = new String();

			for (int i = patron.indexOf(CONTIENE) + 1; i < patron.lastIndexOf(CONTIENE); i++) {

				texto = texto + patron.charAt(i);

			}

			if (!atributo.contains(texto)) {
				
				validacionTotal = false;
				if (modo.equals(VALIDAR)) {
					
					System.out.println("Atributo no válido, no contiene la cadena especificada");
					System.out.println();
				}

			}

		}
		
		// Revisar que la cadena es idéntica a la cadena pedida
		
		if (patron.contains(EXACTO)) {

			String texto = new String();

			for (int i = patron.indexOf(EXACTO) + 1; i < patron.lastIndexOf(EXACTO); i++) {

				texto = texto + patron.charAt(i);

			}

			if (!atributo.equals(texto)) {
				
				validacionTotal = false;
				if (modo.equals(VALIDAR)) {
					
					System.out.println("Atributo no válido, no coincide con la cadena especificada");
					System.out.println();
				}

			}

		}
		
		if (patron.contains(CANTIDADEXACTAABRIR) && !patron.contains(CANTIDADMINIMAABRIR) && !patron.contains(CANTIDADMAXIMAABRIR)) {
			
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

				for (int i = patron.indexOf(CANTIDADEXACTAABRIR) + 1; i < patron.lastIndexOf(CANTIDADCERRAR); i++) {

					texto = texto + patron.charAt(i);

				}

				if (Integer.valueOf(atributo) != Integer.valueOf(texto))  {
					
					validacionTotal = false;
					if (modo.equals(VALIDAR)) {
						
						System.out.println("Atributo no válido, no coincide con la cantidad especificada " + texto);
						System.out.println();
					}

				}
				
			}

		}
		
		if (patron.contains(CANTIDADMINIMAABRIR)) {
			
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
	
				for (int i = patron.indexOf(CANTIDADMINIMAABRIR) + 2; i < patron.indexOf(CANTIDADCERRAR, patron.indexOf(CANTIDADMINIMAABRIR)); i++) {
	
					texto = texto + patron.charAt(i);
	
				}
	
				if (Integer.valueOf(atributo) < Integer.valueOf(texto))  {
					
					validacionTotal = false;
					if (modo.equals(VALIDAR)) {
						
						System.out.println("Atributo no válido, la cantidad es menor al mínimo " + texto);
						System.out.println();
					}
	
				}
				
			}

		}
		
		if (patron.contains(CANTIDADMAXIMAABRIR)) {
			
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
	
				for (int i = patron.indexOf(CANTIDADMAXIMAABRIR) + 2; i < patron.indexOf(CANTIDADCERRAR, patron.indexOf(CANTIDADMAXIMAABRIR)); i++) {
	
					texto = texto + patron.charAt(i);
	
				}
	
				if (Integer.valueOf(atributo) > Integer.valueOf(texto))  {
					
					validacionTotal = false;
					if (modo.equals(VALIDAR)) {
						
						System.out.println("Atributo no válido, la cantidad es mayor al máximo " + texto);
						System.out.println();
					}
	
				}
			
			}

		}

		return validacionTotal;

	}

}