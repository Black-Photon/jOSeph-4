package jOSeph_4;

/**
 * Contains all relevant info of stability jOSeph version
 */
public class Version {
	/**
	 * Holds info about stability version
	 *
	 * @param stability Stability, eg. Stable
	 * @param b Version No, eg. 4.2.0
	 * @param release Stage, eg. Alpha
	 */
	public Version(String stability, int[] b, String release){
		this.stability = stability;
		this.version = b;
		this.release = release;
	}
	/**
	 * Holds info about stability version
	 *
	 * @param b Version No, eg. 4.2.0
	 * @param release Stage, eg. Alpha
	 */
	public Version(int[] b, String release){
		this.version = b;
		this.release = release;
	}
	/**
	 * Use once - has current version data
	 */
	public Version(){

	}

	//Holds default version info
	/**
	 * Stability - Eg. Unstable, stable, fairly stable ect.
	 */
	private String stability = "Mostly Stable";
	/**
	 * Version to 4 sig figs - eg. 4.1.2.9
	 */
	private int[] version = {4,2,0,0};
	/**
	 * Release type: Alpha, Beta, Pre-Release, Release
	 */
	private String release = "Beta";

	public String getStability() {
		return stability;
	}

	public void setStability(String stability) {
		this.stability = stability;
	}

	public int[] getVersion() {
		return version;
	}

	public void setVersion(int[] version) {
		this.version = version;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	/**
	 * 	Gets version in "x.y.z" form
	 */
	public String versionToString(){
		StringBuilder version = new StringBuilder("");
		for(int x: this.version) {
			version.append(x).append(".");
		}
		return version.substring(0,version.length()-1);
	}

	/**
	 * Returns the version in a convenient string
	 * @return Whole version
	 */
	public String getWholeVersion(){
		return versionToString() + " " + getRelease() + " - " + getStability();
	}
	/**
	 * Returns the version without the stability in a convenient string
	 * @return Version
	 */
	public String getMostVersion(){
		return versionToString() + " " + getRelease();
	}
}
