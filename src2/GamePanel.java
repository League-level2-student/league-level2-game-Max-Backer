import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Obstacle obstacle;
	Character character = new Character(20, EndlessRunner.HEIGHT - 50, 20, 20);
	ObjectManager objectManager = new ObjectManager(character);

	Timer timer;
	Font font;
	Font font2;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		font = new Font("Arial", Font.PLAIN, 85);
		font2 = new Font("Arial", Font.PLAIN, 45);

		obstacle = new Obstacle(EndlessRunner.WIDTH, EndlessRunner.HEIGHT - 50, 50, 50); 
		
		timer.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
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
		g.drawString("Press Space to Start", 200, 330);

	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, EndlessRunner.WIDTH, EndlessRunner.HEIGHT);
		
		objectManager.draw(g);

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, EndlessRunner.WIDTH, EndlessRunner.HEIGHT);
		
		g.setFont(font2);
		g.setColor(Color.BLACK);
		g.drawString("You survived for this long", 50, 250);
		
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("You Died", 150, 110);
		

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
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				currentState = GAME;
			} else if (currentState == GAME) {
				currentState = END;
			} else if (currentState == END) {
				currentState = MENU;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		character.up = false;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
