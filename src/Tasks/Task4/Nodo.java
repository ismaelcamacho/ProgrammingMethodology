/***************************************************************************************************************************
	*
	* Class Name: Nodo
	* Author/s name: Ismael Camacho Talavera and Andrés Castellanos Cantos
	* Release/Creation date: 05/05/2021
	* Class version: 
	* Class description: this is the class of the object Nodo, where we can find the constructor and all getters and setters.
	*
	****************************************************************************************************************************
	*/

package Tasks.Task4;


import java.util.ArrayList;

public class Nodo {
	
	public Nodo father;
	public ArrayList <Operation> operation;
	public ArrayList <Integer> numbers;
	
	
	public Nodo (Nodo father, ArrayList <Operation> operation, ArrayList <Integer> numbers) {
		this.father = father;
		this.operation = operation;
		this.numbers = numbers;
		
	}


	public ArrayList<Operation> getOperation() {
		return operation;
	}


	public void setOperation(ArrayList<Operation> operation) {
		this.operation = operation;
	}


	public Nodo getFather() {
		return father;
	}

	public void setFather(Nodo father) {
		this.father = father;
	}

	

	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
	

}



