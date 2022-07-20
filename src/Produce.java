/**
 * 
 * Produce class is a subclass of base class GroceryItem, has setter/getter, overrides toString method, and has many constructors to create a produce object
 * 
 * @author Benny Chen
 * @section CSS 143B
 * @version 12-3-18
 *
 */

public class Produce extends GroceryItem{

	private boolean isOrganic;
	
	/**
	 * Constructor takes in 4 params and initializes all 4 using base class constructor
	 * @param name of produce
	 * @param quantity of produce
	 * @param price of produce
	 * @param isOrganic set to false on default
	 */
	public Produce(String name, int quantity, double price, boolean isOrganic){
		
		super(name, quantity, price);
		this.isOrganic(DEFAULT_FALSE);
		
	}
	
	/**
	 * Overloaded constructor to take in produce name/quantity with no pricing
	 * @param name of produce
	 * @param quantity of produce
	 */
	public Produce(String name, int quantity){
		
		super(name, quantity, DEFAULT_PRICE);
		this.isOrganic(DEFAULT_FALSE);
		
	}
	
	/**
	 * Overloaded constructor
	 * Splits input line from text file and add each produce detail into a separate array index
	 * @param inputLine next line from text file
	 */
	public Produce(String inputLine){
		
        String[] input = inputLine.split(" ");
        String produce = input[0]; //PRODUCE
        this.setName(input[1]);
        this.setQuantity(Integer.valueOf(input[2]));
        this.setPrice(Double.valueOf(input[3]));
        this.isOrganic(Boolean.valueOf(input[4]));

	}
	
	/**
	 * Setter for isOrganic
	 * @param organic
	 */
	public void isOrganic(boolean organic){
		
		this.isOrganic = organic;
		
	}
	
	/**
	 * Getter for isOrganic
	 * @return boolean true or false if produce is organic
	 */
	public boolean getIsOrganic(){
		
		return this.isOrganic;
		
	}
	
	/**
	 * Overrided method that returns a string of the details of produce
	 * @return String of produce details
	 */
	@Override
	public String toString(){
		
		String retVal = String.format("Name: %-18s Quantity:  %2d   Price: $%.2f \t   Organic:   \t %s"
				, getName() ,getQuantity(),getPrice(), isOrganic);
		
	    return retVal;
		
	}
}