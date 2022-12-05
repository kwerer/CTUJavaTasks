package com.example.selectionsortdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public static String SelectionSortAlgorithm() {
        // outer loop for index
        for (int i = 0; i < ReadFile.numbersArrayInt.get(0).size(); i++ ) {
            // inner loop to compare values of unsorted array
            for (int j = i + 1; j < ReadFile.numbersArrayInt.get(0).size(); j ++) {
                if (ReadFile.numbersArrayInt.get(0).get(j) < ReadFile.numbersArrayInt.get(0).get(i)) {
                    // swap value
                    Collections.swap(ReadFile.numbersArrayInt.get(0),i,j);
                }
            }
        }

        return ReadFile.numbersArrayInt.get(0).toString();
    }

    static void printArray(int arr[])
    {
        System.out.print("Sorted Array: ");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
}
