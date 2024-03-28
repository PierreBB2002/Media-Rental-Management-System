//this game class be inherited from media super class
public class Game extends Media {
	private double weight;
	
	//null constructor
	public Game() {
		
	}

	//taking title/number of copies from super class and weight from this class and add them to the album
	public Game(String title, int numOfCopies, double weight) {
		super(title, numOfCopies);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Game [title="+getTitle()+", number of copies available="+getNumOfCopies()+", weight=" + weight + "]";
	}
}

/*
Pierre Backleh
1201296
*/