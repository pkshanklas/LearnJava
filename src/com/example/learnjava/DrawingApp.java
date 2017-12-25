package com.example.learnjava;
import com.example.algorithms.Search;

import java.util.*;

class DrawingApp {

    public static void main(String args[] ) throws Exception {
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int x = 55;

        // Find the index of 'x' using Jump Search
        Search searchObj = new Search(arr, x);
        int index = searchObj.jumpSearch();

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                " is at index " + index);

        index = searchObj.linearSearch();

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                " is at index " + index);

        index = searchObj.binarySearch();

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                " is at index " + index);

        index = searchObj.interPolationSearch();

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                " is at index " + index);
    }

}
