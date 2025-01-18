import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<Obstacle> obstacles = new ArrayList<>();
	Character character;
	

	public ObjectManager(Character character) {
		this.character = character;

	}
	
	public void addObstacle(Obstacle obstacle) {

		obstacles.add(obstacle);
		
	}

	public void draw(Graphics g) {
		for (Obstacle o : obstacles) {
			o.draw(g);

		}
		
		character.draw(g);
		
		

	}

}
