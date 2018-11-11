package SongForest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

public class GenerateDB {
	ServletContext context;
	HashMap<String, HashMap<String, NoteTree>> mood;
	public static HashMap<String, HashMap<String, NoteTree>> getData(ServletContext context){
    	String fullPath = context.getRealPath("/DATA");
    	GenerateDB db=new GenerateDB(context);
    	return db.getMood();
    }
	public GenerateDB(ServletContext context) {
		HashMap<String, NoteTree> song = null;
		NoteTree tm=null,tn=null;
		TxtReader tr = null;
		ArrayList<Note> alm = null;
		this.context = context;
		try {
			mood = new HashMap<>();
			for (File a : new File(context.getResource("/DATA").getPath()).listFiles()) {// mood
				song = new HashMap<>();
				tm=null;
				tn=null;
				for (File c : a.listFiles()) {// Raga
					if (c.isDirectory()) {
						for (File d : c.listFiles()) {// Antra or Mokhdo
							for (File b : d.listFiles()) {// DB Generate from text files
								if (b.isFile()) {
									tr = new TxtReader();

									tr.openFile(b);
									alm = tr.getAlm();
									if (alm == null) {
										System.out.println("ERROR JAHUINJ");
										continue;
									}else if(alm.size()==0) {
										System.out.println("ERROR sakskajs");
										continue;
									}
									
									if (d.getName().equals("Antra")) {
										tm=NoteTree.generateNoteTree(alm, tm);
									} else {
										tn=NoteTree.generateNoteTree(alm, tn);
									}
								}
							}
						}

					} else {
						// --------------->here enter code to insert like or dislike mood
						// wise<--------------------------------------
						// ----------->*******************************************************************<-----------------------------
					}
				}
				song.put("Antra", tm);
				song.put("Mokhda", tn);
				mood.put(a.getName(), song);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public HashMap<String, HashMap<String, NoteTree>> getMood() {
		return mood;
	}

	public void setMood(HashMap<String, HashMap<String, NoteTree>> mood) {
		this.mood = mood;
	}

}
