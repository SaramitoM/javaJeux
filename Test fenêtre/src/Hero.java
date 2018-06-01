import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Hero {
	
	
	
	
	private boolean isAlive;
	private int lives;
	private int AxeX;
	private int AxeY;
	private String imagePath;
	
	
	public void paintComponent( Graphics g) {
	
	}
	
	//Constructors
	
	public Hero( int lives, int AxeX, int AxeY, String imagePath, boolean isAlive)
	{
		super();
		this.setAxeX(AxeX);
		this.setAxeY(AxeY);
		this.setImagePath(imagePath);
		this.setLives(lives);
		this.setAlive(isAlive);
	}
	
	public void drawPlayer(Graphics g) {
		ImageIcon img = new ImageIcon(imagePath);
		g.drawImage(img.getImage(), AxeX, AxeY, null);
		}

	

	public int getAxeX() {
		return AxeX;
	}

	public void setAxeX(int axeX) {
		AxeX = axeX;
	}

	public int getAxeY() {
		return AxeY;
	}

	public void setAxeY(int axeY) {
		AxeY = axeY;
	}
	
	
	
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		if(imagePath==null)
			JOptionPane.showMessageDialog(null, "Invalid string !");
		else if(imagePath.length()==0)
			JOptionPane.showMessageDialog(null, "String Empty !");
		else
		this.imagePath = imagePath;
	}
	
	
}