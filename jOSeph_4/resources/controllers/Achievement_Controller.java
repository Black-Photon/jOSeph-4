package jOSeph_4.resources.controllers;

import jOSeph_4.Achievement;
import jOSeph_4.Achievement_Type;
import jOSeph_4.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class Achievement_Controller  implements Initializable {

	private Scene scene;
	private static Stage stage;
	private static Achievement achievement;
	private static List allAchievements;
	private static List generatorAchievements;

	@FXML
	ImageView imageView;
	@FXML
	Label title;
	@FXML
	Label description;
	@FXML
	Button button;

	//Static Methods control creation of all generatorAchievements

	public static void createAchievements(){
		allAchievements = new ArrayList<List>();
		createGeneratorAchievements();
	}

	public static void createGeneratorAchievements(){
		generatorAchievements = new ArrayList<Achievement>();
		Achievement_Type type = Achievement_Type.GENERATOR;
		generatorAchievements.add(new Achievement("level10.png","Good Thinker", "Reached Level 10",10, type));
		generatorAchievements.add(new Achievement("level25.png","Great Thinker", "Had lots of ideas",25, type));
		generatorAchievements.add(new Achievement("level42.png","Deep Thought", "Discovered the answer to Life, the Universe and Everything",42, type));
		generatorAchievements.add(new Achievement("level50.png","Amazing Thinker", "Formed a new Theory",50, type));
		generatorAchievements.add(new Achievement("level100.png","Prize Winning Thinker", "Got a Turing Award",100, type));
		generatorAchievements.add(new Achievement("level500.png","Revolutionary Thinker", "The Modern Newton",500, type));
		allAchievements.add(generatorAchievements);
	}

	public static void onLevelUp(int level) throws IOException{
		for(Iterator<Achievement> iterator = generatorAchievements.iterator(); iterator.hasNext();){
			Achievement thisAchievement = iterator.next();
			if(thisAchievement.getLevel()==level){
				thisAchievement.setObtained(true);
				Achievement_Controller thisController = new Achievement_Controller();
				thisController.start(thisAchievement);
			}
		}
	}

	public void start(Achievement achievement) throws IOException {
		this.achievement = achievement;
		stage = new Stage();
		Main.createWindow("Achievement.fxml", stage, "New Achievement!");
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageView.setImage(achievement.getImage());
		title.setText(achievement.getTitle());
		description.setText(achievement.getDescription());
	}
	public void onButtonClick(){
		stage.close();
	}

	public static List getAllAchievements() {
		return allAchievements;
	}

	public static void setAllAchievements(List allAchievements) {
		Achievement_Controller.allAchievements = allAchievements;
	}
}
