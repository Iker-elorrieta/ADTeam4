package comunes;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelo.Libro;

import javax.xml.parsers.DocumentBuilderFactory;

public class LectorXml {

	public static ArrayList<Libro> LeerArchivoXML(String archivo) {

		ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
		try {

			

			DocumentBuilderFactory Dbf = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = Dbf.newDocumentBuilder();

			File archivoXML = new File(archivo);

			Document doc = dBuilder.parse(archivoXML);
			doc.getDocumentElement().normalize();

			System.out.println(doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("libro");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				// System.out.println("\nElemento actual :");
				// System.out.print(nNode.getNodeName());

				Libro lb = new Libro();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					// System.out.print("\nid : ");
					// System.out.println(eElement.getAttribute("titulo"));
					lb.setTitulo(eElement.getAttribute("titulo"));

					NodeList editorial = eElement.getElementsByTagName("editorial");
					for (int count = 0; count < editorial.getLength(); count++) {
						Node node1 = editorial.item(count);
						if (node1.getNodeType() == Node.ELEMENT_NODE) {

							Element libro = (Element) node1;

							// System.out.print("Editorial : ");
							// System.out.println(libro.getTextContent());
							lb.setEditorial(libro.getTextContent());

						}

					}

					NodeList paginas = eElement.getElementsByTagName("paginas");
					for (int count = 0; count < paginas.getLength(); count++) {
						Node node1 = paginas.item(count);
						if (node1.getNodeType() == Node.ELEMENT_NODE) {

							Element libro = (Element) node1;

							// System.out.print("Paginas : ");
							// System.out.println(libro.getTextContent());
							lb.setPaginas(Integer.parseInt(libro.getTextContent()));
						}

					}

					NodeList altura = eElement.getElementsByTagName("altura");
					for (int count = 0; count < altura.getLength(); count++) {
						Node node1 = altura.item(count);
						if (node1.getNodeType() == Node.ELEMENT_NODE) {

							Element libro = (Element) node1;

							// System.out.print("Altura: ");
							// System.out.println(libro.getTextContent());
							lb.setAltura(Integer.parseInt(libro.getTextContent()));
						}

					}

					NodeList notas = eElement.getElementsByTagName("notas");
					for (int count = 0; count < notas.getLength(); count++) {
						Node node1 = notas.item(count);
						if (node1.getNodeType() == Node.ELEMENT_NODE) {

							Element libro = (Element) node1;

							// System.out.print("Notas: ");
							// System.out.println(libro.getTextContent());
							lb.setNotas(libro.getTextContent());
						}

					}
					NodeList isbn = eElement.getElementsByTagName("isbn");
					for (int count = 0; count < isbn.getLength(); count++) {
						Node node1 = isbn.item(count);
						if (node1.getNodeType() == Node.ELEMENT_NODE) {

							Element libro = (Element) node1;

							// System.out.print("Isbn: ");
							// System.out.println(libro.getTextContent());
							lb.setIsbn(libro.getTextContent());
						}

					}
					NodeList materias = eElement.getElementsByTagName("materias");
					for (int count = 0; count < materias.getLength(); count++) {
						Node node1 = materias.item(count);
						if (node1.getNodeType() == Node.ELEMENT_NODE) {

							Element libro = (Element) node1;

							// System.out.print("Materias: ");

							// System.out.println(libro.getTextContent());

							lb.setMaterias(libro.getTextContent());
						}

					}

				}
				arrayLibros.add(lb);
				

			}

			
		} catch (Exception e) {
			System.out.println("Ha ocurrido algún error al leer el archivo");
			
		}
		
		return arrayLibros;
	}
	
}
