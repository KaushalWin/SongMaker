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
	HashMap<String,HashMap<String, NoteTree>> mood;
	public GenerateDB(ServletContext context) {
		HashMap<String, NoteTree> song=null;
		
		TxtReader tr=null;
		ArrayList<Note> alm=null;
		this.context = context;
		try {
			mood=new HashMap<>();
			for(String a:new File(context.getResource("/DATA").getPath()).list()) {
				song=new HashMap<>();
				for(File b:new File(context.getResource("/DATA/"+a).getPath()).listFiles()) {
					tr=new TxtReader();
					
					tr.openFile(b);
					alm=tr.getAlm();
					if(alm==null) {
						System.out.println("ERROR JAHUINJ");
						continue;
					}
					song.put(b.getName(), NoteTree.generateNoteTree(alm));
				}
				
				mood.put(a, song);				
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
