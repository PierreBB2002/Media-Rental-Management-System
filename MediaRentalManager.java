import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MediaRentalManager implements MediaRentalInt{
	protected String name;
	private int limitedMedia;
	private ArrayList<Customer>arrCust=new ArrayList<>();
	private ArrayList<Media>arrMedia=new ArrayList<>();
	private ArrayList<Movie>arrMovie=new ArrayList<>();
	private ArrayList<Album>arrAlbum=new ArrayList<>();
	private ArrayList<Game>arrGame=new ArrayList<>();
	private ArrayList<String>media=new ArrayList<>();
	private ArrayList<String>mediaT=new ArrayList<>();
	private ArrayList<Cart>arrCart=new ArrayList<>();
	
	public MediaRentalManager() {
		//default value for the limited media
		this.limitedMedia=2;
		this.arrCust=new ArrayList<Customer>();
		this.arrMedia=new ArrayList<Media>();
	}
	
	public MediaRentalManager(String name) {
		super();
		this.name = name;
		this.limitedMedia=2;
		this.arrCust=new ArrayList<Customer>();
		this.arrMedia=new ArrayList<Media>();
	}
	
	protected String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Customer> getArrCust() {
		return arrCust;
	}
	
	public void setArrCust(ArrayList<Customer> arrCust) {
		this.arrCust = arrCust;
	}
	
	
	public ArrayList<Movie> getArrMovie() {
		return arrMovie;
	}
	
	public void setArrMovie(ArrayList<Movie> arrMovie) {
		this.arrMovie = arrMovie;
	}
	
	public ArrayList<Album> getArrAlbum() {
		return arrAlbum;
	}
	
	public void setArrAlbum(ArrayList<Album> arrAlbum) {
		this.arrAlbum = arrAlbum;
	}
	
	public ArrayList<Game> getArrGame() {
		return arrGame;
	}
	
	public void setArrGame(ArrayList<Game> arrGame) {
		this.arrGame = arrGame;
	}
	
	public ArrayList<Media> getArrMedia() {
		return arrMedia;
	}
	
	public void setArrMedia(ArrayList<Media> arrMedia) {
		this.arrMedia = arrMedia;
	}
	
	
	public ArrayList<String> getMedia() {
		return media;
	}

	public void setMedia(ArrayList<String> media) {
		this.media = media;
	}

	
	public int getLimitedMedia() {
		return limitedMedia;
	}

	public void setLimitedMedia(int limitedMedia) {
		this.limitedMedia = limitedMedia;
	}

	public ArrayList<Cart> getArrCart() {
		return arrCart;
	}

	public void setArrCart(ArrayList<Cart> arrCart) {
		this.arrCart = arrCart;
	}

	
	public ArrayList<String> getMediaT() {
		return mediaT;
	}

	public void setMediaT(ArrayList<String> mediaT) {
		this.mediaT = mediaT;
	}

	@Override
	public String toString() {
		return "MediaRentalManager [name=" + name + "]";
	}
	
	//to compare the current name with the specified name.
	public boolean equals(String name, ArrayList<Customer>arr) {
		boolean flag=false;
		for(int i=0;i<arr.size();i++) {
			Customer customers=arr.get(i);
			if(customers.getName()==name)
				return true;
		}
		return flag;
	}
	
	@Override
	public void addCustomer(String cn,String cp,String ad) {
		Customer customer=new Customer();
		ArrayList <Customer>arr=new ArrayList<>();
		customer=new Customer(cn,ad,cp);
		//adding customer to array list of customer
		arr.add(customer);
		System.out.println(customer.toString());
		setArrCust(arr);
		System.out.println("Add customer success!");
	}
	
	@Override
	public void addMovie(String mt,int nc,String rating) {
		Movie movies=new Movie();
		ArrayList <Movie>arr=new ArrayList<>();
		movies=new Movie(mt,nc,rating);
		arrMedia.add(movies);
		arr.add(movies);
		System.out.println(movies.toString());
		//adding movie to array list of movie and media
		setArrMovie(arr);
		media.add(arrMovie.toString());
		mediaT.add(movies.getTitle());
		System.out.println("Add movie success!");
	}
	
	@Override
	public void addGame(String title,int copiesAvailable,double weight) {
		Game games=new Game();
		ArrayList <Game>arr=new ArrayList<>();
		games=new Game(title,copiesAvailable,weight);
		arrMedia.add(games);
		arr.add(games);
		System.out.println(games.toString());
		//adding game to array list of game and media
		setArrGame(arr);
		media.add(arrGame.toString());
		mediaT.add(games.getTitle());
		System.out.println("Add game success!");
	}
	
	@Override
	public void addAlbum(String title,int copiesAvailable,String artist,String songs) {
		Album albums=new Album();
		ArrayList <Album>arr=new ArrayList<>();
		albums=new Album(title,copiesAvailable,artist,songs);
		arrMedia.add(albums);
		arr.add(albums);
		System.out.println(albums.toString());
		//adding album to array list of album and media
		setArrAlbum(arr);
		media.add(arrAlbum.toString());
		mediaT.add(albums.getTitle());
		System.out.println("Add album success!");
	}

	@Override
	public void setLimitedPlanLimit(int value) {
		this.limitedMedia=value;
	}
	
	public int getLimitedPlanLimit() {
		return limitedMedia;
	}
	
	@Override
	public String getAllCustomersInfo() {
		Collections.sort(arrCust);
		String CustomerInfo="Customer information:\n";
		for(int i=0;i<arrCust.size();i++) {
			CustomerInfo+=arrCust.get(i).toString()+"\n";
			setArrCust(arrCust);
		}
		return CustomerInfo;
	}
	
	@Override
	public String getAllMediaInfo() {
		Collections.sort(arrMedia);
		String mediaInfo="Media information:\n";
		for(int i=0;i<arrMedia.size();i++) {
			mediaInfo+=arrMedia.get(i).toString()+"\n";
			setArrMedia(arrMedia);
		}
		return mediaInfo;
	}
	
	//this extra method to return array list of media and use it in other methods
	@Override
	public ArrayList <Media> getAllMediaInfo1(){
		Collections.sort(arrMedia);
		ArrayList <Media>arr=new ArrayList<>();
		for(int i=0;i<arrMedia.size();i++) {
			arr.add(arrMedia.get(i));
			setArrMedia(arrMedia);
		}
		return arr;
	}
	
	@Override
	public boolean addToCart(String customerName, String mediaTitle) {
		Cart cart=new Cart();
		cart=new Cart(customerName,mediaTitle);
		ArrayList <Media>arr=getAllMediaInfo1();
		for(int i=0;i<arrCust.size();i++) {
			for(int j=0;j<arr.size();j++) {
				if(arrCust.get(i).getName().equalsIgnoreCase(customerName)&&arr.get(j).getTitle().equalsIgnoreCase(mediaTitle)) {
					if(arr.get(j).getNumOfCopies()>=0) {
						arrCart.add(cart);
						for(int k=0;k<arrCart.size();k++) {
							arrCart.get(k).updateNumOfMedia("add");
						}
						arr.get(j).updateNumOfCopies("remove");
						return true;
					}
				}
			}
		}
		return false;
		/*
		 * if the method returns true it means that the customer and the media are entered before by the user
		 * if the method returns false it means that either the customer or the media or both are not entered before by the user
		 */
	}
	
	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) {
		
		for(int i=0;i<arrCart.size();i++) {
			if(arrCart.get(i).getCustomerName().trim().equalsIgnoreCase(customerName)&&
					arrCart.get(i).getMediaTitle().trim().equalsIgnoreCase(mediaTitle)) {
				arrCart.remove(i);
				return true;
			}
		}
		return false;
		/*
		 * if the method returns true it means that the customer name and the media title is a part of the cart
		 * if the method returns false it means that the customer name and the media title is not a part of the cart
		 */
	}
	
	@Override
	public String processRequests1() {
		String proc="Process Requests: \n";
		ArrayList <Media>arr=getAllMediaInfo1();
		for(int c=0;c<arrCart.size();c++) {
			for(int p=0;p<arr.size();p++) {
				if(!arrCart.get(c).getMediaTitle().equalsIgnoreCase(arr.get(p).getTitle())) {
					arr.remove(p);
				}
			}	
		}
		for(int i=0;i<arrCart.size();i++) {
			for(int j=0;j<arrCust.size();j++) {
				if(arrCust.get(j).getPlan().equalsIgnoreCase("unlimited") && arrCart.get(i).getCustomerName().equalsIgnoreCase(arrCust.get(j).getName())) {
					proc+="sending "+arrCart.get(i).getMediaTitle()+" to "+arrCart.get(i).getCustomerName()+" \n";
				}
			}
		}
		return proc;
	}
	
	/*public String processRequests2() {
		String proc="Precess Requests: \n";
		ArrayList <Media>arr=getAllMediaInfo1();
		ArrayList <Cart>arr1=new ArrayList<>();
		int newLim=0;
		int index=0;
		int n=getLimitedMedia();
		int m=getLimitedPlanLimit();
		if(n==2) {
		for(int i=0;i<arrCart.size();i++) {
			for(int j=0;j<arrCust.size();j++) {
				if(arrCust.get(j).getPlan().equalsIgnoreCase("limited") && arrCart.get(i).getCustomerName().equalsIgnoreCase(arrCust.get(j).getName())) {
					for(int k=0;k<arr.size();k++) {
						if(arr.get(k).getTitle().equalsIgnoreCase(arrCart.get(i).getMediaTitle())) {
							int MX=arr.get(k).getNumOfCopies();
							int CDMX=arrCust.get(j).getLimitedMedia();
							if(MX<=CDMX && newLim==0) {
								//give a new value of limited media
								arrCust.get(j).setNewLimitedMedia(CDMX-MX);
								if(arrCust.get(j).getNewLimitedMedia()>0) {
									index=1;
								}
							}
							newLim=arrCust.get(j).getNewLimitedMedia();
							if(newLim!=0) {
								arr1.add(arrCart.get(i));
							}
						}
					}
				}
			}
		}
			for(int i=0;i<arrCart.size();i++) {
				for(int j=0;j<arrCust.size();j++) {
					if(arrCust.get(j).getPlan().equalsIgnoreCase("limited") && arrCart.get(i).getCustomerName().equalsIgnoreCase(arrCust.get(j).getName())) {
						for(int k=0;k<arr.size();k++) {
							if(arr.get(k).getTitle().equalsIgnoreCase(arrCart.get(i).getMediaTitle())) {
								int MX=arrCart.size();
								int CDMX=arrCust.get(j).getLimitedMedia();
								if(MX<=CDMX && newLim==0) {
									//give a new value of limited media
									arrCust.get(j).setNewLimitedMedia(CDMX-MX);
									if(arrCust.get(j).getNewLimitedMedia()>0) {
										index=1;
									}
								}
								newLim=arrCust.get(j).getNewLimitedMedia();
								if(newLim!=0) {
									arr1.add(arrCart.get(i));
								}
							}
						}
					}
				}
			}
		//this case is used to check if we can add media to the customer if he has a limited plan
		if(index==1) {
			for(int i=0;i<arr1.size();i++) {
				for(int j=0;j<arrCust.size();j++) {
					for(int k=0;k<arr.size();k++) {
						if(arr1.get(i).getMediaTitle().equalsIgnoreCase(arr.get(k).getTitle())&&arr1.get(i).getCustomerName().equalsIgnoreCase(arrCust.get(j).getName())) {
							if(arrCust.get(j).getNewLimitedMedia()>=arr.get(k).getNumOfCopies()) {
								proc+="sending "+arr1.get(i).getMediaTitle()+" to "+arr1.get(i).getCustomerName()+" \n";
							}
							else
								proc+="can't sending "+arr1.get(i).getMediaTitle()+" to "+arr1.get(i).getCustomerName()+" \n";
						}
					}
		}
		}
		}
		}
		if(n!=2) {
			for(int i=0;i<arrCart.size();i++) {
				for(int j=0;j<arrCust.size();j++) {
					if(arrCust.get(j).getPlan().equalsIgnoreCase("limited") && arrCart.get(i).getCustomerName().equalsIgnoreCase(arrCust.get(j).getName())) {
						for(int k=0;k<arr.size();k++) {
							if(arr.get(k).getTitle().equalsIgnoreCase(arrCart.get(i).getMediaTitle())) {
								int MX=arr.get(k).getNumOfCopies();
								int CDMX=arrCust.get(j).getLimitedMedia();
								if(MX<=CDMX && newLim==0) {
									//give a new value of limited media
									arrCust.get(j).setNewLimitedMedia(CDMX-MX);
									if(arrCust.get(j).getNewLimitedMedia()>0) {
										index=1;
									}
								}
								newLim=arrCust.get(j).getNewLimitedMedia();
								if(newLim!=0) {
									arr1.add(arrCart.get(i));
								}
							}
						}
					}
				}
			}
			//this case is used to check if we can add media to the customer if he has a limited plan
			if(index==1) {
				for(int i=0;i<arr1.size();i++) {
					for(int j=0;j<arrCust.size();j++) {
						for(int k=0;k<arr.size();k++) {
							if(arr1.get(i).getMediaTitle().equalsIgnoreCase(arr.get(k).getTitle())&&arr1.get(i).getCustomerName().equalsIgnoreCase(arrCust.get(j).getName())) {
								if(arrCust.get(j).getNewLimitedMedia()>=arr.get(k).getNumOfCopies()) {
									proc+="sending "+arr1.get(i).getMediaTitle()+" to "+arr1.get(i).getCustomerName()+" \n";
								}
								else
									proc+="can't sending "+arr1.get(i).getMediaTitle()+" to "+arr1.get(i).getCustomerName()+" \n";
							}
						}
			}
			}
			}
			}
			
		return proc;
	}*/

	public String processRequests2() {
		String proc="Precess Requests: \n";
		ArrayList <Media>arr=getAllMediaInfo1();
		//ArrayList <Cart>arr1=new ArrayList<>();
		int counter=0;
		for(int i=0;i<arr.size();i++) {
			for(int j=0;j<arrCart.size();j++) {
				for(int k=0;k<arrCust.size();k++) {
				if(arr.get(i).getTitle().equalsIgnoreCase(arrCart.get(j).getMediaTitle()) && arrCust.get(k).getPlan().equalsIgnoreCase("limited")) {
					if(arrCust.get(k).getName().equalsIgnoreCase(arrCart.get(j).getCustomerName())){
						counter++;
					}
					if(counter<=arrCust.get(k).getLimitedMedia()) {
						proc+="sending "+arrCart.get(j).getMediaTitle()+" to "+arrCart.get(j).getCustomerName()+"\n";
					}
					if(counter>arrCust.get(k).getLimitedMedia()) {
						proc+=arrCart.get(j).getCustomerName()+" can't buy all the products, only "+arrCust.get(k).getLimitedMedia()+" products \n";
					}
				}
				}
			}
		}
		return proc;
	}
	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		ArrayList <Media>arr=getAllMediaInfo1();
		for(int i=0;i<arrCart.size();i++) {
			for(int j=0;j<arr.size();j++) {
				for(int k=0;k<arrCust.size();k++) {
			if(arrCart.get(i).getCustomerName().trim().equalsIgnoreCase(customerName)&&
					arrCart.get(i).getMediaTitle().trim().equalsIgnoreCase(mediaTitle)) {
				//to remove the media which we want to return from the cart
				arrCart.remove(i);
				return true;
			}
			if(!arrCart.get(i).getCustomerName().trim().equalsIgnoreCase(customerName) || 
					!arrCart.get(i).getMediaTitle().trim().equalsIgnoreCase(mediaTitle))
				return false;
			if(arr.get(j).getTitle().equalsIgnoreCase(mediaTitle) && arrCust.get(k).getName().equalsIgnoreCase(customerName)) {
				//to re-calculation the value of limited media
				int MX=arrCust.get(k).getLimitedMedia()+arr.get(j).getNumOfCopies();
				 arrCust.get(k).setNewLimitedMedia(MX);
			}
				}
			}
		}
		for(int i=0;i<arrCart.size();i++) {
			for(int j=0;j<arrCust.size();j++) {
				if(arrCust.get(j).getPlan().equalsIgnoreCase("limited") && arrCart.get(i).getCustomerName().equalsIgnoreCase(arrCust.get(j).getName())) {
					for(int k=0;k<arr.size();k++) {
						if(arr.get(k).getTitle().equalsIgnoreCase(arrCart.get(i).getMediaTitle())) {
							int MX1=arr.get(k).getNumOfCopies();
							int CDMX=arrCust.get(j).getLimitedMedia();
							if(MX1<=CDMX) {
								return true;
							}
							if(MX1>CDMX) {
								return false;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs){
		
		ArrayList<String>searchMedia=new ArrayList<>();
	    for(int i=0;i<media.size();i++) {
			if(media.get(i).contains(title)&&mediaT.get(i).contains(title)) {
				searchMedia.add(mediaT.get(i));
			}
			if(media.get(i).contains(rating)||media.get(i).contains(artist)||media.get(i).contains(songs)) {
				searchMedia.add(mediaT.get(i));
			}
			
		}
		return searchMedia;
	}

	public boolean ifRepeat(String title, ArrayList <Cart> arrCart) {
		boolean flag=false;
		if(arrCart==null)
			return false;
		else
		{
			for(int i=0;i<arrCart.size();i++) {
				Cart cart=arrCart.get(i);
				if(cart.getMediaTitle().toLowerCase().trim().equals(title.toLowerCase()))
					return true;
			}
			return flag;
		}
	}
}

/*
Pierre Backleh
1201296
*/


