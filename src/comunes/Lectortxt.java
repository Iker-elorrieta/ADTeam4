package comunes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lectortxt {

	public static boolean txt(String enlace) throws IOException {
		boolean boo;
		
		File readfichero = new File("listalibros.txt");
		FileReader fr = new FileReader (readfichero);
		BufferedReader br = new BufferedReader(fr);
		try {
			
			String linea = "";
			boo=true;
			while((linea=br.readLine())!=null) {
				
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			boo=false;
			e.printStackTrace();
		}
		
		return boo;
	}
}
