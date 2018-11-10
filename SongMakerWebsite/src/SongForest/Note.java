package SongForest;

public class Note {
	int finalIndex;
	int index;
	int octave;
	public Note(int finalIndex)
	{
		setFinalIndex(finalIndex);
	}
	public int getFinalIndex() {
		return finalIndex;
	}

	public void setFinalIndex(int finalIndex) {
		this.finalIndex = finalIndex;
		index=finalIndex%12;
		octave=finalIndex/12;
	}
}
