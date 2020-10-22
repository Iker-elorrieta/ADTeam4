package comunes;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import modelo.Libro;


public class CrearXml {

	public static void generarXML(String name, ArrayList<Libro> arrayLb)  {
		
	
		try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, name, null);
		document.setXmlVersion("1.0");
		
		
		
		for (int i = 0; i < arrayLb.size(); i++) {
			// Main Node
			Element raiz = document.getDocumentElement();

			// Libro Node
			Element itemNode = document.createElement("Libro");

			// Titulo Node
			Element tituloNode = document.createElement("titulo");
			Text nodetituloValue = document.createTextNode(arrayLb.get(i).getTitulo());
			tituloNode.appendChild(nodetituloValue);

			// Editorial node
			Element editorialNode = document.createElement("editorial");
			Text nodeeditorialValue = document.createTextNode(arrayLb.get(i).getEditorial());
			editorialNode.appendChild(nodeeditorialValue);

			// Paginas Node
			Element paginasNode = document.createElement("paginas");
			Text nodepaginasValue = document.createTextNode(arrayLb.get(i).getPaginas() + "");
			paginasNode.appendChild(nodepaginasValue);

			// Altura Node
			Element alturaNode = document.createElement("altura");
			Text nodealturaValue = document.createTextNode(arrayLb.get(i).getAltura() + "");
			alturaNode.appendChild(nodealturaValue);

			// Notas Node
			Element notasNode = document.createElement("notas");
			Text nodenotasValue = document.createTextNode(arrayLb.get(i).getNotas());
			notasNode.appendChild(nodenotasValue);

			// Isbn Node
			Element isbnNode = document.createElement("isbn");
			Text nodeisbnValue = document.createTextNode(arrayLb.get(i).getIsbn());
			isbnNode.appendChild(nodeisbnValue);

			// Materia Node
			Element materiaNode = document.createElement("materia");
			Text nodemateriaValue = document.createTextNode(arrayLb.get(i).getMaterias());
			materiaNode.appendChild(nodemateriaValue);

			// metemos los hijos al principal
			itemNode.appendChild(tituloNode);
			itemNode.appendChild(editorialNode);
			itemNode.appendChild(alturaNode);
			itemNode.appendChild(notasNode);
			itemNode.appendChild(isbnNode);
			itemNode.appendChild(materiaNode);

			
			raiz.appendChild(itemNode); // pegamos el elemento a la raiz "Documento"

			

		}
		System.out.println("Libro Creado, revise la raiz del proyecto");
		// Generate XML
		Source source = new DOMSource(document);
		// Indicamos donde lo queremos almacenar
		Result result = new StreamResult(new java.io.File(name + ".xml"));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
		
		
	}catch(Exception e) {
		System.out.println("Ha habido algun error en el proceso");
		e.printStackTrace();
	}
	}
	
	public static void cambiarXML() {
		
		System.out.println("Que fichero de los disponibles va a querer cambiar");
		
		 
		
		
		
		
	}
}
