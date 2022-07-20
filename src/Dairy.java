/**
 * 
 * Dairy class is a subclass of base class GroceryItem, has setter/getter, overrides toString method, and has many constructors to create a dairy object
 * 
 * @author Benny Chen
 * @section CSS 143B
 * @version 12-3-18
 *
 */

public class Dairy extends GroceryItem{

	private int refrigerationTemperature;
	public static final int DEFAULT_TEMP = 34;
	
	/**
	 * Constructor takes in 4 params and initializes all 4 using base class constructor
	 * @param name of dairy
	 * @param quantity of dairy
	 * @param price of dairy
	 * @param refrigerationTemperature set to 34 on default
	 */
	public Dairy(String name, int quantity, double price, int refrigerationTemperature){
		
		super(name, quantity, price);
		setRefrigerationTemperature(refrigerationTemperature);
		
	}
	
	/**
	 * Overloaded constructor to take in dairy name/quantity with no pricing
	 * @param name of dairy
	 * @param quantity of dairy
	 */
	public Dairy(String name, int quantity){
		
		super(name, quantity, DEFAULT_PRICE);
		setRefrigerationTemperature(DEFAULT_TEMP);
		
	}
	
	/**
	 * Overloaded constructor
	 * Splits input line from text file and add each dairy detail into a separate array index
	 * @param inputLine next line from text file
	 */
	public Dairy(String inputLine){
		
        String[] input = inputLine.split(" ");
        String produce = input[0]; //PRODUCE
        this.setName(input[1]);
        this.setQuantity(Integer.valueOf(input[2]));
        this.setPrice(Double.valueOf(input[3]));
        this.setRefrigerationTemperature(Integer.valueOf(input[4]));
		
	}
	
	/**
	 * Setter for refrigerationTemperature
	 * @param temp temp of dairy product
	 */
	public void setRefrigerationTemperature(int temp){
		
		this.refrigerationTemperature = temp;
		
	}
	
	/**
	 * Getter for refrigerationTemperature
	 * @return temperature of dairy product
	 */
	public int getRefrigerationTemperature(){
		
		return this.refrigerationTemperature;
		
	}
	
	/**
	 * Overrided method that returns a string of the details of dairy
	 * @return String of dairy details
	 */
	@Override
	public String toString(){
		
		String retVal = String.format("Name: %-18s Quantity:  %2d   Price: $%.2f \t   Temperature:\t %s"
				, getName() ,getQuantity(),getPrice(), getRefrigerationTemperature());
		
	    return retVal;
		
	}	
}