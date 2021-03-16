package Tasks.Task1;

public class Third_Algorithm {
    public static void main(String[]args){
        int [] numbers = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400};
        long StartTime = System.currentTimeMillis();
        for (int i=0; i<numbers.length; i++){
            System.out.print("The square root of " + numbers[i] + " is= ");
            System.out.println(SquareRoot(numbers[i]));
        }
        System.out.print("Time in milliseconds to execute this algorithm = ");
        System.out.println(System.currentTimeMillis()-StartTime + "ms");
    }
    public static double recursiveSquareRoot(double x, double y){
        if (x==1){
            return 1;
        }
        else{
            double result = (y + (x/y)/2);
            return recursiveSquareRoot(x-1, result);
        }
    }
    public static double SquareRoot(double x){
        return recursiveSquareRoot(x, x-1);
    }
}
