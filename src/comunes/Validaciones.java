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

}
