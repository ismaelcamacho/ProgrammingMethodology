package Task4;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class main {
	
	private static Scanner sc = new Scanner (System.in);
	
	
	public static void main(String[] args) throws IOException {
		
		int [] nBig = {25,50,75,100};
		int [] nSmall = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};
		
		int amount_big_numbers = choose_big_Numbers ();
		int [] selected_big_Numbers = new int [amount_big_numbers];
		
		for (int i =0; i< amount_big_numbers; i++) {
			int n_selected = getRandom(nBig);
			selected_big_Numbers[i] = nBig[n_selected];
			nBig = update_nBig(nBig, n_selected);
			
			//System.out.print(selected_big_Numbers[i]+" ");
		}
		
		int [] selected_small_numbers = new int [6-amount_big_numbers];
		
		for (int i =0; i< 6-amount_big_numbers; i++) {
			int n_selected = getRandom(nSmall);
			selected_small_numbers[i] = nSmall[n_selected];
			nSmall = update_nSmall(nSmall, n_selected, selected_small_numbers);
			
			//System.out.print(selected_small_numbers[i]+" ");
		}
		
		int [] selected_numbers = new int [6];
		
		for (int i=0; i<selected_big_Numbers.length; i++) {
			selected_numbers[i] = selected_big_Numbers[i];
		}
		for (int j=selected_big_Numbers.length, k = 0; j<selected_numbers.length; j++) {
			selected_numbers[j] = selected_small_numbers[k++];
		}
		
		for (int i=0; i<selected_numbers.length; i++ ) {
			System.out.print(selected_numbers[i]+" ");
		}
		
		
		int RandomNumber = (int) (Math.random() * (999 - 101)) + 101;
		
		numerosBack (0, selected_numbers, RandomNumber);
		
	}
	
	public static void numerosBack (int etapa, int [] numeros, int cantidad) {
		if (etapa == numeros.length) {
			
		} else {
			for (int i=0; i<numeros.length;i++) {
				if (Vale(i, etapa, numeros, cantidad)) {
					
				}
			}
		}
	}
	
	public static boolean Vale (int i, int etapa, int [] numeros, int cantidad) {
		boolean resultado = false;
		
		return resultado;
	}
	
	public static int [] update_nSmall (int [] nSmall, int randomNumber, int [] selected_small_numbers) {
		int [] new_nSmall = new int [nSmall.length-1];
		
		if (nSmall == null || randomNumber < 0 || randomNumber > nSmall.length) {
			System.out.println("Nothing can be removed");
			return nSmall;
		}
		
		for (int i =0; i < selected_small_numbers.length; i++) {
			if (nSmall [randomNumber] == selected_small_numbers[i] ) {
				return nSmall;
			}
		}
		
		for (int i =0, k=0; i <nSmall.length; i++) {
				if (i == randomNumber) {
					continue;
				}
				new_nSmall[k++] = nSmall[i];
			
			
		}
		
		
		return new_nSmall;
	}
	
	
	
	public static int getRandom (int [] array) {
		Random r = new Random();
		int randomNumber = r.nextInt(array.length);
		return randomNumber ;
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
