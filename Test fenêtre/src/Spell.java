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
import java.awt.Image;

public class Spell extends Hero implements Runnable{

	
	private TestHero TestHero;
	Random random = new Random();
	public int xdirection=1;
	public int ydirection = 2;
	private Hero lorann;
	private Evil evil;
	private Evil evilII;
	public boolean A;
	int color;
	String tablecolor []=new String[5];
	
	
	
	
	public Spell(int lives, int AxeX, int AxeY, String imagePath, boolean isAlive, TestHero TestHero, Hero lorann, Evil evil, Evil evilII) {
		super(lives, AxeX, AxeY, imagePath, isAlive);
		// TODO Auto-generated constructor stub
		this.TestHero = TestHero;
		this.lorann = lorann;
		this.evil = evil;
		this.evilII=evilII;
		A=false;
	}


	

	
	
	public void kill() {
		Rectangle lorannRect = new Rectangle(lorann.getAxeX(),lorann.getAxeY(),32,32);
		Rectangle spellRect = new Rectangle(this.getAxeX(),this.getAxeY(),32,32);
		Rectangle evilRect = new Rectangle(evil.getAxeX(),evil.getAxeY(),25,25);
		Rectangle evilIIRect = new Rectangle(evilII.getAxeX(),evilII.getAxeY(),25,25);
		if(lorannRect.intersects(spellRect) ) {
				 
			
			A=false;
			TestHero.B=true;
			TestHero.Fire = true;
			this.setAxeX(getAxeX()-100000);
			this.setAxeY(getAxeY()-100000);
			
			
		}
		if (spellRect.intersects(evilRect))
		{
			
			evil.setAxeX(getAxeX()-66666);
			
		}
		if (spellRect.intersects(evilIIRect))
		{
			
			evilII.setAxeX(getAxeX()-66666);
			
		}
	}
	

	@Override
	public void run() {
		while (true) {
			
	 		
		 for(int i = 0;i<5;i++)
		 {
			
			
		 try {
			
			 Thread.sleep(8);
		 }catch(Exception e) {
			 JOptionPane.showMessageDialog(null, "Thread interrupted");
			 System.exit(1);
		 }
		 	tablecolor[0]="src/fireball_5.png";
			tablecolor[1]="src/fireball_1.png";
			tablecolor[2]="src/fireball_2.png";
			tablecolor[3]="src/fireball_3.png";
			tablecolor[4]="src/fireball_4.png";
		 
		 
		 if ( TestHero.directionx==1 && A==false && TestHero.B== false)
		 {
			this.setAxeX(lorann.getAxeX()+40);
			this.setAxeY(lorann.getAxeY());
			xdirection = 2;
			ydirection =0;
			TestHero.repaint();
         	A=true;
		 }
		 
		 if ( TestHero.directionx==0 && A ==false && TestHero.B== false)
		 {
			 	this.setAxeX(lorann.getAxeX()-40);
			 	this.setAxeY(lorann.getAxeY());
			 	TestHero.repaint();
			 	xdirection = -2;
			 	ydirection =0;
	         	A=true;
		 }
		 
		 if (TestHero.directiony==1 && A==false && TestHero.B== false)
		 {
			 this.setAxeX(lorann.getAxeX());
			 this.setAxeY(lorann.getAxeY()-40);
			 xdirection=0;
			 ydirection =-2;
			 TestHero.repaint();
			 A = true;
		 }
		 
		 if (TestHero.directiony==0 && A==false && TestHero.B== false)
		 {
			 this.setAxeX(lorann.getAxeX());
			 this.setAxeY(lorann.getAxeY()+40);
			 xdirection=0;
			 ydirection = 2;
			 TestHero.repaint();
			 A = true;
		 }
		 
		 
		 if(getAxeX() <= 0 ) {
			 
			 xdirection = 2;
			 
			 
		 }
		 else if(getAxeX() >= ( TestHero.widthofscene- 50) ) {
			 xdirection = -2;
			 
		 }
		 else if(getAxeY() <= 0 ) {
			 ydirection = 2;
			
		 }
		 else if(getAxeY() >= ( TestHero.heightofscene - 70) ) {
			 ydirection = -2;
			 
 		 }
		 
		 kill();
		 
		 
		 this.setAxeX(getAxeX() + 2 *xdirection);
		 this.setAxeY(getAxeY()+ 2*ydirection);
		 
		 
			
		
			 this.setImagePath(tablecolor[i]);
			 
			 
			 try {
					
				 Thread.sleep(5);
			 }catch(Exception e) {
				 JOptionPane.showMessageDialog(null, "Thread interrupted");
				 System.exit(1);
			 }
			 TestHero.repaint();
		 }
			   
		 
		 
		 }
		
	}
}
