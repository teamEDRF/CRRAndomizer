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
import org.jvnet.substance.SubstanceLookAndFeel;
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
    private static String[] skinResource = new String[]{
        "org.jvnet.substance.skin.AutumnSkin",
        "org.jvnet.substance.skin.BusinessBlackSteelSkin",
        "org.jvnet.substance.skin.BusinessBlueSteelSkin",
        "org.jvnet.substance.skin.BusinessSkin",
        "org.jvnet.substance.skin.CremeCoffeeSkin",
        //            5
        "org.jvnet.substance.skin.CremeSkin",
        "org.jvnet.substance.skin.EmeraldDuskSkin",
        "org.jvnet.substance.skin.FieldOfWheatSkin",
        "org.jvnet.substance.skin.FindingNemoSkin",
        "org.jvnet.substance.skin.GreenMagicSkin",
        //            10
        "org.jvnet.substance.skin.MagmaSkin",
        "org.jvnet.substance.skin.MangoSkin",
        "org.jvnet.substance.skin.MistAquaSkin",
        "org.jvnet.substance.skin.ModerateSkin",
        "org.jvnet.substance.skin.NebulaBrickWallSkin",
        //            15
        "org.jvnet.substance.skin.NebulaSkin",
        "org.jvnet.substance.skin.OfficeBlue2007Skin",
        "org.jvnet.substance.skin.OfficeSilver2007Skin",
        "org.jvnet.substance.skin.RavenGraphiteGlassSkin",
        "org.jvnet.substance.skin.RavenGraphiteSkin",
        //            20
        "org.jvnet.substance.skin.RavenSkin",
        "org.jvnet.substance.skin.SaharaSkin"};

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
        //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
        MainFrame.setDefaultLookAndFeelDecorated(true);
        // Setencia que aplica el skin Creme de Substance
        SubstanceLookAndFeel.setSkin(skinResource[9]);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
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
