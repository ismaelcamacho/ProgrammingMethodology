package Tasks.Task4;


import java.util.ArrayList;

public class Nodo {
	
	protected Nodo padre;
	protected ArrayList <Integer> numbers = new ArrayList<> ();
	protected int objetivo;
	
	public Nodo (Nodo padre, ArrayList <Integer> numbers, int Objetivo) {
		padre = null;
		numbers = this.numbers;
		Objetivo = this.objetivo;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}

	public int getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(int objetivo) {
		this.objetivo = objetivo;
	}
}
