package principal;

import org.junit.jupiter.api.Test;

class TestPrograma {

	@Test
	void test1() {
		String[] args = {"1"};
		principal.Programa.main(args);
	}
	
	@Test
	void test2() {
		String[] args = {"2"};
		principal.Programa.main(args);
	}
	
	@Test
	void test3() {
		String[] args = {"3"};
		principal.Programa.main(args);
	}
	
	@Test
	void test4() {
		String[] args = {"0", "1"};
		principal.Programa.main(args);
	}
	
	@Test
	void test5() {
		String[] args = {"a"};
		principal.Programa.main(args);
	}

}
