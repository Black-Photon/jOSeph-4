package questionareGui;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class CreateNotepad {
	
	//So complex i'm just leaving it for now. You shouldn't need to use it much
	
	private static Scanner read;
	public static String[] load(boolean create, String info[]){
		String[] basic = {"","","","",""};
		String[] text=info;
		File use = new File("jOSeph_"+Generator4.user+".txt");
		
		if(create){
			createFile();
			writeFile(text);
			closeFile();
			return basic;
		}else{
			if(use.isFile()){
				loadFile();
				return readFile();
			}else{
				return basic;
			}
		}
		
	}
	private static Formatter file;
	public static void createFile(){
		try{
			file = new Formatter("jOSeph_"+Generator4.user+".txt");
		}catch(Exception e){
			AlertBox_GUI.display("Error...", "Error trying to write a new file", "Return", 300);
		}
		File use = new File("jOSeph_"+Generator4.user+".txt");
		try{
			read = new Scanner(use);
		}catch(Exception e){
			System.out.println("Error?");
		}
	}
	public static void loadFile(){
		File use = new File("jOSeph_"+Generator4.user+".txt");
		try{
			read = new Scanner(use);
		}catch(Exception e){
			System.out.println("Error");
		}
		
	}
	public static void writeFile(String[] x){
		int z = 0;
		while(z<x.length){
			file.format("%s %s ",x[z],";");
			z++;
		}
	}
	
	public static String[] readFile(){
		String[] text = {"","","","",""};
		String letter;
		String thisText="";
		int count = 0;
		while(read.hasNext()){
			letter = read.next();
			if(letter.equals(";")){
				text[count] = thisText;
				thisText = "";
				count++;
			}else{
				if(thisText != ""){
					thisText +=" "+letter;
				}else{
					thisText =letter;
				}
			}
		}
		return text;
		
	}
	public static void closeFile(){
		file.close();
		
	}
}
