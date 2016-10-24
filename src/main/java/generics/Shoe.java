package generics;

import java.awt.Color;

public class Shoe implements Clothing {
	private Color color;
	private int size;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Shoe [color=" + color + ", size=" + size + "]";
	}

	public Shoe(Color color, int size) {
		super();
		this.color = color;
		this.size = size;
	}

}
