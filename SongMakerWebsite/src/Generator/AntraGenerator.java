package Generator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import SongForest.Note;
import SongForest.NoteTree;

public class AntraGenerator {
	HashMap<String, HashMap<String, NoteTree>> DataSet;
	int antraTypes;
	int numberOfAntras;
	int NumberOfNotesPerLine=16;
	int NumberOfLinesInAntra=4;
	String mood;
	public AntraGenerator(HashMap<String, HashMap<String, NoteTree>> dataSet, int antraTypes, int numberOfAntras,
			String mood) {
		super();
		DataSet = dataSet;
		this.antraTypes = antraTypes;
		this.numberOfAntras = numberOfAntras;
		this.mood = mood;
	}
	public AntraGenerator(HashMap<String, HashMap<String, NoteTree>> dataSet, int antraTypes, int numberOfAntras) {
		super();
		DataSet = dataSet;
		this.antraTypes = antraTypes;
		this.numberOfAntras = numberOfAntras;
	}
	
	public AntraGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	public HashMap<String, HashMap<String, NoteTree>> getDataSet() {
		return DataSet;
	}
	public void setDataSet(HashMap<String, HashMap<String, NoteTree>> dataSet) {
		DataSet = dataSet;
	}
	public int getAntraTypes() {
		return antraTypes;
	}
	public void setAntraTypes(int antraTypes) {
		this.antraTypes = antraTypes;
	}
	public int getNumberOfAntras() {
		return numberOfAntras;
	}
	public void setNumberOfAntras(int numberOfAntras) {
		this.numberOfAntras = numberOfAntras;
	}
	public String GenerateAtras()
	{
		
		HashMap<String, NoteTree> song= DataSet.get(mood);
		NoteTree root=song.get("Antra");
		String Antraas="";
		for (int i = 0; i < numberOfAntras; i++) {
			 Antraas+=CreateAntra(root);
		}
		return Antraas;
	}
	
	public String CreateAntra(NoteTree root)
	{
		String Antra="";
		for (int i = 0; i < NumberOfLinesInAntra; i++) {
			Antra+=CreateAntraPhrase(root);
		}
		return "";
	}
	public String CreateAntraPhrase(NoteTree root)
	{
		Random a=new Random(System.currentTimeMillis());
		int f=0;
		String Phrase="";
		for (int i = 0; i < 10; i++) {
			ArrayList<NoteTree> FirstNote= root.getChildren();
			f=a.nextInt(FirstNote.size());
			NoteTree next=FirstNote.get(f);
			Phrase+=next.getRoot().getFinalIndex()+" ";
			if(next.getChildren().size()>0)
			{
				root=next;
			}
			else {
				
			}
		}
		return Phrase+"  \n";
	}
	
}
