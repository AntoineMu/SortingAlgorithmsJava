import SortingAlgorithmsJava.Display.Display;
import java.util.Random;

import static java.lang.Math.abs;
import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.Callbacks.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;


public class BubbleSort{

    public static void main(String [] args){

        Random rd = new Random(); // creating Random object
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(); // storing random integers in an array
        }

        Display display = new Display();
        display.init();
        loop(display, arr);

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

    private static void loop(Display display, int[] arr) {
        long window = display.getWindowId();

        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        GL11.glMatrixMode(GL11.GL_PROJECTION_MATRIX);
        glDisable(GL_DEPTH_TEST);

        float barWidth = (float) 1/arr.length;

        int barHeight = -1000000000;
        for(int i : arr){
            if(Math.abs(i) > barHeight) barHeight = Math.abs(i);
        }


        while ( !glfwWindowShouldClose(window) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer



            for(int j=0; j<arr.length; ++j) {
                glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
                float currBarWidth = 0.f;
                for (int i = 0; i < arr.length - 1 - j; ++i) {
                    //TODO: Update display
                    //draw(currBarWidth, arr[i], barWidth);       //passing the current x and y coordinates and the total width

                    glBegin(GL_QUADS);
                    glColor3f(currBarWidth, 1-currBarWidth, 1.0f);
                    glVertex2f(currBarWidth, 0);
                    glVertex2f(currBarWidth, (float)arr[i]/(float) barHeight);
                    glVertex2f(currBarWidth+barWidth, (float)arr[i]/(float)barHeight);
                    glVertex2f(currBarWidth+barWidth, 0);
                    glEnd();
                    currBarWidth += barWidth;
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }

                glfwSwapBuffers(window); // swap the color buffers
                glfwPollEvents();
            }
            //TODO: Update display

            glfwSwapBuffers(window); // swap the color buffers
            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public static void draw(double x, int y, double width){
        glBegin(GL_QUADS);
        glVertex2f((float)x, (float)0);
        glVertex2f((float)(x), y);
        glVertex2f((float)(x+width), y);
        glVertex2f((float)(x+width), 0);
        glEnd();
    }
}