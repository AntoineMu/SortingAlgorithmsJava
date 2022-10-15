import SortingAlgorithmsJava.initArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort {

    public static void main(String[] args){
        List<Integer> arr = initArrayList.init(500, 50);

        long startTime = System.nanoTime();
        arr = countingSort(arr);
        long stopTime = System.nanoTime();
        long totalTime = stopTime - startTime;

        System.out.println("Array Sorted: ");
        System.out.println("Execution time in nanoseconds: " + totalTime);
        System.out.println("Execution time in milliseconds: " + (double)totalTime / 1000000);
        System.out.println("Execution time in seconds: " + (double)totalTime / 1000000000);
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static List<Integer> countingSort(List<Integer> a){
        int largest = -999999999;
        for(int i : a){
            if(i > largest) largest = i;
        }
        List<Integer> helpArray = Arrays.asList(new Integer[largest+1]);
        for(int i=0; i<helpArray.size(); ++i) {
            helpArray.set(i, 0);
        }
        for(int i : a){
            int temp = 0;
            if(helpArray.get(i) != null) temp = helpArray.get(i);
            ++temp;
            helpArray.set(i, temp);
        }
        int count = 0;
        for(int i= 1; i<helpArray.size(); ++i){
            count = helpArray.get(i) + helpArray.get(i - 1);
            helpArray.set(i, count);
        }
        List<Integer> ordered = Arrays.asList(new Integer[a.size()]);
        for(int i : a){
            ordered.set(helpArray.get(i) -1, i);
            int temp = helpArray.get(i) - 1;
            helpArray.set(i, temp);
        }

        return ordered;
    }
}
