import java.util.*;

public class Player {

    private Monopoly game;
    int cursqr;//contains the location of the player on the board
    int balance;//the players money
    int playerOrder;//the player order for turns
    int getOutOfJailFreeCount;//how many get out of jail free cards the player has
    boolean jail;//stores if player is in jail
    String name;//stores the players name
    ArrayList<Building> buildings = new ArrayList<Building>();//makes an arraylist to hold all of the players buildings
    ArrayList<Utilities> utilities = new ArrayList<Utilities>();//makes an arraylist to hold utilities
    ArrayList<Railroad> railroads = new ArrayList<Railroad>();//makes ab arraylist to hold railroads

    public Player(String n, int b, int p, Monopoly tempMono){
	this.game = tempMono;//
	this.name = n;//set the player name
	this.balance = b;//set the players money
	this.playerOrder = p;//give a number for player order	
    }

    public Monopoly getGame() {
	return this.game;//get the monopoly game
    }

    public String getName() {
	return this.name;//return the players name
    }

    public void changeName(String s) {
	name = s;//change the players name
    }
    
    public void addMoney(int amt) {
	this.balance = this.balance + amt;//add the money taken from whoever to the player	
    }

    public int getMoney() {
	return this.balance;//returns a players balance
    }

    public int takeMoney(int amt) {
	int temp;
	
	if (this.balance > amt) {//if the player can afford to pay
	    this.balance = this.balance - amt;//take the amount of money from the player
	}
	
	if (this.balance < amt) {//if the player can't afford to pay
	    temp = this.balance;//store what money the player has
	    this.balance = 0;//set balance to 0
	}
	
	return amt;//return the amount
	
    }
    
    public int getHouses() {
	int numHouses = 0;//total for how many houses the player owns

	for (int i = 0;i > buildings.size();i++) {
	    if (this.buildings.get(i).returnNumHouses() > 0) {
		numHouses += this.buildings.get(i).returnNumHouses();//add the number of houses on this property to the total
	    }
	}
	return numHouses;//returns total number of houses
    }

    public int getHotels() {
	int numHotels = 0;//total for how many hotels the player owns
	
	for (int i = 0;i > buildings.size();i++) {
	    if (this.buildings.get(i).returnHotel() == true) {
		numHotels += 1;//add the number of hotels on this property to the total
	    }
	}
	return numHotels;//return total number of hotels
    }

    public void useJailCard() {
	this.getOutOfJailFreeCount -= 1;//use a get out of jail free card
    }
    
    public void addJailCard() {
	this.getOutOfJailFreeCount += 1;//add a get out of jail free card
    }

    public boolean checkJail() {
	return jail;//returns if the player is in jail
    }

    public void inJail(boolean j) {
	this.jail = j;//change jail status
    }
    
    public int getPlayerOrder() {
	return this.playerOrder;//return the players play order
    }

    public int getCurSqr() {
	return this.cursqr;//returns the current square of the player
    }
    
    public void changeCurSqrWithNoCheck(int p){//don't check the square after moving
	cursqr = p;//move the player
    }
    
    public void changeCurSqr(int p) {
	cursqr = p;//move the player
	game.checkSquare(p, this);//check the cursqr of the player
    }

    public void addProperty(Building b) {//adds a building
	buildings.add(b);//add a property to the players list of their properties
    }

    public void addProperty(Railroad r) {//adds a railroad
	railroads.add(r);//add a property to the players list of their properties
    }

    public void addProperty(Utilities u) {//adds a utility
	utilities.add(u);//add a property to the players list of their properties
    }

    public void removeProperty(Building b) {//removes buildings
	String name = b.getName();//get the property name
	int index = 0;//store the index
	
	for (int i = 0; i < buildings.size();i++) {
	    if (buildings.get(i).getName().equals(name) == true) {//when the property matches
		i = index;//save the index
	    }
	}
	buildings.remove(index);//remove the property in the index

    }

    public void removeProperty(Railroad r) {//removes railroads
	String name = r.getName();//get the property name
	int index = 0;//store the index
	
	for (int i = 0; i < railroads.size();i++) {
	    if (railroads.get(i).getName().equals(name) == true) {//when the property matches
		i = index;//save the index
	    }
	}
	railroads.remove(index);//remove the property in the index
	
    }

    public void removeProperty(Utilities u) {//removes utilities
	String name = u.getName();//get the property name
	int index = 0;//store the index
	
	for (int i = 0; i < utilities.size();i++) {
	    if (utilities.get(i).getName().equals(name) == true) {//when the property matches
		i = index;//save the index
	    }
	}
	utilities.remove(index);//remove the property in the index
	
    }

    public int numBuildings() {
	return buildings.size();//return the count of Buildings
    }

    public int numRailroads() {
	return railroads.size();//return the count of Railroads
    }

    public int numUtilities() {
	return utilities.size();//return the count of Utilities
    }

    public void returnAllProperties() {  // lists all the properties

	for (int i = 0;i < buildings.size();i++) {
	    System.out.println (buildings.get(i).getName());//get the name of all the buildings and display them
	}
	
	for (int i = 0;i < railroads.size();i++) {
	    System.out.println (railroads.get(i).getName());//get the name of all the railroads and display them
	}
	
	for (int i = 0;i < utilities.size();i++) {
	    System.out.println (utilities.get(i).getName());//get the name of all the utilities and display them
	}
    }

    public void returnAllBuildings() {//only get the building names
	for (int i = 0;i < buildings.size();i++) {
	    System.out.println (buildings.get(i).getName());//get the name of all the buildings and display them
	}
    }
    
    public int getPlayerValue() {
	int total = 0;//holds the total value
	
	for (int i = 0;i < buildings.size();i++) {
	    total += buildings.get(i).getMortgageValue();//add all of the players properties' mortgage values
	}

	for (int i = 0;i < railroads.size();i++) {
	    total += railroads.get(i).getMortgageValue();//add all of the players properties' mortgage values
	}
	
	for (int i = 0;i < utilities.size();i++) {
	    total += utilities.get(i).getMortgageValue();//add all of the players properties' mortgage values
	}
	
	total += this.getMoney();//add the players money
	
	return total;//return the total
    }
    
    public boolean equals(Player p) {

	if (p.getPlayerOrder() == this.getPlayerOrder()) {//if the player has the same player order
	    return true;//its the same player
	}else {
	    return false;//its not the same player
	}
    }

    public static void main(String[] args) {
	
    }

}