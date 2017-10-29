package jOSeph_4.resources.controllers.core;

import jOSeph_4.Achievement;
import jOSeph_4.messageBoxes.sourceFiles.Error;
import jOSeph_4.resources.controllers.Achievement_Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Achievements_Controller implements Initializable {
	@FXML
	public Accordion accordion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<List> listOfAchievements = Achievement_Controller.getAllAchievements();
		for(List<Achievement> list: listOfAchievements){
			try{
				Achievement_Category_Controller.setList(list);
				VBox category = FXMLLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/core/Achievement_Catagory.fxml"));
				category.setAlignment(Pos.CENTER);
				TitledPane titledPane = new TitledPane();
				titledPane.getStyleClass().add("option");
				titledPane.setContent(category);
				titledPane.setText(list.get(0).getCategory());
				accordion.getPanes().add(titledPane);
			}catch (IOException e){
				new Error("Error #0009: IOException at Achievements_Controller.java", 600).showModalWindow();
				e.printStackTrace();
			}
		}
	}
}
