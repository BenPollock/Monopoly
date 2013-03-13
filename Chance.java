public class Chance implements Square {

    private Deck deck;

    public Chance (Deck d) {
	this.deck = d;//creates a deck of chance cards
    }

    public void handlePlayer (Player p) {
	System.out.println ("You landed on chance!  You draw:");
	System.out.println (deck.print());//prints the string
	deck.next(p); //draws a card

    }
    
    public Player getOwner() {
	return null;//the square cannot be owned
    }





}