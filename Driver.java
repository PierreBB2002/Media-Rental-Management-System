import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class Driver {
	// this method is used to check if the customer name exists before and to avoid the repetition
	public static boolean ifRepeat(String name, ArrayList <Customer>arrCust) {
		boolean flag=false;
		if(arrCust ==null)
			return false;
		else
		{
		for(int i=0;i<arrCust.size();i++) {
			Customer customers=arrCust.get(i);
			if(customers.getName().toLowerCase().trim().equals(name.toLowerCase()))
				return true;
		}
		return flag;
		}
	}
	
	public static void main(String[] args) throws IOException{
		MediaRentalManager m=new MediaRentalManager();
		Customer customer=new Customer();
		Movie movies=new Movie();
		Game games=new Game();
		Album albums=new Album();
		Cart cart=new Cart();
		//array list of customer type
		ArrayList <Customer>arrayCustomer=new ArrayList<>();
		
		//array list of media type
		ArrayList <Media>arrayMedia=new ArrayList<>();
		
		//array list of string to get the media information
		ArrayList <String>med=new ArrayList<>();
		
		ArrayList <String>ar=new ArrayList<>();
		//array list of cart type 
		ArrayList <Cart>arrayCart=new ArrayList<>();
		
		System.out.println("Enter a file name to save data in it");
		Scanner o=new Scanner(System.in);
		
		//to print data in a file
		String fileName=o.next().trim();
		
		FileWriter myFile=new FileWriter(fileName,true);
		PrintWriter out=new PrintWriter(myFile);
		
		while (true) {
			System.out.println("Welcome to the MEDIA RENTAL system ");
			System.out.println("1. Add Customer");
			System.out.println("2. Add Movie");
			System.out.println("3. Add Game");
			System.out.println("4. Add Album");
			System.out.println("5. Set Limited Plan value");
			System.out.println("6. Get All customers informations");
			System.out.println("7. Get All media informations");
			System.out.println("8. Add to cart");
			System.out.println("9. Remove from cart");
			System.out.println("10.ProcessRequests");
			System.out.println("11.Return Media");
			System.out.println("12.Search media");
			System.out.println("13.Exit and save in a file");
			System.out.print("Please enter your choice :");
			Scanner in =new Scanner(System.in);
			String choice =in.next();
			String name;
			switch (choice) {
			case "1" :
				System.out.println("Add Customer");
				Scanner inp1=new Scanner(System.in);
				while(true) {
					System.out.println("Please enter a customer name");
			        name=inp1.nextLine();
					if(ifRepeat(name,arrayCustomer)) {
						System.out.println("Customer name repeat, please re-enter a customer name");
						continue;
					}
					else 
						break;
				}
				System.out.println("enter a customer address");
				String add=inp1.nextLine();
				String plan;
				System.out.println("enter a customer plan");
				plan=inp1.nextLine().toLowerCase().trim();
				//to check if the entered plan is limited or unlimited
				while(!plan.equalsIgnoreCase("limited") && !plan.equalsIgnoreCase("unlimited")) {
					System.out.println("Re-enter a customer plan");
					plan=inp1.nextLine().toLowerCase().trim();
				}
				//adding the entered information to array list of customer
				customer=new Customer(name,add,plan);
				m.addCustomer(name, plan, add);
				arrayCustomer.add(customer);
				m.setArrCust(arrayCustomer);
				break;
            case "2":
            	System.out.println("Add Movie");
            	int copiesAvailable=0;
            	inp1=new Scanner(System.in);
            	System.out.println("enter a movie name");
            	String title=inp1.nextLine();
            	try {
            	System.out.println("enter the number of copies");
            	copiesAvailable=inp1.nextInt();
            	}
            	catch(Exception e){
            		System.out.println("wrong type of value entered");
            	}
            	System.out.println("Please enter a movie rating (DR or HR or AC): ");
        		String rating=in.next();
        		//to check if the entered rating is allowed or not
        		while (!rating.equalsIgnoreCase("DR")&&!rating.equalsIgnoreCase("HR")&&!rating.equals("AC")) {
        			System.out.println("Re-enter a movie rating");
        			rating=in.next().toLowerCase().trim();
        		}
        		//adding the entered information to array list of movie and to array list of media
        		m.addMovie(title, copiesAvailable, rating);
        		arrayMedia.add(movies);
        		med.add(movies.toString());
                break;
            case "3":
            	Scanner inp=new Scanner(System.in);
            	int numOfCopies=0;
            	double weight=0;
                System.out.println("Add Game");
                System.out.println("Please enter a game name: ");
        		String titleGame=inp.nextLine();
        		try {
        		System.out.println("Please enter the number of copies: ");
        		numOfCopies=inp.nextInt();
        		System.out.println("Please enter a game weight : ");
        		weight=inp.nextDouble();
        		}
        		catch(Exception e) {
        			System.out.println("wrong type of value entered");
        		}
        		//adding the entered information to array list of game and to array list of media
        		m.addGame(titleGame, numOfCopies, weight);
                med.add(games.toString());
                arrayMedia.add(games);
                break;
            case "4":
            	Scanner n=new Scanner(System.in);
            	int nc=0;
                System.out.println("Add Album");
                System.out.println("Please enter an album name: ");
        		String an=n.nextLine();
        		try {
        		System.out.println("Please enter the number of copies: ");
        		nc=n.nextInt();
        		}
        		catch(Exception e) {
        			System.out.println("wrong type of value entered");
        		}
        		Scanner input=new Scanner(System.in);
        		System.out.println("Please enter an artist name: ");
        		String art=input.nextLine();
        		System.out.println("Please enter a song: ");
        		String song=input.nextLine();
        		//adding the entered information to array list of album and to array list of media
        		m.addAlbum(an, nc, art, song);
				med.add(albums.toString());
				arrayMedia.add(albums);
                break;
            case "5":
            	//to set the number of media associated with the limited plan
            	System.out.println("Set Limited plan Limit");
            	try {
            	System.out.println("Please enter a value for limited plans");
            	int v=in.nextInt();
            	m.setLimitedMedia(v);
            	customer.setLimitedMedia(v);
            	m.setLimitedPlanLimit(v);
            	}
            	catch (Exception e){
            		System.out.println("wrong type of value entered!");
            	}
            	break;
          
            case "6":
            	System.out.println("Get All customers information");
            	out.println("Get All customers information");
            	String c=m.getAllCustomersInfo();
            	System.out.println(c);
            	out.println(c);
            	break;
            	
            case "7":
            	System.out.println("Get All media information");
            	out.println("Get All media information");
            	String m1=m.getAllMediaInfo()+"\n";
            	System.out.println(m1);
            	out.println(m1);
            	break;
            case "8":
            	boolean x;
            	System.out.println("Add to cart");
            	out.println("Add to cart");
            	Scanner sc=new Scanner(System.in);
            	System.out.println("Enter a customer name that you want to add media to his/her cart");
            	String name1=sc.nextLine();
            	System.out.println("Enter the media that you want to add it to the cart");
            	String media=sc.nextLine();
            	//adding the entered information to array list of cart
            	x=m.addToCart(name1,media);
            	cart.addToCart(name1, media);
            	arrayCart.add(cart);
            	System.out.println(x);
            	out.println(x);
            	break;
            case "9":
            	System.out.println("Remove from cart");
            	out.println("Remove from cart");
            	Scanner scn=new Scanner(System.in);
            	System.out.println("Enter a customer name that you want to remove media from his/her cart");
            	String name2=scn.nextLine();
            	System.out.println("Enter the media that you want to remove from the cart");
            	String media2=scn.nextLine();
            	cart.removeFromCart(name2, media2);
            	boolean y=m.removeFromCart(name2, media2);
            	arrayCart.remove(cart);
            	System.out.println(y);
            	out.println(y);
            	break;
            case "10":
            	//for unlimited plan
            	String pr=m.processRequests1();
            	System.out.println(pr);
            	//for limited plan
            	String pr1=m.processRequests2();
            	System.out.println(pr1);
            	out.println(pr);
            	out.println(pr1);
            	break;
            case "11":
            	System.out.println("Return Media");
            	out.println("Return Media");
            	Scanner scn1=new Scanner(System.in);
            	System.out.println("Enter a customer name that you want to return media from his/her cart");
            	String name3=scn1.nextLine();
            	System.out.println("Enter the media that you want to return");
            	String media3=scn1.nextLine();
            	cart.returnMedia(name3, media3);
            	boolean z=m.returnMedia(name3, media3);
            	//removing the selected media from the cart
            	arrayCart.remove(cart);
            	System.out.println(z);
            	out.println(z);
            	break;
            case "12":
            	//searching for media and sorting them
            	System.out.println("serach media");
            	out.println("search media");
            	Scanner input1=new Scanner(System.in);
            	System.out.println("Please enter a media title");
            	String title1=input1.nextLine();
            	System.out.println("Please enter a rating");
            	String rating1=input1.nextLine();
            	System.out.println("Please enter an artist");
            	String artist=input1.nextLine();
            	System.out.println("Please enter a song name");
            	String song1=input1.nextLine();
            	ar=m.searchMedia(title1, rating1, artist, song1);
            	Collections.sort(ar);
            	System.out.println("Sorted media by title");
            	for(int i=0;i<ar.size();i++) {
            		System.out.println(ar.get(i)+"\n");
            		out.println(ar.get(i)+"\n");
            	}
            	break;
            case "13":
            	out.close();
            	System.exit(0);
            default:
            	System.out.println("Illegal input, please re-enter your choice");
            	break;
			}
		}
	}
}

/*
Pierre Backleh
1201296
*/