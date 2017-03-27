package com.team6.teamrocket.blizzardboard;

/**
 * @author Jordan Kieltyka
 * @date March 15, 2017
 * @brief This class defines bulletins that list items or services
 * 		  that are for sale. Its parent class is Bulletin.
 */

import java.io.File;
import java.util.ArrayList;

public class ForSaleBulletin extends Bulletin{
	
	private ArrayList<File> pictures = new ArrayList<File>();	//picture of the item
	private String condition = new String();					//the condition of the item
	private double price = 0;									//the price of the item
	
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
}