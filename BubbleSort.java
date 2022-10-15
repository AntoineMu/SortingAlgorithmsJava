import SortingAlgorithmsJava.Display.Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.*;

public class BubbleSort{

    public static void main(String [] args){

        Random rd = new Random(); // creating Random object
        int[] arr = new int[500];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }

        //mergeSort(arr);
        Display display = new Display();
        display.init();
        int outerLoop = 0;
        int innerLoop = 0;
        loop(display, arr, outerLoop, innerLoop);

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

    private static void loop(Display display, int[] arr, int outerLoop, int innerLoop) {
        long window = display.getWindowId();

        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glMatrixMode(GL11.GL_PROJECTION_MATRIX);
        glDisable(GL_DEPTH_TEST);

        float barWidth = (float) 2/arr.length;
        int barHeight = -1000000000;
        for(int i : arr){
            if(Math.abs(i) > barHeight) barHeight = Math.abs(i);
        }

        while ( !glfwWindowShouldClose(window) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            drawArray(barWidth, arr, barHeight);
            if(outerLoop < arr.length -1){
                if(innerLoop < arr.length -1 - outerLoop){
                    if(arr[innerLoop] > arr[innerLoop + 1]){
                        int temp = arr[innerLoop];
                        arr[innerLoop] = arr[innerLoop + 1];
                        arr[innerLoop+1] = temp;
                    }
                }
            }
            ++innerLoop;
            if(innerLoop >= arr.length-outerLoop) {
                innerLoop = 0;
                ++outerLoop;
            }
            drawArray(barWidth, arr, barHeight);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void drawArray(float width, int[] arr, float barHeight){
        float currBarWidth = -1;
        for(int i : arr) {
            glColor3f(currBarWidth, 1-currBarWidth, 1);
            glBegin(GL_QUADS);
            glVertex2f(currBarWidth, 0);
            glVertex2f(currBarWidth, (float)i/barHeight);
            glVertex2f(currBarWidth+width, (float)i/barHeight);
            glVertex2f(currBarWidth+width, 0);
            glEnd();
            currBarWidth += width;
        }
    }
}