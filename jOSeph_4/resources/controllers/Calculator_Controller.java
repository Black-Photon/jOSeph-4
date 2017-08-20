package jOSeph_4.resources.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jOSeph_4.Error;

import java.util.ArrayList;

/**
 * Controls the calculator logic
 */

public class Calculator_Controller {
	@FXML
	private TextField text;

	@FXML
	void on0Pressed() {
		onPress("0");
	}

	@FXML
	void on1Pressed() {
		onPress("1");
	}

	@FXML
	void on2Pressed() {
		onPress("2");
	}

	@FXML
	void on3Pressed() {
		onPress("3");
	}

	@FXML
	void on4Pressed() {
		onPress("4");
	}

	@FXML
	void on5Pressed() {
		onPress("5");
	}

	@FXML
	void on6Pressed() {
		onPress("6");
	}

	@FXML
	void on7Pressed() {
		onPress("7");
	}

	@FXML
	void on8Pressed() {
		onPress("8");
	}

	@FXML
	void on9Pressed() {
		onPress("9");
	}

	@FXML
	void onAddPressed() {
		onPress("+");
	}

	@FXML
	void onClearPressed() {
		text.setText("");
	}

	@FXML
	void onDecimalPressed() {
		onPress(".");
	}

	@FXML
	void onDividePressed() {
		onPress("/");
	}

	@FXML
	void onEqualsPressed() {
		parseAnswer();
	}

	@FXML
	void onMinusPressed() {
		onPress("-");
	}

	@FXML
	void onTimesPressed() {
		onPress("x");
	}

	//In order of BODMAS
	private final char[] operators = {'/','x','+','-','\\'};

	/**
	 * Simply adds whatever pressed to the answer box
	 * @param whatPressed The button pressed
	 */
	private void onPress(String whatPressed){
		text.setText(text.getText()+whatPressed);
	}

	/**
	 * Solves the problem, and puts the answer in the answer box
	 */
	private void parseAnswer(){
		//Ensures no empty text
		if(text.getText().equals("")){
			return;
		}

		//Holds info for both ArrayLists - Simply used so splitInfo can return 2 things
		ArrayList<ArrayList> info = splitInfo(text.getText());

		//List of operators in problem (In order)
		ArrayList<Character> operators = info.get(1);

		//List of numbers in problem (In order)
		ArrayList<Float> numbers = info.get(0);


		//Given the end of the problem is an operator ('\'), the number of
		//operators and numbers should be the same in any problem
		if(operators.size()!=numbers.size()){
			new Error("Syntax Error: Too many/few operators", 450);
			return;
		}

		//Completes calculations one by one until there is only one number and
		//operator - the answer and end of problem, '\'
		for(char operatorType: this.operators) {
			//Exits for exit operator
			if(operatorType=='\\'){
				break;
			}
			int size = operators.size();
			completeOperatorOperations(size, operatorType, operators, numbers);
		}

		//Knowing there should be 1 number, this confirms it, and displays the answer
		if(numbers.size()==1) {
			text.setText(Float.toString(numbers.get(0)));
		}else if(numbers.size()==0) {
			new Error("Math Error: No Input", 300);
		}else{
			new Error("Math Error: Unused numbers", 300);
		}
	}

	/**
	 * Run for every operator, this will perform every operation, and replace it in the lists
	 * @param size The list's size
	 * @param operatorType The type of operator to be used
	 * @param operators The list of operators
	 * @param numbers The list of numbers
	 */
	private void completeOperatorOperations(int size, char operatorType, ArrayList<Character> operators, ArrayList<Float> numbers){
		//Runs through numbers up to the size of lists
		for (int i = 0; i < size; i++) {
			//Only does anything if the operator is found
			if(operators.get(i).equals(operatorType)){
				//	Removes operator from list, as well as involved numbers before replacing with the answer
				//	This allows multiple operations, eg. 4+5/2:
				//	+  /  \
				//	4  5  2
				//
				//	   |
				//	  \-/
				//
				//	 +   \
				//	 4  2.5
				//
				//	   |
				//	  \-/
				//
				//	   \
				//	  6.5
				//
				//	Answer = 6.5
				operators.remove(i);
				float num1 = numbers.get(i);
				float num2 = numbers.get(i+1);
				numbers.remove(i);
				numbers.remove(i);
				numbers.add(i, performOperation(operatorType, num1, num2));
				//Whenever it performs operation X, it checks again from the start any more X operations,
				//and then cancels the last check. This prevents IndexOutOfBoundsExceptions
				completeOperatorOperations(size-1, operatorType, operators, numbers);
				return;
			}
		}
	}

	/**
	 * Splits a string such as 3+6\ to ArrayLists [[3,6],[+,\]]
	 * Numbers array index 0, operators index 1
	 * @param string The string to split
	 * @return An array of operations and numbers
	 */
	private ArrayList<ArrayList> splitInfo(String string){
		//Adds an end operator on the end
		string+='\\';
		StringBuilder temp = new StringBuilder("");

		//Creates ArrayLists - See parseAnswer for uses
		ArrayList<ArrayList> superArray = new ArrayList<>();
		ArrayList<Character> operatorArray = new ArrayList<>();
		ArrayList<Float> numberArray = new ArrayList<>();

		//When it detects an operator, it compiles everything read before into a number with parseNumber,
		//and adds this number and the operator to ArrayLists
		for(char character: string.toCharArray()){
			if(isOperator(character)){
				numberArray.add(parseNumber(temp.toString()));
				temp = new StringBuilder("");
				operatorArray.add(character);
				if(character=='\\'){
					break;
				}
			}else{
				temp.append(character);
			}
		}
		//SuperArray avoids too many Global Variables
		superArray.add(0, numberArray);
		superArray.add(1, operatorArray);
		return superArray;
	}

	/**
	 * Performs one of the 4 operations, dependant
	 * @param operator The operator to use
	 * @param num1 Number to perform operation on
	 * @param num2 Other number to perform operation on
	 * @return Answer to operation
	 */
	private float performOperation(char operator, float num1, float num2){
		switch(operator){
			case '+':
				return num1 + num2;
			case '-':
				return num1 - num2;
			case 'x':
				return num1 * num2;
			case '/':
				return num1 / num2;
			default:
				new Error("Calculator Operation Error", 300);
				return 0;
		}
	}

	/**
	 * Tests if it's an operator
	 * @param character Character to test
	 * @return True or False
	 */
	private boolean isOperator(char character){
		for(char operator: operators){
			if(character == operator){
				return true;
			}
		}
		return false;
	}

	/**
	 * Converts string to float
	 * @param string String to convert
	 * @return The number (float)
	 */
	private float parseNumber(String string){
		try{
			//If an int, simply converts
			return Integer.parseInt(string);
		}catch(NumberFormatException e){
			//Else, does it in 2 parts - before and after the decimal
			StringBuilder temp = new StringBuilder("");
			float number = 0;
			int afterDecimal;
			boolean beforeDecimal = true;
			//For each number/decimal, tests for decimal, and adds
			for(char character: string.toCharArray()){
				if(beforeDecimal) {
					//Adds like a normal number
					if(character != '.') {
						temp.append(character);
					}else{
						//Converts first part and moves onto second
						number+=Integer.parseInt(temp.toString());
						temp = new StringBuilder("");
						beforeDecimal = false;
					}
				}else{
					//Don't try it
					if(character=='.'){
						new Error("Syntax Error: 2 decimals not allowed", 400);
						return 0;
					}
					//Adds to temp string for processing after
					temp.append(character);
				}
			}
			//If there is a number after the decimal to do something with, it converts it and adds it using toDecimal
			if(!temp.toString().equals("") && !beforeDecimal) {
				afterDecimal = Integer.parseInt(temp.toString());
				number+=toDecimal(afterDecimal);
			}
			return number;
		}
	}

	/**
	 * Converts to a decimal - eg. 4645 -> 0.4645, by testing every possibility
	 * @param number To convert
	 * @return The decimal
	 */
	private float toDecimal(float number){
		//Tests all reasonable divisions by 10 - Trial and error approach
		for(float i = 10; i<Math.pow(10,10); i = i*10){
			//Tests for decimal - first number <0
			if(number/i<1){
				return number/i;
			}
		}
		return 0;
	}
}
