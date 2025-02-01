import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Character extends GameObject {
	int yVelocity = 100;
	int gravity = 5;
	int acceleration = 0;

	boolean onGround = true;

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Character(int x, int y, int width, int height) {
		super(x, y, width, height);

		if (needImage) {
			loadImage("1628971969992651.png");
		}

	}

	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

	}

	public void update() {
		super.update();
		y += acceleration;

		if (y >= EndlessRunner.HEIGHT - 150) {
			acceleration = 0;
			onGround = true;
		}

		if (!onGround) {
			acceleration += gravity;
		}
	}

	public void jump() {
		if (onGround) {
			acceleration -= 50;
			onGround = false;
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
