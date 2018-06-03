package view;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class Panel extends JPanel implements IPanel { 
	
	
	private static final long serialVersionUID = 1L;
	// Theses attributs allow to define the loop with correct arguments
	private int beginPos = 8;
	private int increment = 32;
	private int x = beginPos;
	private int y = beginPos;
	private int count = 0;
	private int rebounce = 25;
	private int lastPos = (rebounce-1)*increment+beginPos;
	private int MyMap[];
	
	public Panel(int [] MyMap) {
		this.MyMap = MyMap;
	}
	
	public void paintComponent(Graphics f){
		System.out.println("CALL ADD COMPONENENT ");
		try {
			// We need to put image's link without absolute link
			Image wallV = ImageIO.read(new File("D:\\Documents\\Cours Exia\\Projet 5 Java\\Lorann\\view\\src\\main\\java\\view\\vertical_bone.png"));
			Image wallH = ImageIO.read(new File("D:\\Documents\\Cours Exia\\Projet 5 Java\\Lorann\\view\\src\\main\\java\\view\\horizontal_bone.png"));
			Image wallC = ImageIO.read(new File("D:\\Documents\\Cours Exia\\Projet 5 Java\\Lorann\\view\\src\\main\\java\\view\\bone.png"));
			Image door = ImageIO.read(new File("D:\\Documents\\Cours Exia\\Projet 5 Java\\Lorann\\view\\src\\main\\java\\view\\gate_open.png"));
			Image start = ImageIO.read(new File("D:\\Documents\\Cours Exia\\Projet 5 Java\\Lorann\\view\\src\\main\\java\\view\\lorann_r.png"));
			Image loot = ImageIO.read(new File("D:\\Documents\\Cours Exia\\Projet 5 Java\\Lorann\\view\\src\\main\\java\\view\\purse.png"));
			Image nothing = ImageIO.read(new File("D:\\Documents\\Cours Exia\\Projet 5 Java\\Lorann\\view\\src\\main\\java\\view\\nothing.png"));
			Image img = nothing;
			for (int i = 0; i <MyMap.length;i++) {
				System.out.println("Hello world ! i = "+i);
				if (MyMap[i] == 0) {
					if (	(	(x == beginPos) || (x == lastPos)	) && (	(y == beginPos) || (y == lastPos)	)	) img = wallC;
					else if (	(	(count == 0) || (count == (rebounce-1)	)	)) img = wallV;
					else img = wallH;
					}
				if (MyMap[i] == 1) {img = start;}
				if (MyMap[i] == 2) {img = door;}
				if (MyMap[i] == 3) {img = nothing;}
				if (MyMap[i] == 4) {img = loot;}
				//if (MyMap[i] == 4) {f.setColor(Color.RED); img = loot;}
				//f.fillRect(x, y,30, 30);
			    f.drawImage(img, x, y,increment,increment, this);
				x += increment;
				count++;
				if (count >= rebounce) {
					x = beginPos;
					y += increment;
					count = 0;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
