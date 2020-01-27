import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) {
	    
	    Deck deck = new Deck();
	    Player player = new Player("Michael", deck.createPlayerHand());
	    Player dealer = new Player("Dealer", deck.createPlayerHand());
	    System.out.println("Dealers Cards: " + deck.cardToString(dealer.getPlayerDeck().get(0)));
	    System.out.println("Your hand: " + deck.cardToString(player.getPlayerDeck().get(0)) + " and " + deck.cardToString(player.getPlayerDeck().get(1)));
	    System.out.println("Your Total: " + deck.getHandTotal(player.getPlayerDeck()));
	    System.out.println(" ");
	    
	    Scanner scan = new Scanner(System.in);
	    boolean playerActive = true;
	    boolean dealersTurn = false;
	    while (playerActive) {
	     System.out.println("Enter 1 to hit and 0 to stand");
	     int value = scan.nextInt();
	     if (value == 1) {
	         int drawCard = deck.drawAnotherCard();
	         player.addPlayerDeck(drawCard);
	         System.out.println("You drew the " + deck.cardToString(drawCard));
	         int total = deck.getHandTotal(player.getPlayerDeck());
	         System.out.println("Current total: " + total);
	         if (total > 21) {
	             System.out.println("Bust! Dealer won!");
	             playerActive = false;
	         } else if (total == 21) {
	             System.out.println("Blackjack!");
	             playerActive = false;
	         }
	     } else if (value == 0) {
	         System.out.println("You ended with a total of " + deck.getHandTotal(player.getPlayerDeck()));
	         playerActive = false;
	         dealersTurn = true;
	     }
	    }
	    
	    if (dealersTurn) {
	     boolean dealerWin = false;
	     boolean dealerBust = false;
	     boolean shouldContinue = true;
	     System.out.println("Dealers turn");
	     int dealerTotal = deck.getHandTotal(dealer.getPlayerDeck());
	     System.out.println("Dealers second card: " + deck.cardToString(dealer.getPlayerDeck().get(1)));
	     System.out.println("Dealers hand total: " + dealerTotal);
	     if (dealerTotal == 21) {
	         System.out.println("Dealer blackjack!");
	         dealerWin = true;
	     }
	     while (deck.getHandTotal(dealer.getPlayerDeck()) <= deck.getHandTotal(player.getPlayerDeck()) && deck.getHandTotal(dealer.getPlayerDeck()) < 21 && shouldContinue) {
	         int dealerCard = deck.drawAnotherCard();
	         dealer.addPlayerDeck(dealerCard);
	         int newTotal = deck.getHandTotal(dealer.getPlayerDeck());
	         System.out.println("Dealer drew the " + deck.cardToString(dealerCard) + " with a new total of " + newTotal);
	         if (newTotal > 21) {
	             System.out.println("Dealer bust!");
	             shouldContinue = false;
	             dealerBust = true;
	         } else if (newTotal == 21) {
	             System.out.println("Dealer blackjack!");
	             dealerWin = true;
	             shouldContinue = false;
	         }
	         if (deck.getHandTotal(dealer.getPlayerDeck()) > deck.getHandTotal(player.getPlayerDeck()) && !shouldContinue) {
	             dealerWin = true;
	             shouldContinue = false;
	         }
	     }
	     
	     if (dealerWin && deck.getHandTotal(dealer.getPlayerDeck()) <= 21 && !dealerBust) {
	         System.out.println("You lost!");
	     } else {
	         System.out.println("You won!");
	     }
	    }
	    
	}
}
