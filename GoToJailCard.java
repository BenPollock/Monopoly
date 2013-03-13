public class GoToJailCard extends Card{
    
    private String text;
    
    
    public GoToJailCard (String text){ //text on card
	this.text = text;
    }
    
    public void execute (Player p){
	p.changeCurSqr(30); //go directly to the go to jail square no passing go, this happens to be sqr 30
    }
    public String printText(){ //print card text
	return this.text;
    }
}



