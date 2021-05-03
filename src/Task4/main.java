package Task4;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class main {
	
	private static Scanner sc = new Scanner (System.in);
	public static void main (String [] args) throws IOException {
		
		int [] nBig = {25,50,75,100};
		int [] nSmall = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};
		
		int amount_big_numbers = choose_big_Numbers ();
		int [] selected_big_Numbers = new int [amount_big_numbers];
		
		for (int i =0; i< amount_big_numbers; i++) {
			selected_big_Numbers[i] = getRandom(nBig);
			System.out.print(selected_big_Numbers[i]+" ");
		}
		
	}
	
	public static int getRandom (int [] nBig) {
		Random r = new Random();
		int randomNumber = r.nextInt(nBig.length);
		int selectedNumber = nBig[randomNumber];
		
		nBig = update_nBig(nBig, randomNumber);
		
		return selectedNumber ;
	}
	
	public static int [] update_nBig (int [] nBig, int randomNumber) {
		int [] new_nBig = new int [nBig.length-1];
		
		
		if (nBig == null || randomNumber < 0 || randomNumber > nBig.length) {
			System.out.println("Nothing can be removed");
			return nBig;
		}
		
		for (int i =0, k=0; i <nBig.length; i++) {
			if (i == randomNumber) {
				continue;
			}
			new_nBig[k++] = nBig[i];
		}
		
		return new_nBig;
	}
	
	public static int choose_big_Numbers () throws IOException, InputMismatchException {
		int i=0;
		System.out.println("How many large numbers do you want to play (0 to 4)");
  	  	try {
  		  i = sc.nextInt();
  		  if (i<0 || i>4) {
  			  System.out.println("Error");
  			choose_big_Numbers();
  		  }
  		  
  	  } catch (InputMismatchException e) {
  		  System.out.println("Error. Only integer allowed");
  		  sc.next();
  		  choose_big_Numbers();
  	  }
  	  return i;
	}

}
