package jOSeph_4.core.quiz;

import jOSeph_4.Main;
import jOSeph_4.Variable;
import jOSeph_4.resources.controllers.quiz.Question_Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Holds all question data, and used to directly make into new window with createWindow();
 */
public class Question {

	private int questionNumber;
	private Subject subject;
	private String question;
	private String[] answers;
	private Scene scene;
	private int correctAnswer;
	private boolean correct;
	private String correctString;
	private String isCorrectString;

	//Sets subject (and question number) to be used later
	public Question(Subject subject){
		this.subject = subject;
		answers = new String[4];
	}
	public Question(Subject subject,int questionNumber){
		this.subject = subject;
		this.questionNumber = questionNumber;
		answers = new String[4];
	}





	//Getters and Setters
	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correct) {
		this.correctAnswer = correct;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public void setCorrectString(){
		correctString = answers[correctAnswer-1];
	}

	public int getQuestionNumber() {
		return questionNumber+1;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectString() {
		return correctString;
	}

	public String getIsCorrectString() {
		return isCorrectString;
	}

	public void setIsCorrectString() {
		if(correct){
			isCorrectString = "Correct";
		}else{
			isCorrectString = "Incorrect";
		}
	}

	/**
	 * Tells it to make a new scene and set as current, holding question
	 * Use to load GUI as current scene
	 *
	 * MUST have set questionNumber,subject,question,answers and correctAnswer first
	 */
	public void createWindow(){

		Question_Controller.preinitialize(questionNumber,subject,question,answers,this,correctAnswer);



		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			root = fxmlLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/quiz/Question.fxml"));
		}catch(Exception e){
			System.out.println("Root could not be set D:");
			e.printStackTrace();
		}
		scene = new Scene(root);
		Variable.getWindow().setScene(scene);
		try {
			Variable.getWindow().setTitle(subject.thisSubjectShown);
		}catch(Exception e){
			Variable.getWindow().setTitle("Quiz");
		}



	}


}
