import java.util.Random; //random generator

public class Deck {
    
    
    
    private Card[] cards= new Card[20];// my card array
    private int index = 0;
    private boolean chanceDeck;
    private int total;
    
    public Deck (boolean chanceDeck){
	if (chanceDeck == false){ // this is the presets of the community chest deck
	    this.cards[0]= new PayCard("bank error in your favor - collect $200", 200);
	    this.cards[1]= new PayCard("Doctor's fee - pay $50", -50);
	    this.cards[2]= new PayCard("Income Tax Refund - collect $20",20);
	    this.cards[3]= new PayCard("Life Insurance matures - collect $100", 100);
	    this.cards[4]= new PayCard("Pay Hospital fees - pay $100", -100);
	    this.cards[5]= new PayCard("Pay School tax - pay $150", -150);
	    this.cards[6]= new PayCard("Receive for 'Services' ;) - collect $25", 25);
	    this.cards[7]= new PayCard("You win 2nd place in a fat contest - collect $10", 10);
	    this.cards[8]= new PayCard("Your parents die, you inherit $100", 100);
	    this.cards[9]= new PayCard("From sale of stock you earn 45$", 45);
	    this.cards[10]= new PayCard("Xmas fund matures - collect 100$", 100);
	    this.cards[11] = new PayPerBuildingCard (45,115,"You are assessed for street repairs – $40 per house, $115 per hotel");
	    this.cards[12] = new PayPlayerCard(50,"Grand Opera Night - pay 50$ to each player");
	    this.cards[13] = new GetOutOfJailCard("Get out of jail free – this card may be kept until needed, or sold");
	    this.cards[14] = new GoToJailCard("Go to jail – go directly to jail – Do not pass Go, do not collect $200 ");
	    this.cards[15] = new GoToCard("Advance to Go, Collect 200$",0);
	    this.total = 16;
	}
	else{ // these are the presets for the cards in the chance deck
	    this.cards[0] = new GetOutOfJailCard("Get out of jail free – this card may be kept until needed, or sold");
	    this.cards[1] = new GoToCard("Advance to Go, Collect 200$",0);
	    this.cards[2] = new GoToCard("Advance to Illinois Avenue",24);
	    this.cards[3] = new GoToCard("Advance to St. Charles Place",11);
	    this.cards[4]= new PayCard("Bank pays you dividend of $50 ", 50);
	    this.cards[5]= new MoveBackCard(3,"Go back 3 spaces");
	    this.cards[6] = new GoToJailCard("Go to jail – go directly to jail – Do not pass Go, do not collect $200 ");
	    this.cards[7] = new PayPerBuildingCard (25,100,"Make general repairs on all your property – $25 per house, $100 per hotel");
	    this.cards[8]= new PayCard("Pay poor tax of $15 ", -15);
	    this.cards[9] = new GoToCard("Take a ride on the Reading",5);
	    this.cards[10] = new GoToCard("Advance to Boardwalk",39);
	    this.cards[11] = new PayPlayerCard(50,"You have been elected chairman of the board - pay 50$ to each player");
	    this.cards[12]= new PayCard("Your building loan matures - collect $150", 150);
	    this.cards[13]= new CloseUtilCard("Advance token to nearest Utility");
	    this.cards[14] = new CloseRailRoadCard("Advance token to the nearest Railroad");
	    this.cards[15]= new PayCard("You are sued for having to much hair on your body - pay $3000 for court services", -3000); //lol card
	    this.cards[16]= new PayCard("You sue for no reason, because you can - collect $3000 in damages", 3000); //lol card
	    this.total = 17;
	}
    }
    
    public void shuffle () { //shuffle the deck
	Random randomGenerator = new Random();
	for (int i=0;i<900;i++){ // shuffle 900 times for accuracy, or rather for randomness
	    int chosenCard = randomGenerator.nextInt(total);
	    int chosenCard2 = randomGenerator.nextInt(total);
	    Card temp = cards[chosenCard]; // store in temporary
	    cards[chosenCard]= cards[chosenCard2]; //switch card
	    cards[chosenCard2]=temp;
	}
    }
    
    public void next(Player p) { // draw the next card, do what it says, and place it back under the deck
	Card temp = cards[index];
	cards[index].execute(p);
	index++; // move up thru deck
	if (index==total){ //end of deck
	    index=0;
	}
	
	
    }
    public String print (){ //print the current card text
	return cards[index].printText();
    }
}
