import java.util.Scanner;

public class Railroad extends Property{

    private int currentRent;
    String useranswer;
    Scanner s = new Scanner(System.in);


    public Railroad(String n) {
	name = n;//store the name of the Railroad
	mortgageValue = 100;
	purchasePrice = 200;//set the price of the railroad
	canBeOwned = true;
    }

    public void handlePlayer (Player p){
	if (owner == null){
	    System.out.println ("Would you like to buy " + this.name+ "  $200. y or n");
	    useranswer = s.next();

	    if (useranswer.equalsIgnoreCase("y")==true){
		p.takeMoney(this.purchasePrice);
		this.owner = p;
		System.out.println("You have purchased "+this.name);
		p.addProperty(this);
	    }
	}
	else{
	    // give owner 25, 50, 100, 200 dollars
	  
	    int count = 0;
	    for (int i = 5; i < 40; i = i + 10){
		if (p.getGame().returnSquare(i).getOwner() == this.getOwner()){
		    count++;
		}
	    }
	    if (count == 1){
		currentRent = 25;	    }
		//take 25
	    if (count == 2){
		currentRent = 50;
	    }
	    // take 50
	    if (count == 3){
		currentRent = 100;
	    }
	    // take 100
	    if (count == 4){
		currentRent = 200;
	    }
	    // take 200
	    
	    int c = currentRent;
	    if (p.getMoney() < this.currentRent)
		c = p.getMoney();
	    p.takeMoney(c);
	    this.owner.addMoney(c);

	    System.out.println ("You owe " + this.owner.getName() + " " + this.currentRent + " dollars");
	}
    }
    
    
}