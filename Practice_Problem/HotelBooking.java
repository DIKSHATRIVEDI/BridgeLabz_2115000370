import java.util.Scanner;
public class HotelBooking{
    String guestName;
	String roomType;
	int nights;
	public HotelBooking(){
	    this("Guest", "Standard", 1);
	}
	public HotelBooking(String guestName,String roomType,int nights){
	    this.guestName=guestName;
		this.roomType=roomType;
		this.nights=nights;
	}
	public HotelBooking(HotelBooking other){
	    this.guestName=other.guestName;
		this.roomType=other.roomType;
	    this.nights=other.nights;
	}
	public void display(){
	    System.out.println("Guest Name "+guestName);
		System.out.println("Room Type "+roomType);
		System.out.println("Number of Nights "+nights);
	}
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
		System.out.print("Enter guest name ");
		String guestName=sc.nextLine();
		System.out.print("Enter room type ");
		String roomType=sc.nextLine();
		System.out.print("Enter number of nights ");
		int nights=sc.nextInt();
		HotelBooking booking1=new HotelBooking(guestName,roomType,nights);
		HotelBooking booking2=new HotelBooking(booking1);
		booking1.display();
		System.out.println("Copied through constructor ");
		booking2.display();
	}
}