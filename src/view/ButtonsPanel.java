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
        JButton randomizeButton = new JButton();
        randomizeButton.setText(StringResource.REPARTIR);
        
        randomizeButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                index.Index.showCardsController.suffleCards(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
            }
        });
        this.add(randomizeButton);
    }
    
}
