package comunes;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

public class LectorXml {

	
	public static void LeerArchivoXML() {
	
	try {	
		
	
	
	DocumentBuilderFactory Dbf = DocumentBuilderFactory.newInstance();
	
	DocumentBuilder dBuilder = Dbf.newDocumentBuilder();
	
	File archivoXML = new File("Ciclos.xml");
	
	Document doc = dBuilder.parse(archivoXML);
	doc.getDocumentElement().normalize();
	
	System.out.print("Elemento Raiz: ");
	System.out.println(doc.getDocumentElement().getNodeName());
	
	NodeList nList = doc.getElementsByTagName("ciclos");
	System.out.println("----------------------------");
	for (int temp = 0; temp < nList.getLength(); temp++) {
		Node nNode = nList.item(temp);
		System.out.println("\nElemento actual :");
		System.out.print(nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			System.out.print("\nid : ");
			System.out.println(eElement.getAttribute("id"));
			NodeList nombreCiclo = eElement.getElementsByTagName("nombre");
			for (int count = 0; count < nombreCiclo.getLength(); count++) {
				Node node1 = nombreCiclo.item(count);
				if (node1.getNodeType() == node1.ELEMENT_NODE) {

					Element ciclo = (Element) node1;

					System.out.print("Nombre ciclo : ");
					System.out.println(ciclo.getTextContent());
					System.out.print("Grado : ");
					System.out.println(ciclo.getAttribute("Grado"));
					System.out.print("Titulo : ");
					System.out.println(ciclo.getAttribute("DecretoTitulo"));
					
				}
			}
		}
	}
	
	
	
	
	}catch(Exception e) {
		System.out.println("Ha ocurrido algún error al leer el archivo");
	}
	
	}
}
