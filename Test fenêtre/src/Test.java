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
		    
		    //Centrer la fnêtre au centre de l'écran
		    this.setLocationRelativeTo(null);
		    // Faire quitter le programme quand on ferma le fenêtre
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		   
		    //Prévenir JFrame de JPanel
		    this.setContentPane(pan);
		    
		   
		    //Rendre la fenêtre visible
		    this.setVisible(true);
		    evilmove(pan.getPosX(), pan.getPosY(),2 + r.nextInt(2));
		    evilmove(pan.getPos1X(), pan.getPos1Y(),4 + r.nextInt(1));
	}
	
	private void evilmove(int x, int y, int v) {
		
		
		//Créer un variable qui désigne lorsque l'ennemi touche un rebord
		int t=1;
		while  (true) {
			//Déplacement de l'ennemi horizontalement
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
			
			//Pause pour apercevoir le déplacement
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			} else {
				
				//Vitesse inversée
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
			//L'ennemie touche le haut de l'écran
			if (y<0) {
				t=1;
			}
		}
		
		//Déplacement horizontal inversé de l'ennemie
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
