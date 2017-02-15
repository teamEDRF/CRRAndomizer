/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Card;

/**
 *
 * @author santi
 */
public class CardPanel extends JPanel {

    private BufferedImage image;
    private int position;

    public CardPanel(Card cardSelected, int position) {
        try {
            image = ImageIO.read(new File(cardSelected.getUrl()));
        } catch (IOException ex) {
            System.err.println("Error cargando imagen");
        } catch (NullPointerException ex) {
            System.err.println("Error cargando imagen: " + cardSelected.getUrl());
        }
        this.position = position;
        initiateComponents();
        this.addMouseListener(new MouseAdapter() {
            private Color background;

            @Override
            public void mousePressed(MouseEvent e) {
                int[] toRemove = new int[]{position};
                // remove all cards (positions 0-7)
                index.Index.getShowCardsController().suffleCards(toRemove);
                index.Index.getMainFrame().getShowCardPanel().showCards(toRemove);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }
        });
    }

    private void initiateComponents() {
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, (int) (MainFrame.FRAME_WIDTH / 5), (int) (MainFrame.FRAME_HEIGTH / 2.5), null); // see javadoc for more info on the parameters            
    }

    public int getPosition() {
        return position;
    }

}
