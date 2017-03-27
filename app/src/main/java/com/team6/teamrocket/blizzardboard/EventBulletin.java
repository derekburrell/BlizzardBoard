package com.team6.teamrocket.blizzardboard;

/**
 * defines methods for an event bulletin contains
 * greater detail than the standard bulletin
 * @author Mads Howard
 * @date 2017/03/14
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class EventBulletin extends Bulletin {

	private ArrayList<File> pictures = new ArrayList<File>();
	private Date eventDate;
	private Address location;
	private String host;
	
	//Constructors based on different inputs
	public EventBulletin(){
		super();
		EventBulletinConstructor(eventDate, location, host);
	}
	
	public EventBulletin(Date eventDate, Address address, String host){
		super();
		EventBulletinConstructor(eventDate, location, host);
	}
	
	public EventBulletin(Date eventDate, String host){
		super();
		EventBulletinConstructor(eventDate, location, host);
	}
	
	public EventBulletin(Address address, String host){
		super();
		EventBulletinConstructor(eventDate, location, host);
	}
	
	public EventBulletin(Date eventDate, Address address){
		super();
		EventBulletinConstructor(eventDate, location, host);
	}
	
	public EventBulletin(Date eventDate){
		super();
		EventBulletinConstructor(eventDate, location, host);
	}
	
	public EventBulletin(Address address){
		super();
		EventBulletinConstructor(eventDate, location, host);
	}
	
	public EventBulletin(String host){
		super();
		EventBulletinConstructor(eventDate, location, host);
	}
	
	//Helps the constructor methods by setting variables
	public  void EventBulletinConstructor(Date eventDate, Address address, String host){
		setEventDate(eventDate);
		setLocation(address);
		setHost(host);
	}
	
	// getter/setter for event date
    public Date getEventDate() {return eventDate;}
    public void setEventDate(Date Date) {eventDate = Date;}

    // getter/setter for event location
    public Address getLocation() {return location;}
    public void setTitle(Address location ) {this.location = location;}
    
    // getter/setter for the event host
    public String getHost() {return host;}
    public void setHost(String host ) {this.host = host;}
	
	
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
}
