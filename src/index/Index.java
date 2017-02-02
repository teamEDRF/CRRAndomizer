/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import java.util.ArrayList;
import model.Card;
import model.CardMapper;
import view.MainFrame;

/**
 *
 * @author santi
 */
public class Index {

    /**
     * Routo to xml file with all card data
     */
    public static final String XML_CARD_FILE = "./src/xml/cards.xml";
    /**
     * Arraylist with all cards in xml file
     */
    public static ArrayList<Card> baraja;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //fill list data
        baraja = new CardMapper().loadFile();
        //start frame
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }
}
