import java.util.Scanner;

public class Utilities extends Property{

    String useranswer;
    Scanner s = new Scanner(System.in);
    int cost;
    int c = 0;
    int currentRent;
    
    
    public Utilities (String na, int b) {
        mortgageValue = b;
	purchasePrice = 150;
	name = na;
	canBeOwned = true;
	
    }

    public Player getOwner(){
	return this.owner;
    }

    public void handlePlayer (Player p){
	if (owner == null){
	    System.out.println ("Would you like to buy " + this.name + "  $150. y or n");
	    useranswer = s.next();
	    
	    if (useranswer.equalsIgnoreCase("y") == true){
		p.takeMoney(this.purchasePrice);
		this.owner = p;
		System.out.println ("You have purchased "+this.name);
		p.addProperty(this);

	    }
	    // give owner the square or not
	}
	else{
	    // roll dice
	    // find if owner owns both utilities
	    // multiply roll by 4 or 10
	    // player p gives money to owner
	    Dice dice = new Dice();
	   int playerRoll = dice.roll();
	   System.out.println ("You have rolled a "+playerRoll);
	   if (p.getGame().returnSquare(12).getOwner() == this.getOwner() &&p.getGame().returnSquare(28).getOwner() == this.getOwner()){
	       cost = playerRoll * 10;
	   }
	   else{
	       cost = playerRoll * 4;
	   }
	   currentRent = cost;
	   System.out.println ("You owe "+this.owner.getName() + " " + cost);
	   if (p.getMoney() < this.currentRent)
	       c = p.getMoney();//if the player doesn't have enough money, take all they have.
	   p.takeMoney(c);
	   this.owner.addMoney(c);
	       
	}
    }

}