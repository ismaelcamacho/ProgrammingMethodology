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

        long StartTime2 = System.currentTimeMillis();
        for(int i=0; i< numbers.length;i++){
            System.out.print("The square root of " + numbers[i] + " is= ");
            System.out.println(babylonian(numbers[i]));
        }
        System.out.print("Time in milliseconds to execute this algorithm = ");
        System.out.println(System.currentTimeMillis()-StartTime2 + "ms");
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
        public static double babylonian(int number){
            double result = number/2;
            for (int j=1; j<10; j++){
                if(result*result==number){
                    return result;
                }
                else{
                    result = (result + (number/result)) / 2;
                }
            }
            return result;
        }
    }