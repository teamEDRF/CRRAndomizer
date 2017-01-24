/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crrandomizer;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author santi
 */
public class CardPanel extends JPanel {

    public CardPanel() {

        initiateComponents();
    }

    private void initiateComponents() {
        Color color;

        Random randomGenerator = new Random();
        int randomNum = randomGenerator.nextInt(5);
        switch (randomNum) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.PINK;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.YELLOW;
                break;
            case 4:
                color = Color.RED;
                break;
            case 5:
                color = Color.WHITE;
                break;
            default:
                throw new AssertionError();
        }
        
        
        this.setBackground(color);
    }
}
