// I make an extra class to add all media and customer is interested in receiving media
public class Cart extends MediaRentalManager{
	private String customerName;
	private String mediaTitle;
	private int NumOfMeida=0;
	
	//null constructor
	public Cart() {
		
	}
	
	//take the customer name and media title and add them to the cart
	public Cart(String customerName, String mediaTitle) {
		super();
		this.customerName = customerName;
		this.mediaTitle = mediaTitle;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getMediaTitle() {
		return mediaTitle;
	}
	
	public void setMediaTitle(String mediaTitle) {
		this.mediaTitle = mediaTitle;
	}
	
	public int getNumOfMeida() {
		return NumOfMeida;
	}

	public void setNumOfMeida(int numOfMeida) {
		NumOfMeida = numOfMeida;
	}

	public void updateNumOfMedia(String s) {
		if(s.equalsIgnoreCase("add")) {
			this.NumOfMeida++;
		}
		if(s.equalsIgnoreCase("remove")) {
			this.NumOfMeida--;
		}
	}
	
	@Override
	public String toString() {
		return "Cart [customerName=" + customerName + ", mediaTitle=" + mediaTitle + "]";
	}
}

/*
Pierre Backleh
1201296
*/