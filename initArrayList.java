package SortingAlgorithmsJava;

import java.util.ArrayList;
import java.util.Random;

public class initArrayList {

    public static ArrayList<Integer> init(int cap){
        Random rd = new Random(); // creating Random object
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < cap; i++) {
            arr.add(Math.abs(rd.nextInt())); // storing random integers in an array
        }

        return arr;
    }

    public static ArrayList<Integer> init(int cap, int size){
        Random rd = new Random(); // creating Random object
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < cap; i++) {
            int temp = rd.nextInt() % size;
            temp = Math.abs(temp);
            arr.add(temp); // storing random integers in an array
        }

        return arr;
    }
}
