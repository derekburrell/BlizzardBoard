package com.team6.teamrocket.blizzardboard;

/**
 * @author Jordan Kieltyka
 * @date March 15, 2017
 * @brief This class defines bulletins that list items or services
 * 		  that are for sale. Its parent class is Bulletin.
 */

import com.google.firebase.database.Exclude;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ForSaleBulletin extends Bulletin{
	
	protected ArrayList<File> pictures = new ArrayList<File>();	//picture of the item
	protected String condition = new String();					//the condition of the item
	protected double price = 0;									//the price of the item
	
	/**
	 * Helps construct the ForSaleBulletin object.
	 * 
	 * @param price - The price of the item for sale.
	 * @param condition - The condition of the item for sale.
	 */
	private void ForSaleBulletinConstructor(double price, String condition){
		setPrice(price);
		setCondition(condition);
	}
	
	//constructors
	public ForSaleBulletin(){
		super();
		ForSaleBulletinConstructor(0, "not listed");
	}
	
	public ForSaleBulletin(double price){
		super();
		ForSaleBulletinConstructor(price, "not listed");
	}
	
	public ForSaleBulletin(String condition){
		super();
		ForSaleBulletinConstructor(0, condition);
	}
	
	public ForSaleBulletin(double price, String condition){
		super();
		ForSaleBulletinConstructor(price, condition);
	}
	
	//get methods
	public ArrayList<File> getPictures(){return pictures;}		//get the pictures; used for accessing the ArrayList functions
	public String getCondition(){return condition;} 			//get what the condition of the item is
	public double getPrice(){return price;}						//get the price of the item
	
	//set methods
	public void setPictures(ArrayList<File> pictures){this.pictures = pictures;}	//used if an ArrayList of pictures is available
	public void setCondition(String condition){this.condition = condition;}			//sets the condition of the item
	public void setPrice(double price){this.price = price;}							//sets the price of the item
	
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
		return result;
	}
}