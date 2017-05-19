package questionareGui;

import java.io.File;
import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Generator4 extends Application{
	//Welcome to my app :D :D Hope you like it -Joseph (not jOSeph)
	
	//Why gen 4? Gen 2 was console based, and gen 3 a rewrite when I discovered constructors. I don't remember what gen 1 was...
	
	//Put the version number, type and stability here
	public static String stable = "Fairly Stable";
	public static Object versiona = 3;
	public static Object versionb = 3;
	public static Object versionc = 0;
	public static String versiontype = "Alpha";
	
	//It starts here - this tells it to launch
	public static void main(String args[]){
		launch(args);
	}
	
	//Creates the window and username/password keys
	static Stage window;
	public static HashMap<String, String> database;
	
	//This is the start (effectively)
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		//Initialises the config file
		File file = new File("jOSeph_config.txt");
		
		//Create a config file if there isn't one with default username/password keys
		if(file.isFile()==false){
			CreateSettings.load(true, null);
		}
		//Gets username/password keys
		database = new HashMap<String, String>();
		database = CreateSettings.load(false, null);
		
		
		window = primaryStage;
		
		//Sets title, Icon and what happens if you click the cross button
		window.setTitle("jOSeph " + versiona + "." + versionb + "." + versionc);
		window.setOnCloseRequest(e -> {off();e.consume();});
		window.getIcons().add(new Image("questionareGui/BasicLogo.png"));
		
		//Set's out on screen buttons ect.
		GridPane maingridpane = new GridPane();
		maingridpane.setPadding(new Insets(10,10,10,10));
		maingridpane.setVgap(8);
		maingridpane.setHgap(10);
		
		Label welcome = new Label("Welcome to jOSeph");
		GridPane.setConstraints(welcome, 3, 0);
		Button mainOn = new Button("On");
		Button mainOff = new Button("Off");
		GridPane.setConstraints(mainOn, 2, 2);
		GridPane.setConstraints(mainOff, 4, 2);
		Label version = new Label("This computor is currently in version " + versiona + "." + versionb + "." + versionc + " " + versiontype + " - " + stable);
		GridPane.setConstraints(version, 1,12);
		maingridpane.getChildren().addAll(welcome,mainOn,mainOff,version);
		
		Scene Main = new Scene(maingridpane, 800, 200);
		window.setScene(Main);
		window.show();
		
		
		//0 = Load
		//1 = Main Menu
		//2 = Password
		int skip = 2;
		
		switch(skip){
		
		case 0:
		mainOn.setOnAction(e -> {
			Load l = new Load();
			l.load();
		});
		break;
		
		case 1:
		mainOn.setOnAction(e -> mainmenu());
		break;
		
		case 2:
		mainOn.setOnAction(e -> {	Password.password("Ele20002", CreateSettings.load(false, null));	});
		break;
		
		}
		mainOff.setOnAction(e -> off());	
	}
	
	//Says that you successfully shut it down in the console. A bit pointless, but...
	public static void off(){
		System.out.println("System closed successfully");
		window.close();

	}
	
	//The main menu
	public static void mainmenu(){
		database = CreateSettings.load(false, null);
		
		if(user == null){
			user = "Guest";
			//user = "Ele20002";
		}
		
		GridPane menu1gridpane = new GridPane();
		menu1gridpane.setPadding(new Insets(10,10,10,10));
		menu1gridpane.setVgap(8);
		menu1gridpane.setHgap(10);
		
		//Sets title
		
		window.setTitle("jOSeph " + versiona + "." + versionb + "." + versionc + " - "+user);
		
		//Sets out main window
		
		Label title = new Label("Launcher Options:");
		GridPane.setConstraints(title, 0, 0, 2, 1);
		Label pag_no = new Label("Page 1");
		GridPane.setConstraints(pag_no, 55, 0);
		Button Quiz = new Button("Quiz");
		Button Calc1 = new Button("Calculator");
		Button New = new Button("New");
		Button Help = new Button("Help");
		Button temp_1 = new Button("temp_1");
		Button temp_2 = new Button("temp_2");
		Button Exit = new Button("Exit");
		Button Page2 = new Button("Next Page");
		GridPane.setConstraints(Quiz, 0, 1);
		GridPane.setConstraints(Calc1, 1, 1);
		GridPane.setConstraints(New, 0, 2);
		GridPane.setConstraints(Help, 1, 2);
		GridPane.setConstraints(temp_1, 0, 3);
		GridPane.setConstraints(temp_2, 1, 3);
		GridPane.setConstraints(Exit, 55, 5);
		GridPane.setConstraints(Page2, 55, 4);
		Button settings = new Button("User Settings");
		GridPane.setConstraints(settings, 0, 3, 2, 1);
		menu1gridpane.getChildren().addAll(title,pag_no,Quiz, Calc1, New, Help, Exit, Page2, settings);
		
		Scene menu = new Scene(menu1gridpane, 800, 200);
		window.setScene(menu);
		
		//Tells buttons what to do
		
		Quiz.setOnAction(e -> {Quiz1.mainmenu();} );
		Calc1.setOnAction(e -> {Calculator.calc();} );
		New.setOnAction(e -> InfoBox.box("New", "What's new in this version:","3.3: Notes section :D :D !!!!", "3.2: Added and fixed Bubble and Shuttle Sorting Algorithms","3.1: I have implemented a fully functional Noughts and Crosses game, and added an error message for an invalid username", "3.0: There's less stuff D:, so no more generate, and quizes are together", "Added Calculator", "Added (After great hard work) the loading menu (Finally)","New 'Users' which allow you to log on to a (to be) personalised version, and ability to change passwords","Return to Main Menu") );
		Help.setOnAction(e -> InfoBox.box("Help", "Help:", "To sign in, type your name and password, and click login", "To navigate, simply use the relevant buttons", "To change password, simply go onto user settings, insert a new password and press OK","","","","", "Return to Main Menu") );
		Exit.setOnAction(e -> off() );
		Page2.setOnAction(e -> {page2();});
		settings.setOnAction(e -> {Settings.settings(database, user);} );
		
	}
	public static String user;
	
	//After using password, sets the username so the system knows which user it is
	
	public static void userStore(String username){
		user = username;
		Load.load();
	}

	//Main Menu - Part 2: The revenge of the Programmers	
	
	public static void page2(){
		
		//If you are stupid enough to bypass the password screen (like I am), and don't have a username, this sets it
		if(user == null){
			user = "Guest";
			
		}
		
		GridPane menu1gridpane = new GridPane();
		menu1gridpane.setPadding(new Insets(10,10,10,10));
		menu1gridpane.setVgap(8);
		menu1gridpane.setHgap(10);
		
		//Glorious Titles!
		window.setTitle("jOSeph " + versiona + "." + versionb + "." + versionc + " - "+user);
		
		//More layout
		Label title = new Label("Launcher Options:");
		GridPane.setConstraints(title, 0, 0, 2, 1);
		Label pag_no = new Label("Page 2");
		GridPane.setConstraints(pag_no, 45, 0);
		Button Exit = new Button("Exit");
		Button Page1 = new Button("Last Page");
		GridPane.setConstraints(Exit, 45, 5);
		GridPane.setConstraints(Page1, 45, 4);
		Button XO = new Button("Noughts & Crosses");
		GridPane.setConstraints(XO, 0, 1);
		Button encrypt = new Button("Basic Encryption");
		GridPane.setConstraints(encrypt, 1, 1);
		Button Algs = new Button("Algorithms");
		GridPane.setConstraints(Algs, 0, 2);
		Button note = new Button("Notepad");
		GridPane.setConstraints(note, 1, 2);
		menu1gridpane.getChildren().addAll(title,pag_no, Exit, Page1,XO,encrypt,Algs,note);
		
		Scene menu = new Scene(menu1gridpane, 800, 200);
		window.setScene(menu);
		
		//Tells buttons what to do
		XO.setOnAction(e -> XO2.OX() );
		Exit.setOnAction(e -> off() );
		Page1.setOnAction(e -> {mainmenu();});
		encrypt.setOnAction(e -> Encryption.main() );
		Algs.setOnAction(e -> Algorithms_2.algs() );
		note.setOnAction(e -> Notepad.notes() );
	}
}


//This is where all the legal stuff would go if I knew how it worked
//Yeah :D














