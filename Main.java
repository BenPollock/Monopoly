public class Main{   


    public static void main(String[] args){
	Monopoly monopolyGame = new Monopoly();
	monopolyGame.initialize();
	for (int j = 0; j < 100; j ++){
	    for (int i = 0; i < monopolyGame.getNumPlayers(); i ++){
		monopolyGame.turn(monopolyGame.players[i]);
	    }
	}
	
    }
}