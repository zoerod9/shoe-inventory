package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Shoes;

public class Csv {

	/*
	 * getShoesFromCSV will read in shoes from the specific data file and will then
	 * put them in an ArrayList of shoes and return that ArrayList
	 * Parameters:
	 * None but data/shoes.csv must exist
	 * Returns:
	 * An ArrayList of Shoes that are taken from the CSV file.
	 */
    public static ArrayList<Shoes> getShoesFromCsv() throws FileNotFoundException {
        ArrayList<Shoes> shoes = new ArrayList<>();
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

    /*
	 * getShoesToCheckInFromCSV will read in shoes from the specific data file and will then
	 * put them in an ArrayList of shoes and return that ArrayList of shoes to checkIn
	 * Parameters:
	 * None but data/shoesToCheckIn.csv must exist
	 * Returns:
	 * An ArrayList of Shoes that are taken from the CSV file that need to be checked in still.
	 */
    public static ArrayList<Shoes> getShoesToCheckInFromCsv() throws FileNotFoundException {
        ArrayList<Shoes> shoes = new ArrayList<>();
        File file = new File("data/shoesToCheckIn.csv");
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

    public static void checkInShoes(Shoes selectedShoes) {
        // this will delete whatever shoe is passed from shoestocheckin.csv
        // it will also write whatever shoe is passed to shoes.csv
        // another baeldung
        // https://www.baeldung.com/java-delete-file-contents

        // from baeldung:
        // @Test
        // public void whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo() 
        // throws IOException {
        //     String str = "World";
        //     BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        //     writer.append(' ');
        //     writer.append(str);
            
        //     writer.close();
        // }
    }
}
