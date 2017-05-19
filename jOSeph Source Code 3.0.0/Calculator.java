package questionareGui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Calculator {
	
	static double FirstNumber = 0;
	static double SecondNumber = 0;
	static boolean dota = false;
	static boolean dotb = false;
	static int dotaPlaces = 1;
	static int dotbPlaces = 1;
	static boolean operator = false;
	static String operatorType = "";
	static boolean isaInt = false;
	static boolean isbInt = false;
	static double answer = 0.0;
	static int IntAnswer = 0;
	static TextField choice = new TextField();
	
	public static void calc(){
		//Sets default values
		
		FirstNumber = 0;
		SecondNumber = 0;
		dota = false;
		dotb = false;
		dotaPlaces = 1;
		dotbPlaces = 1;
		operator = false;
		operatorType = "";
		isaInt = false;
		isbInt = false;
		answer = 0.0;
		IntAnswer = 0;
		
		//Sets up layout
		
		Stage window = new Stage();
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		window.setTitle("Calculator");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
		GridPane.setConstraints(choice, 0, 0);
		Button One = new Button("1");
		Button Two = new Button("2");
		Button Three = new Button("3");
		Button Four = new Button("4");
		Button Five = new Button("5");
		Button Six = new Button("6");
		Button Seven = new Button("7");
		Button Eight = new Button("8");
		GridPane.setConstraints(One, 0, 1);
		GridPane.setConstraints(Two, 1, 1);
		GridPane.setConstraints(Three, 2, 1);
		GridPane.setConstraints(Four, 0, 2);
		GridPane.setConstraints(Five, 1, 2);
		GridPane.setConstraints(Six, 2, 2);
		GridPane.setConstraints(Seven, 0, 3);
		GridPane.setConstraints(Eight, 1, 3);
		Button Nine = new Button("9");
		Button Zero = new Button("0");
		Button Dot = new Button(".");
		Button Hash = new Button("#");
		Button Times = new Button("X");
		Button Divide = new Button("/");
		Button Add = new Button("+");
		Button Minus = new Button("-");
		Button Equals = new Button("=");
		GridPane.setConstraints(Nine, 2, 3);
		GridPane.setConstraints(Zero, 1, 4);
		GridPane.setConstraints(Dot, 2, 4);
		GridPane.setConstraints(Hash, 0, 4);
		GridPane.setConstraints(Times, 3, 3);
		GridPane.setConstraints(Divide, 3, 4);
		GridPane.setConstraints(Add, 3, 1);
		GridPane.setConstraints(Minus, 3, 2);
		GridPane.setConstraints(Equals, 3, 0);
		gridpane.add(choice, 0, 0, 3, 1);
		
		//What happens if I click this button?
		
		One.setOnAction(e -> WhatToDo(1) );
		Two.setOnAction(e -> WhatToDo(2) );
		Three.setOnAction(e -> WhatToDo(3) );
		Four.setOnAction(e -> WhatToDo(4) );
		Five.setOnAction(e -> WhatToDo(5) );
		Six.setOnAction(e -> WhatToDo(6) );
		Seven.setOnAction(e -> WhatToDo(7) );
		Eight.setOnAction(e -> WhatToDo(8) );
		Nine.setOnAction(e -> WhatToDo(9) );
		Zero.setOnAction(e -> WhatToDo(0) );
		Equals.setOnAction(e -> WhatToDo2("=") );
		Minus.setOnAction(e -> WhatToDo2("-") );
		Add.setOnAction(e -> WhatToDo2("+") );
		Times.setOnAction(e -> WhatToDo2("*") );
		Divide.setOnAction(e -> WhatToDo2("/") );
		Hash.setOnAction(e -> {window.close();calc();choice.setText("");} );
		Dot.setOnAction(e -> WhatToDo2(".") );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		gridpane.getChildren().addAll(One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Dot,Hash,Equals,Add,Minus,Times,Divide);
		Scene scene = new Scene(gridpane, 160, 200);
		window.setScene(scene);
		window.show();
		
		
		
	}
	
	//Long method to make decimals. 
	//Basically, 1 = 0*10+1 = 1
	//1 then 2 = (0*10+1)*10+2 = 1*10+2 = 12, ect...
	
	public static void WhatToDo(double args){
		if(operator==false){
			if(dota==false){
				FirstNumber*=10;
				FirstNumber+=args;
			}else{
				args=args * 1/Math.pow(10,dotaPlaces);
				FirstNumber+=args;
				
				
				dotaPlaces++;
			}
		}else{
			if(dotb==false){
				SecondNumber*=10;
				SecondNumber+=args;
			}else{
				args= args* 1/Math.pow(10,dotbPlaces);
				SecondNumber+=args;
				
				
				dotbPlaces++;
			}
		}
		if(operator){
		
		
		
		if(FirstNumber % 1 == 0){
			if(SecondNumber % 1 == 0){
				int FirstInt = (int) (FirstNumber);
				int SecondInt = (int) (SecondNumber);
				isaInt = true;
				isbInt = true;
				System.out.println(FirstInt +" "+ operatorType + " " + SecondInt);
				choice.setText(FirstInt +" "+ operatorType + " " + SecondInt);
			}else{
				int FirstInt = (int) (FirstNumber);
				isaInt = true;
				isbInt = false;
				System.out.println(FirstInt +" "+ operatorType + " " + SecondNumber);
				choice.setText(FirstInt +" "+ operatorType + " " + SecondNumber);
			}
		}else{
			if(SecondNumber % 1 == 0){
				int SecondInt = (int) (SecondNumber);
				isaInt = false;
				isbInt = true;
				System.out.println(FirstNumber +" "+ operatorType + " " + SecondInt);
				choice.setText(FirstNumber +" "+ operatorType + " " + SecondInt);
			}else{
				isaInt = false;
				isbInt = false;
				System.out.println(FirstNumber +" "+ operatorType + " " + SecondNumber);
				choice.setText(FirstNumber +" "+ operatorType + " " + SecondNumber);
			}
		}
		}else{
			if(FirstNumber % 1 == 0){
				if(SecondNumber % 1 == 0){
					int FirstInt = (int) (FirstNumber);
					isaInt = true;
					isbInt = true;
					System.out.println(FirstInt);
					choice.setText(FirstInt+"");
				}else{
					int FirstInt = (int) (FirstNumber);
					isaInt = true;
					isbInt = false;
					System.out.println(FirstInt);
					choice.setText(FirstInt+"");
				}
			}else{
				if(SecondNumber % 1 == 0){
					isaInt = false;
					isbInt = true;
					System.out.println(FirstNumber);
					choice.setText(FirstNumber +"");
				}else{
					isaInt = false;
					isbInt = false;
					System.out.println(FirstNumber);
					choice.setText(FirstNumber +"");
				}
			}
		
		
		}
	}
	
	//For operators
	
	public static void WhatToDo2(String args){
		switch(args){
		
			case ".":
				if(operator){
					dotb=true;
					
					
				}else{
					dota=true;
				}
				
				
				break;
				
			case "+":
				if(operator){
					break;
					
				}else{
					operator=true;
					operatorType="+";
					if(FirstNumber % 1 == 0){
						if(SecondNumber % 1 == 0){
							int FirstInt = (int) (FirstNumber);
							isaInt = true;
							isbInt = true;
							System.out.println(FirstInt +" "+ operatorType);
							choice.setText(FirstInt +" "+ operatorType);
						}else{
							int FirstInt = (int) (FirstNumber);
							isaInt = true;
							isbInt = false;
							System.out.println(FirstInt +" "+ operatorType);
							choice.setText(FirstInt +" "+ operatorType);
						}
					}else{
						if(SecondNumber % 1 == 0){
							isaInt = false;
							isbInt = true;
							System.out.println(FirstNumber +" "+ operatorType);
							choice.setText(FirstNumber +" "+ operatorType);
						}else{
							isaInt = false;
							isbInt = false;
							System.out.println(FirstNumber +" "+ operatorType);
							choice.setText(FirstNumber +" "+ operatorType);
						}
					}

				}
				
				
				break;
				
			case "-":
				if(operator){
					break;
					
				}else{
					operator=true;
					operatorType="-";
					if(FirstNumber % 1 == 0){
						if(SecondNumber % 1 == 0){
							int FirstInt = (int) (FirstNumber);
							isaInt = true;
							isbInt = true;
							System.out.println(FirstInt +" "+ operatorType);
							choice.setText(FirstInt +" "+ operatorType);
						}else{
							int FirstInt = (int) (FirstNumber);
							isaInt = true;
							isbInt = false;
							System.out.println(FirstInt +" "+ operatorType);
							choice.setText(FirstInt +" "+ operatorType);
						}
					}else{
						if(SecondNumber % 1 == 0){
							isaInt = false;
							isbInt = true;
							System.out.println(FirstNumber +" "+ operatorType);
							choice.setText(FirstNumber +" "+ operatorType);
						}else{
							isaInt = false;
							isbInt = false;
							System.out.println(FirstNumber +" "+ operatorType);
							choice.setText(FirstNumber +" "+ operatorType);
						}
					}

				}
				
				
				break;
				
			case "*":
				if(operator){
					break;
					
				}else{
					operator=true;
					operatorType="*";
					if(FirstNumber % 1 == 0){
						if(SecondNumber % 1 == 0){
							int FirstInt = (int) (FirstNumber);
							isaInt = true;
							isbInt = true;
							System.out.println(FirstInt +" "+ operatorType);
							choice.setText(FirstInt +" "+ operatorType);
						}else{
							int FirstInt = (int) (FirstNumber);
							isaInt = true;
							isbInt = false;
							System.out.println(FirstInt +" "+ operatorType);
							choice.setText(FirstInt +" "+ operatorType);
						}
					}else{
						if(SecondNumber % 1 == 0){
							isaInt = false;
							isbInt = true;
							System.out.println(FirstNumber +" "+ operatorType);
							choice.setText(FirstNumber +" "+ operatorType);
						}else{
							isaInt = false;
							isbInt = false;
							System.out.println(FirstNumber +" "+ operatorType);
							choice.setText(FirstNumber +" "+ operatorType);
						}
					}

				}
				
				
				break;
				
			case "/":
				if(operator){
					break;
					
				}else{
					operator=true;
					operatorType="/";
					if(FirstNumber % 1 == 0){
						if(SecondNumber % 1 == 0){
							int FirstInt = (int) (FirstNumber);
							isaInt = true;
							isbInt = true;
							System.out.println(FirstInt +" "+ operatorType);
							choice.setText(FirstInt +" "+ operatorType);
						}else{
							int FirstInt = (int) (FirstNumber);
							isaInt = true;
							isbInt = false;
							System.out.println(FirstInt +" "+ operatorType);
							choice.setText(FirstInt +" "+ operatorType);
						}
					}else{
						if(SecondNumber % 1 == 0){
							isaInt = false;
							isbInt = true;
							System.out.println(FirstNumber +" "+ operatorType);
							choice.setText(FirstNumber +" "+ operatorType);
						}else{
							isaInt = false;
							isbInt = false;
							System.out.println(FirstNumber +" "+ operatorType);
							choice.setText(FirstNumber +" "+ operatorType);
						}
					}
				}
				
				
				break;
				
			case "=":
				switch(operatorType){
				case "+":
					answer = FirstNumber + SecondNumber;
					if(answer % 1 == 0){
						IntAnswer = (int) (answer);
						System.out.println(IntAnswer);
						choice.setText(Integer.toString(IntAnswer));
					}else{
						System.out.println(answer);
						choice.setText(Double.toString(answer));
					}
					
					break;
				case "-":
					answer = FirstNumber - SecondNumber;
					if(answer % 1 == 0){
						IntAnswer = (int) (answer);
						System.out.println(IntAnswer);
						choice.setText(Integer.toString(IntAnswer));
					}else{
						System.out.println(answer);
						choice.setText(Double.toString(answer));
					}
					
					break;
				case "*":
					answer = FirstNumber * SecondNumber;
					if(answer % 1 == 0){
						IntAnswer = (int) (answer);
						System.out.println(IntAnswer);
						choice.setText(Integer.toString(IntAnswer));
					}else{
						System.out.println(answer);
						choice.setText(Double.toString(answer));
					}
					
					break;
				case "/":
					answer = FirstNumber / SecondNumber;
					if(answer % 1 == 0){
						IntAnswer = (int) (answer);
						System.out.println(IntAnswer);
						choice.setText(Integer.toString(IntAnswer));
					}else{
						System.out.println(answer);
						choice.setText(Double.toString(answer));
					}
					
					break;
				default:
					if(isaInt){
						System.out.println((int) (FirstNumber));
						choice.setText(Integer.toString((int) (FirstNumber)));
					}else{
						System.out.println(FirstNumber);
						choice.setText(Double.toString(FirstNumber));
					}
				}
				
				
				break;
				
		
		
			//I've done it so much now I have to. Even if it's useless
			default:
				AlertBox_GUI.display("Error...", "Something went wrong, this shouldn't be appearing...", "Return?", 300);
				break;
		}
	}
	
}


//I Know. It's long right?

















