package jOSeph_4;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

public class Encryption {

	public static Random random;

	/* Takes text to encode and keycode, and encodes it, returning the result
	 *
	 *
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

	/* Takes text to decode and keycode, and decodes it, returning the result
	 *
	 *
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
	
	
	
	
	
	
	
	
	
	
	
	
}
