public class Gotojail implements Square{
    
    int value;
    boolean canBeOwned = false;

    public Player getOwner(){
	return null;
    }
    
    public void handlePlayer (Player p){
	System.out.println ("Go to jail. Go directly to jail.");
	System.out.println ("Do not pass Go. Do not get $200.");
	p.inJail(true);              // makes guy go to jail
    } 
}