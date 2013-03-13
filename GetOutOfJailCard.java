public class GetOutOfJailCard extends Card{
    
    private String text;
    
    
    public GetOutOfJailCard (String text){ // make this card
	this.text = text;
    }
    
    public void execute (Player p){
	p.addJailCard(); // give player a jail card
    }
    public String printText(){// print the text on the card
	return this.text;
    }
}



