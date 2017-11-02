package jOSeph_4;

/**
 * Object creates a new load scene and sets as current scene
 *
 * Doesn't need to be big now as controllers do stuff and Main.createWindow() actually creates the window
 *
 * TODO remove
 */
public class Load {
	/**
	 * Start's the load screen
	 */
	public void start(){
		Main.createWindow("Load.fxml", Variable.getWindow(), "Loading...");
	}
}





