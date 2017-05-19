package questionareGui;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Algorithms_2 {
	
	static double FirstNumber = 0;
	static double SecondNumber = 0;
	static boolean dota = false;
	static boolean dotb = false;
	static int dotaPlaces = 1;
	static int dotbPlaces = 1;
	static String operatorType = "";
	static boolean isaInt = false;
	static boolean isbInt = false;
	static double answer = 0.0;
	static String answerText = "";
	static int IntAnswer = 0;
	static TextField choice = new TextField();
	static Label Answer;
	
	//Did this in Decision 1 Maths at school, so why not here too? :D
	
	
	public static void algs(){
		//Setting up variables and the window. The layout too!
		choice.setText("");
		FirstNumber=0;
		answerText = "";
		Stage window = new Stage();
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		window.setTitle("Algorithms Menu");
		window.initModality(Modality.APPLICATION_MODAL);
		
		GridPane.setConstraints(choice, 0, 1,6,1);
		choice.setPrefWidth(1);
		Button One = new Button("1");
		Button Two = new Button("2");
		Button Three = new Button("3");
		Button Four = new Button("4");
		Button Five = new Button("5");
		Button Six = new Button("6");
		Button Seven = new Button("7");
		Button Eight = new Button("8");
		GridPane.setConstraints(One, 0, 2);
		GridPane.setConstraints(Two, 1, 2);
		GridPane.setConstraints(Three, 2, 2);
		GridPane.setConstraints(Four, 0, 3);
		GridPane.setConstraints(Five, 1, 3);
		GridPane.setConstraints(Six, 2, 3);
		GridPane.setConstraints(Seven, 0, 4);
		GridPane.setConstraints(Eight, 1, 4);
		Button Nine = new Button("9");
		Button Zero = new Button("0");
		Button Hash = new Button("#");
		GridPane.setConstraints(Nine, 2, 4);
		GridPane.setConstraints(Zero, 1, 5);
		GridPane.setConstraints(Hash, 2, 5);
		Button Space = new Button("  ");
		GridPane.setConstraints(Space, 0, 5);
		
		Label header = new Label("Algorithms Menu");
		GridPane.setConstraints(header, 0, 0, 4, 1);
		/*Button Sort = new Button("Sort");
		GridPane.setConstraints(Sort, 4, 1);
		Button PCS = new Button("P.C.S");
		GridPane.setConstraints(PCS, 5, 1);*/
		Button Bubble = new Button("Bubble");
		GridPane.setConstraints(Bubble, 4, 2);
		Button Shuttle = new Button("Shuttle");
		GridPane.setConstraints(Shuttle, 5, 2);
		Button back = new Button("Return");
		GridPane.setConstraints(back, 25, 8);
		back.setOnAction(e -> {window.close();} );
		Label Answer = new Label();
		GridPane.setConstraints(Answer, 4, 3, 6, 3);
		Label Passes = new Label("Passes:");
		GridPane.setConstraints(Passes, 6, 0,10,3);
		Label Comps = new Label("Comparisons:");
		GridPane.setConstraints(Comps, 6, 1,10,3);
		Label Swaps = new Label("Swaps:");
		GridPane.setConstraints(Swaps, 6, 2,10,3);
		//PCS.setOnAction(e -> {});
		//Sort.setOnAction(e -> {});
		
		
		//I wonder what each button does...?
		One.setOnAction(e -> WhatToDo("1") );
		Two.setOnAction(e -> WhatToDo("2") );
		Three.setOnAction(e -> WhatToDo("3") );
		Four.setOnAction(e -> WhatToDo("4") );
		Five.setOnAction(e -> WhatToDo("5") );
		Six.setOnAction(e -> WhatToDo("6") );
		Seven.setOnAction(e -> WhatToDo("7") );
		Eight.setOnAction(e -> WhatToDo("8") );
		Nine.setOnAction(e -> WhatToDo("9") );
		Zero.setOnAction(e -> WhatToDo("0") );
		Hash.setOnAction(e -> {window.close();algs();choice.setText("");} );
		Space.setOnAction(e -> WhatToDo(" ") );
		
		//Useless Test Stuffs (It took FOREVER to fix. Still not as bad as the loading bar)
		List<Integer> trial = new ArrayList<Integer>();
		trial.add(6);
		trial.add(3);
		trial.add(5);
		trial.add(2);
		
		Bubble.setOnAction(e -> {
			if(!choice.getText().equals("")){
			Answer.setText(answer(Bubble(toList(choice.getText()), 1)));
			List<Integer> pcs = new ArrayList<Integer>();
			pcs = Bubble(toList(choice.getText()), 2);
			Passes.setText("Passes: "+Integer.toString(pcs.get(0)));
			Comps.setText("Comparisons: "+Integer.toString(pcs.get(1)));
			Swaps.setText("Swaps: "+Integer.toString(pcs.get(2)));
			}
		} );
		
		Shuttle.setOnAction(e -> {
			if(!choice.getText().equals("")){
			Answer.setText(answer(Shuttle(toList(choice.getText()), 1)));
			List<Integer> pcs = new ArrayList<Integer>();
			pcs = Shuttle(toList(choice.getText()), 2);
			Passes.setText("Passes: "+Integer.toString(pcs.get(0)));
			Comps.setText("Comparisons: "+Integer.toString(pcs.get(1)));
			Swaps.setText("Swaps: "+Integer.toString(pcs.get(2)));
			}
		} );
		
		gridpane.getChildren().addAll(One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Bubble, Shuttle, header,back,/*PCS,Sort,*/Answer,choice,Passes,Swaps,Comps,Hash,Space);
		
		Scene this_ = new Scene(gridpane, 500, 250);
		window.setScene(this_);
		window.show();
		
	}
	//List to Text
	public static String answer(List<Integer> list){
		StringBuilder sb = new StringBuilder();
		
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2 = list;
		for (int s : list2){
		    sb.append(Integer.toString(s));
		    sb.append(" ");
		}
		return sb.toString();
	}
	//Text to List
	public static List<Integer> toList(String in){
		List<Integer> list8 = new ArrayList<Integer>();
		int temp = 0;
		for(int x=0; x<in.length();x++){
			if(!(Character.toString(in.charAt(x)).toString().equals(" "))){
				//If the character isn't a space
				temp*=10;
				temp += Integer.parseInt(Character.toString(in.charAt(x)).toString());
				if(x==in.length()-1){
					list8.add(temp);
				}
				
			}else{
				//If the character is a space
				list8.add(temp);
				temp = 0;
			}
		}
		return list8;
	}
	//The bubble algorithm!!
	public static List<Integer> Bubble(List<Integer> list, int w){
		List<Integer> pcs = new ArrayList<Integer>();
		int var1;
		int var2;
		boolean go = true;
		int length = list.size()-1;
		int passes = 0;
		int comps = 0;
		int swaps = 0;
		while(go){
			if(length == 0){
				break;
			}
			go = false;
			if(passes<list.size()){
				passes++;
			}
			for(int x=0;x<length;x++){
				var1 = (int) list.get(x);
				var2 = (int) list.get(x+1);
				if(var1>var2){
					comps++;
					swaps++;
					list.set(x, var2);
					list.set(x+1, var1);
					go = true;
				}else{
					comps++;
				}	
			}
		if(length!=0){	
			length--;
		}
		}
		pcs.add(passes);
		pcs.add(comps);
		pcs.add(swaps);
		if(w==1){
			return list;
		}else{
			return pcs;
			
		}
	}
	//The shuttle (3,2,1... WE HAVE LIFT OFF) algorithm
	public static List<Integer> Shuttle(List<Integer> list, int w){
		List<Integer> pcs = new ArrayList<Integer>();
		int var1;
		int var2;
		int length = list.size()-1;
		int passes = 0;
		int comps = 0;
		int swaps = 0;
		int y = 0;
		int temp_y;
		
		for(int x=0;x<length;x++){
			temp_y = y;
			if(y<x){y=x;}
			var1 = (int) list.get(x);
			var2 = (int) list.get(x+1);
			if(var1>var2){
				comps++;
				swaps++;
				list.set(x, var2);
				list.set(x+1, var1);
				if (x!=0){
					x-=2;
				}else{
					x=y;
				}
			}else{
				comps++;
				x=y;
			}

			if(temp_y!=y || y==0){
				passes++;
			}	
		}
		pcs.add(passes);
		pcs.add(comps);
		pcs.add(swaps);
		if(w==1){
			return list;
		}else{
			return pcs;
			
		}
	}
	
	//Adds the number to the text box if you click it (8)
	public static void WhatToDo(String args){
		answerText += args;
		choice.setText(answerText);
		
	}
}
