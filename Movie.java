//this movie class be inherited from media super class
public class Movie extends Media{
	private String rating;
	private String Code;
	
	//null constructor
	public Movie() {
		
	}

	//taking the title/number of copies from super class and rating and add them to movie class
	public Movie(String title,int NumOfCopies,String rating) {
		super(title,NumOfCopies);
		this.rating = rating;
	}
	
	public Movie(String title,int NumOfCopies,String rating, String Code) {
		super(title,NumOfCopies);
		this.rating = rating;
		this.Code=Code;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	@Override
	public String toString() {
		return "Movie [title="+getTitle()+", number of copies available="+getNumOfCopies()+", rating=" + rating +", code="+Code+"]";
	}
}

/*
Pierre Backleh
1201296
*/