package comunes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import principal.Programa;

public class Permisos {

	
	
	public boolean cambiarPermisos(String url) {
	
		
		
			 	 
		 
		 switch(recogerSistema()) {
		 
		 
		 case "Windows 10":		permisosWindows(url);						break;
		
		
		 case "Ubuntu":			permisosLinux(url);							break;
		
		 
		
		
		
		 
		 }
		 
	return true;
		 
	}
	
	public String recogerSistema() {
		
		String sistemaOperativo="";
			
		
		sistemaOperativo=System.getProperty("os.name");
		
		
		return sistemaOperativo;
	}
	
	
	
	
	public boolean permisosLinux (String url) {
		
		Process proceso = null;
		
		Scanner  sc = new Scanner(System.in);
		int permisos=000;
		
		System.out.println("Introduzca los nuevos permisos");
		
		permisos = sc.nextInt();
		
		
		System.out.println("Cambiamos permisos a : "+ permisos);
		try
		{
			proceso = Runtime.getRuntime().exec("chmod "+permisos+" "+ url);
		 }
		catch(IOException e)
		{
		
		System.out.println("Ha habido algun tipo de problema");
		return false;
		}
		
		return true;
		}
	
	private boolean permisosWindows(String url) {
		String usuario;
		String permiso;
	
				System.out.println("Ingrese el nombre del usuario que tendrá los permisos");
				usuario = Programa.teclado.nextLine();
			

				
				System.out.println("que permiso desea agregar");
				System.out.println("F - Acceso Total");
				System.out.println("M - Modificar");
				System.out.println("RX - Lectura y Ejecución");
				System.out.println("R - Lectura");
				System.out.println("W - Escritura");
				System.out.println("D - Eliminación");
				permiso =  Programa.teclado.nextLine();
			
				try {
					Process process;
					process = Runtime.getRuntime().exec("cmd /c ICACLS " + url + " /grant " + usuario + ":(" + permiso + ")");
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
	
	public boolean quitarPermiso(String url) {
		String usuario;
		boolean correcto=false;
		
		try {
			System.out.println("Ingrese el nombre del usuario al cual le quitara permisos");
			usuario = Programa.teclado.nextLine();
		
				
			Process process = Runtime.getRuntime().exec("cmd /c ICACLS " + url + " /remove " + usuario);
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
	
}
	

