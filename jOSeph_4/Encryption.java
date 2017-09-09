package jOSeph_4;

import java.util.ArrayList;
import java.util.Random;

public class Encryption {

	public static Random random;
	public static int possibleChars = 95;

	/**
	 * Encrypts text with my algorithm
	 * @param text To encode
	 * @param code Used to convert to and from encoded
	 * @return Encrypted Text
	 */
	public static String encrypt(String text, String code){
		random = new Random();

		text = text.toUpperCase();
		code = code.toUpperCase();
        String ans = "";

        int count = 0;
        int keycount = 0;
        while (count<(text).length()){
            if(random.nextInt(2)==1){
                ans += text.charAt(count);
                ans += code.charAt(keycount);
                count++;
                keycount++;
                if(keycount==code.length()){
                    keycount=0;
                }
			}else{
				ans += code.charAt(keycount);
	            keycount++;
	            if(keycount==code.length()){
	                keycount=0;
	            }
			}
        }
		return ans;
	}

	/**
	 * Decrypts text with my algorithm
	 * @param text To decode
	 * @param code Used to convert to and from encoded
	 * @return Decrypted Text
	 */
	public static String decrypt(String text, String code){
		text = text.toUpperCase();
		code = code.toUpperCase();
        String ans = "";

        int count = 0;
        int keycount = 0;
        while (count<text.length()){
            if(text.charAt(count)==code.charAt(keycount)){
                count++;
                keycount++;
                if(keycount==code.length()){
                    keycount=0;
                }
			}else{
				ans+=text.charAt(count);
				count++;
			}
        }
		return ans;
	}


	//Following all part of hashEncrypt
	private static String textToConvert;

	/**
	 * A new trial method for passwords, involving the password not being decrypted at all
	 * @param text To encrypt
	 * @return The encrypted text
	 */
	public static String hashEncrypt(String text){
		if(text.equals("")){
			return "";
		}
		textToConvert = text;
		ArrayList<Integer> numberArray = stringToInts(text);
		ArrayList<Double> functionArray = generateFunction(text);
		ArrayList<Long> encodedArray = mainFormula(functionArray.get(0),functionArray.get(1),functionArray.get(2), numberArray);
		return arrayToString(encodedArray);
	}
	private static ArrayList<Integer> stringToInts(String text){
		ArrayList<Integer> numberArray = new ArrayList<Integer>();

		for(char i: text.toCharArray()){
			numberArray.add((int) i);
		}
		return numberArray;
	}
	private static ArrayList<Double> generateFunction(String code){
		ArrayList<Double> partsOfFormula = new ArrayList<Double>();

		double uniqueNumber = 0;

		//Should be careful to prevent multiple combinations - Default: 100
		int source = 100;

		for(int i = 0; i<code.length(); i++ ){
			uniqueNumber+= ((int) code.charAt(i))*Math.pow(100,i);
		}
		partsOfFormula.add(formulaA(uniqueNumber));
		partsOfFormula.add(formulaB(uniqueNumber));
		partsOfFormula.add(formulaC(uniqueNumber));
		return partsOfFormula;
	}
	private static String arrayToString(ArrayList<Long> encodedArray){
		String text = "";
		for(long i: encodedArray){
			text+=(char) ((i%possibleChars)+32);
		}
		return text;
	}

	private static double formulaA(double n){
		n = Math.pow(n, 1/textToConvert.length());
		return Math.abs(Math.pow(n,2)+2*n-5);
	}
	private static double formulaB(double n){
		n = Math.pow(n, 1/Math.pow(textToConvert.length(),1.7));
		return Math.abs(Math.pow(n,3)+n-5*Math.sqrt(n));
	}
	private static double formulaC(double n){
		n = Math.pow(n, 1/Math.pow(textToConvert.length(),2));
		return (n*Math.sqrt((n+1)*(n-n/2)));
	}

	private static ArrayList<Long> mainFormula(double a, double b, double c, ArrayList<Integer> text){
		ArrayList<Long> encoded = new ArrayList<Long>();
		for(int i:text){
			encoded.add(Math.round(a*Math.pow(i,2)+b*i+c));
		}
		return encoded;
	}
}
