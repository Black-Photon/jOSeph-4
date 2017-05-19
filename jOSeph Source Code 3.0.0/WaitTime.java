package questionareGui;

import javafx.concurrent.Task;

import java.util.Random;

public class WaitTime implements Runnable{

	private Random rand;
	private static Load2 l;
	
	public WaitTime(){
		rand = new Random();
		l = new Load2();
	}
	
	@Override
	public void run() {
		System.out.println("Started");
		l.updateMessage("Starting configuration settings...");
		l.update(0.1f,120);
		l.update(0.2f,120);
		l.updateMessage("Saving Files to C:/Java/System/Projects...");
		l.update(0.3f,120);
		l.updateMessage("Searching for Updates...");
		l.update(0.4f,1500);
		l.updateMessage("Starting Launcher...");
		l.update(0.5f,600);
		int dictionaries = rand.nextInt(7);
		int update = rand.nextInt(3);
		l.updateMessage("Downloaded " + dictionaries + " dictionaries...");
		l.update(0.6f,600);
		l.update(0.7f,120);
		if(update==2){
			l.updateMessage("Update found...");
			l.update(0.8f,300);
			l.updateMessage("Downloading update...");
			l.update(0.9f,1800);
			l.updateMessage("Update downloaded.");
			l.update(1.0f,1500);
		}else{
			l.updateMessage("No updates found...");
			l.update(1.0f,150);
        }
		System.out.println("Done");
	}

}
