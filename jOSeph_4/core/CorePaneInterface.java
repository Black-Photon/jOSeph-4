package jOSeph_4.core;

import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Enforces the need for the getPane() method
 */
public interface CorePaneInterface {
	/**
	 * Get's a Pane containing the data to replace on the core
	 * @return The content pane
	 * @throws IOException
	 */
	public Pane getPane() throws IOException;
}
