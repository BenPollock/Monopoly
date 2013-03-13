public class CloseRailRoadCard extends Card{
    // the closest rail road card
    private String text;
    
    public CloseRailRoadCard (String text){ //constructor only takes in text
	this.text = text;
    }

    public void execute (Player p){
	int result = 0;
	if (p.getCurSqr() == 7)// first chance sqr
	    result = 8; //move 8 slots to rail road
	if (p.getCurSqr() == 22)// second chance sqr
	    result = 3;// move up 3 slots
	if (p.getCurSqr() == 36){ // 3rd chance sqr
	    p.addMoney(200); // for passing go u get 200
	    result = 9; //move up 9
	}
	p.changeCurSqr(p.getCurSqr()+result); //implement changes
    }
    public String printText(){ // print card text
	return this.text;
    }
}

