package modelo;

import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList <Libro> listaLibros;
	
	public Biblioteca() {
		
		listaLibros = new ArrayList <Libro>();
		
	}
	
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

}
