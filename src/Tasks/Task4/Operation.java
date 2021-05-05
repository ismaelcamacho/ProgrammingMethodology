package Tasks.Task4;

public class Operation {

	private int number1;
	private int number2;
	private String operator;
	private int resultado;
	
	public Operation (int number1, int number2, String operator, int resultado) {
		this.number1 = number1;
		this.number2 = number2;
		this.operator = operator;
		this.resultado = resultado;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	
}
