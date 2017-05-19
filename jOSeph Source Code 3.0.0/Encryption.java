package questionareGui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Random;

public class Encryption {
	public static void main(){
		//Set's up the window
		Stage window = new Stage();
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		window.setTitle("Encryption Menu");
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label header = new Label("Encryption Menu");
		GridPane.setConstraints(header, 0, 0);
		Button Encrypt = new Button("Encrypt");
		GridPane.setConstraints(Encrypt, 5, 10);
		Button Decrypt = new Button("Decrypt");
		GridPane.setConstraints(Decrypt, 10, 10);
		Button back = new Button("Return");
		GridPane.setConstraints(back, 15, 20);
		back.setOnAction(e -> {window.close();} );
		Encrypt.setOnAction(e -> {encrypt();window.close();} );
		Decrypt.setOnAction(e -> {decrypt();window.close();} );
		
		gridpane.getChildren().addAll(Encrypt,Decrypt, header,back);
		
		Scene this_ = new Scene(gridpane, 500, 250);
		window.setScene(this_);
		window.show();
		
		
		
		
	}
	//Encrypts
	public static void encrypt(){
		Stage window = new Stage();
		
		window.setTitle("Encrypt");
		window.setOnCloseRequest(e -> {main();});
		window.initModality(Modality.APPLICATION_MODAL);
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		Label en_Label = new Label("What to Encrypt: ");
		GridPane.setConstraints(en_Label, 0, 0);
		TextField en_Input = new TextField();
		en_Input.setPromptText("Enter Input");
		GridPane.setConstraints(en_Input, 1, 0,50,1);
		
		Label key_Label = new Label("Keycode: ");
		GridPane.setConstraints(key_Label, 0, 1);
		TextField key_Input = new TextField("");
		key_Input.setPromptText("Enter Keycode");
		GridPane.setConstraints(key_Input, 1, 1,50,1);
		
		Button login = new Button("Encode");
		GridPane.setConstraints(login, 1, 3);
		
		TextField out = new TextField("");
		GridPane.setConstraints(out, 1, 4,50,1);
		
		gridpane.getChildren().addAll(en_Label,en_Input,key_Label,key_Input,login,out);

		
		window.setScene(new Scene(gridpane));
		window.show();
		
		Random rand = new Random();
		
		//Randomly places letters from the key code between the message
		
		login.setOnAction(e -> {
	        String in1 = en_Input.getText().toUpperCase();
	        String in2 = key_Input.getText().toUpperCase();
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
			out.setText(ans);
		});
	}
	
	//Decrypts
	
	public static void decrypt(){
		Stage window = new Stage();
		
		window.setTitle("Decrypt");
		window.setOnCloseRequest(e -> {main();});
		window.initModality(Modality.APPLICATION_MODAL);
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		Label en_Label = new Label("What to Decrypt: ");
		GridPane.setConstraints(en_Label, 0, 0);
		TextField en_Input = new TextField();
		en_Input.setPromptText("Enter Code");
		GridPane.setConstraints(en_Input, 1, 0,50,1);
		
		Label key_Label = new Label("Keycode: ");
		GridPane.setConstraints(key_Label, 0, 1);
		TextField key_Input = new TextField("");
		key_Input.setPromptText("Enter Keycode");
		GridPane.setConstraints(key_Input, 1, 1,50,1);
		
		Button login = new Button("Decode");
		GridPane.setConstraints(login, 1, 3);
		
		TextField out = new TextField("");
		GridPane.setConstraints(out, 1, 4,50,1);
		
		gridpane.getChildren().addAll(en_Label,en_Input,key_Label,key_Input,login,out);

		
		window.setScene(new Scene(gridpane));
		window.show();
		
		new Random();
		
		//Removes ordered keycode letters from the encrypted message. Requires the correct keycode
		
		login.setOnAction(e -> {
	        String in1 = en_Input.getText().toUpperCase();
	        String in2 = key_Input.getText().toUpperCase();
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
			out.setText(ans);
		});
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
