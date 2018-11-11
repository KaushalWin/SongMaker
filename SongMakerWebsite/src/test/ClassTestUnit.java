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
    String nout;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/DATA");
		PrintWriter out = response.getWriter();
		GenerateDB db=new GenerateDB(context);
		HashMap<String, HashMap<String, NoteTree>> mood = db.getMood();
		Set<String> mkey = mood.keySet();
		HashMap<String, NoteTree> song=null;
		for(String a:mkey) {
			song = mood.get(a);
			out.append("<br/>"+a);
			for(String b: song.keySet()) {
				NoteTree abcd = song.get(b);
				out.append("<br/>&nbsp&nbsp&nbsp&nbsp:"+b+":"+abcd);
				nout="<br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
				if(abcd!=null) {displayNoteTree(abcd);out.append(nout);}
			}
		}
		
	}
	private void displayNoteTree(NoteTree root) {
		if(root.getRoot()!=null)nout+="("+root.getRoot().getFinalIndex()+","+root.getCount()+")_";
		if(root.getChildren().size()==0) {
			nout+="<br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
			return;
		}
		for(NoteTree a:root.getChildren()) {
			displayNoteTree(a);
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
