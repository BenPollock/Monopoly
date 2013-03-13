/***************************************************
 *  Author Michal Pasternak
 *  Date:december 6th 2009
 *  Filename: Dice.java
 *  Description: Roll dem dice yo
 **************************************************/

public class Dice {
    
    private int diceOne = 0;
    private int diceTwo = 0;
    private int total = 0;
    private boolean loaded;
    
    public Dice(){
	
	loaded = false;
    }
    public Dice (boolean loaded){
	
	this.loaded = loaded;
    }
    
    public int roll (){ //roll the dice
	diceOne = 0;
	diceTwo = 0;
	while (diceOne<1||diceOne>6){
	    diceOne = (int)(Math.random()*10);
	}
	
	if (loaded == false){
	    
	    while (diceTwo<1||diceTwo>6){
		diceTwo = (int)(Math.random()*10);
	    }
	    
	    if (loaded == true)
		diceTwo = diceOne;
	    
	}
	
	total = diceOne + diceTwo;
	return total;
    }
    
    public boolean isDouble (){ // are the two dice last rolled doubles?
	
	if (diceOne==diceTwo)
	    return true;
	else 
	    return false;
    }   
}
