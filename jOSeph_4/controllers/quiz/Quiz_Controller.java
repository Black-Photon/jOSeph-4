package jOSeph_4.resources.controllers.quiz;

import jOSeph_4.Main;
import jOSeph_4.core.quiz.Quiz_Runtime;

public class Quiz_Controller {
	public void onMathsPressed(){
		Quiz_Runtime.start();
		Quiz_Runtime.startMaths();
	}
	public void onSciPressed(){
		Quiz_Runtime.start();
		Quiz_Runtime.startSci();
	}
	public void onCompPressed(){
		Quiz_Runtime.start();
		Quiz_Runtime.startComp();
	}
	public void onExitPressed(){
		Main.coreProgramStart();
	}
}
