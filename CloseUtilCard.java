public class CloseUtilCard extends Card{
    
    private String text; //text on card
    private int square; // square that you will move to
    
    
    public CloseUtilCard (String text){ // set card text, make this card
	this.text = text;
    }
    
    public void execute (Player p){
	boolean first; // true means you go to electric company false means you go to water works
	int result = 0;

	if (p.getCurSqr()>12){ //figure out if water works or electric are closer to player
	    if (p.getCurSqr()>28){
		p.addMoney(200); //add 200$ since you wil move past go
		first = true;}
	    else {
		first = false;}
	}
	else {
	    first = true;
	}
	if (first == true){ //set square values based on which is closer
	    square = 12;}
	else
	    square = 28;
	p.changeCurSqr(square); //move to this square
	
    }
    public String printText(){ //print text on card
	return this.text;
    }
}

