public class PayCard extends Card {
    
    private String text;
    private int amount;

    public PayCard(String text, int value){ // card text and amount required to pay
	this.text = text;
	this.amount = value;
    }
    
    public void execute(Player p){
	p.addMoney(amount); // give player the amount of money he deserves
    }
    public String printText(){// print the text text on the card
	return this.text;
    }
}
