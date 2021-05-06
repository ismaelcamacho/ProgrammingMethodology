package Tasks.Task4;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;

public class main {
	
	private static Scanner sc = new Scanner (System.in);
	
	/***************************************************************************************************************************
	*
	* Class Name: main Task 4
	* Author/s name: Ismael Camacho Talavera and Andrés Castellanos Cantos
	* Release/Creation date: 05/05/2021
	* Class version: 
	* Class description: this class is the main of the program, where is developed both objetives requested.
	*
	****************************************************************************************************************************
	*/
	
	
	public static void main(String[] args) throws IOException {	
		
		int [] nBig = {25,50,75,100};
		int [] nSmall = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};
		
		int amount_big_numbers = choose_big_Numbers ();
		
		ArrayList<Integer> selected_big_Numbers = selected_Numbers (amount_big_numbers, nBig);	
		ArrayList<Integer> selected_small_numbers = selected_Numbers(6-amount_big_numbers, nSmall);		
		ArrayList<Integer> numbers = new ArrayList<>();		
			
		for (int i=0; i<selected_big_Numbers.size(); i++ ) {
			numbers.add(selected_big_Numbers.get(i));
		}
		
		for (int i=0; i<selected_small_numbers.size(); i++ ) {
			numbers.add(selected_small_numbers.get(i));
		}
		
		for (int i=0; i<numbers.size(); i++ ) {
			System.out.print(numbers.get(i)+" ");
		}

		Nodo nodo = new Nodo (null, null, numbers);
		
		int RandomNumber = (int) (Math.random() * (999 - 101)) + 101;
		
		numbersBacktracking (nodo, RandomNumber);
		
	}
	
	/*********************************************************************
    *
    * Method name: numerosBacktracking
    *
    * Description of the Method: clasic method for doing a Backtracking using DFS. First of all
    * check if the nodo is the solution, else its go through all numbers of the arraylist of the
    * nodo.
    *
    * Calling arguments: 
	* 		- Nodo nodo.
	* 		- int objective
    *
    * Return value: void
    *
    *********************************************************************/
	
	
	public static void numbersBacktracking (Nodo nodo, int objective) {
		if (isSolution(nodo, objective)) {
			while (nodo.getFather()!=null ) {
				// GO THROR BACK OF NODOS FATHER AND SHOW OPERATIONS
			}
			
		} else {
			for (int i=0; i<nodo.getNumbers().size();i++) {
				for (int j=0; j<nodo.getNumbers().size();j++) {
					if (i!=j) {

						//ArrayList<Operation> op = generateOperations (nodo, i, j);
						nodo.operation = generateOperations (nodo, i, j);
						
						for (int k=0; k<nodo.operation.size();k++) {
							
							if (nodo.numbers.size()>1) {
								nodo.numbers.remove(get_Pos(nodo, nodo.operation.get(k).getNumber1()));
								nodo.numbers.remove(get_Pos(nodo, nodo.operation.get(k).getNumber2()));

								nodo.numbers.add(nodo.operation.get(k).result());
							}
							
							
							numbersBacktracking(new Nodo(nodo,nodo.operation,nodo.numbers),objective);	
							
						}		
					}
				}
			}
		}
		}
	
	/*********************************************************************
    *
    * Method name: get_Pos
    *
    * Description of the Method: method that gets the position of a number
    * in the arraylist of a specific nodo.
    *
    * Calling arguments: 
	* 		- Nodo nodo.
	* 		- int number
    *
    * Return value: integer, that is the position of the number.
    *
    *********************************************************************/
	
	public static int get_Pos(Nodo nodo, int number) {
		int pos = 0;
		for (int i=0; i<nodo.numbers.size();i++) {
			if (nodo.numbers.get(i)==number) {
				pos = i;
			}
		}
		return pos;
	}
	
	/*********************************************************************
    *
    * Method name: generateOperations
    *
    * Description of the Method: create an ArrayList of operations depending on the parameters. If
    * the operation between both numbers returns a remainder not equal to zero or the result is 
    * lower than 0, then the operation is not gonna be safe
    *
    * Calling arguments: 
	* 		- Nodo nodo.
	* 		- int i
	* 		- int j
	* 
    * Return value: arraylist of operations.
    *
    *********************************************************************/
	
	public static ArrayList<Operation> generateOperations (Nodo nodo, int i, int j) {
		ArrayList<Operation> op = new ArrayList <>(); 
		
			op.add(new Operation(nodo.getNumbers().get(i),nodo.getNumbers().get(j),"add"));
			
			if ((nodo.getNumbers().get(i)-nodo.getNumbers().get(j))>0) {
				op.add(new Operation(nodo.getNumbers().get(i),nodo.getNumbers().get(j),"substract"));
			}
			
			if ((nodo.getNumbers().get(i)%nodo.getNumbers().get(j))==0) {
				op.add(new Operation(nodo.getNumbers().get(i),nodo.getNumbers().get(j),"substract"));
			}
			
			op.add(new Operation(nodo.getNumbers().get(i),nodo.getNumbers().get(j),"multiply"));
		
			return op;
	}
	
	/*********************************************************************
    *
    * Method name: isSolution
    *
    * Description of the Method: method that checks if one element is the objective
    * looked for. So if it's, returns true.
    *
    * Calling arguments: 
	* 		- Nodo nodo.
	* 		- int objective
	* 
    * Return value: boolean
    *
    *********************************************************************/
	
	public static boolean isSolution (Nodo nodo, int objective) {
		boolean solution = false;
			for (int i=0; i<nodo.getNumbers().size();i++) {
				if (nodo.getNumbers().get(i)==objective) {
					solution = true;
				}	
			}
		return solution;
	}
	
	/*********************************************************************
    *
    * Method name: selected_numbers
    *
    * Description of the Method: method that keep in the arraylist the random 
    * a random number of the given matrix.  Once it's kept the matrix is updated
    * and the number is deleted
    *
    * Calling arguments: 
	* 		- int amount
	* 		- int [] numbers_array
	* 
    * Return value: arraylist of integers.
    *
    *********************************************************************/
	
	public static ArrayList<Integer> selected_Numbers (int amount, int [] numbers_array) {
		ArrayList <Integer> array = new ArrayList<>();
		
		for (int i =0; i< amount; i++) {
			int n_selected = getRandom(numbers_array);
			array.add(numbers_array[n_selected]);
			numbers_array = update_array(numbers_array, n_selected);	
		}
		
		
		return array;
	}
	
	/*********************************************************************
    *
    * Method name: getRandom
    *
    * Description of the Method: method that returns a selected random number
    * of a given matrix.
    *
    * Calling arguments: 
	*		- int [] numbers_array
	* 
    * Return value: integer.
    *
    *********************************************************************/
	
	
	public static int getRandom (int [] array) {
		Random r = new Random();
		int randomNumber = r.nextInt(array.length);
		return randomNumber ;
	}
	
	/*********************************************************************
    *
    * Method name: update_Array
    *
    * Description of the Method: method that updates the matrix deleting a 
    * given number
    *
    * Calling arguments: 
	*		- int [] array
	*		- int randomNumber
	* 
    * Return value: array of integers..
    *
    *********************************************************************/
	
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
	
	/*********************************************************************
    *
    * Method name: choose_big_numbers
    *
    * Description of the Method: method that checks that the input is an
    * integer, and also checks if the number is in the range recomended.
    *
    * Calling arguments: 
	* 
    * Return value: integer.
    *
    *********************************************************************/
	
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
