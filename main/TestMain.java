package main;

import java.io.FileNotFoundException;
import java.util.List;

import model.Shoes;
import utilities.Csv;

public class TestMain  {

    public static void main(String[] args) throws FileNotFoundException {

        List<Shoes> shoes = Csv.getShoesFromCsv();

        for (Shoes shoe : shoes){
            System.out.println("shoe data");
            System.out.println(shoe);
        }
        
    }
}