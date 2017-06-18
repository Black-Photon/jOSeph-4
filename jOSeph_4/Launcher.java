package jOSeph_4;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Launcher {

	private Scene scene;

	//Objects
	private Label welcome;
	private Button on;
	private Button off;
	private Label version;

	/* This method creates a new launcher
	 *
	 *
	 *
	 */

	public Launcher(){

		welcome = new Label("Welcome to jOSeph");
		on = new Button("On");
		off = new Button("Off");
		version = new Label("This system is currently in version " + Main.getVars().getVersionObject().bToString() + " " + Main.getVars().getVersionObject().getC() + " - " + Main.getVars().getVersionObject().getA());

		HBox hBox = new HBox();
		hBox.getChildren().addAll(on,off);
		hBox.setAlignment(Pos.CENTER);
		//hBox.setPadding(defaultInsets);
		hBox.setSpacing(20.0);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(hBox);
		borderPane.setTop(welcome);
		borderPane.setBottom(version);
		borderPane.setAlignment(borderPane.getTop(), Pos.CENTER);
		borderPane.setAlignment(borderPane.getCenter(), Pos.CENTER);
		borderPane.setAlignment(borderPane.getBottom(), Pos.CENTER);
		borderPane.setPadding(Main.getVars().getDefaultInsets());

		//Id's for CSS
		on.setId("green");
		off.setId("red");

		//Listeners
		on.setOnAction(e -> {Logon logon = new Logon();});
		off.setOnAction(e -> Main.quit());

		scene  = new Scene(borderPane, 500, 200);
		scene.getStylesheets().addAll("jOSeph_4/resources/css/main.css");
	}

	//Setters and Getters

	public Scene getScene() {
		return scene;
	}
}
