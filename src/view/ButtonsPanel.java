/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import strings.StringResource;

/**
 *
 * @author santi
 */
public class ButtonsPanel extends JPanel {

    public ButtonsPanel() {
        initiateComponents();

    }

    private void initiateComponents() {
        this.setBackground(Color.WHITE);
        Dimension buttonDimension = new Dimension(100, 40);
        JButton randomizeButton = new JButton();
        randomizeButton.setText(StringResource.REPARTIR);
        randomizeButton.setPreferredSize(buttonDimension);

        randomizeButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                index.Index.getShowCardsController().suffleCards(index.Index.allPositions);
                index.Index.getMainFrame().getShowCardPanel().showCards(index.Index.allPositions);
                System.out.println(randomizeButton.getSize().width);
               
            }
        });
        this.add(randomizeButton);
        repaint();
        
    }
}
