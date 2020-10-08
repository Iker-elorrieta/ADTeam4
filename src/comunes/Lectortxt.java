package comunes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lectortxt {

	public static void txt() throws IOException {
		
		File readfichero = new File("C:\\Users\\IN2DAM-B\\Desktop\\prueba.txt");
		FileReader fr = new FileReader (readfichero);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = "";
		
		while((linea=br.readLine())!=null) {
			
			System.out.println(linea);
		}
	}
}
