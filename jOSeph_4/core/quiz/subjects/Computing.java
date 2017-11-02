package jOSeph_4.core.quiz.subjects;

import jOSeph_4.core.quiz.Subject;

import java.util.ArrayList;

public class Computing extends Subject{
	public Computing(){
		super();
		thisSubjectShown = "Computing";
	}

	@Override
	public void start() {
		questions = new ArrayList<>();
		createQuestion("What is this made in?", new String[] {"C++","Java","Python","SQL"},this,2);
		createQuestion("Which Operating System is open source?", new String[] {"Windows","IOS","Linux","Android"},this,3);
		createQuestion("What does the computer use to access a website?", new String[] {"IP Address","Website URL","MAC Address","The Internet"},this,1);

		loadQuestion();
	}
}
