public class PayPlayerCard extends Card {
    private String text;
    private int amount;
    
    public PayPlayerCard (int value, String text){
	this.text = text;
	this.amount = value;
    }
    
    public void execute (Player p){
	int temp = p.getGame().getNumPlayers();
	p.addMoney(-amount*temp);
	for (int i = 0; i<p.getGame().getNumPlayers();i++){
	    p.addMoney(amount);
	}
    }
    public String printText(){
	return this.text;
    }
}



