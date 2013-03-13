public class IncomeTax implements Square {

    int defaultTax = 200; //the most common charge
    int tax;
    
    // canBeOwned = false;

    public IncomeTax() {

    }
    public Player getOwner(){
	return null;
    }
    
    public void handlePlayer(Player p){

	 System.out.println ("You have been charged income tax");
	 System.out.println ("It was calculated by taking 10 percent of your total worth, with a max fee of $200.00");
	
	 tax = (int)(p.getPlayerValue()*.1); //calculates 10 percent of players total worth

	if (tax > defaultTax){//if this is more than 200 dollars, just use the default
	    tax = 200;
	}
	
	System.out.println ("You are charged "+tax+" dollars");
	p.takeMoney(tax);//return the value
	
	
    }
    



}