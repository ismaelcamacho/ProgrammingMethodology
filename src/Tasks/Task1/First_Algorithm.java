package Tasks.Task1;

import java.lang.Math;

public class First_Algorithm {

    public static void main(String[] args) {
        int [] numbers = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400};
        long startTime = System.currentTimeMillis();
        for (int i=0; i<numbers.length; i++){
            System.out.print("The square root of " + numbers[i] + " is= ");
            System.out.println(Math.sqrt(numbers[i]));
        }
        System.out.print("Time in milliseconds to execute this algorithm = ");
        System.out.println(System.currentTimeMillis()-startTime + "ms");
    }
}
