package modelo;

import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList <Libro> listaLibros;
	
	public Biblioteca() {
		
		listaLibros = new ArrayList <Libro>();
		
	}
	
	public void anyadirLibros(ArrayList <Libro> lista) {
		
		for (Libro libro: lista) {
			
			this.listaLibros.add(libro);
			
		}	
		
	}
	
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

}
