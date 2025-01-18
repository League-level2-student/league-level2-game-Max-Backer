import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject {
	boolean up;
	int yVelocity = -20;
	int gravity = 2;

	public Character(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);

	}

	public void update() {
		if (up) {
			y += yVelocity;
		}
		
		y -= gravity;

	}

}
