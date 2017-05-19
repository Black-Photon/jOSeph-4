package questionareGui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoBox {
	public static void box(String title, String Heading, String Info1, String Info2, String Info3,String Info4, String Info5, String Info6, String Info7, String Back){
		Stage window = new Stage();
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label head = new Label(Heading);
		GridPane.setConstraints(head, 0, 0,20,1);
		Label info1 = new Label(Info1);
		GridPane.setConstraints(info1, 0, 1,20,1);
		Label info2 = new Label(Info2);
		GridPane.setConstraints(info2, 0, 2,20,1);
		Label info3 = new Label(Info3);
		GridPane.setConstraints(info3, 0, 3,20,1);
		Label info4 = new Label(Info4);
		GridPane.setConstraints(info4, 0, 4,20,1);
		Label info5 = new Label(Info5);
		GridPane.setConstraints(info5, 0, 5,20,1);
		Label info6 = new Label(Info6);
		GridPane.setConstraints(info6, 0, 6,20,1);
		Label info7 = new Label(Info7);
		GridPane.setConstraints(info7, 0, 7,20,1);
		Button back = new Button(Back);
		GridPane.setConstraints(back, 20, 0);
		back.setOnAction(e -> {window.close();} );
		
		gridpane.getChildren().addAll(info1,info2,info3,info4, info5, info6,info7, head,back);
		
		Scene this_ = new Scene(gridpane, 1000, 500);
		window.setScene(this_);
		window.show();
		
		
	}
}
