package jOSeph_4;

/**
 * Object creates a new login scene and sets as current scene
 *
 * Doesn't need to be big now as controllers do stuff and Main.createWindow() actually creates the window
 *
 * TODO remove
 */
public class Logon {
	/**
	 * Start's the logon screen
	 */
	public void start(){
		Main.createWindow("Logon.fxml", Variable.getWindow(), "Login");
	}
}
