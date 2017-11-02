package jOSeph_4;

import jOSeph_4.messageBoxes.sourceFiles.Error;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controls the password system, with methods to do with everything
 */
public class Password {

	/**
	 * Is the password correct
	 */
	private static boolean correct = false;

	private static Stage stage;

	/**
	 * Checks if the password is correct giving errors if not
	 * @param userText Username to test
	 * @param passText Password to test
	 * @return True if the password and username are in the database
	 */
	public static boolean isPasswordCorrect(String userText, String passText){
		//Security!
		passText = Encryption.hashEncrypt(passText);
		if(Variable.getDatabase().get(userText)==null){
			new Error("Please enter valid username",400).showModalWindow();

			//If database password = password, start loading
		}else if(userText.equals("")){
			//If username empty, give relevant error message
			new Error("Please enter username",400).showModalWindow();

			//If database password = password, start loading
		}else if(Variable.getDatabase().get(userText).equals(passText)){
			return true;

			//If password empty, give relevant error message
		}else if(passText.equals("")){
			new Error("Please Enter Password",300).showModalWindow();

			//For Wrong Password this is what's given out
		}else if(!(Variable.getDatabase().get(userText).equals(passText))){
			new Error("Your password seems to be incorrect",400).showModalWindow();
		}else{
			new Error("Something went wrong! Please contact admin. Error #0001",500).showModalWindow();
		}
		return false;
	}

	/**
	 * Creates a box to confirm whether the password is correct. It set's the 'correct' variable in this class, so isPasswordCorrect() can be instantly called
	 */
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

	/**
	 * Closes the stage
	 */
	public static void closeStage() {
		stage.close();
	}
}
