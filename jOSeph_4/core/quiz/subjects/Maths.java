package jOSeph_4.core.quiz.subjects;

import jOSeph_4.core.quiz.Question;
import jOSeph_4.core.quiz.Results;
import jOSeph_4.core.quiz.Subject;

import java.util.ArrayList;

public class Maths extends Subject {
	private ArrayList<Question> questions;
	private int counter;
	private int questionCounter;
	private String thisSubject = MATHS;
	public String thisSubjectShown;

	public Maths(){
		questionCounter = 0;
		counter = 0;
		thisSubjectShown = "Maths";
	}

	@Override
	public void start() {
		questions = new ArrayList<>();
		createQuestion("What is 2+2?", new String[] {"2","3","4","5"},this,3);
		createQuestion("What is x when (x+1)(x-1)=2^3?", new String[] {"3","3/-3","2/-2","8"},this,2);
		createQuestion("What is (2i+1)^2?", new String[] {"2i+1","2i-1","4i^2-4i+1","4i-3"},this,4);

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
