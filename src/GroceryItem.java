/**
 * 
 * GroceryItem class is used to store items, implements comparable, has setters/getters, toString as well as clone and compareTo methods
 * 
 * @author Benny Chen
 * @section CSS 143B
 * @version 12-3-18
 *
 */

public class GroceryItem implements Comparable{

	private String name;
	private int quantity;
	private double price;
	public static final int DEFAULT_QUANTITY = 0;
	public static final double DEFAULT_PRICE = 0.00;
	public static final boolean DEFAULT_FALSE = false;
	
	/**
	 * Constructor that takes 3 params and initializes them
	 * @param name of grocery item
	 * @param quantity of grocery item
	 * @param price of grocery item
	 */
	public GroceryItem(String name, int quantity, double price){
		
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		
	}
	
	/**
	 * Overloaded constructor that sets name, quantity, and price of grocery item to default
	 */
	public GroceryItem(){
		
		this.name = "";
		this.quantity = DEFAULT_QUANTITY;
		this.price = DEFAULT_PRICE;
		
	}
	
	/**
	 * Setter for name of grocery item
	 * @param name of grocery item
	 */
	public void setName(String name){
		
		this.name = name;
		
	}
	
	/**
	 * Getter for name of grocery item
	 * @return name of grocery item
	 */
	public String getName(){
		
		return this.name;
		
	}
	
	/**
	 * Setter for price of grocery item
	 * @param price of grocery item
	 */
	public void setPrice(double price){
		
		this.price = price;
		
	}
	
	/**
	 * Getter for price of grocery item
	 * @return price of grocery item
	 */
	public double getPrice(){
		
		return this.price;
		
	}
	
	/**
	 * Setter for quantity of grocery item
	 * @param quantity of grocery item
	 */
	public void setQuantity(int quantity){
		
		this.quantity = quantity;
		
	}
	
	/**
	 * Getter for quantity of grocery item
	 * @return quantity of grocery item
	 */
	public int getQuantity(){
		
		return this.quantity;
		
	}
	
	/**
	 * Overrided toString method that returns name, quantity and price of grocery item
	 * @return String details of grocery item
	 */
	@Override
	public String toString(){
		
		return "Name: " + this.name + " Quantity: " + this.quantity + " Price: $ " + this.price;
		
	}
	
	/**
	 * Overrided compareTo method to compare 2 groceryItem object's names
	 * @param -1, 0, 1 depending on if equal or not
	 */
	@Override
	public int compareTo(Object o){
			
		GroceryItem other = (GroceryItem) o;
		
		if(this.name.compareTo(other.name) == 0){
			
			return 0;
			
		}
		
		else if(this.name.compareTo(other.name) > 0){
			
			return 1;
			
		}
		else{
			
			return -1;
			
		}
	}
	
	/**
	 * Overrided clone method to clone groceryItem object
	 * @return Object groceryItem object
	 */
    @Override
    public Object clone(){
    	
        return new GroceryItem(this.name, this.quantity, this.price);
        
    }
}