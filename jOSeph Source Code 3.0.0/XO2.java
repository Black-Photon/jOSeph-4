package questionareGui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class XO2 {
	static String turn;
	static Stage window;
	static boolean win_ = false;
	public static void OX(){
		win_ = false;
		turn = "O";
		window = new Stage();
		GridPane menu1gridpane = new GridPane();
		menu1gridpane.setPadding(new Insets(10,10,10,10));
		menu1gridpane.setVgap(8);
		menu1gridpane.setHgap(10);
		
		window.setTitle("Noughts and Crosses");
		
		
		Label who = new Label("Welcome to Noughts and crosses. Right now it is " + turn + "'s turn");
		GridPane.setConstraints(who, 0, 0,5,1);
		
		//Yup
		Button one = new Button(" ");
		GridPane.setConstraints(one, 0, 1);
		Button two = new Button(" ");
		GridPane.setConstraints(two, 1, 1);
		Button three = new Button(" ");
		GridPane.setConstraints(three, 2, 1);
		Button four = new Button(" ");
		GridPane.setConstraints(four, 0, 2);
		Button five = new Button(" ");
		GridPane.setConstraints(five, 1, 2);
		Button six = new Button(" ");
		GridPane.setConstraints(six, 2, 2);
		Button seven = new Button(" ");
		GridPane.setConstraints(seven, 0, 3);
		Button eight = new Button(" ");
		GridPane.setConstraints(eight, 1, 3);
		Button nine = new Button(" ");
		GridPane.setConstraints(nine, 2, 3);
		
		Button Exit = new Button("Exit");
		GridPane.setConstraints(Exit, 4, 3);
		Button Reset = new Button("Reset");
		GridPane.setConstraints(Reset, 4, 2);
		menu1gridpane.getChildren().addAll(Reset,Exit,who,one,two,three,four,five,six,seven,eight,nine);
		
		Scene menu = new Scene(menu1gridpane, 800, 200);
		window.setScene(menu);
		window.show();
		
		one.setOnAction(e -> what_to_do(who,one,one,two,three,four,five,six,seven,eight,nine) );
		two.setOnAction(e -> what_to_do(who,two,one,two,three,four,five,six,seven,eight,nine) );
		three.setOnAction(e -> what_to_do(who,three,one,two,three,four,five,six,seven,eight,nine) );
		four.setOnAction(e -> what_to_do(who,four,one,two,three,four,five,six,seven,eight,nine) );
		five.setOnAction(e -> what_to_do(who,five,one,two,three,four,five,six,seven,eight,nine) );
		six.setOnAction(e -> what_to_do(who,six,one,two,three,four,five,six,seven,eight,nine) );
		seven.setOnAction(e -> what_to_do(who,seven,one,two,three,four,five,six,seven,eight,nine) );
		eight.setOnAction(e -> what_to_do(who,eight,one,two,three,four,five,six,seven,eight,nine) );
		nine.setOnAction(e -> what_to_do(who,nine,one,two,three,four,five,six,seven,eight,nine) );
		Reset.setOnAction(e -> {window.close();XO2.OX();} );
		Exit.setOnAction(e -> {window.close();Generator4.page2();} );
		
		
		
		
		
	}
	public static void what_to_do(Label who,Button b, Button one, Button two, Button three, Button four, Button five, Button six, Button seven, Button eight, Button nine){
		if(b.getText()==" "){
			b.setText(turn);
			if (turn == "O"){
				turn = "X";
				
				
			}else{
				turn = "O";
				
			}
			who.setText("Welcome to Noughts and crosses. Right now it is " + turn + "'s turn");
			
			String _1 = one.getText();
			String _2 = two.getText();
			String _3 = three.getText();
			String _4 = four.getText();
			String _5 = five.getText();
			String _6 = six.getText();
			String _7 = seven.getText();
			String _8 = eight.getText();
			String _9 = nine.getText();
			
			if(b.getText()=="X"){
				if(_1 == "X" && _2 == "X" && _3 == "X"){
					win("X");
					win_ = true;
				}
				if(_1 == "X" && _4 == "X" && _7 == "X"){
					win("X");
					win_ = true;
				}
				if(_1 == "X" && _5 == "X" && _9 == "X"){
					win("X");
					win_ = true;
				}
				if(_7 == "X" && _5 == "X" && _3 == "X"){
					win("X");
					win_ = true;
				}
				if(_2 == "X" && _5 == "X" && _8 == "X"){
					win("X");
					win_ = true;
				}
				if(_4 == "X" && _5 == "X" && _6 == "X"){
					win("X");
					win_ = true;
				}
				if(_3 == "X" && _6 == "X" && _9 == "X"){
					win("X");
					win_ = true;
				}
				if(_7 == "X" && _8 == "X" && _9 == "X"){
					win("X");
					win_ = true;
				}
			}else{
				if(_1 == "O" && _2 == "O" && _3 == "O"){
					win("O");
					win_ = true;
				}
				if(_1 == "O" && _4 == "O" && _7 == "O"){
					win("O");
					win_ = true;
				}
				if(_1 == "O" && _5 == "O" && _9 == "O"){
					win("O");
					win_ = true;
				}
				if(_7 == "O" && _5 == "O" && _3 == "O"){
					win("O");
					win_ = true;
				}
				if(_2 == "O" && _5 == "O" && _8 == "O"){
					win("O");
					win_ = true;
				}
				if(_4 == "O" && _5 == "O" && _6 == "O"){
					win("O");
					win_ = true;
				}
				if(_3 == "O" && _6 == "O" && _9 == "O"){
					win("O");
					win_ = true;
				}
				if(_7 == "O" && _8 == "O" && _9 == "O"){
					win("O");
					win_ = true;
				}
			}
			if(win_ == false){
				if(_1 != " " && _2 != " " && _3 != " " && _4 != " " && _5 != " " && _6 != " " && _7 != " " && _8 != " " && _9 != " "){
					AlertBox_GUI.display("NO WINNER", "It's a draw!", "Reset", 500);
					window.close();
					OX();
				}
				
			}
			
		}
		}
	public static void win(String win){
		String ThisString = "And the winner is "+ win;
		AlertBox_GUI.display("WINNER", ThisString, "Reset", 500);
		window.close();
		OX();
		
	}
		
		
		
		
		
		
		
		
		
		
	}
	
	

















