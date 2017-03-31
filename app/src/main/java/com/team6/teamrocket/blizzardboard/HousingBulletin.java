package com.team6.teamrocket.blizzardboard;

/**
 * @author Jordan Kieltyka
 * @date March 16, 2017
 * @brief This class defines bulletins that list housing
 * 		  that is available for rent. Its parent class 
 * 		  is ForSaleBulletin.
 */

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HousingBulletin extends ForSaleBulletin{

	private Address address = new Address();					//the address of the living unit
	private int roommates = 0;									//number of roommates permitted
	private Date start = new Date();							//start day for living in unit
	private Date end = new Date();								//end day for living in unit
	private ArrayList<String> utilities = new ArrayList<String>();	//utilities that come with unit
	private ArrayList<String> appliances = new ArrayList<String>();	//appliances that come with unit
	
	/**
	 * Used to help construct the HousingBulletin object.
	 * 
	 * @param address - The address of the unit.
	 * @param roommates - The number of roommates permitted.
	 * @param start - The first day for living in the unit.
	 * @param end - The last day for living in the unit.
	 * @param utilities - Utilities that come with the unit.
	 * @param appliances - Appliances that come with the unit.
	 */
	private void housingBulletinConstructor(Address address, int roommates, Date start, Date end, ArrayList<String> utilities, ArrayList<String> appliances){
		setAddress(address);
		setRoommates(roommates);
		setStart(start);
		setEnd(end);
		setUtilities(utilities);
		setAppliances(appliances);
	}
	
	//constructors
	public HousingBulletin(){
		super();
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	public HousingBulletin(Address address){
		super();
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	public HousingBulletin(int price){
		super(price);
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	public HousingBulletin(int price, Address address){
		super(price);
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	public HousingBulletin(int price, Date start, Date end){
		super(price);
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	public HousingBulletin(Address address, Date start, Date end){
		super();
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	public HousingBulletin(int price, Address address, Date start, Date end){
		super(price);
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	public HousingBulletin(Address address, int roommates, Date start, Date end, ArrayList<String> utilities, ArrayList<String> appliances){
		super();
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	public HousingBulletin(int price, Address address, int roommates, Date start, Date end, ArrayList<String> utilities, ArrayList<String> appliances){
		super(price);
		housingBulletinConstructor(address, roommates, start, end, utilities, appliances);
	}
	
	//set methods
	public void setAddress(Address address){this.address = address;}
	public void setRoommates(int roommates){this.roommates = roommates;}
	public void setStart(Date start){this.start = start;}
	public void setEnd(Date end){this.end = end;}
	public void setUtilities(ArrayList<String> utilities){this.utilities = utilities;}
	public void setAppliances(ArrayList<String> appliances){this.appliances = appliances;}
	
	//get methods
	public Address getAddress(){return address;}
	public int getRoommates(){return roommates;}
	public Date getStart(){return start;}
	public Date getEnd(){return end;}
	public ArrayList<String> getUtilities(){return utilities;}
	public ArrayList<String> getAppliances(){return appliances;}
	
	/* Unimplemented Methods */
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
	public Map<String, Object> toMap() {
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
		result.put("Pictures",pictures);
		result.put("Condition",condition);
		result.put("Price",price);
		result.put("Roommates",roommates);
		result.put("Start", start);
		result.put("End",end);
		result.put("Utilities",utilities);
		result.put("Appliances",appliances);
		return result;
	}
}