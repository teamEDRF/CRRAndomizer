/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import controller.ShowCardsController;
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
    private static ArrayList<Card> baraja;

    private static ShowCardsController showCardsController;
    private static MainFrame mainFrame;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //fill list data
        baraja = new CardMapper().loadFile();
        //instancia el controller, necesita tener los datos cargados
        showCardsController = new ShowCardsController();
        //start frame
        mainFrame = new MainFrame(showCardsController);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }

    public static ArrayList<Card> getBaraja() {
        return baraja;
    }

    public static ShowCardsController getShowCardsController() {
        return showCardsController;
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

}
