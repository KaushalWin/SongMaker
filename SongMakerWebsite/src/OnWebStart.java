

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import SongForest.GenerateDB;
import SongForest.NoteTree;

/**
 * Application Lifecycle Listener implementation class OnWebStart
 *
 */
@WebListener
public class OnWebStart implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public OnWebStart() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    	ServletContext context = arg0.getServletContext();
    	String fullPath = context.getRealPath("/DATA");
    	GenerateDB db=new GenerateDB(context);
		HashMap<String, HashMap<String, NoteTree>> mood = db.getMood();
		context.setAttribute("DATA", mood);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
