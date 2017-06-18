package jOSeph_4;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Error {

	private Label label;
	private Image image;
	private ImageView imageView;
	private Scene scene;
	private Stage stage;
	private Button ok;

	public Error(String title, int width){
		label = new Label();
		image = new Image("jOSeph_4/resources/images/Error.png");
		imageView = new ImageView(image);
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.getChildren().addAll(imageView,label);
		hBox.setAlignment(Pos.CENTER);

		ok = new Button("OK");
		ok.setOnAction(e -> {stage.close();});


		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(hBox);
		borderPane.setBottom(ok);
		borderPane.setAlignment(borderPane.getBottom(), Pos.CENTER);

		borderPane.setPadding(Main.getVars().getDefaultInsets());

		scene = new Scene(borderPane, width,150);
		scene.getStylesheets().setAll("jOSeph_4/resources/css/error.css");

		stage = new Stage();
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
	}

	public void setLabel(String text) {
		this.label.setText(text);
	}
}
