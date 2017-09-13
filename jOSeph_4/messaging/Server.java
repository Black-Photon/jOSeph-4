package jOSeph_4.messaging;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Used as controller for a server.
 *
 * <h2>FXML:</h2>
 * <h3>Vars:</h3>
 * TextField userText<br/>
 * TextArea chatWindow
 *
 * <h3>Methods:</h3>
 * startSendMessage sends whatever's in the TextField and clears it
 *
 */

public class Server implements Initializable{
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket socket;
	private ArrayList<Connection> connections;
	@FXML
	public TextField userText;
	@FXML
	public TextArea chatWindow;
	private static boolean end = false;

	/**
	 * Starts the server background running. Called by initialize ONLY
	 */
	private void startRunning() {
		connections = new ArrayList<>();
		try {
			server = new ServerSocket(Connection.getPort(), 100);
		}catch(IOException e){
			e.printStackTrace();
		}
		startConnecting();
	}

	/**
	 * Sends a message to specified connection
	 * @param message Message to send
	 * @param connection Connection to send message to
	 */
	private void sendMessage(String message, Connection connection){
		if(message.equals("")||message.equals(" ")) return;
		silentSend("SERVER - "+message, connection);
	}

	private void silentSend(String message, Connection connection){
		if(message.equals("")||message.equals(" ")) return;

		if(message.endsWith("END")){
			end = true;
		}

		try {
			if(isClient(message)) {
				connection.getOutput().writeObject(message.substring(2));
				connection.getOutput().flush();
			}else{
				connection.getOutput().writeObject(message);
				connection.getOutput().flush();
			}
		}catch (IOException e) {
			chatWindow.appendText("Error in sending message\n");
		}
	}

	/**
	 * Tests if the message is from the client
	 * @param message Message to test
	 * @return Whether the message is from the client
	 */
	private boolean isClient(String message){
		return message.substring(0,2).equals("/c");
	}

	/**
	 * Attempts to send a message to everyone connected. Calls sendMessage(message);
	 * @param message The message to send
	 */
	private void sendAllMessage(String message){
		for(Connection i: connections) {
			sendMessage(message, i);
		}
	}

	/**
	 * Connect's socket to serverSocket
	 * @throws IOException Thrown in connection
	 */
	private void waitForConnection() throws IOException {
		if(connections.size()==0) {
			showMessage("Waiting for Connection...");
		}
		socket = server.accept();
	}

	/**
	 * Creates input and output streams
	 * @throws IOException Due to creation
	 */
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(socket.getOutputStream());
		output.flush();
		input = new ObjectInputStream(socket.getInputStream());
	}

	/**
	 * Waits for a message, and displays it
	 * @param current Current connection to listen to
	 * @throws IOException When reading message sent
	 */
	private void whileChatting(Connection current) throws  IOException{
		String message = "";
		ableToType(true);
		do{
			try{
				message = (String) current.getInput().readObject();
				if(message.endsWith("/u")){
					String user = message.substring(0,message.length()-2);
					current.setName(user);
					message = user+" connected";
					showMessage("SERVER - "+message);
					sendAllMessage(message);
				}else {
					showMessage(message);
					for (Connection connection : connections) {
						if (!connection.equals(current)) {
							sendMessage("/c" + message, connection);
						}
					}
				}
			}catch (EOFException e){
				break;
			}catch (ClassNotFoundException e) {
				showMessage("Unable to process received message");
			}
		}while(!message.endsWith("END"));
	}

	/**
	 * Shows the message passed, and a new line
	 * @param message Message to show
	 */
	private void showMessage(String message){
		chatWindow.appendText(message+"\n");
	}

	/**
	 * Closes given connection
	 * @param connection Which connection to close
	 */
	private void closeConnection(Connection connection) {
		try {
			connection.getSocket().close();
			connection.getInput().close();
			connection.getOutput().close();
			connections.remove(connection);
		}catch (IOException e) {
			e.printStackTrace();
		}
		if(end){
			showMessage("Server Ended the Connection");
			ableToType(false);
		}else {
			showMessage("SERVER - "+connection.getName()+" Left");
			sendAllMessage(connection.getName()+" Left");
			if (connections.size() == 0) {
				ableToType(false);
				startConnecting();
			}
		}
	}

	/**
	 * Changes whether you are permitted to type
	 * @param canType Whether you can type
	 */
	private void ableToType(boolean canType){
		userText.setEditable(canType);
	}

	/**
	 * Start's the background processes running in a new thread
	 */
	@FXML
	public void initialize(URL location, ResourceBundle resources) {
		chatWindow.textProperty().addListener(e->{
			chatWindow.setScrollTop(Double.MAX_VALUE);
		});

		Task task = new Task() {
			@Override
			protected Object call() throws Exception {
				return null;
			}

			@Override
			public void run() {
				startRunning();
			}
		};

		Thread thread = new Thread(task);
		thread.start();

	}

	/**
	 * Attempt's to send a message to all connected devices
	 */
	@FXML
	public void startSendMessage(){
		String message = userText.getText();
		if(message.equals("")||message.equals(" ")) return;
		showMessage("SERVER - "+message);
		sendAllMessage(message);
		userText.setText("");
	}

	/**
	 * Handles every connection. Only call with intent attempt to connect to a new device. Self-Sustaining (Recursive, in order to allow infinite connections)
	 */
	private void startConnecting(){
		new Thread(
				new Task() {
					@Override
					protected Object call() throws Exception {
						return null;
					}
					@Override
					public void run() {
						Connection connection = new Connection();
						try {
							waitForConnection();
							connection.setSocket(socket);
							setupStreams();
							connection.setInput(input);
							connection.setOutput(output);
							connections.add(connection);
							startConnecting();
							whileChatting(connection);
						} catch (EOFException e) {
							showMessage("Server ended the socket");
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							closeConnection(connection);
						}
					}
				}
		).start();
	}
}
