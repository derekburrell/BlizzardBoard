package com.team6.teamrocket.blizzardboard;

/**
 * defines methods for an travel bulletin contains
 * greater detail than the standard bulletin
 * @author Mads Howard
 * @date 2017/03/14
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TravelBulletin extends Bulletin {
	
	private Date rideDate = new Date();
	private String destination = "Unknown";
	private int numSeats = 0;
	
	//constructors based on different inputs
	public TravelBulletin(Date rideDate, String destination, int numSeats){
		TravelBulletinConstructor(rideDate, destination, numSeats);
	}
	
	public TravelBulletin(){
		super();
		TravelBulletinConstructor(rideDate, destination, numSeats);
	}
	
	public TravelBulletin(String destination, int numSeats){
		super();
		TravelBulletinConstructor(rideDate, destination, numSeats);
	}
	
	public TravelBulletin(Date rideDate, int numSeats){
		super();
		TravelBulletinConstructor(rideDate, destination, numSeats);
	}
	
	public TravelBulletin(String destination, Date rideDate){
		super();
		TravelBulletinConstructor(rideDate, destination, numSeats);
	}
	
	public TravelBulletin(Date rideDate){
		super();
		TravelBulletinConstructor(rideDate, destination, numSeats);
	}
	
	public TravelBulletin(String destination){
		super();
		TravelBulletinConstructor(rideDate, destination, numSeats);
	}
	
	public TravelBulletin(int numSeats){
		super();
		TravelBulletinConstructor(rideDate, destination, numSeats);
	}

	// Helper method for the constructors
	public void TravelBulletinConstructor(Date rideDate, String destination, int numSeats){
		setRideDate(rideDate);
		setDestination(destination);
		setNumSeats(numSeats);
	}
	
	// getter/setter for number of seats avalible
	public int getNumSeats() {return numSeats;}
	public void setNumSeats(int numSeats) {this.numSeats = numSeats;}
	
	// getter/setter for destination
	public String getDestination() {return destination;}
	public void setDestination(String destination) {this.destination = destination;}
	
	// getter/setter for the departure date
	public Date getRideDate() {return rideDate;}
	public void setRideDate(Date rideDate) {this.rideDate = rideDate;}
	
	@Override
	public String toXMLTile() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toXMLFullPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Converts the bulletin into a map.
	 * @return The bulletin in map form.
	 */
	@Override
	public Map<String, Object> toMap(){
		HashMap<String, Object> result = new HashMap<>();
		result.put("Title",title);
		result.put("Description",description);
		result.put("Tags",tags);
		result.put("Date Created",dateCreated);
		result.put("Date Expires",dateExpires);
		result.put("Author",author);
		result.put("Rating",rating);
		result.put("Flags", flags);
		result.put("Address", address);
		result.put("Ride Date",rideDate);
		result.put("Destination",destination);
		result.put("Number of Seats",numSeats);
		return result;
	}
}
