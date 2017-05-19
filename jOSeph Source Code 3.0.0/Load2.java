package questionareGui;

import java.util.Random;

import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Load2 implements Runnable{
	
	static Stage stage;
	static Label label;
	static ProgressBar bar;
	private static Load2 l;
	private static Scene scene;
	private static GridPane loadgridpane;

	private static float x;
	
	/*
	 *  STILL WIP - DON'T USE UNDER ANY CIRCUMSTANCES (Except testing this)
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	public Load2(){
		label = new Label("System booting up...");
		bar = new ProgressBar(0.0);
		stage = new Stage();
		x = 0.0f;
	}
	
	public static void load() {
		l = new Load2();
		l.page();
		//Thread a = new Thread(l);
		Thread b = new Thread(new WaitTime());
		//a.start();
		b.start();
	}
	
	public void updateMessage(String message){
		label.setText(message);
	}
	public void updateBar(float percentage){
		bar.setProgress(percentage);
	}
	
	@Override
	public void run() {
		new Random();
		GridPane loadgridpane = new GridPane();
		loadgridpane.setPadding(new Insets(10,10,10,10));
		loadgridpane.setVgap(8);
		loadgridpane.setHgap(10);
		
		GridPane.setConstraints(label, 0, 0);
		GridPane.setConstraints(bar, 1, 0);
		loadgridpane.getChildren().addAll(label,bar);
		
		
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Loading...");
		

		System.out.println("Load2 Thread");
	}
	private void page(){
		new Random();
		loadgridpane = new GridPane();
		loadgridpane.setPadding(new Insets(10,10,10,10));
		loadgridpane.setVgap(8);
		loadgridpane.setHgap(10);
		
		GridPane.setConstraints(label, 0, 0);
		GridPane.setConstraints(bar, 1, 0);
		loadgridpane.getChildren().addAll(label,bar);
		
		
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Loading...");

		scene = new Scene(loadgridpane,500,40);

		stage.setScene(scene);
		stage.show();
		
	}
	public static void update(float f, int time){

		Task<Void> t = new Task<Void>() {
			@Override
			protected Void call() throws Exception {

				while (x < f) {
					//l.updateBar(x);
					bar.setProgress(x);

					try {
						//Thread.sleep(time);
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println("Error in WaitTime class thread\nWhoops...");
					}


					x += 0.01;
				}
				return null;
			}
		};

		new Thread(t).start();


	}
}
