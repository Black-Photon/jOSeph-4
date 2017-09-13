package jOSeph_4.files;

import jOSeph_4.Variable;

import java.io.File;
import java.io.IOException;

public class NotesFiles extends Files {
	public void saveNotes(File file, String text) throws IOException {
		createFile(Variable.getUser()+"/"+file.getName());
		formatter.format(text);
		closeFile();
	}
	public String readNotes(File file) throws IOException{
		loadFile(file);
		String answer = readFile(file);
		scanner.close();
		return answer;
	}
}
