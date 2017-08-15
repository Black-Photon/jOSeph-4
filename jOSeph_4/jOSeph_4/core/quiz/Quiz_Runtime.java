package jOSeph_4.core.quiz;

import jOSeph_4.core.quiz.subjects.Computing;
import jOSeph_4.core.quiz.subjects.Maths;
import jOSeph_4.core.quiz.subjects.Science;

import java.util.ArrayList;

/**
 * Quiz Runtime is a simple class which holds the subjects to run
 *
 *
 *
 */


public class Quiz_Runtime {

	private static ArrayList<Subject> subjects;

	private static Subject maths;
	private static Subject science;
	private static Subject computing;

	//Creates all subjects for use
	public static void start(){
		maths = new Maths();
		science = new Science();
		computing = new Computing();
	}
	//Runs specific subjects made
	public static void startMaths(){
		maths.start();
	}
	public static void startSci(){
		science.start();
	}
	public static void startComp(){
		computing.start();
	}
}



























