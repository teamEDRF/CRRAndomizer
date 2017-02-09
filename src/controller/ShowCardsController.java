/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static index.Index.baraja;
import java.util.HashSet;
import java.util.Random;
import model.Card;

/**
 * Class controller to manage all actions from show cards panel
 *
 * @author santi
 */
public class ShowCardsController {

    private Random randomGenerator;
    //conjunto de numeros que indican los id de las cartas
    private HashSet<Integer> numbers;
    //cards selected
    private Card[] cards;

    /**
     * Get card selected to panel
     *
     * @param index selected card index
     * @return Card selected
     */
    public Card getCard(int index) {
        return cards[index];
    }

    /**
     * Initiate controller selecting the 8 cards
     */
    public ShowCardsController() {
        this.numbers = new HashSet<>();
        this.randomGenerator = new Random();
        this.cards = new Card[8];
        suffleCards();
    }

    public void suffleCards() {
        this.numbers = new HashSet<>();
        int randomNum;
        for (int i = 0; i < 8; i++) {
            // add 8 card without repeat it
            do {
                randomNum = randomGenerator.nextInt(baraja.size());
                numbers.add(randomNum);
            } while (numbers.size() <= i);
            cards[i] = baraja.get(randomNum);
        }
    }
}
