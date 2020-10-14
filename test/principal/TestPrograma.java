package principal;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestPrograma {

	@Test
	void test1() {
		
		String input = "1 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, Programa.iniciarPrograma(teclado)); 
	}
		
		
	@Test
	void test2() {
		
		String input = "2 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, Programa.iniciarPrograma(teclado)); 

	}
	
	@Test
	void test3() {
		
		String input = "3 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, Programa.iniciarPrograma(teclado)); 

	}
	
	@Test
	void test4() {
		
		String input = "a \n 1 \n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	    Scanner teclado = new Scanner(System.in); 
		assertEquals(true, Programa.iniciarPrograma(teclado)); 

	}
	
}
