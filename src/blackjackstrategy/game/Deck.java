/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackstrategy.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author phazyr
 */
public class Deck {
    
    private int numDecks;
    List<Integer> oneDeckCards = Arrays.asList(
        2,3,4,5,6,7,8,9,10,10,10,10,11,
        2,3,4,5,6,7,8,9,10,10,10,10,11,
        2,3,4,5,6,7,8,9,10,10,10,10,11,
        2,3,4,5,6,7,8,9,10,10,10,10,11
    );
    ArrayList<Integer> cardsList = new ArrayList<>();
    
    
    
    
    public Deck(int numDecks) {
        this.numDecks = numDecks;
        
        for (int i = 0; i < numDecks; i++) {
            cardsList.addAll(oneDeckCards);
        }
        
        this.shuffle();
    }
    
    private void shuffle() {
        Collections.shuffle(cardsList);
    }
    
    public int drawCard() {
        int cardVal = cardsList.get(0);
        cardsList.remove(0);
        return cardVal;
    }
    
    public void reset() {
        cardsList.clear();
        for (int i = 0; i < numDecks; i++) {
            cardsList.addAll(oneDeckCards);
        }
        
        this.shuffle();
    }
    
    public void debug() {
        System.out.println(" ");
        for (int i = 0; i < cardsList.size(); i++) {
            System.out.print(cardsList.get(i) + " ");
        }
        
    }
    
    
}
