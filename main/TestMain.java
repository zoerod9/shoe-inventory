package main;

import java.io.FileNotFoundException;
import java.util.List;

import model.Shoes;
import utilities.Csv;

public class TestMain  {

	/*
	 * Testing main method of the program will run and start the program and will test method
	 * by printing out information.
	 * Parameters: 
	 * String[] args: The arguments given to the program while compiling and running.
	 * Returns:
	 * No return
	 */
    public static void main(String[] args) throws FileNotFoundException {

        List<Shoes> shoes = Csv.getShoesFromCsv();

        for (Shoes shoe : shoes){
            System.out.println("shoe data");
            System.out.println(shoe);
        }
        
    }
}