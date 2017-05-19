package questionareGui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Quiz1 {
	private static String math1 = "Incorrect";
	private static String math2 = "Incorrect";
	private static String math3 = "Incorrect";
	private static int totalmath = 0;
	private static String sci1 = "Incorrect";
	private static String sci2 = "Incorrect";
	private static String sci3 = "Incorrect";
	private static int totalsci = 0;
	private static String ict1 = "Incorrect";
	private static String ict2 = "Incorrect";
	private static String ict3 = "Incorrect";
	private static int totalict = 0;
	
	public static void mainmenu(){
		math1 = "Incorrect";
		math2 = "Incorrect";
		math3 = "Incorrect";
		totalmath = 0;
		sci1 = "Incorrect";
		sci2 = "Incorrect";
		sci3 = "Incorrect";
		totalsci = 0;
		ict1 = "Incorrect";
		ict2 = "Incorrect";
		ict3 = "Incorrect";
		totalict = 0;
		
		Stage window = new Stage();
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		window.setTitle("Quiz Main Menu");
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label header = new Label("Quiz Main Menu:");
		GridPane.setConstraints(header, 0, 0);
		Button quiz1 = new Button("Maths");
		GridPane.setConstraints(quiz1, 5, 10);
		Button quiz2 = new Button("Science");
		GridPane.setConstraints(quiz2, 10, 10);
		Button quiz3 = new Button("Computing");
		GridPane.setConstraints(quiz3, 15, 10);
		Button back = new Button("Return");
		GridPane.setConstraints(back, 20, 20);
		back.setOnAction(e -> {window.close();} );
		quiz1.setOnAction(e -> {maths();window.close();} );
		quiz2.setOnAction(e -> {science();window.close();} );
		quiz3.setOnAction(e -> {computing();window.close();} );
		
		gridpane.getChildren().addAll(quiz1,quiz2,quiz3, header,back);
		
		Scene this_ = new Scene(gridpane, 580, 250);
		window.setScene(this_);
		window.show();
		
		
		
	}
	public static void maths(){
		Stage window = new Stage();
		GridPane g1 = new GridPane();
		g1.setPadding(new Insets(10,10,10,10));
		g1.setVgap(8);
		g1.setHgap(10);
		
		window.setTitle("Maths Quiz");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
		Label header = new Label("Question 1:");
		GridPane.setConstraints(header, 0, 0);
		Label question = new Label("Factorise: (x+2)(x-5)(x-2)");
		GridPane.setConstraints(question, 0, 1);
		TextField answer = new TextField();
		GridPane.setConstraints(answer, 5, 10);
		Button next = new Button("Next");
		GridPane.setConstraints(next, 20, 18);
		
		GridPane g2 = new GridPane();
		g2.setPadding(new Insets(10,10,10,10));
		g2.setVgap(8);
		g2.setHgap(10);
		
		Label header2 = new Label("Question 2:");
		GridPane.setConstraints(header2, 0, 0);
		Label question2 = new Label("Find x. x+y=5 3y=9x+21");
		GridPane.setConstraints(question2, 0, 1);
		TextField answer2 = new TextField();
		GridPane.setConstraints(answer2, 5, 10);
		Button next2 = new Button("Next");
		GridPane.setConstraints(next2, 20, 18);
		g2.getChildren().addAll(answer2,question2, header2,next2);
		
		Scene q2 = new Scene(g2, 580, 250);
		
		GridPane g3 = new GridPane();
		g3.setPadding(new Insets(10,10,10,10));
		g3.setVgap(8);
		g3.setHgap(10);
		
		Label header3 = new Label("Question 3:");
		GridPane.setConstraints(header3, 0, 0);
		Label question3 = new Label("A Triangle has sides 7,8 and 10. Find the angle opposite 10");
		GridPane.setConstraints(question3, 0, 1, 11, 1);
		Label question3help = new Label("a2 = b2 + c2 - 2bc cos A");
		GridPane.setConstraints(question3help, 0, 2);
		TextField answer3 = new TextField();
		GridPane.setConstraints(answer3, 5, 6);
		Button calc = new Button("Calc");
		GridPane.setConstraints(calc, 15, 16);
		Button next3 = new Button("Next");
		GridPane.setConstraints(next3, 16, 16);
		g3.getChildren().addAll(answer3,question3,calc,question3help, header3,next3);
		
		Scene q3 = new Scene(g3, 580, 250);
		
		GridPane done = new GridPane();
		done.setPadding(new Insets(10,10,10,10));
		done.setVgap(8);
		done.setHgap(10);
		
		Label Title = new Label("Your Score:");
		GridPane.setConstraints(Title, 0, 0);
		Label ques1 = new Label("Question 1:");
		GridPane.setConstraints(ques1, 0, 1);
		Label ques2 = new Label("Question 2:");
		GridPane.setConstraints(ques2, 0, 3);
		Label ques3 = new Label("Question 3:");
		GridPane.setConstraints(ques3, 0, 5);
		Button back = new Button("Done");
		GridPane.setConstraints(back, 16, 8);
		
		done.getChildren().addAll(Title, ques1, ques2,ques3,back);
		
		Scene qdone = new Scene(done, 580, 250);
		
		
		back.setOnAction(e -> {window.close();mainmenu();});
		calc.setOnAction(e -> Calculator.calc());
		next.setOnAction(e -> {
			
			
			
		boolean mcorrect1 = false;
		if(answer.getText().equals("x3-5x2-4x+20")){
			mcorrect1 = true;
			math1 = "Correct";
			totalmath++;
		}
		
		if(mcorrect1){
			
			AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
			window.setScene(q2);
		}else{
			
			AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
			window.setScene(q2);
		}	
		} );
		
		
		next2.setOnAction(e -> {
			
			
			
			boolean mcorrect2 = false;
			if(answer2.getText().equals("3")){
				mcorrect2 = true;
				math2 = "Correct";
				totalmath++;
			}
			
			if(mcorrect2){
				
				AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
				window.setScene(q3);
			}else{
				
				AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
				window.setScene(q3);
			}	
		} );
		next3.setOnAction(e -> {
			
			
			
			boolean mcorrect3 = false;
			if(answer3.getText().equals("83") || answer3.getText().equals("cos-1(0.116)")){
				mcorrect3 = true;
				math3 = "Correct";
				totalmath++;
			}
			
			if(mcorrect3){
				
				AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
				Label qa1 = new Label(math1);
				Label qa2 = new Label(math2);
				Label qa3 = new Label(math3);
				GridPane.setConstraints(qa1, 0, 2);
				GridPane.setConstraints(qa2, 0, 4);
				GridPane.setConstraints(qa3, 0, 6);
				
				Label total = new Label("Your Score is: "+totalmath+"/3");
				GridPane.setConstraints(total, 0, 7);
				
				done.getChildren().addAll(qa1,qa2,qa3,total);
				window.setScene(qdone);
			}else{
				
				AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
				Label qa1 = new Label(math1);
				Label qa2 = new Label(math2);
				Label qa3 = new Label(math3);
				GridPane.setConstraints(qa1, 0, 2);
				GridPane.setConstraints(qa2, 0, 4);
				GridPane.setConstraints(qa3, 0, 6);
				
				Label total = new Label("Your Score is: "+totalmath+"/3");
				GridPane.setConstraints(total, 0, 7);
				
				done.getChildren().addAll(qa1,qa2,qa3,total);
				window.setScene(qdone);
			}	
		} );
		g1.getChildren().addAll(answer,question, header,next);
		
		Scene q1 = new Scene(g1, 580, 250);
		window.setScene(q1);
		window.show();
		
		
	}
	
	public static void science(){
		Stage window = new Stage();
		GridPane g1 = new GridPane();
		g1.setPadding(new Insets(10,10,10,10));
		g1.setVgap(8);
		g1.setHgap(10);
		
		window.setTitle("Science Quiz");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
		Label header = new Label("Question 1 - Biology:");
		GridPane.setConstraints(header, 0, 0);
		Label question = new Label("What happens at the Ribosomes?");
		GridPane.setConstraints(question, 0, 1, 11, 1);
		TextField answer = new TextField();
		GridPane.setConstraints(answer, 5, 10);
		Button next = new Button("Next");
		GridPane.setConstraints(next, 20, 18);
		
		GridPane g2 = new GridPane();
		g2.setPadding(new Insets(10,10,10,10));
		g2.setVgap(8);
		g2.setHgap(10);
		
		Label header2 = new Label("Question 2 - Chemestry:");
		GridPane.setConstraints(header2, 0, 0);
		Label question2 = new Label("Metal can react to produce an oxide. What type of bond does this create?");
		GridPane.setConstraints(question2, 0, 1, 11, 1);
		TextField answer2 = new TextField();
		GridPane.setConstraints(answer2, 5, 10);
		Button next2 = new Button("Next");
		GridPane.setConstraints(next2, 20, 18);
		g2.getChildren().addAll(answer2,question2, header2,next2);
		
		Scene q2 = new Scene(g2, 580, 250);
		
		GridPane g3 = new GridPane();
		g3.setPadding(new Insets(10,10,10,10));
		g3.setVgap(8);
		g3.setHgap(10);
		
		Label header3 = new Label("Question 3 - Physics:");
		GridPane.setConstraints(header3, 0, 0);
		Label question3 = new Label("What is alpha radiation made of?");
		GridPane.setConstraints(question3, 0, 1, 11, 1);
		TextField answer3 = new TextField();
		GridPane.setConstraints(answer3, 5, 6);
		Button next3 = new Button("Next");
		GridPane.setConstraints(next3, 16, 16);
		g3.getChildren().addAll(answer3,question3, header3,next3);
		
		Scene q3 = new Scene(g3, 580, 250);
		
		GridPane done = new GridPane();
		done.setPadding(new Insets(10,10,10,10));
		done.setVgap(8);
		done.setHgap(10);
		
		Label Title = new Label("Your Score:");
		GridPane.setConstraints(Title, 0, 0);
		Label ques1 = new Label("Question 1:");
		GridPane.setConstraints(ques1, 0, 1);
		Label ques2 = new Label("Question 2:");
		GridPane.setConstraints(ques2, 0, 3);
		Label ques3 = new Label("Question 3:");
		GridPane.setConstraints(ques3, 0, 5);
		Button back = new Button("Done");
		GridPane.setConstraints(back, 16, 8);
		
		done.getChildren().addAll(Title, ques1, ques2,ques3,back);
		
		Scene qdone = new Scene(done, 580, 250);
		
		
		back.setOnAction(e -> {window.close();mainmenu();});
		next.setOnAction(e -> {
			
			
			
		boolean scorrect1 = false;
		if(answer.getText().toUpperCase().equals("PROTEIN SYNTHESIS")){
			scorrect1 = true;
			sci1 = "Correct";
			totalsci++;
		}
		
		if(scorrect1){
			
			AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
			window.setScene(q2);
		}else{
			
			AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
			window.setScene(q2);
		}	
		} );
		
		
		next2.setOnAction(e -> {
			
			
			
			boolean scorrect2 = false;
			if(answer2.getText().toUpperCase().equals("IONIC")){
				scorrect2 = true;
				sci2 = "Correct";
				totalsci++;
			}
			
			if(scorrect2){
				
				AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
				window.setScene(q3);
			}else{
				
				AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
				window.setScene(q3);
			}	
		} );
		next3.setOnAction(e -> {
			
			
			
			boolean scorrect3 = false;
			if(answer3.getText().toUpperCase().equals("A HELIUM NUCLEUS")){
				scorrect3 = true;
				sci3 = "Correct";
				totalsci++;
			}
			
			if(scorrect3){
				
				AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
				Label qa1 = new Label(sci1);
				Label qa2 = new Label(sci2);
				Label qa3 = new Label(sci3);
				GridPane.setConstraints(qa1, 0, 2);
				GridPane.setConstraints(qa2, 0, 4);
				GridPane.setConstraints(qa3, 0, 6);
				
				Label total = new Label("Your Score is: "+totalsci+"/3");
				GridPane.setConstraints(total, 0, 7);
				
				done.getChildren().addAll(qa1,qa2,qa3,total);
				window.setScene(qdone);
			}else{
				
				AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
				Label qa1 = new Label(sci1);
				Label qa2 = new Label(sci2);
				Label qa3 = new Label(sci3);
				GridPane.setConstraints(qa1, 0, 2);
				GridPane.setConstraints(qa2, 0, 4);
				GridPane.setConstraints(qa3, 0, 6);
				
				Label total = new Label("Your Score is: "+totalsci+"/3");
				GridPane.setConstraints(total, 0, 7);
				
				done.getChildren().addAll(qa1,qa2,qa3,total);
				window.setScene(qdone);
			}	
		} );
		g1.getChildren().addAll(answer,question, header,next);
		
		Scene q1 = new Scene(g1, 580, 250);
		window.setScene(q1);
		window.show();
		
		
		
		
	}
	
	public static void computing(){
		Stage window = new Stage();
		GridPane g1 = new GridPane();
		g1.setPadding(new Insets(10,10,10,10));
		g1.setVgap(8);
		g1.setHgap(10);
		
		window.setTitle("ICT Quiz");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
		Label header = new Label("Question 1:");
		GridPane.setConstraints(header, 0, 0);
		Label question = new Label("What language was this made in?");
		GridPane.setConstraints(question, 0, 1, 11, 1);
		TextField answer = new TextField();
		GridPane.setConstraints(answer, 14, 10);
		Button next = new Button("Next");
		GridPane.setConstraints(next, 25, 18);
		
		GridPane g2 = new GridPane();
		g2.setPadding(new Insets(10,10,10,10));
		g2.setVgap(8);
		g2.setHgap(10);
		
		Label header2 = new Label("Question 2:");
		GridPane.setConstraints(header2, 0, 0);
		Label question2 = new Label("What is used to test for an error?");
		GridPane.setConstraints(question2, 0, 1, 11, 1);
		TextField answer2 = new TextField();
		GridPane.setConstraints(answer2, 14, 10);
		Button next2 = new Button("Next");
		GridPane.setConstraints(next2, 25, 18);
		g2.getChildren().addAll(answer2,question2, header2,next2);
		
		Scene q2 = new Scene(g2, 580, 250);
		
		GridPane g3 = new GridPane();
		g3.setPadding(new Insets(10,10,10,10));
		g3.setVgap(8);
		g3.setHgap(10);
		
		Label header3 = new Label("Question 3:");
		GridPane.setConstraints(header3, 0, 0);
		Label question3 = new Label("What are the different tabs?");
		GridPane.setConstraints(question3, 0, 1, 11, 1);
		Label question3help = new Label("(In Eclispe)");
		GridPane.setConstraints(question3help, 0, 2);
		TextField answer3 = new TextField();
		GridPane.setConstraints(answer3, 14, 6);
		Button next3 = new Button("Next");
		GridPane.setConstraints(next3, 25, 16);
		g3.getChildren().addAll(answer3,question3,question3help, header3,next3);
		
		Scene q3 = new Scene(g3, 580, 250);
		
		GridPane done = new GridPane();
		done.setPadding(new Insets(10,10,10,10));
		done.setVgap(8);
		done.setHgap(10);
		
		Label Title = new Label("Your Score:");
		GridPane.setConstraints(Title, 0, 0);
		Label ques1 = new Label("Question 1:");
		GridPane.setConstraints(ques1, 0, 1);
		Label ques2 = new Label("Question 2:");
		GridPane.setConstraints(ques2, 0, 3);
		Label ques3 = new Label("Question 3:");
		GridPane.setConstraints(ques3, 0, 5);
		Button back = new Button("Done");
		GridPane.setConstraints(back, 16, 8);
		
		done.getChildren().addAll(Title, ques1, ques2,ques3,back);
		
		Scene qdone = new Scene(done, 580, 250);
		
		
		back.setOnAction(e -> {window.close();mainmenu();});
		next.setOnAction(e -> {
			
			
			
		boolean ccorrect1 = false;
		if(answer.getText().toUpperCase().equals("JAVA")){
			ccorrect1 = true;
			ict1 = "Correct";
			totalict++;
		}
		
		if(ccorrect1){
			
			AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
			window.setScene(q2);
		}else{
			
			AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
			window.setScene(q2);
		}	
		} );
		
		
		next2.setOnAction(e -> {
			
			
			
			boolean ccorrect2 = false;
			if(answer2.getText().toUpperCase().equals("TRY")){
				ccorrect2 = true;
				ict2 = "Correct";
				totalict++;
			}
			
			if(ccorrect2){
				
				AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
				window.setScene(q3);
			}else{
				
				AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
				window.setScene(q3);
			}	
		} );
		next3.setOnAction(e -> {
			
			
			
			boolean ccorrect3 = false;
			if(answer3.getText().toUpperCase().equals("CLASSES")){
				ccorrect3 = true;
				ict3 = "Correct";
				totalict++;
			}
			
			if(ccorrect3){
				
				AlertBox_GUI.display("Correct", "Well Done, you got it right", "Continue", 300);
				Label qa1 = new Label(ict1);
				Label qa2 = new Label(ict2);
				Label qa3 = new Label(ict3);
				GridPane.setConstraints(qa1, 0, 2);
				GridPane.setConstraints(qa2, 0, 4);
				GridPane.setConstraints(qa3, 0, 6);
				
				Label total = new Label("Your Score is: "+totalict+"/3");
				GridPane.setConstraints(total, 0, 7);
				
				done.getChildren().addAll(qa1,qa2,qa3,total);
				window.setScene(qdone);
			}else{
				
				AlertBox_GUI.display("Incorrect", "Better Luck next time", "Continue", 300);
				Label qa1 = new Label(ict1);
				Label qa2 = new Label(ict2);
				Label qa3 = new Label(ict3);
				GridPane.setConstraints(qa1, 0, 2);
				GridPane.setConstraints(qa2, 0, 4);
				GridPane.setConstraints(qa3, 0, 6);
				
				Label total = new Label("Your Score is: "+totalict+"/3");
				GridPane.setConstraints(total, 0, 7);
				
				done.getChildren().addAll(qa1,qa2,qa3,total);
				window.setScene(qdone);
			}	
		} );
		g1.getChildren().addAll(answer,question, header,next);
		
		Scene q1 = new Scene(g1, 580, 250);
		window.setScene(q1);
		window.show();
		
		
		
		
	}
}




















