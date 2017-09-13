package jOSeph_4.core;

import java.util.ArrayList;

public class Connection_Data {
	private String name;
	private String ip;
	private ArrayList ipArray;
	private int port;

	public Connection_Data(String name, String ip, int port){
		this.name = name;
		this.ip = ip;
		this.port = port;
	}
	public Connection_Data(String name, ArrayList ip, int port){
		this.name = name;
		this.ipArray = ip;
		this.port = port;
		this.ip = arrayToIp(ipArray);
		System.out.println("Created Connection "+name+" at "+this.ip+":"+port);
	}

	public boolean sameAs(Connection_Data data){
		if(name.equals(data.name) && ip.equals(data.ip) && port == data.port){
			return true;
		}
		return false;
	}

	private String arrayToIp(ArrayList array){
		StringBuilder sb = new StringBuilder();
		sb.append(array.get(0));
		sb.append(".");
		sb.append(array.get(1));
		sb.append(".");
		sb.append(array.get(2));
		sb.append(".");
		sb.append(array.get(3));
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public ArrayList getIpArray() {
		return ipArray;
	}

	public void setIpArray(ArrayList ipArray) {
		this.ipArray = ipArray;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
