import java.util.ArrayList;
//this interface class that contains all the methods used in the project
public interface MediaRentalInt{
	public void addCustomer(String cn,String cp,String ad);
	public void addGame(String title,int copiesAvailable,double weight);
	public void addAlbum(String title,int copiesAvailable,String artist,String songs);
	public void setLimitedPlanLimit(int value);
	public String getAllCustomersInfo();
	public String getAllMediaInfo();
	public boolean addToCart(String customerName,String mediaTitle);
	public boolean removeFromCart(String customerName, String mediaTitle);
	
	//this extra method that returns array list of media to use it in addToCart and processRequests methods
	String processRequests1();
	
	public boolean returnMedia(String customerName, String mediaTitle);
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs);
	public void addMovie(String mt,int nc,String rating);	
	public ArrayList <Media> getAllMediaInfo1();
}

/*
Pierre Backleh
1201296
*/