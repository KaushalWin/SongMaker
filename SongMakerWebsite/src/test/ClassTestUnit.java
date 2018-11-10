package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Directory;

import SongForest.GenerateDB;
import SongForest.NoteTree;

/**
 * Servlet implementation class ClassTestUnit
 */
@WebServlet("/ClassTestUnit")
public class ClassTestUnit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassTestUnit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/DATA");
		PrintWriter out = response.getWriter();
		GenerateDB db=new GenerateDB(context);
		HashMap<String, HashMap<String, NoteTree>> mood = db.getMood();
		Set<String> mkey = mood.keySet();
		HashMap<String, NoteTree> song=null;
		for(String a:mkey) {
			song = mood.get(a);
			for(String b: song.keySet()) {
				out.append("<br/>"+a+":"+b);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
