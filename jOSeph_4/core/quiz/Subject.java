package jOSeph_4.core.quiz;

import java.util.ArrayList;

/**
 * The superclass for all subject types. It makes all essential methods abstract, for easier making of new subjects.
 * This means all different subjects can be considered a "Subject", and access their methods, making the process reusable for all subjects extending this class.
 */


public abstract class Subject {
	/**
	 * Name of the subject for the user to see
	 */
	protected String thisSubjectShown;
	protected ArrayList<Question> questions;
	protected int counter;
	protected int questionCounter;


	public Subject(){
		questionCounter = 0;
		counter = 0;
	}

	/**
	 * Start's the quiz<br/>
	 * Creates and loads the first question
	 */
	public abstract void start();

	/**
	 * Sets question data in a new question, and saves it to an array of questions in the subject class
	 *
	 * @param questionString Question to ask
	 * @param answers That are possible - size = 4
	 * @param subject Subject of the question
	 * @param correct Which given answer is correct 1-4
	 */
	protected void createQuestion(String questionString, String[] answers, Subject subject, int correct){
		Question question = new Question(subject,subject.getQuestionCounter());
		subject.getQuestions().add(question);
		question.setQuestion(questionString);
		question.setAnswers(answers);
		question.setCorrectAnswer(correct);
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public String getThisSubjectShown() {
		return thisSubjectShown;
	}
	public int getQuestionCounter() {
		return questionCounter;
	}
	public void setQuestionCounter(int questionCounter) {
		this.questionCounter = questionCounter;
	}

	/**
	 * Set's the question number and loads the next question into the window
	 */
	public void loadQuestion(){
		questions.get(questionCounter).setQuestionNumber(questionCounter);
		questions.get(questionCounter).createWindow();
	}

	/**
	 * Moves to the next question
	 * @param subject Subject to load the next question of
	 */
	public void nextQuestion(Subject subject){
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
