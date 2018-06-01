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

public class TestHero extends JPanel implements KeyListener {
	
	
	private Hero perso = new Hero(5,250,250, "src/lorann_u.png",true );	
	private Evil evil = new Evil(5, 30,30 , "src/monster_1.png",true, this, perso);
	private Evil evilII = new Evil (5,450,450, "src/monster_2.png", true, this, perso );
	private Spell sp = new Spell(5,2000,2000, "src/fireball_2.png", false, this, perso, evil, evilII);
	private JFrame window =  new JFrame("Level 1");
	private ImageIcon background = new ImageIcon("src/noir.png");

	public boolean Fire = true;
	public int directionx;
	public int directiony;
	public boolean B = true;
	public int heightofscene = 640;
	public int widthofscene = 1100;
	
	
	
	public TestHero() {
		
		
			this.setFocusable(true);
			this.addKeyListener(this);
			window.add(this);
			Thread th = new Thread(evil);
			Thread thII = new Thread(evilII);
			Thread spell = new Thread(sp);
			th.start();
			thII.start();
			spell.start();
			window.setSize(widthofscene, heightofscene);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);	
		
        
        
    }
	public void paint(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, null);
		perso.drawPlayer(g);
		evil.drawPlayer(g);
		evilII.drawPlayer(g);
		sp.drawPlayer(g);
	}
 
    // Méthode redéfinie depuis KeyListener
    public void keyPressed(KeyEvent key)
    {
        // touche pressée
         
        // Je test les valeurs de ma touche
         
        int codeDeLaTouche = key.getKeyCode();
         
        switch (codeDeLaTouche) // Les valeurs sont contenue dans KeyEvent. Elles commencent par VK_ et finissent par le nom de la touche
        {
            case KeyEvent.VK_UP: // si la touche enfoncée est celle du haut
            	perso.setAxeY(perso.getAxeY()- 32);
    			perso.setImagePath("src/lorann_u.png");
    			this.repaint();
    			Break();
    			directiony = 1;
    			directionx=3;
                break;
            case KeyEvent.VK_LEFT: // si la touche enfoncée est celle de gauche
            	perso.setAxeX(perso.getAxeX()- 32);
    			perso.setImagePath("src/lorann_l.png");
    			this.repaint();
    			directionx=0;
    			directiony=3;
    			Break();
                break;
            case KeyEvent.VK_RIGHT: // si la touche enfoncée est celle de droite
            	perso.setAxeX(perso.getAxeX()+ 32);
    			perso.setImagePath("src/lorann_r.png");
    			this.repaint();
    			directionx   = 1;
    			directiony=3;
    			Break();
                break;
            case KeyEvent.VK_DOWN: // si la touche enfoncée est celle du bas
            	perso.setAxeY(perso.getAxeY()+ 32);
    			perso.setImagePath("src/lorann_b.png");
    			this.repaint();
    			directiony=0;
    			directionx=3;
    			Break();
                break;
            case KeyEvent.VK_SPACE: 
            	if (Fire ==true) {
            	sp.setAxeX(perso.getAxeX()+32);
            	sp.setAxeY(perso.getAxeY()+32);
            	sp.setImagePath("src/fireball_2.png");
            	Fire = false;
            	B = false;
            	}
            	break;
            	
            
        }
        
        
       
        	
        	
        }
        
    

 
    // Méthode redéfinie depuis KeyListener
    public void keyReleased(KeyEvent key)
    {
        // touche relachée
    }
 
    
     
    
    public void Break() {
    	
    	if (perso.getAxeX()>=this.getWidth()-30)
    	{
    		perso.setAxeX(perso.getAxeX()-32);
    	}else if (perso.getAxeX()<=-5)
    	{
    		perso.setAxeX(perso.getAxeX()+32);
    	}else if (perso.getAxeY()>=this.getHeight()-30)
    	{
    		perso.setAxeY(perso.getAxeY()-32);
    	}else if (perso.getAxeY()<=-5)
    	{
    		perso.setAxeY(perso.getAxeY()+32);
    	}
    }
    
  
    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    

	
}
