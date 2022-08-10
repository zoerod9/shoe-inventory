package model;

/**
 * Shoes is a class that contains information for a Shoes object that will store the information of shoes
 * read from the csv files. This class contains all needed methods for a Shoe to be properly stored.
 * 
 * @authors Zoe Rodriguez (vcd011), Enrique Mata (rre165), William El Haber (csn639)
 * UTSA CS 3443 - shoe-inventory Team Project
 * Summer 2022
 */

public class Shoes {
     // Variables that will hold the information about the shoes
     private String size;
     private String price;
     private String barcode;
     private String color;
     private String model;
     private int stock;
     private String imageURL;

     /*
      * Shoes constructor method with an imageURL included this will set all the
      * variables to the passed in values.
      * @param size: shoe size of the shoe
      * @param price: price of the shoe
      * @param barcode: barcode of the shoe
      * @param color: color of the shoe
      * @param model: model of the shoe
      * @param stock: stock of the shoe
      * @param imageURL: imageURL of the shoe
      * @return No return is constructor
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
      * Shoes constructor method without an imageURL included this will set all the
      * variables to the passed in values.
      * @param size: shoe size of the shoe
      * @param price: price of the shoe
      * @param barcode: barcode of the shoe
      * @param color: color of the shoe
      * @param model: model of the shoe
      * @param stock: stock of the shoe
      * @return No return is constructor
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
      * @param temp: The shoe who's values are used to fill this new Shoes
      * @return No return is constructor
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
      * @param None
      * @return A String representing the size of the shoe.
      */
     public String getSize() {
          return size;
     }

     /*
      * setSize will update the size of this shoe with the given size.
      * @param size: The size that the size of this shoe will be updated to.
      * @return No returns
      */
     public void setSize(String size) {
          this.size = size;
     }

     /*
      * getPrice will return the price of this shoe.
      * @param None
      * @return A String representing the price of the shoe.
      */
     public String getPrice() {
          return price;
     }

     /*
      * setPrice will update the price of this shoe with the given price.
      * @param price: The price that the price of this shoe will be updated to.
      * @return No returns
      */
     public void setPrice(String price) {
          this.price = price;
     }

     /*
      * getBarcode will return the barcode of this shoe.
      * @param None
      * @return A String representing the barcode of the shoe.
      */
     public String getBarcode() {
          return barcode;
     }

     /*
      * setBarcode will update the barcode of this shoe with the given barcode.
      * @param barcode: The barcode that the barcode of this shoe will be updated to.
      * @return No returns
      */
     public void setBarcode(String barcode) {
          this.barcode = barcode;
     }

     /*
      * getColor will return the color of this shoe.
      * @param None
      * @return A String representing the color of the shoe.
      */
     public String getColor() {
          return color;
     }

     /*
      * setColor will update the color of this shoe with the given color.
      * @param color: The color that the color of this shoe will be updated to.
      * @return No returns
      */
     public void setColor(String color) {
          this.color = color;
     }

     /*
      * getModel will return the model of this shoe.
      * @param None
      * @return A String representing the model of the shoe.
      */
     public String getModel() {
          return model;
     }

     /*
      * setModel will update the model of this shoe with the given model.
      * @param model: The model that the model of this shoe will be updated to.
      * @return No returns
      */
     public void setModel(String model) {
          this.model = model;
     }

     /*
      * getStock will return the stock of this shoe.
      * @param None
      * @return An int representing the stock of the shoe.
      */
     public int getStock() {
          return stock;
     }

     /*
      * setStock will update the stock of this shoe with the given stock.
      * @param stock: The stock that the stock of this shoe will be updated to.
      * @return No returns
      */
     public void setStock(int stock) {
          this.stock = stock;
     }

     /*
      * getImageURL will return the imageURL of this shoe.
      * @param None 
      * @return A String representing the imageURL of the shoe.
      */
     public String getImageURL() {
          return imageURL;
     }

     /*
      * setImageURL will update the imageURL of this shoe with the given imageURL.
      * @param imageURL: The imageURL that the imageURL of this shoe will be updated to.
      * @return No returns
      */
     public void setImageURL(String imageURL) {
          this.imageURL = imageURL;
     }

     /*
      * toString will return a string representation of the Shoes class
      * @param None
      * @return A String representing the Shoes class with its variables.
      */
     @Override
     public String toString() {
          return "\nSize = " + size + ", Price = " + price + ", Barcode = " + barcode + ", Color = " + color + "\nModel = "
                    + model + ", Stock = " + stock + "\n";
     }

     /*
      * equals will return a boolean representing if the given object is equal to this object
      * @param obj the object to compare too
      * @return true if they are equal false if they are not
      */
     @Override
     public boolean equals(Object obj) {
          if (obj instanceof Shoes) {
               Shoes shoes = (Shoes) obj;
               if (shoes.getBarcode().equals(this.getBarcode())
                         && shoes.getColor().equals(this.getColor())
                         && shoes.getImageURL().equals(this.getImageURL())
                         && shoes.getModel().equals(this.getModel())
                         && shoes.getPrice().equals(this.getPrice())
                         && shoes.getSize().equals(this.getSize())
                         && shoes.getStock() == this.getStock()) {
                    return true;
               }
          }

          return false;
     }

}
