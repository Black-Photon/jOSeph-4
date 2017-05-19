package questionareGui;

import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

public class Load3 {

    static Stage stage;
    static Label label;
    static ProgressBar bar;
    private static Scene scene;
    private static GridPane loadgridpane;
    private static float x;

    /*
        Unfinished
        Able to change progress, but not text
         */
    public Load3() {
        label = new Label("System booting up...");
        bar = new ProgressBar(0.0);
        stage = new Stage();
        x = 0.0f;

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

    public static void load(){
        Random rand = new Random();
        System.out.println("Started Loading");
        //updateMessage("Starting configuration settings...");
        changeProgress(0.1f,120);
        /*changeProgress(0.2f,120);
        updateMessage("Saving Files to C:/Java/System/Projects...");
        changeProgress(0.3f,120);
        updateMessage("Searching for Updates...");
        changeProgress(0.4f,1500);
        updateMessage("Starting Launcher...");
        changeProgress(0.5f,600);
        int dictionaries = rand.nextInt(7);
        int update = rand.nextInt(3);
        updateMessage("Downloaded " + dictionaries + " dictionaries...");
        changeProgress(0.6f,600);
        changeProgress(0.7f,120);
        if(update==2){
            updateMessage("Update found...");
            changeProgress(0.8f,300);
            updateMessage("Downloading update...");
            changeProgress(0.9f,1800);
            updateMessage("Update downloaded.");
            changeProgress(1.0f,1500);
        }else{
            updateMessage("No updates found...");
            changeProgress(1.0f,150);
        }
        System.out.println("Done");*/
    }

    private static void changeProgress(float progress, int time){
        Task<Void> t = new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                Thread.sleep(time);
                bar.setProgress(progress);
                return null;
            }
        };
        Thread thread = new Thread(t);
        thread.start();
    }

    private static void updateMessage(String message){
        Task<Void> t = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                label.setText(message);
                return null;
            }
        };
        Thread thread = new Thread(t);
        thread.start();
    }
}
