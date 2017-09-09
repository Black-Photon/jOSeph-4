package jOSeph_4;

import jOSeph_4.messageBoxes.Error;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Password {

	private static boolean correct = false;

	private static Stage stage;

	public static boolean isPasswordCorrect(String userText, String passText){
		passText = Encryption.hashEncrypt(passText);
		if(Variable.getDatabase().get(userText)==null){
			new Error("Please enter valid username",400);

			//If database password = password, start loading
		}else if(userText.equals("")){
			//If username empty, give relevant error message
			new Error("Please enter username",400);

			//If database password = password, start loading
		}else if(Variable.getDatabase().get(userText).equals(passText)){
			return true;

			//If password empty, give relevant error message
		}else if(passText.equals("")){
			new Error("Please Enter Password",300);

			//For Wrong Password this is what's given out
		}else if(!(Variable.getDatabase().get(userText).equals(passText))){
			new Error("Your password seems to be incorrect",400);
		}else{
			new Error("Something went wrong! Please contact admin. Error #0001",500);
		}
		return false;
	}

	public static void createConfirmBox(){
		stage = new Stage();
		Main.createWindow("Confirm_Password.fxml", stage, "Confirm Password");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
	}

	public static boolean isCorrect() {
		return correct;
	}

	public static void setCorrect(boolean correct) {
		Password.correct = correct;
	}

	public static void closeStage() {
		stage.close();
	}
}
