package jOSeph_4.core.quiz;

import java.util.ArrayList;

/**
 * The superclass for all subject types. It makes all essential methods abstract, for easier making of new subjects.
 * This means all different subjects can be considered a "Subject", and access their methods, making the process reusable for all subjects extending this class.
 */


public abstract class Subject {
	public static final String MATHS = "MATHS";
	public static final String SCIENCE = "SCIENCE";
	public static final String COMPUTING = "COMPUTING";

	public String thisSubjectShown;

	public abstract void start();

	//Sets question data in a new question, and saves it to an array of questions in the subject class
	public void createQuestion(String questionString, String[] answers, Subject subject, int correct){
		Question question = new Question(subject,subject.getQuestionCounter());
		subject.getQuestions().add(question);
		question.setQuestion(questionString);
		question.setAnswers(answers);
		question.setCorrectAnswer(correct);
	}

	public abstract ArrayList<Question> getQuestions();

	public abstract String getThisSubjectShown();

	public abstract int getQuestionCounter();

	public abstract void setQuestionCounter(int questionCounter);

	public abstract void loadQuestion();

	public void nextQuestion(Question thisQuestion, Subject subject){
		subject.setQuestionCounter(subject.getQuestionCounter()+1);
		if(subject.getQuestionCounter()>=subject.getQuestions().size()){
			Results results = new Results();
			try {
				results.createWindow();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else {
			subject.loadQuestion();
		}
	}
}
