public class GoToCard extends Card{
    
    private String text;
    private int spot;
    
    
    public GoToCard (String text, int spot){ // text on the card, and the square number to move to
	this.text = text;
	this.spot = spot;
    }
    
    public void execute (Player p){
	if (p.getCurSqr()<spot) //go is between the spot and the players position
	    p.addMoney(200); //give him 200$ for passing go
	p.changeCurSqr(spot); //move the player to the spot on the board
    }
    public String printText(){ //print the text on the card
	return this.text;
    }
}
