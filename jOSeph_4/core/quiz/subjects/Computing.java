package jOSeph_4.core.quiz.subjects;

import jOSeph_4.core.quiz.Question;
import jOSeph_4.core.quiz.Results;
import jOSeph_4.core.quiz.Subject;

import java.util.ArrayList;

public class Computing extends Subject{
	private ArrayList<Question> questions;
	private int counter;
	private int questionCounter;
	private String thisSubject = COMPUTING;
	public String thisSubjectShown;

	public Computing(){
		questionCounter = 0;
		counter = 0;
		thisSubjectShown = "Computing";
	}

	@Override
	public void start() {
		questions = new ArrayList<>();
		createQuestion("What is this made in?", new String[] {"C++","Java","Python","SQL"},this,2);
		createQuestion("Which Operating System is open source?", new String[] {"Windows","IOS","Linux","Android"},this,3);
		createQuestion("What does the computer use to access a website?", new String[] {"IP Address","Website URL","MAC Address","The Internet"},this,1);

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
