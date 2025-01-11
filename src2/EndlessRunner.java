import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class EndlessRunner implements ActionListener {
	JFrame frame;
	GamePanel gamePanel;
	public static int WIDTH = 800;
	public static int HEIGHT = 800;
	
	public EndlessRunner() { 
		frame = new JFrame();
		gamePanel = new GamePanel();
		
		createGUI();	 
	}
	
	public void createGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		
		frame.add(gamePanel);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}