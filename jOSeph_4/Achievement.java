package jOSeph_4;

import javafx.scene.image.Image;

public class Achievement {

	/* Holds all info relating to an achievement
	 *
	 */

	private Image image;
	private String title;
	private String description;
	private int level;
	private boolean obtained;
	private Achievement_Type type;

	public Achievement(String url, String title, String description, int level, Achievement_Type type){
		image = new Image("jOSeph_4/resources/images/achievements/"+url,true);
		this.title = title;
		this.description = description;
		this.level = level;
		this.type = type;
	}


	//Getters and Setters

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isObtained() {
		return obtained;
	}

	public void setObtained(boolean obtained) {
		this.obtained = obtained;
	}
}
