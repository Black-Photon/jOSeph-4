package jOSeph_4.resources.controllers.core;

import jOSeph_4.Achievement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Achievement_Controller implements Initializable{
	@FXML
	private ImageView image;

	@FXML
	private Label description;

	@FXML
	private Label title;

	@FXML
	private ImageView obtained;

	private static Achievement achievement;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ColorAdjust monochrome = new ColorAdjust();
		monochrome.setSaturation(-1);
		image.setImage(achievement.getImage());
		description.setText(achievement.getDescription());
		title.setText(achievement.getTitle());
		if(achievement.isObtained()){
			obtained.setImage(new Image("jOSeph_4/resources/images/tickBox.png"));
		}else{
			image.setEffect(monochrome);
		}
	}

	public static Achievement getAchievement() {
		return achievement;
	}

	public static void setAchievement(Achievement achievement) {
		Achievement_Controller.achievement = achievement;
	}
}
