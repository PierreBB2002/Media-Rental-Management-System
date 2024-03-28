//this album class be inherited from media super class
public class Album extends Media {
	private String artist;
	private String song;
	
	//null constructor
	public Album() {
		
	}
	
	//taking the title/number of copies from the super class and artist name/song and add them to album
	public Album(String title,int NumOfCopies,String artist, String song) {
		super(title,NumOfCopies);
		this.artist = artist;
		this.song = song;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	@Override
	public String toString() {
		return "Album [title="+getTitle()+", number of copies available="+getNumOfCopies()+", artist=" + artist + ", song=" + song + "]";
	}
}

/*
Pierre Backleh
1201296
*/