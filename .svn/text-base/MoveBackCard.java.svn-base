public class MoveBackCard extends Card{
    
    private String text;
    private int amount;
    
    
public MoveBackCard (int spaces,String text){ // text, and the amount to move back
    this.text = text;
    this.amount = spaces;
}
    
    public void execute (Player p){
	p.changeCurSqr(p.getCurSqr()-amount);//move player back the amount of squares specified
    }
    public String printText(){ // print the text on the card
	return this.text;
    }
}
