import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Obstacle extends GameObject {
	Random rand = new Random();
	int speed = rand.nextInt(14) + 12;

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	public Obstacle(int x, int y, int width, int height) {
		super(x, y, width, height);
				 
		if(needImage) {
			loadImage("10809503.png");
		}
	}

	public void draw(Graphics g) {
		if(gotImage) {
			g.drawImage(image, x, y, null);
		} else {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		}

	}

	public void update() {
		super.update();
		x -= speed;

		if (x + width < 0) {
			x = EndlessRunner.WIDTH;
			height = rand.nextInt(150) + 100;
			y = EndlessRunner.HEIGHT - height;
			speed = rand.nextInt(14) + 12;

		}
	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

}
