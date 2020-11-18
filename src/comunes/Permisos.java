package comunes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import principal.Programa;

public class Permisos {


	private String sistemaOperativo="";
	private String permiso="";
	private String usuario="";
	private Process process;
	private String url;
	
	public boolean cambiarPermisos(String url) {
	
		this.url = url;
		
			 	 
		 
		 switch(recogerSistema()) {
		 
		 
		 case "Windows 10":		Eleccion();						break;
		
		
		 case "Ubuntu":			permisosLinux();							break;
		
		 
		
		
		
		 
		 }
		 
	return true;
		 
	}
	
	public String recogerSistema() {
		
			
		
		this.sistemaOperativo=System.getProperty("os.name");
		
		
		return sistemaOperativo;
	}
	
	
	
	
	public boolean permisosLinux () {
		
		int permisos=000;
		
		System.out.println("Introduzca los nuevos permisos");
		
		permisos = Programa.teclado.nextInt();
		
		Programa.teclado.nextLine();
		
		System.out.println("Cambiamos permisos a : "+ permisos);
		try
		{
			this.process = Runtime.getRuntime().exec("chmod "+permisos+" "+url);
		 }
		catch(IOException e)
		{
		
		System.out.println("Ha habido algun tipo de problema");
		
		return false;
		}
		
		return true;
	}
	
	

	
	
	
	
	
	private boolean permisosWindows() {

		sacarUsuarioYPermiso();
			
				try {
					Process process;
					process = Runtime.getRuntime().exec("cmd /c icacls " + url + " /grant " + usuario + ":" + permiso);
					BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String resultOfExecution = null;
			
					while ((resultOfExecution = br.readLine()) != null) {
						
						System.out.println(resultOfExecution);
						
					}
					
				} catch (IOException e) {
					
					return false;
				}
				
			System.out.println("Los permisos han sido cambiados");
		return true;

	}
	
	public boolean Eleccion() {
		boolean control=false;
		int eleccion=0;
		
		while(!control) {
			try {
		System.out.println("Que desea hacer respectivo a los permisos");
		System.out.println("1.- Poner permisos");
		System.out.println("2.- Quitar permisos");
		System.out.println();
		
		
		eleccion = Programa.teclado.nextInt();
		Programa.teclado.nextLine();
		}catch(Exception e) {
			System.out.println("Numero correcto no introducido");
			Programa.teclado.nextLine();
		}
		
		if(eleccion == 1) {
			control= true;
			permisosWindows();
			
		}else if (eleccion ==2) {
			control= true;
			quitarPermiso();
		}
		
		}
		
		
		
		return true;
		
		
		
	}
	
	
	
	public boolean quitarPermiso() {

		boolean correcto=false;
	
		try {
					
			sacarUsuarioYPermiso();

			this.process = Runtime.getRuntime().exec("cmd /c icacls " + url + " /deny " + this.usuario + ":" + this.permiso);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String resultOfExecution = null;
			while ((resultOfExecution = br.readLine()) != null) {
				System.out.println(resultOfExecution);
			}
			correcto=true;
		} catch (Exception e) {
			e.getMessage();
			correcto=false;
		}
		return correcto;
	
	}
	
	
	public void sacarUsuarioYPermiso() {
	
		Boolean control = false;
		Boolean controlUsuario = false;
		
		while(!control) {
		
		System.out.println("¿Que permiso desea añadir/quitar?");
		System.out.println("F - Acceso Total");
		System.out.println("M - Modificar");
		System.out.println("RX - Lectura y Ejecución");
		System.out.println("R - Lectura");
		System.out.println("W - Escritura");
		System.out.println("D - Eliminación");
		
		this.permiso =  Programa.teclado.nextLine();
		
		if(this.permiso.toUpperCase().equals("F") || this.permiso.toUpperCase().equals("M")  || this.permiso.toUpperCase().equals("RX")  || this.permiso.toUpperCase().equals("R")  || this.permiso.toUpperCase().equals("W")  || this.permiso.toUpperCase().equals("D")) {
			control = true;
		}else {
			System.out.println("No existe ese tipo de permiso");
			System.out.println();
		}
		
		
		
		}
		
		System.out.println("Ingrese el nombre del usuario al cual le quitara/pondra permisos");
		this.usuario = Programa.teclado.nextLine();
		
			
		
	}
	
}
	

