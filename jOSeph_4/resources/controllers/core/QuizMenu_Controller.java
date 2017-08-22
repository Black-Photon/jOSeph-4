package jOSeph_4.resources.controllers.core;

import jOSeph_4.Core;

public class QuizMenu_Controller {


	public void onQuizStartPressed(){
		Core_Controller.closeThread();
		Core.startQuiz();
	}
}
