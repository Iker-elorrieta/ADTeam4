package mainTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import comunes.LectorXml;
import comunes.Lectortxt;

class testMain {
	
	/*
	
	   _            _      _____  _______      __
	  | |          | |    / ____|/ ____\ \    / /
	  | |_ ___  ___| |_  | |    | (___  \ \  / / 
	  | __/ _ \/ __| __| | |     \___ \  \ \/ /  
	  | ||  __/\__ \ |_  | |____ ____) |  \  /   
	   \__\___||___/\__|  \_____|_____/    \/   
	
	
	*/
	@Test
	void testCsv() {
		assertEquals(true, comunes.Lectorcsv.lectorcsv("listalibros.csv"));
	}
	
	@Test
	void testLectorCsvFallo() {
		assertEquals(false, comunes.Lectorcsv.lectorcsv(null));
	}
	
	/*
	   _            _     _________   _________ 
	  | |          | |   |__   __\ \ / /__   __|
	  | |_ ___  ___| |_     | |   \ V /   | |   
	  | __/ _ \/ __| __|    | |    > <    | |   
	  | ||  __/\__ \ |_     | |   / . \   | |   
	   \__\___||___/\__|    |_|  /_/ \_\  |_| 
	
	
	*/
	
	
	@Test
	void testLectorTxt() throws IOException {
		Lectortxt l1 = new Lectortxt();
		boolean resul = l1.txt("listalibros.txt");
		assertEquals(true,resul);
		
	}
	
	@Test
	void testLectorTxtFallo() throws IOException {
		Lectortxt l1 = new Lectortxt();
		boolean resul = l1.txt("listalibrosa.txt");
		assertEquals(false,resul);
		
	}
	/*
	   _            _    __   ____  __ _      
	  | |          | |   \ \ / /  \/  | |     
	  | |_ ___  ___| |_   \ V /| \  / | |     
	  | __/ _ \/ __| __|   > < | |\/| | |     
	  | ||  __/\__ \ |_   / . \| |  | | |____ 
	   \__\___||___/\__| /_/ \_\_|  |_|______|
	                                            */
	@Test
	void testLectorXML()   {
		
		comunes.LectorXml lx = new LectorXml();
		
		 assertEquals(true,lx.LeerArchivoXML("Libros.xml"));
		 assertEquals(false,lx.LeerArchivoXML("Exception.xml"));
		 

	}
	/*
	
	   _            _     __  __       _       
	  | |          | |   |  \/  |     (_)      
	  | |_ ___  ___| |_  | \  / | __ _ _ _ __  
	  | __/ _ \/ __| __| | |\/| |/ _` | | '_ \ 
	  | ||  __/\__ \ |_  | |  | | (_| | | | | |
	   \__\___||___/\__| |_|  |_|\__,_|_|_| |_|
	
	*/
	
	
	
	
	
	
}
