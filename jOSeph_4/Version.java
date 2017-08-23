package jOSeph_4;

public class Version {
	/**
	 * Holds info about a version
	 *
	 * @param a Stability, eg. Stable
	 * @param b Version No, eg. 4.2.0
	 * @param c Stage, eg. Alpha
	 */
	public Version(String a, int[] b, String c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	 * Holds info about a version
	 *
	 * @param b Version No, eg. 4.2.0
	 * @param c Stage, eg. Alpha
	 */
	public Version(int[] b, String c){
		this.b = b;
		this.c = c;
	}

	/**
	 * Use once - has current version data
	 */
	public Version(){

	}

	//Temp names to hold version information
	private String a = "Fairly Stable";
	private int[] b = {4,1,2,4};
	private String c = "Alpha";

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

	/**
	 * 	Gets version in "x.y.z" form
	 */
	public String bToString(){
		StringBuilder version = new StringBuilder("");
		for(int x:b) {
			version.append(x).append(".");
		}
		return version.substring(0,version.length()-1);
	}
	public String getWholeVersion(){
		return bToString() + " " + getC() + " - " + getA();
	}
	public String getMostVersion(){
		return bToString() + " " + getC();
	}
}
