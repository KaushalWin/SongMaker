package SongForest;

import java.util.ArrayList;
import java.util.Iterator;

public class NoteTree {
	 private Note root;
	 private  int count;
	 private int like;
	 private int hate;
	 private ArrayList<NoteTree> children;

	    public int getHate() {
		return hate;
	}

	public void setHate(int hate) {
		this.hate = hate;
	}

		public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

		public int getCount() {
	        return count;
	    }

	    public void setCount(int count) {
	        this.count = count;
	    }
	    
	    public Note getRoot() {
	        return root;
	    }

	    public void setRoot(Note root) {
	        this.root = root;
	    }

	    public NoteTree(Note root) {
	        this.root = root;
	     children = new ArrayList<>();
	        count = 0;
	    } 
	public NoteTree addChild(Note child) {
        Iterator<NoteTree> it = children.iterator();
        NoteTree t = null;

        while (it.hasNext()) {
            t = it.next();
            if (t.root.getFinalIndex() == child.getFinalIndex()) {
                return t;
            }
        }

        t = new NoteTree(child);
        children.add(t);
        //  insertionSort();
        return t;
    }
	public static NoteTree generateNoteTree(ArrayList<Note> n) {
        NoteTree root = new NoteTree(null), t = null;
        ArrayList<NoteTree> path = new ArrayList<>();
        int k;
        for (k = 1; k <= 6; k++) {

            for (int i = 0, j; i < n.size() - k + 1; i++) {
                t = root;
                for (j = i; j < i + k; j++) {
                    t = t.addChild(n.get(j));

                }
                t.count++;

            }

        }
        return root;
	}
	public static NoteTree generateNoteTree(ArrayList<Note> n,NoteTree root) {
        if(root==null) {
        	return generateNoteTree(n);
        }
        NoteTree t=null;
		ArrayList<NoteTree> path = new ArrayList<>();
        int k;
        for (k = 1; k <= 6; k++) {

            for (int i = 0, j; i < n.size() - k + 1; i++) {
                t = root;
                for (j = i; j < i + k; j++) {
                    t = t.addChild(n.get(j));

                }
                t.count++;

            }

        }
        return root;
	}
	public static NoteTree generateLikeTree(ArrayList<Note> n,NoteTree root) {
        if(root==null) {
        	root=new NoteTree(null);
        }
        NoteTree t=null;
		ArrayList<NoteTree> path = new ArrayList<>();
        int k;
        for (k = 1; k <= 6; k++) {

            for (int i = 0, j; i < n.size() - k + 1; i++) {
                t = root;
                for (j = i; j < i + k; j++) {
                    t = t.addChild(n.get(j));

                }
                t.like++;

            }

        }
        return root;
	}
	public static NoteTree generateHateTree(ArrayList<Note> n,NoteTree root) {
        if(root==null) {
        	root=new NoteTree(null);
        }
        NoteTree t=null;
		ArrayList<NoteTree> path = new ArrayList<>();
        int k;
        for (k = 1; k <= 6; k++) {

            for (int i = 0, j; i < n.size() - k + 1; i++) {
                t = root;
                for (j = i; j < i + k; j++) {
                    t = t.addChild(n.get(j));

                }
                t.hate++;

            }

        }
        return root;
	}
	
}
