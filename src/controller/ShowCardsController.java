/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
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
        this.numbers = new HashSet<>();
        this.randomGenerator = new Random();
        this.cards = new ArrayList<>();
        selectCards();
    }

    /**
     * Select 8 random cards
     *
     */
    public void selectCards() {
        this.numbers = new HashSet<>();
        int randomNum;
        do {
            randomNum = randomGenerator.nextInt(index.Index.getBaraja().size());
            numbers.add(randomNum);
        } while (numbers.size() <= 8);
        System.out.println(numbers);
        // this equals than for
        this.cards.clear();
        numbers.forEach((number) -> {
            this.cards.add(index.Index.getBaraja().get(number));
        });
        System.out.println(cards);
    }

    /**
     * remove cards in parameters and calls select cards method
     *
     * @param positions cards to remove
     */
    public void suffleCards(int[] positions) {
        ArrayList<Integer> toRemove = new ArrayList<>();
        //borra del hashset las posiciones que indica
        for (int position : positions) {
            // same than foreach { if(xxxxx)}
            numbers.stream().filter((number) -> (number == cards.get(position).getId())).forEachOrdered((number) -> {
                toRemove.add(number);
            });
        }
        toRemove.forEach((integer) -> {
            numbers.remove(integer);
        });
        selectCards();
    }
}
