package comunes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lectortxt {

	public static boolean lectorTxt(String enlace)  {
		boolean boo;
		try {	
		File readfichero = new File(enlace);
		FileReader fr = new FileReader (readfichero);
		BufferedReader br = new BufferedReader(fr);
	
			
			String linea = "";
			boo=true;
			while((linea=br.readLine())!=null) {
				
				System.out.println(linea);
			}
		} catch (Exception e) {
			boo=false;
			e.printStackTrace();
		}
		
		return boo;
	}
}
