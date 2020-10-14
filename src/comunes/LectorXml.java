package comunes;

import java.io.File;

import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

public class LectorXml {

	
	public static boolean LeerArchivoXML(String archivo) {
	
	try {	
		
	
	
	DocumentBuilderFactory Dbf = DocumentBuilderFactory.newInstance();
	
	DocumentBuilder dBuilder = Dbf.newDocumentBuilder();
	
	File archivoXML = new File(archivo);
	
	Document doc = dBuilder.parse(archivoXML);
	doc.getDocumentElement().normalize();
	
	System.out.print("Elemento Raiz: ");
	System.out.println(doc.getDocumentElement().getNodeName());
	
	NodeList nList = doc.getElementsByTagName("libro");
	System.out.println("----------------------------");
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);
		System.out.println("\nElemento actual :");
		System.out.print(nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			System.out.print("\nid : ");
			System.out.println(eElement.getAttribute("id"));
					
		 NodeList nombreAutor = eElement.getElementsByTagName("autor");
			for (int count = 0; count < nombreAutor.getLength(); count++) {
				Node node1 = nombreAutor.item(count);
				if (node1.getNodeType() == Node.ELEMENT_NODE) {

					Element libro = (Element) node1;

					System.out.print("Autor : ");
					System.out.println(libro.getTextContent());
				
					
				
				}
				
			}
			
			 NodeList gradoCiclo = eElement.getElementsByTagName("isbn");
				for (int count = 0; count < gradoCiclo.getLength(); count++) {
					Node node1 = gradoCiclo.item(count);
					if (node1.getNodeType() == Node.ELEMENT_NODE) {

						Element libro = (Element) node1;

						
						
						System.out.print("Isbn : ");
						System.out.println(libro.getTextContent());
					
					}
					
				}
				
				
				NodeList titulo = eElement.getElementsByTagName("lanzamiento");
				for (int count = 0; count < titulo.getLength(); count++) {
					Node node1 = titulo.item(count);
					if (node1.getNodeType() == Node.ELEMENT_NODE) {

						Element libro = (Element) node1;

						System.out.print("Año: ");
						System.out.println(libro.getAttribute("año"));
						
					
					}
					
				}
		}
	}
	
	
	
	
	}catch(Exception e) {
	System.out.println("Ha ocurrido algún error al leer el archivo");
	return false;
	}
	return true;
	}
	
	public void crearFicheroXML() {
		
	}

}
