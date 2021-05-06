/***************************************************************************************************************************
	*
	* Class Name: Operation
	* Author/s name: Ismael Camacho Talavera and Andrés Castellanos Cantos
	* Release/Creation date: 06/05/2021
	* Class version: 
	* Class description: this is the class of the object Operation, and where we can find the constructor, the setters
	* and getters, and the method result.
	*
	****************************************************************************************************************************
	*/

package Tasks.Task4;

public class Operation {

	private int number1;
	private int number2;
	private String operator;
	
	
	public Operation (int number1, int number2, String operator) {
		this.number1 = number1;
		this.number2 = number2;
		this.operator = operator;
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
	
	/*********************************************************************
    *
    * Method name: result
    *
    * Description of the Method: method that calculate the operations required
    *
    * Calling arguments: 
	*		- int number 1 and int number2
	* 
    * Return value: integer.
    *
    *********************************************************************/


	public int result () {
		int result = 0;
		
		
		switch (operator) {
		
		case "add":
			result = this.number1+this.number2; 
			break;
			
		case "substract":		
				result = number1-number2;
			break;
			
		case "divide":		
				result = number1/number2;	
		break;
		
		case "multiply":
			result = number1*number2;
			break;
				
	}
	return result;
	}
	
	public String toString () {
		return number1+operator+number2+" is ";
	}
}
