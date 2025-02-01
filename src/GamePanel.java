import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Obstacle obstacle;
	Character character = new Character(50, EndlessRunner.HEIGHT - 150, 85, 100);
	ObjectManager objectManager = new ObjectManager(character);

	Timer timer;
	Font font;
	Font font2;

	int score = 0;

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		font = new Font("Arial", Font.PLAIN, 80);
		font2 = new Font("Arial", Font.PLAIN, 40);

		obstacle = new Obstacle(EndlessRunner.WIDTH, EndlessRunner.HEIGHT - 150, 100, 200);
		
		if(needImage) {
			loadImage("gabriel-gabas-x-pmwxv17xss1tctdo6o1-1280.jpg");
		}

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
		g.drawString("Objective: Survive as long as possible", 53, 250);
		g.drawString("Press ENTER to Start", 200, 330);

	}

	public void drawGameState(Graphics g) {
		if (gotImage) {
			g.drawImage(image, 0, 0, EndlessRunner.WIDTH, EndlessRunner.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, EndlessRunner.WIDTH, EndlessRunner.HEIGHT);
		}
		
		objectManager.update();

		g.setFont(font2);
		g.setColor(Color.WHITE);
		g.drawString("Time Alive: " + score / 60, 15, 35);

		objectManager.draw(g);
		score++;

		if (!character.isActive) {
			currentState = END;
		}
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, EndlessRunner.WIDTH, EndlessRunner.HEIGHT);

		g.setFont(font2);
		g.setColor(Color.BLACK);
		g.drawString("You survived for " + score / 60 + " second(s)", 115, 250);

		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("You Died", 210, 120);

		g.setFont(font2);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to Restart", 145, 380);
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
				currentState = GAME;
				objectManager = new ObjectManager(character);
			} else if (currentState == END) {
				currentState = MENU;
				score = 0;
				character = new Character(50, EndlessRunner.HEIGHT - 150, 85, 100);
				objectManager = new ObjectManager(character);
			}
		}

		if (currentState == GAME && e.getKeyCode() == KeyEvent.VK_SPACE) {
			character.jump();
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
