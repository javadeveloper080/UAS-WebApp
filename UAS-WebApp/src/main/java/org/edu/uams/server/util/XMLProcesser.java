package org.edu.uams.server.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.edu.uams.client.dto.XMLColumnDTO;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLProcesser {
	
	public static List<String> getReportDataMap(String xmlString) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
		List<LinkedHashMap<String, Object>> dataList = new ArrayList<>();
		List<XMLColumnDTO> columns = getReportColumns(xmlString);
		
		 List<String> labels = new ArrayList<>();
		 labels.add("Student_Number");
		 
		List<String> configIdLabels = labels;
		List<String> ids = new ArrayList<>();
		NodeList nodes = doc.getElementsByTagName("row");
		
		for (int i = 0; i < nodes.getLength(); i++) {
			// row = list of values in the row  
			NodeList row = nodes.item(i).getChildNodes();
			LinkedHashMap<String, Object> dataMap = new LinkedHashMap<>();
			int k = 0;
			for (int j = 0; j < row.getLength(); j++) {
				// childNode = where value elements are
				Node childNode = row.item(j);
				String nodeValue = null;
				// not all ChildNodes are ELEMENT_NODE
				if (childNode.getNodeType() == Node.ELEMENT_NODE) {
					// childNodeValues = access to the text content of the value, if any exist
					NodeList childNodeValues = childNode.getChildNodes();
					if (childNodeValues.getLength() == 1) {
						nodeValue = childNodeValues.item(0).getTextContent();
					} else {
						nodeValue = "";
					}
					dataMap.put(columns.get(k++).getColumnName().replaceAll("[^-a-zA-Z0-9:.]", "_"), nodeValue);
				}
			}
			dataList.add(dataMap);
		}
		for (LinkedHashMap<String, Object> columnMap : dataList) {
			for (String id : configIdLabels) {
				if (columnMap.containsKey(id)) {
					ids.add(columnMap.get(id).toString());
				}
			}
		}

		return ids;
	}
	
	 private static List<XMLColumnDTO> getReportColumns(String xmlString) throws Exception {
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        org.w3c.dom.Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
	        List<XMLColumnDTO> columns = new ArrayList<>();

	        XPathFactory xpathFactory = XPathFactory.newInstance();
	        XPath xpath = xpathFactory.newXPath();

	        NodeList nodes = (NodeList) xpath.evaluate("//metadata/item", doc, XPathConstants.NODESET);
	        for (int i = 0; i < nodes.getLength(); i++) {
	            Node nameNode = nodes.item(i).getAttributes().getNamedItem("name");
	            Node typeNode = nodes.item(i).getAttributes().getNamedItem("type");
	            String columnName = nameNode.getNodeValue();
	            String columnType = typeNode.getNodeValue();
	            columns.add(new XMLColumnDTO(columnName, columnType));
	        }
	        return columns;
	    }


}
