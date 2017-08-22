package jOSeph_4.core.newOption;

import jOSeph_4.Version;
import jOSeph_4.resources.controllers.New_Controller;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.*;

public class New {
	private TabPane tabPane;
	public TabPane getNew() throws IOException {
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
	private Pane getTabContents() throws IOException{
		Pane root = FXMLLoader.load(getClass().getResource("../../resources/fxml/New.fxml"));
		return root;
	}
	void createTabs(ArrayList<jOSeph_4.core.newOption.Tab> arrayList, TabPane tabPane) throws IOException{
		for(jOSeph_4.core.newOption.Tab tab: arrayList) {
			Tab fxTab = new Tab();
			setTabContents(tab.getVersion(), tab.getInfo());
			fxTab.setContent(getTabContents());
			tabPane.getTabs().add(fxTab);
		}
	}
}
