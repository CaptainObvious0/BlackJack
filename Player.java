import java.util.ArrayList;

public class Player {
    
    String name;
    ArrayList<Integer> deck;
    
    Player(String player, ArrayList<Integer> deck) {
        this.name = player;
        this.deck = deck;
    }
    
    public ArrayList<Integer> getPlayerDeck() {
        return this.deck;
    }
    
    public void setPlayerDeck(ArrayList<Integer> deck) {
        this.deck = deck;
    }
    
    public void addPlayerDeck(int card) {
        deck.add(card);
    }
    
    public void resetPlayerDeck() {
        deck.clear();
    }
    
}
