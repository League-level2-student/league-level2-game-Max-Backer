import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject {
	int yVelocity = 100;
	int gravity = 5;
	int acceleration = 0;

	boolean onGround = true;

	public Character(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

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
			acceleration -= 60;
			onGround = false;
		}
	}

}
