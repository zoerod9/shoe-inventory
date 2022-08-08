package model;

public class Shoes {
	//Variables that will hold the information about the shoes 
	private String size;
    private String price;
    private String barcode;
    private String color;
    private String model;
    private int stock;
    private String imageURL;
    
    /*
     * Shoes constructor method with an imageURL included this will set all the variables to the passed in
     * values.
     * Parameters:
     * String size: shoe size of the shoe
     * String price: price of the shoe
     * String barcode: barcode of the shoe
     * String color: color of the shoe
     * String model: model of the shoe
     * int stock: stock of the shoe
     * String imageURL: imageURL of the shoe
     * Returns:
     * No return is constructor
     */
    public Shoes(String size, String price, String barcode, String color, String model, int stock, String imageURL) {
    	this.size = size;
    	this.price = price;
    	this.barcode = barcode;
    	this.color = color;
    	this.model = model;
    	this.stock = stock;
    	this.imageURL = imageURL;
    }
    
    /*
     * Shoes constructor method without an imageURL included this will set all the variables to the passed in
     * values.
     * Parameters:
     * String size: shoe size of the shoe
     * String price: price of the shoe
     * String barcode: barcode of the shoe
     * String color: color of the shoe
     * String model: model of the shoe
     * int stock: stock of the shoe
     * Returns:
     * No return is constructor
     */
    public Shoes(String size, String price, String barcode, String color, String model, int stock) {
    	this.size = size;
    	this.price = price;
    	this.barcode = barcode;
    	this.color = color;
    	this.model = model;
    	this.stock = stock;
    	this.imageURL = "NOTFOUND";
    }

    /*
     * Shoes copy constructor with a passed in shoe
     * Parameters:
     * Shoes temp: The shoe who's values are used to fill this new Shoes
     * Returns:
     * No return is constructor
     */
    public Shoes(Shoes temp) {
        this.size = temp.size;
        this.price = temp.price;
        this.barcode = temp.barcode;
    	this.color = temp.color;
    	this.model = temp.model;
    	this.stock = temp.stock;
    	this.imageURL = temp.imageURL;
    }
    
    /*
     * getSize will return the size of this shoe.
     * Parameters:
     * None
     * Returns:
     * A String representing the size of the shoe.
     */
	public String getSize() {
		return size;
	}

	/*
     * setSize will update the size of this shoe with the given size.
     * Parameters:
     * String size: The size that the size of this shoe will be updated to.
     * Returns:
     * No returns
     */
	public void setSize(String size) {
		this.size = size;
	}

	/*
     * getPrice will return the price of this shoe.
     * Parameters:
     * None
     * Returns:
     * A String representing the price of the shoe.
     */
	public String getPrice() {
		return price;
	}

	/*
     * setPrice will update the price of this shoe with the given price.
     * Parameters:
     * String price: The price that the price of this shoe will be updated to.
     * Returns:
     * No returns
     */
	public void setPrice(String price) {
		this.price = price;
	}

	/*
     * getBarcode will return the barcode of this shoe.
     * Parameters:
     * None
     * Returns:
     * A String representing the barcode of the shoe.
     */
	public String getBarcode() {
		return barcode;
	}

	/*
     * setBarcode will update the barcode of this shoe with the given barcode.
     * Parameters:
     * String barcode: The barcode that the barcode of this shoe will be updated to.
     * Returns:
     * No returns
     */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/*
     * getColor will return the color of this shoe.
     * Parameters:
     * None
     * Returns:
     * A String representing the color of the shoe.
     */
	public String getColor() {
		return color;
	}

	/*
     * setColor will update the color of this shoe with the given color.
     * Parameters:
     * String color: The color that the color of this shoe will be updated to.
     * Returns:
     * No returns
     */
	public void setColor(String color) {
		this.color = color;
	}

	/*
     * getModel will return the model of this shoe.
     * Parameters:
     * None
     * Returns:
     * A String representing the model of the shoe.
     */
	public String getModel() {
		return model;
	}

	/*
     * setModel will update the model of this shoe with the given model.
     * Parameters:
     * String model: The model that the model of this shoe will be updated to.
     * Returns:
     * No returns
     */
	public void setModel(String model) {
		this.model = model;
	}

	/*
     * getStock will return the stock of this shoe.
     * Parameters:
     * None
     * Returns:
     * An int representing the stock of the shoe.
     */
	public int getStock() {
		return stock;
	}

	/*
     * setStock will update the stock of this shoe with the given stock.
     * Parameters:
     * int stock: The stock that the stock of this shoe will be updated to.
     * Returns:
     * No returns
     */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/*
     * getImageURL will return the imageURL of this shoe.
     * Parameters:
     * None
     * Returns:
     * A String representing the imageURL of the shoe.
     */
	public String getImageURL() {
		return imageURL;
	}

	/*
     * setImageURL will update the imageURL of this shoe with the given imageURL.
     * Parameters:
     * String imageURL: The imageURL that the imageURL of this shoe will be updated to.
     * Returns:
     * No returns
     */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/*
     * toString will return a string representation of the Shoes class
     * Parameters:
     * None
     * Returns:
     * A String representing the Shoes class with its variables.
     */
	@Override
	public String toString() {
		return "\nSize = " + size + " Price = " + price + " Barcode = " + barcode + " Color = " + color + "\nModel = "
				+ model + " Stock = " + stock + " ImageURL = " + imageURL + "\n";
	}


     	/*
     * equals will return a boolean representing if the given object is equal to this object
     * Parameters: 
     * Object obj
     * Returns:
     * true if they are equal
     */
	@Override
     public boolean equals(Object obj) {
		if (obj instanceof Shoes){
               Shoes shoes =  (Shoes) obj;
               if (
                    shoes.getBarcode().equals(this.getBarcode()) 
                    && shoes.getColor().equals(this.getColor())
                    && shoes.getImageURL().equals(this.getImageURL())
                    && shoes.getModel().equals(this.getModel())
                    && shoes.getPrice().equals(this.getPrice())
                    && shoes.getSize().equals(this.getSize())
                    && shoes.getStock() == this.getStock()
                    ){
                         return true;
                    }
          }

          return false;
	}

     
	
}
