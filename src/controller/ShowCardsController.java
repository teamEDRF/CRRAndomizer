/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static index.Index.baraja;
import java.util.HashSet;
import java.util.Random;
import view.CardPanel;
import model.Card;

/**
 *
 * @author santi
 */
public class ShowCardsController {

    private Random randomGenerator = new Random();

    public Card getCard(int index) {
        return cards[index];
    }

    //conjunto de numeros que indican los id de las cartas
    private HashSet<Integer> numbers = new HashSet<>();
    private Card[] cards;

    public ShowCardsController() {
        this.cards = new Card[8];
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
