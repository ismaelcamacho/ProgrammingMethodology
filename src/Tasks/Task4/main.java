package Tasks.Task4;
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
		int [] selected_big_Numbers = selected_Numbers (amount_big_numbers, nBig);	
		int [] selected_small_numbers = selected_Numbers (6-amount_big_numbers, nSmall);
		int [] selected_numbers = finall_array(selected_big_Numbers, selected_small_numbers);
		
		for (int i=0; i<selected_numbers.length; i++ ) {
			System.out.print(selected_numbers[i]+" ");
		}
		
		
		int RandomNumber = (int) (Math.random() * (999 - 101)) + 101;
		
		numerosBack (0, selected_numbers, RandomNumber);
		
	}
	
	public static int [] finall_array (int [] selected_big_Numbers, int [] selected_small_numbers) {
		int [] final_array = new int [6];
		
		for (int i=0; i<selected_big_Numbers.length; i++) {
			final_array[i] = selected_big_Numbers[i];
		}
		for (int j=selected_big_Numbers.length, k = 0; j<final_array.length; j++) {
			final_array[j] = selected_small_numbers[k++];
		}
		
		return final_array;
	}
	
	public static int [] selected_Numbers (int amount, int [] numbers_array) {
		int [] array = new int [amount];
		
		for (int i =0; i< amount; i++) {
			int n_selected = getRandom(numbers_array);
			array[i] = numbers_array[n_selected];
			numbers_array = update_array(numbers_array, n_selected);	
		}
		
		return array;
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
	
	
	
	public static int getRandom (int [] array) {
		Random r = new Random();
		int randomNumber = r.nextInt(array.length);
		return randomNumber ;
	}
	
	public static int [] update_array (int [] array, int randomNumber) {
		int [] new_array = new int [array.length-1];
		
		if (array == null || randomNumber < 0 || randomNumber > array.length) {
			System.out.println("Nothing can be removed");
			return array;
		}
		
		for (int i =0, k=0; i <array.length; i++) {
			if (i == randomNumber) {
				continue;
			}
			new_array[k++] = array[i];
		}
		
		return new_array;
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
