package jOSeph_4.core;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public abstract class CorePane implements CorePaneInterface{
	/**
	 * Get's a pane full of a scene to use, with a default ResourceBundle containing this (sub)class
	 * @param name Of the FXML file in the jOSeph_4/resources/fxml/core folder
	 * @return The content pane
	 * @throws IOException
	 */
	public Pane getPane(String name) throws IOException {
		CorePane thisObject = this;
		ResourceBundle resources = new ResourceBundle() {
			/**
			 * Should be "this" for this object
			 * @param key What data to retrieve
			 * @return The Object relating to the key
			 */
			@Override
			protected Object handleGetObject(String key) {
				if(key.equals("this")){
					return thisObject;
				}
				return null;
			}

			@Override
			public Enumeration<String> getKeys() {
				Enumeration<String> enumeration = new Enumeration<String>() {
					private String[] elements = {"this"};
					private int count = 0;

					@Override
					public boolean hasMoreElements() {
						if(count<elements.length) return true;
						return false;
					}

					@Override
					public String nextElement() {
						count++;
						return elements[count-1];
					}
				};
				return enumeration;
			}
		};      //Basically contains this object in a convoluted way. Supports extra info
		return getPane(name, resources);
	}

	/**
	 * Get's a pane full of a scene to use
	 * @param name Of the FXML file in the jOSeph_4/resources/fxml/core folder
	 * @param resources What resources to give the controller
	 * @return The content pane
	 * @throws IOException
	 */
	public Pane getPane(String name, ResourceBundle resources) throws IOException {
		StackPane stackPane = FXMLLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/core/"+name), resources);
		stackPane.setAlignment(Pos.CENTER);
		return stackPane;
	}
}