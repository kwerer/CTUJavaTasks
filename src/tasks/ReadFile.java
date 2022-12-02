package tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public String[] numbersArray;
    List<ArrayList<Integer>> numbersArrayInt = new ArrayList<>();

    public void readArray() {
        try {
            File myObj = new File("C:\\Users\\jojoj\\Documents\\SUTD\\Exchange\\Java Programming\\relearn\\src\\tasks\\filename.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                // each line of array
                String data = myReader.nextLine();
                // separate each array by commas
                numbersArray = data.split(",");
                ArrayList<Integer> myIntArray = new ArrayList<Integer>();
                for (String i : numbersArray) {
                    myIntArray.add(Integer.parseInt(i));
                }
                numbersArrayInt.add(myIntArray);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void printArray() {
        for (ArrayList i: numbersArrayInt) {
            System.out.println(Arrays.toString(i.toArray()));
        }

    }
}
