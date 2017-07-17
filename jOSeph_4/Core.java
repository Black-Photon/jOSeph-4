package jOSeph_4;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Core {

	private BorderPane layout;
	private Scene scene;
	private VBox tiles;

	//BUTTONS!
	private Button b_generate;
	private Button b_quiz;
	private Button b_calculator;
	private Button b_new;
	private Button b_help;
	private Button b_exit;
	private Button b_next;

	//MOAR BUTTONS!
	private Button b_noughtsCrosses;
	private Button b_encryption;
	private Button b_decision;
	private Button b_notepad;
	private Button b_temp; //Reserved for future use
	private Button b_exit2;
	private Button b_last;

	public Core(){
		layout = new BorderPane();
		tiles = new VBox(0);


		b_generate = new Button("");
		b_generate.setId("gen");
		b_quiz = new Button("");
		b_quiz.setId("quiz");
		b_calculator = new Button("");
		b_calculator.setId("calc");
		b_new = new Button("");
		b_new.setId("new");
		b_help = new Button("");
		b_help.setId("help");
		b_exit = new Button("");
		b_exit.setId("exit");
		b_next = new Button("");
		b_next.setId("next");

		tiles.getChildren().addAll(b_generate,b_quiz,b_calculator,b_new,b_help,b_exit,b_next);
		layout.setLeft(tiles);

		scene = new Scene(layout, 600, 500);
		scene.getStylesheets().addAll("jOSeph_4/resources/css/core.css");

		//UNFINISHED
		//TODO LEARN SCENE BUILDER!

	}
	public void start(){




		Main.getVars().getWindow().setTitle("Page 1");
		Main.getVars().getWindow().setScene(scene);
	}
}
