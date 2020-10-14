package comunes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLectorCsv {

	@Test
	void test1() {
		assertEquals(true, comunes.Lectorcsv.lectorcsv("listalibros.csv"));
	}
	
	@Test
	void test2() {
		assertEquals(false, comunes.Lectorcsv.lectorcsv(null));
	}
	
}
