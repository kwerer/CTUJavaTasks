package tasks;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    static int[] sampleArray1;



    public static void main(String[] args) {
        ReadFile newReader = new ReadFile();
        newReader.readArray();
        for (ArrayList i: newReader.numbersArrayInt) {
                sampleArray1 = i.stream().mapToInt(element -> (int) element).toArray();
            printArray(SelectionSortAlgorithm(sampleArray1));
        }


    }

    public static int[] SelectionSortAlgorithm(int[] sampleArray) {
        // outer loop for index
        for (int i = 0; i < sampleArray.length; i++ ) {
            // inner loop to compare values of unsorted array
            for (int j = i + 1; j < sampleArray.length; j ++) {
                if (sampleArray[j] < sampleArray[i]) {
                    // swap value
                    int temp = sampleArray[j];
                    sampleArray[j] = sampleArray[i];
                    sampleArray[i] = temp;
                }
            }
        }

        return sampleArray;
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
