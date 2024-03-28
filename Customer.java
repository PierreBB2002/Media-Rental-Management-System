import java.util.ArrayList;
//this customer class contains the name of each cutomer/address/plan
public class Customer implements Comparable<Customer>{
	private String name;
	private String address;
	private String plan;
	//I used limitedMedia to initialize the value of the limited plan for each customer
	private int limitedMedia;
	//I used newLimitedMedia to change the value of the limited plan and it depends on the number of copies for each media
	private int newLimitedMedia;
	
	//null constructor
	public Customer() {
		
	}
	
	//add name/address/plan to this constructor
	public Customer(String name, String address, String plan) {
		super();
		this.limitedMedia=2;
		this.newLimitedMedia=2;
		this.name=name;
		this.address = address;
		this.plan = plan;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	public int getLimitedMedia() {
		return limitedMedia;
	}
	
	public void setLimitedMedia(int limitedMedia) {
		this.limitedMedia = newLimitedMedia;
	}

	
	public int getNewLimitedMedia() {
		return newLimitedMedia;
	}
	
	public void setNewLimitedMedia(int newLimitedMedia) {
		this.newLimitedMedia = newLimitedMedia;
	}
	
	@Override
	public String toString() {
		return "Customer [customer name="+name+", address=" + address + ", plan=" + plan + "]";
	}

	@Override
	public int compareTo(Customer o) {
		Customer temp=o;
		return this.getName().compareToIgnoreCase(temp.getName());
	}
}
