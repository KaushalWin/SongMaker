package test;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Generator.AntraGenerator;
import SongForest.GenerateDB;
import SongForest.NoteTree;

/**
 * Servlet implementation class GenerateSong
 */
@WebServlet("/GenerateSong")
public class GenerateSong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateSong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("generate")!=null)
		{
		String mood=request.getParameter("mood").toString();
		String songName=request.getParameter("name").toString();
		ServletContext context = getServletContext();
		HashMap<String, HashMap<String, NoteTree>> roots = GenerateDB.getData(context);
		HashMap<String, NoteTree> song= roots.get(mood);
		NoteTree root=song.get("Antra");
		AntraGenerator ag=new AntraGenerator();
		String a=ag.CreateAntraPhrase(root);
		response.getWriter().append(a);
		}
		else
		{
			response.sendRedirect("view/HomePage.jsp");
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
