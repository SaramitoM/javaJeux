
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class Panneau extends JPanel {
	
	private int posX = 50;
	private int posY = 50;
	
	private int pos1X = 200;
	private int pos1Y = 200;
	

	public void paintComponent( Graphics g) {
		
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.black);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0 , this.getWidth(), this.getHeight());
		
		
		try {
			Image img = ImageIO.read(new File("src/monster_1.png"));
			g.drawImage(img,  posX,posY, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Deuxième ennemie
				try {
					Image img = ImageIO.read(new File("src/monster_2.png"));
					g.drawImage(img,  pos1X,pos1Y, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getPos1X() {
		return pos1X;
	}

	public void setPos1X(int pos1x) {
		pos1X = pos1x;
	}

	public int getPos1Y() {
		return pos1Y;
	}

	public void setPos1Y(int pos1y) {
		pos1Y = pos1y;
	}

	public void setPosY(int posY) {
		this.posY = posY;
		}
	
	
	
	
	
	
	
}
