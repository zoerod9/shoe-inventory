package model;

public class Shoes {
	private String size;
    private String price;
    private String barcode;
    private String color;
    private String model;
    private int stock;
    private String imageURL;
    
    public Shoes(String size, String price, String barcode, String color, String model, int stock, String imageURL) {
    	this.size = size;
    	this.price = price;
    	this.barcode = barcode;
    	this.color = color;
    	this.model = model;
    	this.stock = stock;
    	this.imageURL = imageURL;
    }
    
    public Shoes(String size, String price, String barcode, String color, String model, int stock) {
    	this.size = size;
    	this.price = price;
    	this.barcode = barcode;
    	this.color = color;
    	this.model = model;
    	this.stock = stock;
    	this.imageURL = "NOTFOUND";
    }

    public Shoes(Shoes temp) {
        this.size = temp.size;
        this.barcode = temp.barcode;
    	this.color = temp.color;
    	this.model = temp.model;
    	this.stock = temp.stock;
    	this.imageURL = temp.imageURL;
    }
    
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Size = " + size + "\nPrice = " + price + "\nBarcode = " + barcode + "\nColor = " + color + "\nModel = "
				+ model + "\nStock = " + stock + "\nImageURL = " + imageURL;
	}
	
}
