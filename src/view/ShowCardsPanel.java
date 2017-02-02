/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ShowCardsController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Paneles que muestra las 8 cartas
 *
 *
 * @author santi
 */
public class ShowCardsPanel extends JPanel {

    ShowCardsController controller;

    public ShowCardsPanel() {
        initiateComponents();
    }

    private void initiateComponents() {
        this.setBackground(Color.blue);

        //instanciamos el Layout
        GridBagLayout gbl = new GridBagLayout();
        //Filas y columnas del layout
        gbl.columnWidths = new int[]{4};
        gbl.rowHeights = new int[]{2};
        // Peso (importancia) de cada columna (la misma atribulle un tamaño igual)
        gbl.columnWeights = new double[]{1, 1, 1, 1};
        gbl.rowWeights = new double[]{1, 1, 1, 1};

        //añado al panel el layout creado
        this.setLayout(gbl);

        //restricciones para los CardPanel
        GridBagConstraints gbc_CardPanel = new GridBagConstraints();
        //hace que que ajuste al alto y ancho del layout
        gbc_CardPanel.fill = GridBagConstraints.BOTH;

        controller = new ShowCardsController();

        for (int i = 0; i < 8; i++) {
            // add 8 card without repeat it           
            if (i < 4) {
                gbc_CardPanel.gridy = 0;
            } else {
                gbc_CardPanel.gridy = 1;
            }
            gbc_CardPanel.gridx = i % 4;
            //añade a este panel las 8 cartas seleccionadas
            this.add(new CardPanel(controller.getCard(i)), gbc_CardPanel);

        }
    }
}
