package mainTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import comunes.PRUEBAXML;

public class mainTEST {

	@Test
	void test() {
		
		PRUEBAXML pX = new PRUEBAXML();
		
		 assertEquals(true,pX.LeerArchivoXML("Libros.xml"));
		 assertEquals(false,pX.LeerArchivoXML("Exception.xml"));
	}
}
