import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Evil extends Hero implements Runnable{

	
	private TestHero TestHero;
	Random random = new Random();
	public int xdirection=1;
	public int ydirection = 2;
	private Hero lorann;
	public Rectangle evilRect;
	
	public Evil(int lives, int AxeX, int AxeY, String imagePath, boolean isAlive, TestHero TestHero, Hero lorann) {
		super(lives, AxeX, AxeY, imagePath, isAlive);
		// TODO Auto-generated constructor stub
		this.TestHero = TestHero;
		this.lorann = lorann;
	}


	

	
	
	public void kill() {
		Rectangle lorannRect = new Rectangle(lorann.getAxeX(),lorann.getAxeY(),25,25);
		Rectangle evilRect = new Rectangle(this.getAxeX(),this.getAxeY(),25,25);
		
		if(lorannRect.intersects(evilRect)) {
			JOptionPane.showMessageDialog(null, "You died !");
			System.exit(0);
		}
	}
	

	@Override
	public void run() {
		while (true) {
		 try {
			
			 Thread.sleep(10);
		 }catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Thread interrupted");
			 System.exit(1);
		 }
		 
		 if(getAxeX() <= 0) {
			 xdirection = 1;
			 
			 
		 }
		 else if(getAxeX() >= ( TestHero.widthofscene- 50)) {
			 xdirection = -1;
			 
		 }
		 else if(getAxeY() <= 0) {
			 ydirection = 2;
			 
		 }
		 else if(getAxeY() >= ( TestHero.heightofscene - 70)) {
			 ydirection = -2;
			 
		 }
		 
		 
		 kill();
		 
		 this.setAxeX(getAxeX() + 2 *xdirection);
		 this.setAxeY(getAxeY() + 2 *ydirection);
		 TestHero.repaint();
		 
		 }
		
	}
}
