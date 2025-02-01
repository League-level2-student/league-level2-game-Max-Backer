import java.awt.Graphics;

public class ObjectManager {
	Obstacle obstacle;
	Character character;

	public ObjectManager(Character character) {
		this.character = character;
		obstacle = new Obstacle(EndlessRunner.WIDTH, EndlessRunner.HEIGHT - 150, 100, 200);
	}

	public void draw(Graphics g) {

		obstacle.draw(g);
		character.draw(g);

	}

	public void update() {
		character.update();
		obstacle.update();

		if (character.isActive) {
			checkCollision();
		}

	}

	void checkCollision() {
		if (character.collisionBox.intersects(obstacle.collisionBox)) {
			character.isActive = false;
		}

	}

}
