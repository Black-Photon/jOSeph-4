package jOSeph_4;

/**
 * Object creates a new load scene and sets as current scene
 *
 * Doesn't need to be big now as controllers do stuff and Main.createWindow() actually creates the window
 *
 * TODO remove
 */
public class Core {
	/**
	 * Starts the core program
	 */
	public void start(){
		Main.createWindow("Core.fxml",Variable.getWindow(),"Page 1");
	}
}
