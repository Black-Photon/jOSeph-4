package jOSeph_4.resources.controllers.core;

import jOSeph_4.Files;
import jOSeph_4.messageBoxes.ConfirmBox;
import jOSeph_4.messageBoxes.Error;
import jOSeph_4.Variable;
import jOSeph_4.core.NoteView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoteView_Controller implements Initializable{
	@FXML
	private Label file_name;

	@FXML
	private TextArea textArea;

	private static File file;

	private File thisFile;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		thisFile = file;
		file_name.setText(thisFile.getName().substring(0,thisFile.getName().length()-4));
		try {
			textArea.setText(Variable.getNotesFiles().readNotes(thisFile));
		}catch (IOException e){
			new Error("Error #0013: IOException at NoteView_Controller", 600);
			e.printStackTrace();
		}

	}

	@FXML
	void onPressBack() {
		try {
			if (!(textArea.getText().equals(Variable.getNotesFiles().readNotes(thisFile))))
				if (new ConfirmBox("Would you like to save?", 500).getAnswer())
					onPressSave();
		}catch(IOException e){
			new Error("Error #0015: IOException at NoteView_Controller.java",650);
		}
		NoteView.getStage().close();
	}

	@FXML
	void onPressSave() {
		try {
			Variable.getNotesFiles().saveNotes(thisFile, textArea.getText());
		}catch (IOException e){
			new Error("Error #0012: IOException at NoteView_Controller", 600);
			e.printStackTrace();
		}

	}

	public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		NoteView_Controller.file = file;
	}
}
