/**
 * 
 * Meat class is a subclass of base class GroceryItem, has setters/getters, overrided toString method, and overloaded constructors to create a meat object
 * 
 * @author Benny Chen
 * @section CSS 143B
 * @version 12-3-18
 */

public class Meat extends GroceryItem{

	private boolean isGround;
	
	/**
	 * Constructor takes in 4 params and initializes all 4 using base class constructor
	 * @param name of meat
	 * @param quantity of meat
	 * @param price of meat
	 * @param isGround set to false on default
	 */
	public Meat(String name, int quantity, double price, boolean isGround){
		
		super(name, quantity, price);
		this.isGround(DEFAULT_FALSE);
		
	}
	
	/**
	 * Overloaded constructor that takes 2 params and initializes 2 using super, and sets price to default
	 * @param name of meat
	 * @param quantity of meat
	 */
	public Meat(String name, int quantity){
		
		super(name, quantity, DEFAULT_PRICE);
		this.isGround(DEFAULT_FALSE);
		
	}
	
	/**
	 * Overloaded constructor
	 * Splits input line from text file and add each meat detail into a separate array index
	 * @param inputLine next line from text file
	 */
	public Meat(String inputLine){
		
        String[] input = inputLine.split(" ");
        String meat = input[0]; //MEAT
        this.setName(input[1]);
        this.setQuantity(Integer.valueOf(input[2]));
        this.setPrice(Double.valueOf(input[3]));
        this.isGround(Boolean.valueOf(input[4]));
		
	}
	
	/**
	 * Setter for isGround
	 * @param ground true or false
	 */
	public void isGround(boolean ground){
		
		this.isGround = ground;
		
	}

	/**
	 * Getter for isGround
	 * @return isGround true or false
	 */
	public boolean getIsGround(){
		
		return this.isGround;
		
	}
	
	/**
	 * Overrided method that returns a string of the details of meat
	 * @return String of meat details
	 */
	@Override
	public String toString(){
		
		String retVal = String.format("Name: %-18s Quantity:  %2d   Price: $%.2f \t   isGround:   \t %s"
				, getName() ,getQuantity(),getPrice(), isGround);
		
	    return retVal;
		
	}
}