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

public class Algorithms {
	
	//OLD AND UNUSED
	
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
	static Label Answer;
	
	
	public static void algs(){
		choice.setText("");
		FirstNumber=0;
		new ArrayList<Integer>();
		Stage window = new Stage();
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		window.setTitle("Algorithms Menu");
		window.initModality(Modality.APPLICATION_MODAL);
		
		GridPane.setConstraints(choice, 0, 1,3,1);
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
		
		Label header = new Label("Algorithms Menu");
		GridPane.setConstraints(header, 0, 0, 4, 1);
		/*Button Sort = new Button("Sort");
		GridPane.setConstraints(Sort, 4, 1);
		Button PCS = new Button("P.C.S");
		GridPane.setConstraints(PCS, 5, 1);*/
		Button Bubble = new Button("Bubble");
		GridPane.setConstraints(Bubble, 4, 1);
		Button Shuttle = new Button("Shuttle");
		GridPane.setConstraints(Shuttle, 5, 1);
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
		Hash.setOnAction(e -> {window.close();algs();choice.setText("");} );
		
		
		//I SAID UNUSED
		
		
		Bubble.setOnAction(e -> {
			if(!choice.getText().equals("")){
			Answer.setText(answer(Bubble(toList(Integer.parseInt(choice.getText())), 1)));
			List<Integer> pcs = new ArrayList<Integer>();
			pcs = Bubble(toList(Integer.parseInt(choice.getText())), 2);
			Passes.setText("Passes: "+Integer.toString(pcs.get(0)));
			Comps.setText("Comparisons: "+Integer.toString(pcs.get(1)));
			Swaps.setText("Swaps: "+Integer.toString(pcs.get(2)));
			}
		} );
		
		Shuttle.setOnAction(e -> {
			if(!choice.getText().equals("")){
			Answer.setText(answer(Shuttle(toList(Integer.parseInt(choice.getText())), 1)));
			List<Integer> pcs = new ArrayList<Integer>();
			pcs = Shuttle(toList(Integer.parseInt(choice.getText())), 2);
			Passes.setText("Passes: "+Integer.toString(pcs.get(0)));
			Comps.setText("Comparisons: "+Integer.toString(pcs.get(1)));
			Swaps.setText("Swaps: "+Integer.toString(pcs.get(2)));
			}
		} );
		
		gridpane.getChildren().addAll(One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Bubble, Shuttle, header,back,/*PCS,Sort,*/Answer,choice,Passes,Swaps,Comps,Hash);
		
		Scene this_ = new Scene(gridpane, 500, 250);
		window.setScene(this_);
		window.show();
		
	}
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
	
	public static List<Integer> toList(int num){
		List<Integer> list = new ArrayList<Integer>();
		int length = String.valueOf(num).length()+1;
		for(int x=1;x<length;x++){
			int z=x;
			int y = (int) (num%Math.pow(10, x));
			while(z!=1){
				y=y-list.get(z-2);
				z--;
			}
			list.add((int) (y/Math.pow(10, x-1)));
		}
		return back(list);
	}
	public static List<Integer> back(List<Integer> list){
		List<Integer> list2 = new ArrayList<Integer>();
		for(int x = list.size();x>0;x--){
			list2.add((int) (list.get(x-1)));
			
		}
		return list2;
	}
	
	//WHY ARE YOU STILL HERE?
	
	public static List<Integer> Bubble(List<Integer> list, int w){
		List<Integer> pcs = new ArrayList<Integer>();
		System.out.println(list);
		int var1;
		int var2;
		boolean go = true;
		int length = list.size()-1;
		int passes = 0;
		int comps = 0;
		int swaps = 0;
		while(go){
			System.out.println(list);
			if(length == 0){
				break;
			}
			go = false;
			if(passes<list.size()){
				passes++;
				System.out.println("Passes: "+passes);
			}
			for(int x=0;x<length;x++){
				var1 = (int) list.get(x);
				var2 = (int) list.get(x+1);
				if(var1>var2){
					comps++;
					swaps++;
					System.out.println("Comps: "+comps);
					System.out.println("Swaps: "+swaps);
					list.set(x, var2);
					list.set(x+1, var1);
					go = true;
				}else{
					comps++;
					System.out.println("Comps: "+comps);
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
	
	//THIS IS POINTLESS
	
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
		
		//IT'S NOT LIKE THERES A SECRET HERE
		
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
		//THIS ONE HAD NO SPACES, SO I REDID IT BETTER
		
		}
	}
}
