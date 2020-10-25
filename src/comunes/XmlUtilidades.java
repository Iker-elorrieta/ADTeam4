package comunes;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import modelo.Libro;

public class XmlUtilidades {

	public static ArrayList<Libro> obtenerLibros(String archivo) {
			
			ArrayList<Libro> arrayLibros = new ArrayList<Libro>();
			
		
			try {

				DocumentBuilderFactory Dbf = DocumentBuilderFactory.newInstance();

				DocumentBuilder dBuilder = Dbf.newDocumentBuilder();

				File archivoXML = new File(archivo);

				Document doc = dBuilder.parse(archivoXML);
				doc.getDocumentElement().normalize();

			

				NodeList nList = doc.getElementsByTagName("libro");
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					// System.out.println("\nElemento actual :");
					// System.out.print(nNode.getNodeName());

					Libro lb = new Libro();
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						
						NodeList titulo = eElement.getElementsByTagName("titulo");
						for (int count = 0; count < titulo.getLength(); count++) {
							Node node1 = titulo.item(count);
							if (node1.getNodeType() == Node.ELEMENT_NODE) {

								Element libro = (Element) node1;

							
								lb.setTitulo(libro.getTextContent());

							}

						}

					
						
						NodeList editorial = eElement.getElementsByTagName("editorial");
						for (int count = 0; count < editorial.getLength(); count++) {
							Node node1 = editorial.item(count);
							if (node1.getNodeType() == Node.ELEMENT_NODE) {

								Element libro = (Element) node1;

						
								lb.setEditorial(libro.getTextContent());

							}

						}

						NodeList paginas = eElement.getElementsByTagName("páginas");
						for (int count = 0; count < paginas.getLength(); count++) {
							Node node1 = paginas.item(count);
							if (node1.getNodeType() == Node.ELEMENT_NODE) {

								Element libro = (Element) node1;

								lb.setPaginas(Integer.parseInt(libro.getTextContent()));
							}

						}

						NodeList altura = eElement.getElementsByTagName("altura");
						for (int count = 0; count < altura.getLength(); count++) {
							Node node1 = altura.item(count);
							if (node1.getNodeType() == Node.ELEMENT_NODE) {

								Element libro = (Element) node1;

								lb.setAltura(Integer.parseInt(libro.getTextContent()));
							}

						}

						NodeList notas = eElement.getElementsByTagName("notas");
						for (int count = 0; count < notas.getLength(); count++) {
							Node node1 = notas.item(count);
							if (node1.getNodeType() == Node.ELEMENT_NODE) {

								Element libro = (Element) node1;
								
								lb.setNotas(libro.getTextContent());
							}

						}
						NodeList isbn = eElement.getElementsByTagName("isbn");
						for (int count = 0; count < isbn.getLength(); count++) {
							Node node1 = isbn.item(count);
							if (node1.getNodeType() == Node.ELEMENT_NODE) {

								Element libro = (Element) node1;

								lb.setIsbn(libro.getTextContent());
							}

						}
						NodeList materias = eElement.getElementsByTagName("materias");
						for (int count = 0; count < materias.getLength(); count++) {
							Node node1 = materias.item(count);
							if (node1.getNodeType() == Node.ELEMENT_NODE) {

								Element libro = (Element) node1;


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
		
	

	public static void escribirXml(String archivo, ArrayList<Libro> listaLibros) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document documento = implementation.createDocument(null, "libreria", null);
			documento.setXmlVersion("1.0");
			Element libros = documento.createElement("libros");

			for (Libro otroLibro : listaLibros) {

				Element libro = documento.createElement("libro");

				Element titulo = documento.createElement("titulo");
				Text textTitulo = documento.createTextNode(otroLibro.getTitulo());
				titulo.appendChild(textTitulo);
				libro.appendChild(titulo);

				Element editorial = documento.createElement("editorial");
				Text textEditorial = documento.createTextNode(otroLibro.getEditorial());
				editorial.appendChild(textEditorial);
				libro.appendChild(editorial);

				Element paginas = documento.createElement("páginas");
				Text textPaginas = documento.createTextNode(String.valueOf(otroLibro.getPaginas()));
				paginas.appendChild(textPaginas);
				libro.appendChild(paginas);

				Element altura = documento.createElement("altura");
				Text textAltura = documento.createTextNode(String.valueOf(otroLibro.getAltura()));
				altura.appendChild(textAltura);
				libro.appendChild(altura);

				Element notas = documento.createElement("notas");
				Text textNotas = documento.createTextNode(otroLibro.getNotas());
				notas.appendChild(textNotas);
				libro.appendChild(notas);

				Element isbn = documento.createElement("isbn");
				Text textIsbn = documento.createTextNode(otroLibro.getIsbn());
				isbn.appendChild(textIsbn);
				libro.appendChild(isbn);

				Element materias = documento.createElement("materias");
				Text textMaterias = documento.createTextNode(otroLibro.getMaterias());
				materias.appendChild(textMaterias);
				libro.appendChild(materias);

				libros.appendChild(libro);

			}

			documento.getDocumentElement().appendChild(libros);

			Source source = new DOMSource(documento);
			Result result = new StreamResult(new File(archivo));

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);

			
			System.out.println();
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
