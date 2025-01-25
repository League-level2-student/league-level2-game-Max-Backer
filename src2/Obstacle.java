import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Obstacle extends GameObject {
	int speed = 10;
	Random rand = new Random();

	public Obstacle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);

	}
		
	public void update() {
		super.update();
		x-=speed;
		
		if(x + width < 0) {
			x = EndlessRunner.WIDTH;
			height = rand.nextInt(80, 130);
			y = EndlessRunner.HEIGHT - height;
			speed = rand.nextInt(9, 15);
			
		}
	}

}
