package SAX;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;





public class sax {

	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	
		
		
		try {
			SAXParserFactory saxfak = SAXParserFactory.newInstance();
			SAXParser saxParser = saxfak.newSAXParser();
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException e) {
			
			e.printStackTrace();
		}
		
		

			
	


}
}
