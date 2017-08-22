package jOSeph_4.core.newOption;

import jOSeph_4.Version;

public class Tab {
	private Version version;
	private String info;
	Tab(Version version, String info){
		this.version = version;
		this.info = info;
	}


	//Getters and setters

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
