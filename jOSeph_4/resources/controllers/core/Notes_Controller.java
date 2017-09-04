package jOSeph_4.resources.controllers.core;

import jOSeph_4.messageBoxes.Error;
import jOSeph_4.Variable;
import jOSeph_4.core.NoteView;
import jOSeph_4.messageBoxes.TextBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Notes_Controller implements Initializable{
	@FXML
	private ListView<String> listView;

	private static ArrayList<File> files;

	private String fileLocation;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File folder = new File(Variable.getUser());
		if(!(folder.exists() && folder.isDirectory())) {
			boolean success = folder.mkdirs();
			if (!success) {
				new Error("Could not create this folder", 500);
			}
		}


		files = Variable.getNotesFiles().getAllTextFiles(Variable.getUser());

		ObservableList<String> fileNames = FXCollections.observableArrayList();
		for(File i: files){
			String fileName = i.getName();
			fileNames.add(fileName.substring(0,fileName.length()-4));
		}

		listView.setItems(fileNames);
	}

	@FXML
	void onPressNew() {
		String selectedName = new TextBox("Please enter file name: ", 600, "Enter filename").getString();
		if(selectedName==null || selectedName.equals("")){return;}
		String fileName = selectedName;
		Variable.getNotesFiles().createAndCloseFile(fileToPath(fileName));
		refresh();
		openFile(new File(fileToPath(fileName)));
	}

	@FXML
	void onPressOpen() {
		String selectedName = listView.getSelectionModel().getSelectedItem();
		if(selectedName==null){return;}
		fileLocation = fileToPath(selectedName);
		openFile(new File(fileLocation));
	}

	private void openFile(File file){
		try {
			new NoteView().createNoteView(file);
		}catch (IOException e){
			new Error("Error #0011: IOException at Notes_Controller",600);
			e.printStackTrace();
		}
	}

	private void refresh(){
		files = Variable.getNotesFiles().getAllTextFiles(Variable.getUser());

		ObservableList<String> fileNames = FXCollections.observableArrayList();
		for(File i: files){
			String fileName = i.getName();
			fileNames.add(fileName.substring(0,fileName.length()-4));
		}

		listView.setItems(fileNames);
	}

	private String fileToPath(String name){
		return Variable.getUser() + "/" + name + ".txt";
	}

	@FXML
	void onPressDelete(){
		File file = new File(fileToPath(listView.getSelectionModel().getSelectedItem()));
		file.delete();
		refresh();
	}
}
