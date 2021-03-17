package Tasks.Task1;

public class Third_Algorithm {
    public static void main(String[]args){
        int [] numbers = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400};
        long StartTime = System.currentTimeMillis();
        for (int i=0; i<numbers.length; i++){
            System.out.print("The square root of " + numbers[i] + " is= ");
            System.out.println(Recursive(0,numbers[i],numbers[i]));
        }
        System.out.print("Time in milliseconds to execute this algorithm = ");
        System.out.println(System.currentTimeMillis()-StartTime + "ms");
    }
   public static int Recursive(int low, int high, int x){
        if (low <= high){
            int mid = (low+high)/2;
            if ((mid*mid<=x)&&((mid+1)*(mid+1)>x)){
                return mid;
            }
            else if (mid*mid<x){
                return Recursive(mid+1,high,x);
            }
            else {
                return Recursive(low, mid-1,x);
            }
        }
        return low;
   }
}
