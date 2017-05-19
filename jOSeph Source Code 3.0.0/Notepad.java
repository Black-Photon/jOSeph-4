package questionareGui;

import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Notepad {
	public static Stage window;
	public static String[] text;
	public static TextField info1;
	public static TextField info2;
	public static TextField info3;
	public static TextField info4;
	public static TextField info5;
	public static void notes(){
		//Sets the notepad text to what's saved decrypted (It's saved encrypted so you need to be logged in)
		String[] text = decrypt(CreateNotepad.load(false,null));
		Stage window = new Stage();
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		window.setTitle("Notepad");
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label head = new Label("Welcome to your notepad, "+Generator4.user);
		GridPane.setConstraints(head, 0, 0,20,1);
		TextField info1 = new TextField(text[0]);
		GridPane.setConstraints(info1, 0, 1,40,1);
		TextField info2 = new TextField(text[1]);
		GridPane.setConstraints(info2, 0, 2,40,1);
		TextField info3 = new TextField(text[2]);
		GridPane.setConstraints(info3, 0, 3,40,1);
		TextField info4 = new TextField(text[3]);
		GridPane.setConstraints(info4, 0, 4,40,1);
		TextField info5 = new TextField(text[4]);
		GridPane.setConstraints(info5, 0, 5,40,1);
		Button Cancel = new Button("Cancel");
		GridPane.setConstraints(Cancel, 0, 20);
		Button save = new Button("Save");
		GridPane.setConstraints(save, 1, 20);
		Cancel.setOnAction(e -> {window.close();} );
		//Saves
		save.setOnAction(e -> {
				text[0] = info1.getText();
				text[1] = info2.getText();
				text[2] = info3.getText();
				text[3] = info4.getText();
				text[4] = info5.getText();
				//Encrypts the text when saving
				CreateNotepad.load(true, encrypt(text));
				window.close();
		} );
		
		gridpane.getChildren().addAll(info1,info2,info3,info4, info5, head,Cancel, save);
		
		Scene this_ = new Scene(gridpane, 600, 350);
		window.setScene(this_);
		window.show();
	}
	
	//Encryption algorithm (which I made :D)
	
	public static String[] encrypt(String[] x){
		Random rand = new Random();
		for(int y = 0;y<x.length;y++){
			String in1 = x[y];
	        String in2 = Generator4.user;
	        String ans = "";
	        
	        int count = 0;
	        int keycount = 0;
	        while (count<(in1).length()){
	            if(rand.nextInt(2)<2){
	                ans += in1.charAt(count);
	                ans += in2.charAt(keycount);
	                count++;
	                keycount++;
	                if(keycount==in2.length()){
	                    keycount=0;
	                }
				}else{
					ans += in2.charAt(keycount);
		            keycount++;
		            if(keycount==in2.length()){
		                keycount=0;
		            }
				}
	        }
			x[y] = ans;
		}
		
		return x;
	}
	
	//Decryption algorithm (Which I also made)
	
public static String[] decrypt(String[] x){
	new Random();
	for(int y = 0;y<x.length;y++){
		 String in1 = x[y];
	        String in2 = Generator4.user;
	        String ans = "";
	        
	        int count = 0;
	        int keycount = 0;
	        while (count<(in1).length()){
	            if(in1.charAt(count)==in2.charAt(keycount)){
	                count++;
	                keycount++;
	                if(keycount==in2.length()){
	                    keycount=0;
	                }
				}else{
					ans+=in1.charAt(count);
					count++;
				}
	        }
	        x[y] = ans;
	}
	
	return x;
	}
}
