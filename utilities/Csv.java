package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Shoes;

public class Csv {


    public static void addShoesInCsv(Shoes shoeToAdd){
        // this will add a pair of shoes (single pair) to the list of orders
    }

    public static ArrayList<Shoes> getShoesFromCsv() throws FileNotFoundException {
        ArrayList<Shoes> shoes = new ArrayList();
        File file = new File("data/shoes.csv");
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String line = scan.next();

            String[] prospectShoes = line.split(",");
            
            Shoes newShoes = new Shoes(prospectShoes[0], prospectShoes[1], prospectShoes[2], prospectShoes[3],
                    prospectShoes[4],
                    Integer.parseInt(prospectShoes[5]),
                    prospectShoes[6]);
            shoes.add(newShoes);
        }
        scan.close();

        return shoes;
    }
}
