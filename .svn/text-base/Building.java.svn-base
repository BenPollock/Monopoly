import java.awt.Color;
import java.util.Scanner;

public class Building extends Property{
    
    private Color group;
    private int rentWithHouse, rentWith2Houses, rentWith3Houses, rentWith4Houses, rentWithHotel, currentRent, housesOwned, hotelsOwned, housePrice;
    Scanner s = new Scanner (System.in);

    public Building (String z,Color a, int x, int b, int c, int d, int e, int f, int g, int h, int y){   // the constructor
        group = a;
	purchasePrice = x;
	defaultRent = b;
	rentWithHouse = c;
	rentWith2Houses = d;
	rentWith3Houses = e;
	rentWith4Houses = f;
	rentWithHotel = g;
	mortgageValue = h;
	housesOwned = 0;
	hotelsOwned = 0;
	currentRent = defaultRent;
	name = z;
	housePrice = y;
	canBeOwned = true;
    }
    
    public void handlePlayer (Player p){
	
	if (this.owner == null){
	    System.out.println ("Would you like to buy " + this.name +"?");
	    System.out.println ("The cost is " + this.purchasePrice);
	    System.out.println ("Y/N");
	    String answer;
	    answer = s.next();
	    if (answer.equalsIgnoreCase("Y") == true){
		p.takeMoney(this.purchasePrice);  // allows them to buy square
		this.owner = p;
		System.out.println ("You have purchased " + this.name);
		p.addProperty(this);
	    }
	}
	else if (this.owner.getName().equals(p.getName()) == false)
	    {
		System.out.println ("You have landed on " + this.name);
		System.out.println ("You owe " + this.owner.getName() + " " + this.currentRent + " dollars.");
		int c = this.currentRent;
		if (p.getMoney() < this.currentRent)
		    c = p.getMoney();
		p.takeMoney(c);
		this.owner.addMoney(c);
		//dont let them buy square
	    }
    }
    //defualt rent is handled in properties
    
    // sets and gets the rents for the square
    
    public void setRentWithHouse(int c){
	rentWithHouse = c;
    }
    public void setRentWith2Houses(int c){
	rentWith2Houses = c;
    }
    public void setRentWith3Houses(int c){
	rentWith3Houses = c;
    }
    public void setRentWith4Houses(int c){
	rentWith4Houses = c;
    }
    public void setRentWithHotel(int c){
	rentWithHotel = c;
    }
    public int returnRentWithHouse(){
	return rentWithHouse;
    }
    public int returnRentWith2Houses(){
	return rentWith2Houses;
    }
    public int returnRentWith3Houses(){
	return rentWith3Houses;
    }
    public int returnRentWith4Houses(){
	return rentWith4Houses;
    }
    public int returnRentWithHotel(){
	return rentWithHotel;
    }
    public void setGroup (Color d){       // group is the colour of the square
	this.group = d;
    }
    public Color getGroup(){
	return this.group;
    }

    public int returnNumHouses(){    // retunrs amount of houses owned on square
	return this.housesOwned;
    }

    public boolean returnHotel(){  // returns if a hotel is owned
	if (this.hotelsOwned == 1)
	    return true;
	else
	    return false;
    }

    public int returnCurrentRent(){     // returns the current rent of the square
	return this.currentRent;
    }

    public int getHousePrice() {
	return this.housePrice;
    }
    
    public void buyHouse(Player p){
	// this function has no checks, so the check must be done within player or game
	if (p.getMoney() >= this.housePrice){
	    this.housesOwned++;
	    if (housesOwned == 1)
		currentRent = this.rentWithHouse;
	    else if (housesOwned == 2)
		currentRent = this.rentWith2Houses;
	    else if (housesOwned == 3)
		currentRent = this.rentWith3Houses;
	    else if (housesOwned == 4)
		currentRent = this.rentWith4Houses;

	    p.takeMoney(this.housePrice);
	}
    }
    
    public void buyHotel(Player p){
	// this function has no checks so the check must be done within player or game
	this.hotelsOwned++;
	currentRent = this.rentWithHotel;
    }
    
    
    
    
    
}
