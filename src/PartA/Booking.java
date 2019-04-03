package PartA;

public class Booking {

	int bookingNo, noAdults, noChildren, noOAPs;
	String journeyCode, name, telephone, pickup, travelDate;
	String destination;
	public Booking(){
		this.bookingNo = 0;
		this.noAdults = 0;
		this.noChildren = 0;
		this.noOAPs = 0;
		this.journeyCode = "";
		this.name = "";
		this.telephone = "";
		this.pickup = "";
		this.travelDate = "";

	}
	
	public Booking(int bookingNo, int noAdults, int noChildren, int noOAPs, String journeyCode, 
			String name, String telephone, String pickup, String travelDate)
	{
		this.bookingNo = bookingNo;
		this.noAdults = noAdults;
		this.noChildren = noChildren;
		this.noOAPs = noOAPs;
		this.journeyCode = journeyCode;
		this.name = name;
		this.telephone = telephone;
		this.pickup = pickup;
		this.travelDate = travelDate;
	}
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public int getNoAdults() {
		return noAdults;
	}
	public void setNoAdults(int noAdults) {
		this.noAdults = noAdults;
	}
	public int getNoChildren() {
		return noChildren;
	}
	public void setNoChildren(int noChildren) {
		this.noChildren = noChildren;
	}
	public int getNoOAPs() {
		return noOAPs;
	}
	public void setNoOAPs(int noOAPs) {
		this.noOAPs = noOAPs;
	}
	public String getJourneyCode() {
		return journeyCode;
	}
	public void setJourneyCode(String journeyCode) {
		this.journeyCode = journeyCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String toString()
	{
		String str="";
		str = String.format("%-10s		%-10s		%-10s		%-10s		%-10s		%-10s		%-10s		%-10s		%-10s\n", 
		this.bookingNo,
		this.noAdults,
		this.noChildren, 
		this.noOAPs, 
		this.journeyCode, 
		this.name,
		this.telephone, 
		this.pickup, 
		this.travelDate);
		return str;
	}
	
	
	
	
}
