/**
 * 
 * GroceryException class extends from base class Exception and has overloaded constructor taking message as param and calling super to print it out
 * 
 * @author Benny Chen
 * @section CSS 143B
 * @version 12-3-18
 */
public class GroceryException extends Exception{

	/**
	 * Calling exception class constructor and prints out message
	 * @param message exception message
	 */
	public GroceryException(String message){
		
		super(message);
		
	}
	
	/**
	 * Default no arg constructor calling base class super
	 */
	public GroceryException(){
		
		super();
		
	}
	
}
