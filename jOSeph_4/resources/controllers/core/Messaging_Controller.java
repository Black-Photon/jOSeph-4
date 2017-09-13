package jOSeph_4.resources.controllers.core;

import jOSeph_4.Variable;
import jOSeph_4.core.Connection_Data;
import jOSeph_4.core.Connection_Settings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Messaging_Controller implements Initializable{

	@FXML
	private TableView<Connection_Data> tableView;

	@FXML
	private TableColumn<Connection_Data, String> nameColumn;

	@FXML
	private TableColumn<Connection_Data, Integer> portColumn;

	@FXML
	private TableColumn<Connection_Data, String> ipColumn;

	private ObservableList tableData;
	private ArrayList<Connection_Data> arrayList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.4));
		portColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
		ipColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.4));

		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		portColumn.setCellValueFactory(new PropertyValueFactory<>("port"));
		ipColumn.setCellValueFactory(new PropertyValueFactory<>("ip"));

		arrayList = Variable.getMessagingFiles().readMessagingConfig("messaging_config.txt");
		refresh();

	}

	@FXML
	void onPressCreate() {
		ArrayList<Object> data = new Connection_Settings().createWindow();
		if(data==null || data.get(0).equals(false)) {
			return;
		}
		addEntry(data);
	}

	@FXML
	void onPressJoin() {

	}

	@FXML
	void onDeletePressed(){
		arrayList.remove(tableView.getSelectionModel().getSelectedItem());
		refresh();
	}

	private void refresh(){
		tableData = FXCollections.observableArrayList(arrayList);
		tableView.setItems(tableData);
		Variable.getMessagingFiles().saveMessagingConfig("messaging_config.txt", arrayList);
	}

	private void addEntry(ArrayList data){
		String name = (String) data.get(1);
		ArrayList ip = (ArrayList) data.get(2);
		int port = (int) ((ArrayList) data.get(2)).get(4);
		Connection_Data connection = new Connection_Data(name, ip, port);
		arrayList.add(connection);
		refresh();
	}


}
