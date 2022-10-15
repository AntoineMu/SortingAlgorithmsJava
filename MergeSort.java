import  SortingAlgorithmsJava.initArrayList;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args){

        List<Integer> arr = initArrayList.init(500, 50);

        long startTime = System.nanoTime();
        arr = mergeSort(arr);
        long stopTime = System.nanoTime();
        long totalTime = stopTime - startTime;

        System.out.println("Merge Sorted: ");
        System.out.println("Execution time in nanoseconds: " + totalTime);
        System.out.println("Execution time in milliseconds: " + (double)totalTime / 1000000);
        System.out.println("Execution time in seconds: " + (double)totalTime / 1000000000);
        for(int i : arr){
            System.out.println(i);
        }
    }


    public static List<Integer> mergeSort(List<Integer> a){
        if(a.size() <= 1) return a;
        List<Integer> arrayOne = a.subList(0, a.size()/2);
        List<Integer> arrayTwo = a.subList(a.size()/2, a.size());

        arrayOne = mergeSort(arrayOne);
        arrayTwo = mergeSort(arrayTwo);

        return merge(arrayOne, arrayTwo);
    }

    public static List<Integer> merge(List<Integer> a, List<Integer> b){
        List<Integer> c = new ArrayList<Integer>();
        int aCounter = 0;
        int bCounter = 0;

        while(aCounter < a.size() && bCounter < b.size()){
            if(a.get(aCounter) > b.get(bCounter)){
                c.add(b.get(bCounter));
                ++bCounter;
            }else{
                c.add(a.get(aCounter));
                ++aCounter;
            }
        }
        while(aCounter < a.size()){
            c.add(a.get(aCounter));
            ++aCounter;
        }
        while(bCounter < b.size()){
            c.add(b.get(bCounter));
            ++bCounter;
        }

        return c;
    }
}
