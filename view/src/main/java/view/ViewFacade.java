package view;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.Scanner;
/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends JFrame implements IView {

	private static final long serialVersionUID = 1L;
	/**
     * Instantiates a new view facade.
     */
	JFrame frame = new JFrame("Lorann");
	int MyMap[] = new int[625];
	private int i = 0;
	
	
    public ViewFacade() {   super();    }
    
    public void Window(){
    	
    	frame.setTitle("LORANN - Play");
	    frame.setSize(900,900);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(new Panel(getMyMap())); 
	    frame.setVisible(true);
	 }
    
    public void closeWindow() {		frame.setVisible(false);	}
    
	public void Map(int number) {System.out.println("Load Map with this number : "+number);		MyMap[i] = number;	i++;	}
	
    public int[] getMyMap() {	return MyMap;	}

	public void setMyMap() {	i=0;	}
	
	public int ScanMap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, enter a number between 1 and 5 include :");
		int str = sc.nextInt();
		System.out.println("You choose : " + str);
		//sc.close();
		return str;
	}
	
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {  JOptionPane.showMessageDialog(null, message);    }
}
