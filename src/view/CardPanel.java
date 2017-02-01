/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static index.Index.baraja;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author santi
 */
public class CardPanel extends JPanel {

    private BufferedImage image;

    public CardPanel() {


        Random randomGenerator = new Random();
        int randomNum = randomGenerator.nextInt(baraja.size());

        try {
            image = ImageIO.read(new File(baraja.get(randomNum).getUrl()));
        } catch (IOException ex) {
            System.out.println("Error cargando imagen");
        }
        initiateComponents();
    }

    private void initiateComponents() {

        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }
}
