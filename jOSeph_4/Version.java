package jOSeph_4;

public class Version {

	//Temp names to hold version information. There should only be 1 object instance at any time
	private String a = "Fairly Stable";
	private int[] b = {4,1,2};
	private String c = "Alpha";

	public Version(){
		//Temp for if later needed
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public int[] getB() {
		return b;
	}

	public void setB(int[] b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	//Gets version in "x.y.z" form
	public String bToString(){
		String version = "";
		for(int x:b) {
			version+=x+".";
		} version = version.substring(0,version.length()-1);
		return version;
	}
}
