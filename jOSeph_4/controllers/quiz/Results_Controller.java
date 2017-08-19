package jOSeph_4.resources.controllers.quiz;

import jOSeph_4.Core;
import jOSeph_4.core.quiz.Question;
import jOSeph_4.core.quiz.Quiz;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Results_Controller implements Initializable{
	@FXML
	Label result;
	@FXML
	TableView<Question> tableView;
	@FXML
	TableColumn<Question, Integer> tableColumnQuestionNumber;
	@FXML
	TableColumn<Question, String> tableColumnQuestion;
	@FXML
	TableColumn<Question, String> tableColumnAnswer;
	@FXML
	TableColumn<Question, String> tableColumnResult;

	ArrayList<Question> questions;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.questions = getQuestions();
		tableColumnQuestionNumber.setCellValueFactory(new PropertyValueFactory<>("questionNumber"));
		tableColumnQuestion.setCellValueFactory(new PropertyValueFactory<>("question"));
		for(Question i: questions){
			i.setCorrectString();
		}
		tableColumnAnswer.setCellValueFactory(new PropertyValueFactory<>("correctString"));
		for(Question i: questions){
			i.setIsCorrectString();
		}
		tableColumnResult.setCellValueFactory(new PropertyValueFactory<>("isCorrectString"));

		tableView.setItems(FXCollections.observableArrayList(questions));

		int correct = 0;
		for(Question i: questions){
			if(i.isCorrect()){
				correct++;
			}
		}
		result.setText(correct+"/"+questions.size());
	}

	public ArrayList<Question> getQuestions(){
		return Question_Controller.getSubject().getQuestions();
	}

	public void exit(){
		Core.startQuiz();
	}
}
