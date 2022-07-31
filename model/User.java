package model;

import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    public ArrayList<Shoes> inventory;
    private ArrayList<Shoes> cart;
    private Shoes current;
    
    public User(String userName, String password) {
    	this.userName = userName;
    	this.password = password;
    	inventory = new ArrayList<Shoes>();
    	cart = new ArrayList<Shoes>();
    }
    
    public User getCurrentUser() {
    	return this;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Shoes> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Shoes> inventory) {
		this.inventory = inventory;
	}

	public Shoes getCurrent() {
		return current;
	}

	public void setCurrent(Shoes current) {
		this.current = current;
	}

	public ArrayList<Shoes> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Shoes> cart) {
		this.cart = cart;
	}
    
    public void addToCart(Shoes toAdd) {
    	if(toAdd.getStock() <= 0) {
    		return;
    	}
    	if(cart.size() == 0) {
    		Shoes temp = toAdd;
    		temp.setStock(1);
    		cart.add(temp);
    		toAdd.setStock(toAdd.getStock()-1);
    	}
    	for(int i = 0; i < cart.size(); i++) {
    		if(toAdd.getBarcode().equals(cart.get(i).getBarcode())) {
    			cart.get(i).setStock(cart.get(i).getStock() + toAdd.getStock());
    		}
    		else if(i == cart.size()-1) {
    			Shoes temp = toAdd;
    			temp.setStock(1);
    			cart.add(temp);
    			toAdd.setStock(toAdd.getStock()-1);
    		}
    	}
    }
    
    public void addToInventory(Shoes toAdd) {
    	if(inventory.size() == 0) {
    		inventory.add(toAdd);
    		return;
    	}
    	for(int i = 0; i < inventory.size(); i++) {
    		if(toAdd.getBarcode().equals(inventory.get(i).getBarcode())) {
    			inventory.get(i).setStock(inventory.get(i).getStock() + toAdd.getStock());
    		}
    		else if(i == inventory.size()-1) {
    			inventory.add(toAdd);
    		}
    	}
    }

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", inventory=" + inventory + ", cart=" + cart
				+ ", current=" + current + "]";
	}
}