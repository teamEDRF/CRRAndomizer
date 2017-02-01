/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import model.CardMapper;
import view.MainFrame;

/**
 *
 * @author santi
 */
public class Index {

    /**
     *
     */
    public static final String XML_CARD_FILE = "./src/xml/cards.xml";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new CardMapper().loadFile();

//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);
    }

}
