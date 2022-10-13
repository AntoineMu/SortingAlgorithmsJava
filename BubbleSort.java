import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class BubbleSort{

    public static void main(String [] args){

        Random rd = new Random(); // creating Random object
        int[] arr = new int[5000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }

        long startTime = System.nanoTime();
        bubbleSort(arr);
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

    public static int[] bubbleSort(int[] arr){
        for(int j=0; j<arr.length; ++j) {
            for (int i = 0; i < arr.length - 1 - j; ++i) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }
}