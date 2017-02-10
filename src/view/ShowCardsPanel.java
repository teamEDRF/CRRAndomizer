/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;
import controller.ShowCardsController;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 * Paneles que muestra las 8 cartas
 *
 *
 * @author santi
 */
public class ShowCardsPanel extends JPanel {

    private ShowCardsController controller;

    public ShowCardsPanel(ShowCardsController showCardsController) {
        this.controller = showCardsController;
        initiateComponents();
    }

    private void initiateComponents() {
        this.setBackground(Color.red);
        //instanciamos el Layout
        GridBagLayout gbl = new GridBagLayout();
        //Filas y columnas del layout
        gbl.columnWidths = new int[]{4};
        gbl.rowHeights = new int[]{3};
        // Peso (importancia) de cada columna (la misma atribulle un tamaño igual)
        gbl.columnWeights = new double[]{1, 1, 1, 1};
        gbl.rowWeights = new double[]{1, 100, 100};

        //añado al panel el layout creado
        this.setLayout(gbl);

        GridBagConstraints gbc_ButtonsPanel = new GridBagConstraints();
        //hace que que ajuste al alto y ancho del layout
        gbc_ButtonsPanel.fill = GridBagConstraints.BOTH;
        // ocupa 4 columnas de 1 fila (todo el ancho del panel)
        gbc_ButtonsPanel.gridwidth = 4;
        this.add(new ButtonsPanel(), gbc_ButtonsPanel);

        showCards(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
    }

    public void showCards(int[] positionsToUpdate) {
        removeComponentsByCardId(positionsToUpdate);

        //restricciones para los CardPanel
        GridBagConstraints gbc_CardPanel = new GridBagConstraints();
        //hace que que ajuste al alto y ancho del layout
        gbc_CardPanel.fill = GridBagConstraints.BOTH;

        System.out.print("Cartas a añadir: ");
        for (int i = 0; i < 8; i++) {
            if (contains(positionsToUpdate, i));
            System.out.print(" " + controller.getCard(i).getId());
            // select the position of put card           
            if (i < 4) {
                gbc_CardPanel.gridy = 1;
                System.out.println("a");
            } else {
                gbc_CardPanel.gridy = 2;
            }
            gbc_CardPanel.gridx = i % 4;
            // añade a este panel las 8 cartas seleccionadas
            this.add(new CardPanel(controller.getCard(i), i), gbc_CardPanel);
        }
validate();
        repaint();
    }

    private void removeComponentsByCardId(int[] positionsToUpdate) {
        // borra los cardPanel con position igual a la que se pasa como parametro.
        int componentPosition;
        for (Component component : this.getComponents()) {
            if (component instanceof CardPanel) {
                componentPosition = ((CardPanel) component).getPosition();
                if (contains(positionsToUpdate, componentPosition)) {
                    this.remove(component);
                }
            }
        }
    }

    private boolean contains(int[] positionsToUpdate, int i) {
        for (int pos : positionsToUpdate) {
            if (pos == i) {
                return true;
            }
        }
        return false;
    }

}
