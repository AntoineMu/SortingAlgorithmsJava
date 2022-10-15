package SortingAlgorithmsJava;

import java.util.ArrayList;
import java.util.Random;

public class initArrayList {

    public static ArrayList<Integer> init(int cap){
        Random rd = new Random(); // creating Random object
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < cap; i++) {
            arr.add(rd.nextInt()); // storing random integers in an array
        }

        return arr;
    }
}
