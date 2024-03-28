//media class contains title/number of copies every media in the class
public abstract class Media implements Comparable<Media>{
	private String title;
	private int NumOfCopies;
	private boolean cart;
	
	//null constructor
	public Media() {
		
	}
	
	//take the title and the number of copies and add them to the media
	public Media(String title, int numOfCopies) {
		super();
		this.title = title;
		NumOfCopies = numOfCopies;
	}
	
	public int getNumOfCopies() {
		return NumOfCopies;
	}
	
	public void setNumOfCopies(int numOfCopies) {
		NumOfCopies = numOfCopies;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isCart() {
		return cart;	
	}
	
	public void setCart(boolean cart) {
		this.cart=cart;
	}
	
	public void updateNumOfCopies(String x) {
		if(x.equalsIgnoreCase("remove")) {
			this.NumOfCopies--;
		}
		if(x.equalsIgnoreCase("add"))
			this.NumOfCopies++;
	}

	public abstract String toString();
	
	@Override
	public int compareTo(Media me) {
		Media temp=me;
		return this.getTitle().compareToIgnoreCase(temp.getTitle());
	}

}

/*
Pierre Backleh
1201296
*/