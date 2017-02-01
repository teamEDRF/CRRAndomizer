/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import index.Index;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class CardMapper {

    public ArrayList<Card> loadFile() {
        ArrayList<Card> baraja = new ArrayList<>();
        try {

            File xmlFile = new File(Index.XML_CARD_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("card");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Card card = new Card(Integer.parseInt(eElement.getAttribute("id")));
                    card.setName(eElement.getElementsByTagName("name").item(0).getTextContent());

                    baraja.add(card);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baraja;
    }
}
