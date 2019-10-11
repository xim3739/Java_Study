package chess;

import javafx.scene.image.Image;

public class Pawn {
	private Image image;
	public Pawn() {
		this.image = new Image("/images/pawn.png", 80.0, 80.0, false, true);
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
}
