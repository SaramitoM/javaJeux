import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.util.Scanner;

public class Test extends JFrame{
	
	private Panneau pan = new Panneau();
	Random r = new Random();
	
	
	
	
	
	public Test() {
		 this.setTitle("Level 1");
		 
		    this.setSize(500, 500);
		    
		    //Centrer la fn�tre au centre de l'�cran
		    this.setLocationRelativeTo(null);
		    // Faire quitter le programme quand on ferma le fen�tre
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		   
		    //Pr�venir JFrame de JPanel
		    this.setContentPane(pan);
		    
		   
		    //Rendre la fen�tre visible
		    this.setVisible(true);
		    evilmove(pan.getPosX(), pan.getPosY(),2 + r.nextInt(2));
		    evilmove(pan.getPos1X(), pan.getPos1Y(),4 + r.nextInt(1));
	}
	
	private void evilmove(int x, int y, int v) {
		
		
		//Cr�er un variable qui d�signe lorsque l'ennemi touche un rebord
		int t=1;
		while  (true) {
			//D�placement de l'ennemi horizontalement
		for( x = 0; x<= this.getWidth()-50; x++) {
			//Condition lorsqu'il touche verticalement
			if ( y> this.getHeight()-70) {
				
			t=0;
			}
			
			if ( t == 1) {
				
			//Vitesse verticale	
			y= y+v;
			
			//Refresh de l'ennemie 1
			pan.setPosX(x);
			pan.setPosY(y);
			pan.repaint();
			
			//Refresh de l'ennemie 2
			pan.setPos1X(pan.getPosY()-20);
			pan.setPos1Y(pan.getPosX()-20);
			pan.repaint();
			
			//Pause pour apercevoir le d�placement
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			} else {
				
				//Vitesse invers�e
				y = y-v;
				
				
				pan.setPosX(x);
				pan.setPosY(y);
				pan.repaint();
				
				pan.setPos1X(pan.getPosY()-20);
				pan.setPos1Y(pan.getPosX()-20);
				pan.repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
			}
			//L'ennemie touche le haut de l'�cran
			if (y<0) {
				t=1;
			}
		}
		
		//D�placement horizontal invers� de l'ennemie
		for (x = this.getWidth()-50; x !=0; x--) {
			
			if ( y> this.getHeight()-70) {
				
				t=0;
				}
				
				if ( t == 1) {
				
				y=y+v;
				pan.setPosX(x);
				pan.setPosY(y);
				pan.repaint();
				
				pan.setPos1X(pan.getPosY()-20);
				pan.setPos1Y(pan.getPosX()-20);
				pan.repaint();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
				} else {
					
					y = y-v;
					
					pan.setPosX(x);
					pan.setPosY(y);
					pan.repaint();
					
					pan.setPos1X(pan.getPosY()-20);
					pan.setPos1Y(pan.getPosX()-20);
					pan.repaint();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
						}
				}
				if (y<0) {
					t=1;
				}
			
			}
		}
	}


}
