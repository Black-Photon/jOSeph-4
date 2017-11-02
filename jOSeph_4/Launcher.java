package jOSeph_4;

/**
 * Object creates a new launcher scene and sets as current scene
 *
 * Doesn't need to be big now as controllers do stuff and Main.createWindow() actually creates the window
 *
 * TODO remove
 */
public class Launcher {
	/**
	 * Start's the logon screen
	 */
	void start(){
		Main.createWindow("Launcher.fxml",Variable.getWindow(), "jOSeph " + Variable.getVersionObject().versionToString());
	}

}
