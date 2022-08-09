package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Csv is a class that contains information for a Csv object that contains methods to read and write from
 * the data shoes csv and data shoes to check in csv. These will then be used by other classes to get
 * the information from the data.
 * 
 * @authors Zoe Rodriguez (), Enrique Mata (rre165), William El Haber (csn639)
 * UTSA CS 3443 - shoe-inventory Team Project
 * Summer 2022  
 */

public class Csv {

    private final static String comma = ",";
    private final static String newLine = "\n";

    /*
     * getShoesFromCSV will read in shoes from the specific data file and will then
     * put them in an ArrayList of shoes and return that ArrayList
     * @param None but data/shoes.csv must exist
     * @return An ArrayList of Shoes that are taken from the CSV file.
     */
    public static ArrayList<Shoes> getShoesFromCsv() throws FileNotFoundException {
        ArrayList<Shoes> shoes = new ArrayList<>();
        File file = new File("src/shoes.csv");
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
     * getShoesToCheckInFromCSV will read in shoes from the specific data file and
     * will then put them in an ArrayList of shoes and return that ArrayList of shoes to checkIn
     * @param None but data/shoesToCheckIn.csv must exist
     * @return An ArrayList of Shoes that are taken from the CSV file that need to be
     * checked in still.
     */
    public static ArrayList<Shoes> getShoesToCheckInFromCsv() throws FileNotFoundException {
        ArrayList<Shoes> shoes = new ArrayList<>();
        File file = new File("src/shoesToCheckIn.csv");
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
     * toCSVString will take in the selectedshoes and convert it to the proper csv string
     * @param selectedShoes the shoes to be converted to a csv string representation
     * @return A string representation of the Shoes object passed in in a csv format
     */
    public static String toCSVString(Shoes selectedShoes) {
        return selectedShoes.getSize() + comma + selectedShoes.getPrice() + comma
                + selectedShoes.getBarcode() + comma + selectedShoes.getColor()
                + comma + selectedShoes.getModel() + comma + selectedShoes.getStock() + comma
                + selectedShoes.getImageURL()
                + newLine;
    }

    /*
     * checkInShoes will take in the selectedShoes and write that shoe to the inventory csv file from 
     * the shoes that need to be checked in and this method updates both csv files and will update the
     * internal lists as well.
     * @param selectedShoes the shoes to be checked in to the inventory
     * @return No return but the shoe is taken off the shoes that need to be checked in csv and then the
     * shoe is added to the inventory csv file
     */
    public static void checkInShoes(Shoes selectedShoes) {
        // all shoes to check in
        ArrayList<Shoes> allShoesToCheckIn = new ArrayList<>();

        // just the shoes that we're going to write to the inventory CSV,
        // so they need to be removed from the checkin CSV
        ArrayList<String> shoesToKeepInCheckin = new ArrayList<>();
        try {
            allShoesToCheckIn = getShoesToCheckInFromCsv();
        } catch (FileNotFoundException e) {
            System.out.println("Shoes data CSV not found!");
        }
        // filter the selected shoe out of the toCheckin
        for (Shoes shoes : allShoesToCheckIn) {
            if (!shoes.equals(selectedShoes)) {
                shoesToKeepInCheckin.add(toCSVString(shoes));
            }
        }

        try (PrintWriter checkInWriter = new PrintWriter("src/shoesToCheckIn.csv")) {
            checkInWriter.print("");
            // write the leftover shoes to the file
            for (String string : shoesToKeepInCheckin) {
                checkInWriter.println(string);
            }
            checkInWriter.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Shoe to check-in data CSV not found!");
        }
        // write the inventory file again
        try (BufferedWriter inventoryWriter = new BufferedWriter(new FileWriter("data/shoes.csv", true))) {
            inventoryWriter.append(newLine + toCSVString(selectedShoes));
            inventoryWriter.close();
        } catch (IOException e) {
            // no file found -- that's impossible
            System.out.println("Shoes data CSV not found!");
        }
    }
}
