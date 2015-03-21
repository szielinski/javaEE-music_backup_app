package ie.dit.backupapp.services.ejb;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//@Local
//@Stateless
public class XMLReaderServiceEJB /* implements XMLReaderService */{

//	@Inject
//	private UserLibraryDAO userLibraryDAO;

	public static void main(String [] args) {
		readXML("/home/szymon/Desktop/iTunes Music Library3.xml");
	}

	// @Override
	public static void readXML(String location) {
		File xmlFile = null;
		try {
			xmlFile = new File(location);
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document parsedXML = docBuilder.parse(xmlFile);

			parsedXML.getDocumentElement().normalize();
			System.out.println("Root element: " + parsedXML.getDocumentElement().getNodeName());

			parsedXML.getDocumentElement().getChildNodes();
			// NodeList nList = parsedXML.getElementsByTagName("staff");
			System.out.println("----------------------------");
			showChildNodes(parsedXML.getDocumentElement().getChildNodes());
			
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//
//				Node nNode = nList.item(temp);
//
//				System.out.println("\nCurrent Element :" + nNode.getNodeName());
//
//				// if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//				//
//				// Element eElement = (Element) nNode;
//				//
//				// System.out.println("Track ID : " + eElement.getAttribute("Track ID"));
//				// System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getFirstChild().getNodeValue());
//				// System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getFirstChild().getNodeValue());
//				// System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getFirstChild().getNodeValue());
//				// System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getFirstChild().getNodeValue());
//				//
//				// }
//			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showChildNodes(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);

			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			System.out.println("Value :" + nNode.getNodeValue()+"\n");
			if(nNode.hasChildNodes()){
				showChildNodes(nNode.getChildNodes());
			}
		}
	}
}
