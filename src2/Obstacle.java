import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Obstacle extends GameObject {

	public Obstacle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);

	}
	
	public void update() {
		x-=10;
	}

}
