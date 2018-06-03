package controller;

import java.sql.SQLException;
import java.util.List;
import model.Example;
import model.Level;
import model.IModel;
import view.IView;


/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {

    /** The view. */
    private final IView  view;

    /** The model. */
    private final IModel model;
    private int choice = 1;	
    private boolean loop = true;
    
     /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {
        /*this.getView().displayMessage(this.getModel().getExampleById(1).toString());
        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());
        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {message.append(example);message.append('\n');}
        this.getView().displayMessage(message.toString());*/
    	
    	/**
    	 * Load all map in a list*/
                
        final List<Level> level1 = this.getModel().getLevel1();
        final List<Level> level2 = this.getModel().getLevel2();
        final List<Level> level3 = this.getModel().getLevel3();
        final List<Level> level4 = this.getModel().getLevel4();
        final List<Level> level5 = this.getModel().getLevel5();
        
        /**
         * The player chooses the map and these conditions allow to load the database in a table
         */
//        while(loop) {
        	
        this.getView().displayMessage("Hello ! Which map would you load ?\n 1 : Level 1\n 2 : Level 2\n 3 : Level 3\n 4 : Level 4\n 5 : Level 5");
        choice = this.getView().ScanMap();
        if(choice == 1) {for(int i = 0;i<level1.size();i++) {System.out.print("I looped "+i+" times and from database I got this number : ");System.out.println(level1.get(i).getList());this.view.Map(level1.get(i).getList());}}
        if(choice == 2) {for(int i = 0;i<level2.size();i++) {System.out.print("I looped "+i+" times and from database I got this number : ");System.out.println(level2.get(i).getList());this.view.Map(level2.get(i).getList());}}
        if(choice == 3) {for(int i = 0;i<level3.size();i++) {System.out.print("I looped "+i+" times and from database I got this number : ");System.out.println(level3.get(i).getList());this.view.Map(level3.get(i).getList());}}
        if(choice == 4) {for(int i = 0;i<level4.size();i++) {System.out.print("I looped "+i+" times and from database I got this number : ");System.out.println(level4.get(i).getList());this.view.Map(level4.get(i).getList());}}
        if(choice == 5) {for(int i = 0;i<level5.size();i++) {System.out.print("I looped "+i+" times and from database I got this number : ");System.out.println(level5.get(i).getList());this.view.Map(level5.get(i).getList());}}
        if(choice == 6) {/*this.getView().closeWindow();*/loop = false;}
       
        this.getView().Window();
        this.getView().setMyMap();
//        }
    }
    
    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
}
