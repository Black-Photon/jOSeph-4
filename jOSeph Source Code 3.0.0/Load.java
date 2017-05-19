package questionareGui;

import java.util.Random;

import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

public class Load{
	static Stage stage;
	static boolean done;
	  public static void load() {
		  
		  //I used a bit of code I found online for this as well as my own, as alone, I couldn't get it to work. It waited and then displayed the window instead of displaying and waiting
		  
		  ProgressBar bar = new ProgressBar(0.0);
		  Random rand = new Random();
		    // "message1" won’t be seen because we perform the next action on the JavaFX 
		    // application thread then update the label text again without releasing the 
		    // thread to the JavaFX system.
		    Label label = new Label("System booting up...");
		    label.setPrefWidth(300);

		    // some action

		    // "action done" won’t be seen because we set text again in the next statement.
		    label.setText("");

		    // you're not going to see this because we immediately bind text to the task text and launch the task. 
		    label.setText("");

		    Task <Void> task = new Task<Void>() {
		      @Override public Void call() throws InterruptedException {
		        // "message2" time consuming method (this message will be seen).
		        updateMessage("Starting configuration settings...");
		        double x = 0.0;
		        while(x<0.1){
		        	bar.setProgress(x);
		        	 Thread.sleep(120);
		        	x+=0.01;
		        }
		        
		        // some actions
		       
		        while(x<0.2){
		        	bar.setProgress(x);
		        	 Thread.sleep(120);
		        	x+=0.01;
		        }

		        // "message3" time consuming method (this message will be seen).
		        updateMessage("Saving Files to C:/Java/System/Projects...");
		        while(x<0.3){
		        	bar.setProgress(x);
		        	 Thread.sleep(120);
		        	x+=0.01;
		        }

		        //more  time consuming actions
		        
		        updateMessage("Searching for Updates...");
		        while(x<0.4){
		        	bar.setProgress(x);
		        	 Thread.sleep(1500);
		        	x+=0.01;
		        }
		       
		        updateMessage("Starting Launcher...");
		        while(x<0.5){
		        	bar.setProgress(x);
		        	 Thread.sleep(600);
		        	x+=0.01;
		        }
		        int dictionaries = rand.nextInt(7);
		        int update = rand.nextInt(3);
		        updateMessage("Downloaded " + dictionaries + " dictionaries...");
		        while(x<0.6){
		        	bar.setProgress(x);
		        	 Thread.sleep(600);
		        	x+=0.01;
		        }
		        while(x<0.7){
		        	bar.setProgress(x);
		        	 Thread.sleep(120);
		        	x+=0.01;
		        }
		        if(update==2){
		        	updateMessage("Update found...");
		        	while(x<0.8){
			        	bar.setProgress(x);
			        	 Thread.sleep(300);
			        	x+=0.01;
			        }
		        	updateMessage("Downloading update...");
		        	while(x<0.9){
			        	bar.setProgress(x);
			        	 Thread.sleep(1800);
			        	x+=0.01;
			        }
		        	updateMessage("Update downloaded.");
		        	while(x<1.0){
			        	bar.setProgress(x);
			        	 Thread.sleep(1500);
			        	x+=0.01;
			        }
		        	
		        }else{
		        	updateMessage("No updates found...");
		        	while(x<1.0){
			        	bar.setProgress(x);
			        	 Thread.sleep(150);
			        	x+=0.01;
			        }
		        	
		        }
		        // this will never be actually be seen because we also set a message 
		        // in the task::setOnSucceeded handler.
		        updateMessage("");
		        
		        
		        
		        if(label.getText()=="No updates found..."||label.getText()=="Update downloaded."){
		        	done = true;
		        }
		        
		        
		        

		        return null;
		      }
		    };

		    label.textProperty().bind(task.messageProperty());

		    // java 8 construct, replace with java 7 code if using java 7.
		    task.setOnSucceeded(e -> {
		      label.textProperty().unbind();
		      // this message will be seen.
		      label.setText("Loaded Successfully");
		      stage.close();
		      Generator4.mainmenu();
		    });
		    //???
		    Thread thread = new Thread(task);
		    thread.setDaemon(true);
		    thread.start();
		    
		    
			
			
			
			GridPane loadgridpane = new GridPane();
			loadgridpane.setPadding(new Insets(10,10,10,10));
			loadgridpane.setVgap(8);
			loadgridpane.setVgap(10);
			
			GridPane.setConstraints(label, 0, 0);
			GridPane.setConstraints(bar, 1, 0);
			loadgridpane.getChildren().addAll(label,bar);
		    
		    
		    
		    stage = new Stage();
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.setTitle("Loading...");
		    stage.setScene(new Scene(loadgridpane,500,40));
		    stage.show();
		    
		    		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		  }
}