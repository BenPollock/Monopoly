public class CommunityChest implements Square{
    
    private Deck deck;

    public CommunityChest (Deck a){       // gives the square a deck
	deck = a;
    }

    public void handlePlayer(Player p){      // gives the player the card
	System.out.println ("You landed on CommunityChest!  You draw:");
	System.out.println (deck.print());
	deck.next(p);
    }

    public Player getOwner(){
	return null;
    }
    
    

}