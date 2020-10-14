package mainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import comunes.LectorXml;
import comunes.Lectortxt;


public class mainTEST {

	@Test
	void test()   {
		
		comunes.LectorXml lx = new LectorXml();
		
		 assertEquals(true,lx.LeerArchivoXML("Libros.xml"));
		 assertEquals(false,lx.LeerArchivoXML("Exception.xml"));
		 

	}

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
	
}
