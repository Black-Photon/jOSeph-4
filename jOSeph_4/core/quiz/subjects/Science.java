package jOSeph_4.core.quiz.subjects;

import jOSeph_4.core.quiz.Subject;

import java.util.ArrayList;

public class Science extends Subject{
	public Science(){
		super();
		thisSubjectShown = "Science";
	}

	@Override
	public void start() {
		questions = new ArrayList<>();
		createQuestion("1m^3 of which is the heaviest?", new String[] {"Titanium","Iron","Uranium","Tungsten"},this,4);
		createQuestion("Which is a longitudinal wave?", new String[] {"Visible Light","Ultrasound","X-Rays","Water Waves"},this,2);
		createQuestion("How long for a pebble to drop 10m?", new String[] {"1s","1.4s","2s","5s"},this,2);

		loadQuestion();
	}
}
