package jOSeph_4.resources.controllers.core;

import jOSeph_4.core.quiz.Quiz;

public class QuizMenu_Controller {
	public void onQuizStartPressed(){
		Core_Controller.closeThread();
		new Quiz().startMenu();
	}
}
