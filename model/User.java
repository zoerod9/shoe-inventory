package model;

import java.util.ArrayList;

public class User {
	
	//Variables that will hold the information about the User
    private String userName;
    private String password;
    public ArrayList<Shoes> inventory;
    private ArrayList<Shoes> cart;
    private Shoes current;
    
    /*
     * User constructor method with a userName and password passed in
     * Parameters:
     * String userName: This is the userName of the current user
     * String password: This is the password of the current user
     * Returns:
     * No return is constructor
     */
    public User(String userName, String password) {
    	//Sets username and password and creates the inventory and cart ArrayLists
    	this.userName = userName;
    	this.password = password;
    	inventory = new ArrayList<Shoes>();
    	cart = new ArrayList<Shoes>();
    }
    
    /*
     * getCurrentUser returns the current user which is this
     * Parameters:
     * None
     * Returns:
     * A User representing the current user which is this
     */
    public User getCurrentUser() {
    	return this;
    }

    /*
     * getUserName returns the userName of this User
     * Parameters:
     * None
     * Returns:
     * A String representing the User's userName
     */
	public String getUserName() {
		return userName;
	}

	/*
     * setUserName sets the User's userName to the passed in String
     * Parameters:
     * String userName: The String to change this.userName to.
     * Returns:
     * No Returns
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
     * getPassword returns the password of this User
     * Parameters:
     * None
     * Returns:
     * A String representing the User's password
     */
	public String getPassword() {
		return password;
	}

	/*
     * setPassword sets the User's password to the passed in String
     * Parameters:
     * String password: The String to change this.password to.
     * Returns:
     * No Returns
     */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
     * getInventory returns the Inventory of this User
     * Parameters:
     * None
     * Returns:
     * An ArrayList of shoes that represents the inventory of this User.
     */
	public ArrayList<Shoes> getInventory() {
		return inventory;
	}

	/*
     * setInventory sets the User's inventory to the passed in ArrayList
     * Parameters:
     * ArrayList<Shoes> inventory: The ArrayList to set the inventory to.
     * Returns:
     * No Returns
     */
	public void setInventory(ArrayList<Shoes> inventory) {
		this.inventory = inventory;
	}

	/*
     * getCurrent returns the current shoe of this User
     * Parameters:
     * None
     * Returns:
     * A Shoes object representing the current shoe of this User
     */
	public Shoes getCurrent() {
		return current;
	}

	/*
     * setCurrent sets the User's current Shoes to the passed in Shoes object
     * Parameters:
     * Shoes Current: The Shoes to change this.current to.
     * Returns:
     * No Returns
     */
	public void setCurrent(Shoes current) {
		this.current = current;
	}

	/*
     * getCart returns the cart of this User
     * Parameters:
     * None
     * Returns:
     * An ArrayList of shoes that represents the cart of this User.
     */
	public ArrayList<Shoes> getCart() {
		return cart;
	}

	/*
     * setCart sets the User's cart to the passed in ArrayList
     * Parameters:
     * ArrayList<Shoes> cart: The ArrayList to set the inventory to.
     * Returns:
     * No Returns
     */
	public void setCart(ArrayList<Shoes> cart) {
		this.cart = cart;
	}
    
	/*
	 * addToCart will take in a Shoes object and will add that Shoes to the User's cart.
	 * Parameters:
	 * Shoes toAdd: The shoes to be added to the cart
	 * Returns:
	 * No Returns
	 */
    public void addToCart(Shoes toAdd) {
    	//If the stock is less than or equal to 0 than is should return and not run
    	if(toAdd.getStock() <= 0) {
    		return;
    	}
    	//If this is the first item in the cart you would immediately add the shoes to the cart
    	if(cart.size() == 0) {
    		Shoes temp = new Shoes(toAdd);
    		temp.setStock(1);
    		cart.add(temp);
    		return;
    	}
    	//Checks to see if this shoe is already in the cart in which case it will update the stock instead
    	//    of adding multiple cases of one shoe.
    	for(int i = 0; i < cart.size(); i++) {
    		if(toAdd.getBarcode().equals(cart.get(i).getBarcode())) {
    			cart.get(i).setStock(cart.get(i).getStock() + 1);
    		}
    		else if(i == cart.size()-1) {
    			Shoes temp = new Shoes(toAdd);
    			temp.setStock(1);
    			cart.add(temp);
    			return;
    		}
    	}
    }
    
    /*
     * addToInventory will add the given shoe to the User's inventory
     * Parameters:
     * Shoes toAdd: The shoes to add to the user's inventory
     * Returns:
     * No Returns
     */
    public void addToInventory(Shoes toAdd) {
    	//If inventory is empty add the shoe immediately and return.
    	if(inventory.size() == 0) {
    		inventory.add(toAdd);
    		return;
    	}
    	//Otherwise will check to see if it is already in the inventory and if so will update stock
    	//    else it will add the shoe to the inventory normally.
    	for(int i = 0; i < inventory.size(); i++) {
    		if(toAdd.getBarcode().equals(inventory.get(i).getBarcode())) {
    			inventory.get(i).setStock(inventory.get(i).getStock() + toAdd.getStock());
    		}
    		else if(i == inventory.size()-1) {
    			inventory.add(toAdd);
    		}
    	}
    }

    /*
     * toString will return a string representation of the User class
     * Parameters:
     * None
     * Returns:
     * A String representing the User class with its variables.
     */
	@Override
	public String toString() {
		return "User = " + userName + "\nPassword = " + password + "\nInventory = " + inventory + "\nCart = " + cart
				+ "\nCurrent = " + current;
	}
}