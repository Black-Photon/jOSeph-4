package jOSeph_4.core.quiz.subjects;

import jOSeph_4.core.quiz.Question;
import jOSeph_4.core.quiz.Results;
import jOSeph_4.core.quiz.Subject;

import java.util.ArrayList;

public class Science extends Subject{
	private ArrayList<Question> questions;
	private int counter;
	private int questionCounter;
	private String thisSubject = SCIENCE;
	public String thisSubjectShown;

	public Science(){
		questionCounter = 0;
		counter = 0;
		thisSubjectShown = "Science";
	}

	@Override
	public void start() {
		questions = new ArrayList<>();
		createQuestion("1m^3 of which is the heaviest?", new String[] {"Titanium","Iron","Uranium","Tungsten"},this,4);
		createQuestion("Which is a longitudinal wave?", new String[] {"Visible Light","Ultrasound","X-Rays","Water Waves"},this,2);
		createQuestion("How long for a pebble to drop 10m?", new String[] {"1s","1.4s","2s","5s"},this,2);

		loadQuestion();
	}
	public void loadQuestion(){
		questions.get(questionCounter).setQuestionNumber(questionCounter);
		questions.get(questionCounter).createWindow();
	}

	@Override
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	@Override
	public String getThisSubjectShown() {
		return thisSubjectShown;
	}
	@Override
	public int getQuestionCounter() {
		return questionCounter;
	}
	@Override
	public void setQuestionCounter(int questionCounter) {
		this.questionCounter = questionCounter;
	}
}
