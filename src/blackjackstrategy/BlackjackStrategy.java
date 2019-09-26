/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackstrategy;

import blackjackstrategy.game.*;

/**
 *
 * @author phazyr
 */
public class BlackjackStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //IMPORTANT PARAMETERS
        int numTrials = 1000000;
        int numDecks = 4;
        int playerThreshold = 18;
        int dealerThreshold = 17;
        
        
        
        
        Deck myDeck = new Deck(numDecks);
        Player notDealer = new Player(playerThreshold);
        Player dealer = new Player(dealerThreshold);
        
        
        for(int i = 0; i < numTrials; i++) {
            while(!(notDealer.getBust() || dealer.getBust()) && !(notDealer.getHold() && dealer.getHold())) {
                notDealer.takeTurn(myDeck);
                dealer.takeTurn(myDeck);
            
            }
        
            //System.out.println(notDealer.getTotal());
            //System.out.println(dealer.getTotal());
            
            if (notDealer.getTotal() > 21) {
                dealer.addWin();
            } else if (dealer.getTotal() > 21) {
                notDealer.addWin();
            } else if (dealer.getTotal() >= notDealer.getTotal()) {
                dealer.addWin();
            } else {
                notDealer.addWin();
            }
        
            notDealer.reset();
            dealer.reset();
            myDeck.reset();
        }
        
        System.out.println("The dealer's winrate was " + dealer.getWinrate() + "%.");
        System.out.println("The player's winrate was " + notDealer.getWinrate() + "%.");
        System.out.println("The house had a " + 2*(dealer.getWinrate()-50) + "% edge.");
        
        
                
        
        
        
    }
    
}
