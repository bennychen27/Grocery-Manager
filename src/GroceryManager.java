/*
* CSS 143 Final Assignment: Grocery Manager
* Instructor: Lesley Kalmin
*
*
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GroceryManager {

	private ArrayList<GroceryItem> inventory = new ArrayList<GroceryItem>();
	private HashSet<String> reorderList = new HashSet<>();

	/**
	 * Method that subtracts the items and quantities in the order from the inventory. If inventory hit 0, add to reorder list. If quantity ordered is greater than quantity in inventory,
	 * throw an error with message. If item in order is not in inventory, also throw an error and continue
	 * @param order list of orders
	 * @throws GroceryException exception
	 */
	public void processOrder(GroceryOrder order) throws GroceryException{
		
        sortByName();
        
        //loop through each item in order list
        for (Object item : order){
        	
             GroceryItem temp = (GroceryItem) item;

             GroceryItem inven = findItemByName(temp.getName());
             
             //if item is in inventory
             if(inven != null) {
            
            	 //if inventory quantity - item of order quantity is > 0, subtract
                 if(inven.getQuantity() - temp.getQuantity() >= 0){
                	 
                     inven.setQuantity(inven.getQuantity() - temp.getQuantity());
                     
                 }
                 else{
                	 
                	 //set inventory quantity of item to 0, add to reorder list and throw exception
                     inven.setQuantity(0);
                     reorderList.add(inven.getName());
                     throw new GroceryException("Out of " + inven.getName());
                     
                }
            }
            else{
            	
            	//not in inventory
                throw new GroceryException(temp.getName() + " not found in inventory");
                
            }
        }
	}
	
	/**
	 * Method that loops through each item in inventory and if name matches, return a clone of the grocery item
	 * @param name of grocery item
	 * @return GroceryItem grocery item, else null
	 */
	public GroceryItem findItemByName(String name){
		
		for(GroceryItem item : inventory){
			
			    if(item.getName().equals(name)){
			    	
			    	return (GroceryItem) item.clone();
			    
			    }
		}
		
		return null;
		
	}
	
	/**
	 * Helper function swap is used to compare two grocery items in inventory
	 * @param inven inventory
	 * @param min min of inventory
	 * @return min element in alphabetical order of inventory
	 */
    public int swap(ArrayList<GroceryItem> inven, int min) {

        for(int i = min; i < inventory.size(); i++){
        	
            if(inven.get(min).getName().compareTo(inven.get(i).getName()) > 0) {
                min = i;
            }
        }
        return min;
    }
	
    /**
     * Method that uses selection sort and compareTo to sort items in inventory by alphabetical order, uses helper function swap
     */
	public void sortByName(){

        int min = 0;

        //iterate through inventory
        for (int i = 0; i < inventory.size(); i++) {
        	
        	//using helper function swap, create helper function temp and switch temp with min
            min = swap(inventory, i);
            GroceryItem temp = inventory.get(i);
            inventory.set(i, inventory.get(min));
            inventory.set(min, temp);
        }

	}
	
	/**
	 * Method that sorts all grocery items in inventory by price, using bubble sort
	 */
	public void sortByPrice(){

		//Nested for loop
        for (int i = 0; i < inventory.size() - 1; i++){

            for (int j = 0; j < inventory.size() - i - 1; j++){
            	
            	//If j's price is greater than j+1's price, then create temp variable to hold j's price and swap with j+1
                if (inventory.get(j).getPrice() > inventory.get(j + 1).getPrice()){  //check to see if value needs to be swapped
                	
                    GroceryItem temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);

                }
            }
        }
		
	}
	
    /**
     * Prints out to console list of products in inventory
     */
	public void displayInventory(){
		
		for(int i = 0; i < inventory.size(); i++){
			
			
			System.out.println(inventory.get(i));
			
		}
	}
	
	/**
	 * Return hashset list of products that need to be reordered
	 * @return String list of products needed to be reordered
	 */
	public String getReorderList(){
		
		String retVal = "";

        for (String item: reorderList){
        	
             retVal+= item + "\n";

        }
	
		return retVal;
		
	}
	
	/**
	 * Reads each product in text file and add to inventory arraylist
	 * @throws FileNotFoundException throw exception if file specified not found
	 */
	public void readInventory() throws FileNotFoundException {
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream("groceryInventory.txt"));
			String qline = input.nextLine();
			String[] qparts = qline.split(" ");
			int nDairy = Integer.parseInt(qparts[0]);
			int nProduce = Integer.parseInt(qparts[1]);

			int i = 0;
			
			while (input.hasNext()) {
				String line = input.nextLine();

				if (i++ < nDairy) {
					inventory.add(new Dairy(line));
				} else if (i++ < nProduce + nDairy) {
					inventory.add(new Produce(line));
				} else {
					inventory.add(new Meat(line));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			input.close();
		}
	}

	
}
