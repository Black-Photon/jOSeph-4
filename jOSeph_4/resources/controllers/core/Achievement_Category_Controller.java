package jOSeph_4.resources.controllers.core;

import jOSeph_4.Achievement;
import jOSeph_4.Error;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Achievement_Category_Controller implements Initializable{
	@FXML
	public Label title;
	@FXML
	public VBox vBox;

	private static List<Achievement> list;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		title.setText(list.get(0).getCategory());
		for(Achievement achievement: list){
			try {
				Achievement_Controller.setAchievement(achievement);
				GridPane option = FXMLLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/core/Achievement.fxml"));
				option.setAlignment(Pos.CENTER);
				vBox.getChildren().add(new Separator());
				vBox.getChildren().add(option);
			}catch (IOException e){
				new Error("Error #0011: IOException at A_C_C.java", 500);
				e.printStackTrace();
			}
		}
	}

	public static List<Achievement> getList() {
		return list;
	}

	public static void setList(List<Achievement> list) {
		Achievement_Category_Controller.list = list;
	}

}
