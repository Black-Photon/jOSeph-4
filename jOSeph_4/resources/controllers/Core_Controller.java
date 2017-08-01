package jOSeph_4.resources.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Core_Controller implements Initializable{
	@FXML
	ProgressBar bar;
	@FXML
	Label count;

	private static int countInt;
	private static double progress;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		countInt=0;
		Achievement_Controller.createGeneratorAchievements();
	}

	public void onGeneratorClick(){
		int x = countInt;


		Random random = new Random();
		double randomDouble = (double)(random.nextInt(5))/10.0;
		progress += randomDouble;
		if(progress>=1){
			progress-=1;
			countInt++;
		}
		bar.setProgress(progress);
		count.setText(Integer.toString(countInt));

		boolean changed = true;
		if(countInt==x){
			changed = false;
		}
		if(changed){
			//TODO make message interface

			//*
			try {
				Achievement_Controller.onLevelUp(countInt);
			}catch (IOException e){
				e.printStackTrace();
			}//*/

		}
	}

}
