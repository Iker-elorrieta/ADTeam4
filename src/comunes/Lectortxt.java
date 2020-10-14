package comunes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lectortxt {

	public static boolean txt() {

		try {
			File readfichero = new File("listalibros.txt");
			FileReader fr = new FileReader (readfichero);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = "";

			while((linea=br.readLine())!=null) {
				
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
			
	}
}
