public class PayPerBuildingCard extends Card{
    
    private String text;
    private int housePrice;
    private int hotelPrice;
    
    
    public PayPerBuildingCard (int housePrice,int hotelPrice,String text){
	this.text = text; //text
	this.hotelPrice = hotelPrice; //price of each hotel
	this.housePrice = housePrice; // price of each house
    }
    
    public void execute (Player p){
	p.takeMoney(((p.getHouses()*housePrice)+(p.getHotels()*hotelPrice))); //calculate total value owed
    }
    public String printText(){ //print text
	return this.text;
    }
}
