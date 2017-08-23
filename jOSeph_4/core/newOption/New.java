package jOSeph_4.core.newOption;

import jOSeph_4.Version;
import jOSeph_4.core.CorePane;
import jOSeph_4.resources.controllers.core.New_Controller;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.*;

public class New extends CorePane{
	private TabPane tabPane;

	public Pane getPane() throws IOException{
		StackPane pane = new StackPane();
		pane.getChildren().add(getNew());
		pane.getStylesheets().add("jOSeph_4/resources/css/core/new.css");
		return pane;
	}

	private TabPane getNew() throws IOException {
		tabPane = new TabPane();
		createTabs(new Tabs().generateTabs(), tabPane);
		tabPane.setSide(Side.LEFT);
		return tabPane;
	}

	/**
	 * Always use just before getTabContents()
	 * @param version
	 * @param info
	 */
	private void setTabContents(Version version, String info){
		New_Controller.preInitalize(version, info);
	}
	private BorderPane getTabContents() throws IOException{
		BorderPane root = FXMLLoader.load(getClass().getResource("../../resources/fxml/core/New.fxml"));
		return root;
	}
	void createTabs(ArrayList<jOSeph_4.core.newOption.Tab> arrayList, TabPane tabPane) throws IOException{
		for(jOSeph_4.core.newOption.Tab tab: arrayList) {
			Tab fxTab = new Tab();
			fxTab.setText(tab.getVersion().bToString());
			setTabContents(tab.getVersion(), tab.getInfo());
			fxTab.setContent(getTabContents());
			tabPane.getTabs().add(fxTab);
		}
	}
}
