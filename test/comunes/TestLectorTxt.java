package comunes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class TestLectorTxt {

	@org.junit.jupiter.api.Test
	void testLectorTxt() throws IOException {
		Lectortxt l1 = new Lectortxt();
		boolean resul = l1.txt("listalibros.txt");
		assertEquals(true,resul);
	}
	
	@org.junit.jupiter.api.Test
	void testLectorTxtFallo() throws IOException {
		Lectortxt l1 = new Lectortxt();
		boolean resul = l1.txt("listalibrosa.txt");
		assertEquals(false,resul);
	}

}
