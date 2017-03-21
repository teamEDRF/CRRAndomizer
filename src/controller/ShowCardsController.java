/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import model.Card;

/**
 * Class controller to manage all actions from show cards panel
 *
 * @author santi
 */
public class ShowCardsController {
    
    private Random randomGenerator;
    //cards selected
    private ArrayList<Card> cards;

    /**
     * Get card selected to panel
     *
     * @param index selected card index
     * @return Card selected
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    /**
     * Initiate controller selecting the 8 cards
     */
    public ShowCardsController() {
        this.randomGenerator = new Random();
        this.cards = new ArrayList<>();
        selectCards(index.Index.allPositions);
    }

    /**
     * Select 8 random cards
     *
     */
    public void selectCards(int position) {
        int randomNum;
        boolean salir = false;
        do {
            randomNum = randomGenerator.nextInt(index.Index.getBaraja().size());
            if (!cardAlreadySelected(randomNum)) {
                Card toAdd = index.Index.getBaraja().get(randomNum);
                toAdd.setPositionAsigned(position);
                cards.add(toAdd);
                salir = true;
            }
        } while (!salir);
        System.out.println(cards);
    }

    /**
     * remove cards in parameters and calls select cards method
     *
     * @param positions cards to remove
     */
    public void suffleCards(int[] positions) {
        System.out.println(cards);
        for (int position : positions) {
            suffleCard(position);
        }
    }
    
    public void suffleCard(int position) {
        System.out.println(position);
        for (Card card : cards) {
            if (card.getPositionAsigned() == position) {
                System.out.println(card);

                // cards.remove(card);
                selectCards(position);
            }
        }
        Collection.sort (cards);
        index.Index.getMainFrame().getShowCardPanel().updateCardViews();
        
    }
    
    private boolean cardAlreadySelected(int randomNum) {
        for (Card card : cards) {
            if (card.getId() == randomNum) {
                return true;
            }
        }
        return false;
    }
    
    private void selectCards(int[] allPositions) {
        for (int position : allPositions) {
            selectCards(position);
        }
    }
    
    public Card getCardByPosition(int i) {
        for (Card card : cards) {
            if (card.getPositionAsigned() == i) {
                return card;
            }
        }
        return null;
    }
}
