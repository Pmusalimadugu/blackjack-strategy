/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackstrategy.game;

import java.util.ArrayList;

/**
 *
 * @author phazyr
 */
public class Player {
    private boolean hasBust;
    private boolean isHold;
    ArrayList<Integer> hand = new ArrayList<>();
    private int handTotal;
    private int target;
    private int numWins;
    private int numGames;
    
    
    
    
    public Player(int target) {
        this.target = target;
        hasBust = false;
        isHold = false;
        handTotal = 0;
        numWins = 0;
        numGames = 0;
    }
    
    public void takeTurn(Deck myDeck) {
        
        updateTotal();
        
        if (handTotal == 0) {
            
            hand.add(myDeck.drawCard());
            hand.add(myDeck.drawCard());

        } else if (handTotal < target) {
            
            hand.add(myDeck.drawCard());
            updateTotal();
            
            if (handTotal > 21) {
                if (hand.remove(Integer.valueOf(11)) == true) {
                    hand.add(1);
                } else {
                    hasBust = true;
                }
                
            }
            
        } else {
            isHold = true;
        }
        
        updateTotal();
        
        
    }
    
    private void updateTotal() {
        handTotal = 0;
        for(int i = 0; i < hand.size(); i++) {
            handTotal += hand.get(i);
        }
    }
    
    public int getTotal() {
        return handTotal;
    }
    
    public boolean getBust() {
        return hasBust;
    }
    
    public boolean getHold() {
        return isHold;
    }
    
    public void addWin() {
        numWins += 1;
    }
    
    public double getWinrate() {
        return 100*((double)numWins/numGames);
    }
    
    public void reset() {
        hasBust = false;
        isHold = false;
        handTotal = 0;
        hand.clear();
        numGames += 1;
    }
    
    
}
