/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 *
 * @author santi
 */
public class MainFrame extends JFrame {

    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGTH = 600;

    ShowCardsPanel showCardPanel;

    public MainFrame() {
        //da unos valores iniciales al JFrame
        initiateComponents();
        showCardPanel = new ShowCardsPanel();
        this.add(showCardPanel);
    }

    private void initiateComponents() {
        //Indica el tamaño inicial de la aplicacion (800x600)
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGTH));

        //Hace que la ventana se cierre al pulsar sobre el boton cerrar del frame
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //instanciamos el Layout
        GridBagLayout gbl = new GridBagLayout();

        //Constantes para el GridBagLayout de MainFrame
        GridBagConstraints gbc_MainFrame = new GridBagConstraints();
        //Hace que lo que se añada al frame tenga peso 1 (Ocupe toda la pantalla)
        gbc_MainFrame.weightx = 1;
        gbl.setConstraints(this, gbc_MainFrame);

    }
}
