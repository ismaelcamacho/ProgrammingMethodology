package Tasks.Task1;

import java.io.*;

public class Second_Algorithm{
    public static void main(String[]args){
        int [] numbers = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400};
        long StartTime1 = System.currentTimeMillis();
        for(int i=0; i< numbers.length;i++){
            System.out.print("The square root of " + numbers[i] + " is= ");
            System.out.println(binary_search(numbers[i]));
        }
        System.out.print("Time in milliseconds to execute this algorithm = ");
        System.out.println(System.currentTimeMillis()-StartTime1 + "ms");
    }

    public static double binary_search(int x) {
        int left = 0;
        int right = x;
            if (x < 2) {
                return x;
            }
            while (left < right) {
                int mid = left + ((right - left) / 2);
                if (mid * mid == x) {
                    return mid;
                } else if (mid * mid < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left - 1;
        }
    }