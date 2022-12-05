package com.example.selectionsortdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public String[] numbersArray;
    public static List<ArrayList<Integer>> numbersArrayInt = new ArrayList<>();

    public String readArray(File file) {
        try {
            Scanner myReader = new Scanner(file);
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

        return numbersArrayInt.get(0).toString();
    }

    public void printArray() {
        for (ArrayList i: numbersArrayInt) {
            System.out.println(Arrays.toString(i.toArray()));
        }

    }
}
