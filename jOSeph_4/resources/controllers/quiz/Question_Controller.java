package jOSeph_4.resources.controllers.quiz;

import jOSeph_4.Main;
import jOSeph_4.core.Calculator;
import jOSeph_4.core.quiz.Feedback;
import jOSeph_4.core.quiz.Question;
import jOSeph_4.core.quiz.Subject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Question_Controller implements Initializable{
	@FXML
	private Label qnum;
	@FXML
	private Label qtype;
	@FXML
	private Label qques;

	@FXML
	private Button a1;
	@FXML
	private Button a2;
	@FXML
	private Button a3;
	@FXML
	private Button a4;

	private static Subject subject;
	private static Question thisQuestion;

	public void onAnswer1(){
		onAnswer(1);
	}
	public void onAnswer2(){
		onAnswer(2);
	}
	public void onAnswer3(){
		onAnswer(3);
	}
	public void onAnswer4(){
		onAnswer(4);
	}


	public void onAnswer(int selected){
		if(selected==correctAnswer){
			correct = true;
		}else{
			correct = false;
		}

		thisQuestion.setCorrect(correct);


		System.out.println("Correct = "+correct);

		String answer = answers[correctAnswer-1];



		Feedback feedback = new Feedback();
		feedback.create(correct, answer);

		//subject.nextQuestion(thisQuestion);
	}

	//Opens calculator in new window
	public void calculator(){
		Stage stage = new Stage();
		Main.createWindow("core/Calculator.fxml", stage, "Calculator");
		stage.show();
	}




	//Sets the values of the actual onscreen window
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		qnum.setText(qnum_s.getText());
		qtype.setText(qtype_s.getText());
		qques.setText(qques_s.getText());

		a1.setText(a1_s.getText());
		a2.setText(a2_s.getText());
		a3.setText(a3_s.getText());
		a4.setText(a4_s.getText());
	}

	private static Label qnum_s;
	private static Label qtype_s;
	private static Label qques_s;

	private static Button a1_s;
	private static Button a2_s;
	private static Button a3_s;
	private static Button a4_s;

	private static int correctAnswer;
	private boolean correct;
	private static String[] answers;


	/**
	 * Sets all the variables in a static context so they can be accessed when the window is made and accessed in initialize
	 *
	 * @param questionNumber
	 * @param subject
	 * @param question
	 * @param answers
	 * @param thisQuestion
	 * @param correct
	 */
	public static void preinitialize(int questionNumber, Subject subject, String question, String[] answers, Question thisQuestion, int correct){
		qnum_s = new Label(Integer.toString(questionNumber+1));
		qtype_s = new Label(subject.getThisSubjectShown());
		qques_s = new Label(question);

		a1_s = new Button(answers[0]);
		a2_s = new Button(answers[1]);
		a3_s = new Button(answers[2]);
		a4_s = new Button(answers[3]);

		Question_Controller.thisQuestion = thisQuestion;
		Question_Controller.subject = subject;

		Question_Controller.correctAnswer = correct;
		Question_Controller.answers = answers;
	}

	public boolean isCorrect() {
		return correct;
	}

	public static Subject getSubject() {
		return subject;
	}

	public static void setSubject(Subject subject) {
		Question_Controller.subject = subject;
	}

	public static Question getThisQuestion() {
		return thisQuestion;
	}

	public static void setThisQuestion(Question thisQuestion) {
		Question_Controller.thisQuestion = thisQuestion;
	}
}
