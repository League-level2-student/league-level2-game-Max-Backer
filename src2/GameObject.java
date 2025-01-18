import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle rect;
	
	public GameObject(int x, int y, int width, int height) {
		this.height = height;
		this.x = x;
		this.y = y;
		this.width = width;
		 rect = new Rectangle(x, y, width, height);
		
	}
	
	public void update() {
		rect.setBounds(x, y, width, height);
	}

}
