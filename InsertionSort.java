import  SortingAlgorithmsJava.initArrayList;

import java.util.List;


public class InsertionSort {

    public static void main(String[] args){

        List<Integer> arr = initArrayList.init(500, 50);

        long startTime = System.nanoTime();
        insertionSort(arr);
        long stopTime = System.nanoTime();
        long totalTime = stopTime - startTime;
        int largest = arr.get(arr.size()-1);
        boolean sorted = true;
        for(int i : arr){
            if(i > largest){
                sorted = false;
            }
        }
        if(!sorted){
            System.out.println("ARRAY NOT SORTED!!!!");
        }else System.out.println("Insertion Sorted: ");
        System.out.println("Execution time in nanoseconds: " + totalTime);
        System.out.println("Execution time in milliseconds: " + (double)totalTime / 1000000);
        System.out.println("Execution time in seconds: " + (double)totalTime / 1000000000);
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void insertionSort(List<Integer> a){
        for(int i=1; i<a.size(); ++i){
            int j = i;
            while(j>0 && a.get(j-1) > a.get(j)){
                int temp = a.get(j);
                a.set(j, a.get(j-1));
                a.set(j-1, temp);
                --j;
            }
        }
    }
}
