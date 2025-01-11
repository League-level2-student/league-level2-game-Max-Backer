import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;

	Timer timer;
	Font font;
	Font font2;
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		font = new Font("Arial", Font.PLAIN, 85);
		font2 = new Font("Arial", Font.PLAIN, 45);

	}

	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if ( currentState == END) {
			drawEndState(g);
		}
	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, EndlessRunner.WIDTH, EndlessRunner.HEIGHT);
		
		g.setFont(font);
		g.setColor(Color.BLUE);
		g.drawString("EndlessRuner", 150, 110);
		
		g.setFont(font2);
		g.setColor(Color.RED);
		g.drawString("Objective: Survive as long as possible", 10, 250);
		g.drawString("Space to Start", 250, 330);

	}

	public void drawGameState(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, EndlessRunner.WIDTH, EndlessRunner.HEIGHT);

	}

	public void drawEndState(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
