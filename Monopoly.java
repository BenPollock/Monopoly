import java.awt.Color;
import java.util.Scanner;

public class Monopoly {

    private int numPlayers;
    Scanner s = new Scanner (System.in);

    Square[] board = new Square[41];
    Deck communityChest = new Deck(false);
    Deck chance = new Deck(true);
    Dice dice = new Dice();

    Player [] players = new Player [5];


    public Monopoly(){
	numPlayers = 0;
    }


    void movePlayer(int num, Player p){        // player movement, only for dice rolls
	for (int i = 0; i < num; i ++){
	    // System.out.println (p.getName() + " " + p.getCurSqr() + " changing   " + (num- i));
	    p.changeCurSqrWithNoCheck(p.getCurSqr() + 1);
	    checkGo(p);
	
	    
	}
	checkSquare(p.getCurSqr(), p);      // checks square once they land
	
    }


    void checkGo(Player p){
	if (p.getCurSqr() == 40){       // checks if player is on go, wraps them, gives them $200
	    p.changeCurSqr(0);
	    p.addMoney(200);
	    System.out.println ("You collect $200 for passing GO.");
	}
    }


    void checkSquare(int squareNum, Player p){       // checks the square the player is on and runs the checkplayer
	board[squareNum].handlePlayer(p);
    }
    
    void initialize(){

	chance.shuffle();
	communityChest.shuffle();

	System.out.println ("How many players will be playing, between 2-6");
	int zz = s.nextInt();
	if (zz > 6)
	    zz = 6;
	if (zz < 2)
	    zz = 2;

	//gui gets amount of players, then i construct them


	board [0] = new Go();
	board [1] = new Building("Mediterranean Avenue", Color.magenta, 60, 2, 10, 30, 90, 160, 250, 30, 50);
	board [2] = new CommunityChest(communityChest);
	board [3] = new Building("Baltic Avenue", Color.magenta, 60, 4, 20, 60, 180, 320, 450, 30, 50);
	board [4] = new IncomeTax();
	board [5] = new Railroad ("Reading Railroad");
	board [6] = new Building("Oriental Avenue", Color.cyan, 100, 6, 30, 90, 270, 400, 550, 50, 50);
	board [7] = new Chance(chance);
	board [8] = new Building ("Vermont Avenue", Color.cyan, 100, 6, 30, 90, 270, 400, 550, 50, 50);
	board [9] = new Building ("Connecticut Avenue", Color.cyan, 120, 8, 40, 100, 300, 450, 600, 60, 50);
	board [10] = new Freespace();
	board [11] = new Building ("St. Charles Place", Color.pink, 140, 10, 50, 150, 450, 625, 750, 70, 100);
	board [12] = new Utilities("Electric Company", 75);
	board [13] = new Building ("States Avenue", Color.pink, 140, 10, 50, 150, 450, 625, 750, 70, 100);
	board [14] = new Building ("Virginia Avenue", Color.pink, 160, 12, 60, 80, 180, 500, 900, 80, 100);
	board [15] = new Railroad ("Pennsylvania RailRoad");
	board [16] = new Building ("St. James Place", Color.orange, 180, 14, 70, 200, 550, 750, 950, 90, 100);
	board [17] = new CommunityChest(communityChest);
	board [18] = new Building ("Tennessee Avenue", Color.orange, 180, 14, 70, 200, 550, 750, 950, 90, 100);
	board [19] = new Building ("New York Avenue", Color.orange, 200, 16, 80, 220, 600, 800, 1000, 100, 100);
	board [20] = new Freespace();
	board [21] = new Building ("Kentucky Avenue", Color.red, 220, 18, 90, 250, 700, 875, 1050, 110, 150);
	board [22] = new Chance(chance);
	board [23] = new Building ("Indiana Avenue", Color.red, 220, 18, 90, 250, 700, 875, 1050, 110, 150);
	board [24] = new Building ("Illinois Avenue", Color.red, 240, 20, 100, 300, 750, 925, 1100, 120, 150);
	board [25] = new Railroad ("B&O RailRoad");
	board [26] = new Building ("Atlantic Avenue", Color.yellow, 260, 22, 110, 330, 800, 975, 1150, 130, 150);
	board [27] = new Building ("Ventnor Avenue", Color.yellow, 260, 22, 110, 330, 800, 975, 1150, 130, 150);
	board [28] = new Utilities("Waterworks", 75);
	board [29] = new Building ("Marvin Gardens", Color.yellow, 280, 24, 120, 360, 850, 1025, 1200, 140, 150);
	board [30] = new Gotojail();
	board [31] = new Building ("Pacific Avenue", Color.green, 300, 26, 130, 390, 900, 1100, 1275, 150, 200);
	board [32] = new Building ("North Carolina Avenue", Color.green, 300, 26, 130, 390, 900, 1100, 1275, 150, 200);
	board [33] = new CommunityChest(communityChest);
	board [34] = new Building ("Pennsylvania Avenue", Color.green, 320, 28, 150, 450, 1000, 1200, 1400, 160, 200);
	board [35] = new Railroad("Shortline");
	board [36] = new Chance(chance);
	board [37] = new Building ("Park Place", Color.blue, 350, 35, 175, 500, 1100, 1300, 1500, 175, 200);
	board [38] = new Luxurytax();
	board [39] = new Building ("Boardwalk", Color.blue, 400, 50, 200, 600, 1400, 1700, 2000, 200, 200);
	board [40] = new Freespace();
	
	numPlayers = zz;      // bla is temporary
	for (int i = 0; i < numPlayers; i ++){
	    System.out.println ("What is player " + (i + 1) + "'s name?");
	    String temp = s.next();
	    players[i] = new Player (temp, 1500, i, this);
	    players[i].changeCurSqrWithNoCheck(0);
	}

	

	
    }

    public Player getPlayer (int i){
	return players[i];
    }

    public void turn(Player p){
	System.out.println ("\nPlayer " + p.getName() + ", you're up.");
	while (true){
	    System.out.println ("Press R to roll, B to see balance, M to mortgage property, or H to purchase houses.");
	    String answer;
	    answer = s.next();
	    if (answer.equalsIgnoreCase("R") == true){
		int a = dice.roll();
		//	if (a.isDouble() == true){
		//  System.out.println ("You rolled Doubles!");
		//	}
		System.out.println ("You roll " + a);
		this.movePlayer(a, p);
		break;
	    }
	    else if (answer.equalsIgnoreCase("B") == true){
		System.out.println ("Your balance is " + p.getMoney());
	    }
	    else if (answer.equalsIgnoreCase("M") ==true){
		p.returnAllProperties();
		while (true){
		    System.out.println ("\nPress A to exit, B to mortgage buildings, R to mortgage railroads, U to mortgage utilities.");
		    String mort = s.next();


		    if (mort.equalsIgnoreCase("A")== true){
			break;
		    }
		    else if (mort.equalsIgnoreCase("B") == true)
			this.mortgageBuildings(p);
		    else if (mort.equalsIgnoreCase("R") == true)
			this.mortgageRailroads(p);
		    else if (mort.equalsIgnoreCase("U") == true)
			this.mortgageUtilities(p);
		    
		    
		}
	    }
	    else{
		this.buyHouses(p);
	    }
	}
    }

    private void buyHouses (Player p){
	boolean propertyChecked;
	boolean groupOwned; //if it is possible to buy a home.	
	int groupCount = 0;
	Color colorGroup = null;	
	//if the player owns all of a color group
       	String house;
	System.out.println ("What building would you like to buy a house for?");

	house= s.nextLine();
	
	
	for (int i = 0; i < p.numBuildings(); i ++){
	    if (p.buildings.get(i).getName().equalsIgnoreCase(house)){   // goes through every owned property to see if the names match
		propertyChecked = true;
		 colorGroup = p.buildings.get(i).getGroup();//get the group the property belongs to
	    }
	}
		
	if (propertyChecked){
	   
		
	    for (int i = 0; i < p.numBuildings(); i++){
		if (p.buildings.get(i).getGroup() == colorGroup)
		    groupCount++;
	    
	    
		if (colorGroup.equals(Color.magenta) && groupCount == 2){
		    // if the whole group is owned, buy a house for the property
		    p.takeMoney(p.buildings.get(i).getHousePrice());
		    p.buildings.get(i).buyHouse(p);//buys the house
		    System.out.println ("You have bought a house for " + p.buildings.get(i).getName());
		}
	    

		else if (colorGroup.equals(Color.cyan) && groupCount == 3){
		    // if the whole group is owned, buy a house for the property
		    p.takeMoney(p.buildings.get(i).getHousePrice());
		    p.buildings.get(i).buyHouse(p);//buys the house
		    System.out.println ("You have bought a house for " + p.buildings.get(i).getName());
		}
		
		else if (colorGroup.equals(Color.pink) && groupCount == 3){
		    // if the whole group is owned, buy a house for the property
		    p.takeMoney(p.buildings.get(i).getHousePrice());
		    p.buildings.get(i).buyHouse(p);//buys the house
		    System.out.println ("You have bought a house for " + p.buildings.get(i).getName());
		}
		
		else if (colorGroup.equals(Color.orange) && groupCount == 3){
		    // if the whole group is owned, buy a house for the property
		    p.takeMoney(p.buildings.get(i).getHousePrice());
		    p.buildings.get(i).buyHouse(p);//buys the house
		    System.out.println ("You have bought a house for " + p.buildings.get(i).getName());
		}
		
		else if (colorGroup.equals(Color.red) && groupCount == 3){
		    // if the whole group is owned, buy a house for the property
		    p.takeMoney(p.buildings.get(i).getHousePrice());
		    p.buildings.get(i).buyHouse(p);//buys the house
		    System.out.println ("You have bought a house for " + p.buildings.get(i).getName());
		}
		
		else if (colorGroup.equals(Color.yellow) && groupCount == 3){
		    // if the whole group is owned, buy a house for the property
		    p.takeMoney(p.buildings.get(i).getHousePrice());
		    p.buildings.get(i).buyHouse(p);//buys the house
		    System.out.println ("You have bought a house for " + p.buildings.get(i).getName());
		}
		
		else if (colorGroup.equals(Color.green) && groupCount == 3){
		    // if the whole group is owned, buy a house for the property
		    p.takeMoney(p.buildings.get(i).getHousePrice());
		    p.buildings.get(i).buyHouse(p);//buys the house
		    System.out.println ("You have bought a house for " + p.buildings.get(i).getName());
		}
		
		else if (colorGroup.equals(Color.blue) && groupCount == 2){
		    // if the whole group is owned, buy a house for the property
		    p.takeMoney(p.buildings.get(i).getHousePrice());
		    p.buildings.get(i).buyHouse(p);//buys the house
		    System.out.println ("You have bought a house for " + p.buildings.get(i).getName());
		}

		else{
		    System.out.println ("This property cannot be improved unless you own the entire color group.");
		}
	    }
	}
	if (propertyChecked == false){  // if no property is found, it doesn't exist
	    System.out.println ("This property does not exist.");
	}
	 


    }

    // for mortgaging proprties
    private void mortgageBuildings(Player p){
	System.out.println ("Type in the name of the building you want to mortgage");
	Scanner temp = new Scanner (System.in);
	String mort2 = temp.nextLine();
	boolean propertyChecked = false; // if a property is found, this is true
	for (int i = 0; i < p.numBuildings(); i ++){
	    if (p.buildings.get(i).getName().equalsIgnoreCase(mort2)){   // goes through every owned property to see if the names match
		propertyChecked = true;

		if (p.buildings.get(i).isMortgaged == false){
		    p.buildings.get(i).mortgageProperty();          // if the name matches, mortgage the property
		    p.addMoney(p.buildings.get(i).getMortgageValue());
		    System.out.println ("You have mortgaged " + p.buildings.get(i).getName() + " and have received " + p.buildings.get(i).getMortgageValue() + " dollars.");
		}

		else
		    System.out.println ("This property is already mortgaged.");
		
	    }
	}
	if (propertyChecked == false)  // if no property is found, it doesn't exist
	    System.out.println ("This property does not exist.");
    }

    // for mortgaging proprties
    private void mortgageRailroads(Player p){
	System.out.println ("Type in the name of the railroad you want to mortgage");
	Scanner temp = new Scanner (System.in);
	String mort2 = temp.nextLine();
	boolean propertyChecked = false; // if a property is found, this is true
	for (int i = 0; i < p.numRailroads(); i ++){
	    if (p.railroads.get(i).getName().equalsIgnoreCase(mort2)){   // goes through every owned property to see if the names match
		propertyChecked = true;

		if (p.railroads.get(i).isMortgaged == false){
		    p.railroads.get(i).mortgageProperty();          // if the name matches, mortgage the property
		    p.addMoney(p.railroads.get(i).getMortgageValue());
		    System.out.println ("You have mortgaged " + p.railroads.get(i).getName() + " and have received " + p.railroads.get(i).getMortgageValue() + " dollars.");
		}

		else
		    System.out.println ("This property is already mortgaged.");
		
	    }
	}
	if (propertyChecked == false)  // if no property is found, it doesn't exist
	    System.out.println ("This property does not exist.");
    }


    // for mortgaging proprties
    private void mortgageUtilities(Player p){
	System.out.println ("Type in the name of the building you want to mortgage");
	Scanner temp = new Scanner (System.in);
	String mort2 = temp.nextLine();
	boolean propertyChecked = false; // if a property is found, this is true
	for (int i = 0; i < p.numUtilities(); i ++){
	    if (p.utilities.get(i).getName().equalsIgnoreCase(mort2)){   // goes through every owned property to see if the names match
		propertyChecked = true;

		if (p.utilities.get(i).isMortgaged == false){
		    p.utilities.get(i).mortgageProperty();          // if the name matches, mortgage the property
		    p.addMoney(p.utilities.get(i).getMortgageValue());
		    System.out.println ("You have mortgaged " + p.utilities.get(i).getName() + " and have received " + p.utilities.get(i).getMortgageValue() + " dollars.");
		}

		else
		    System.out.println ("This property is already mortgaged.");
		
	    }
	}
	if (propertyChecked == false)  // if no property is found, it doesn't exist
	    System.out.println ("This property does not exist.");
    }












    
    public int getNumPlayers(){
	return numPlayers;
    }
    
    public Square returnSquare(int a){
	
	return board[a];
    }




}
