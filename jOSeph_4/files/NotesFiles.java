package jOSeph_4.files;

import jOSeph_4.Variable;

import java.io.File;
import java.io.IOException;

public class NotesFiles extends Files {
	/**
	 * Saves the given text to the given notes file
	 * @param file To fill
	 * @param text To fill with
	 * @throws IOException
	 */
	public void saveNotes(File file, String text) throws IOException {
		createFile(Variable.getUser()+"/"+file.getName());
		formatter.format(text);
		closeFile();
	}

	/**
	 * Returns the entire contents of the file
	 * @param file To read
	 * @return The file contents
	 * @throws IOException
	 */
	public String readNotes(File file) throws IOException{
		loadFile(file);
		String answer = readFile(file);
		scanner.close();
		return answer;
	}
}
