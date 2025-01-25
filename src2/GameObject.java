import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	
	boolean isActive;
	
	public GameObject(int x, int y, int width, int height) {
		this.height = height;
		this.x = x;
		this.y = y;
		this.width = width;
		collisionBox = new Rectangle(x, y, width, height);
		isActive = true;
		
	}
	
	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

}
