package com.team6.teamrocket.blizzardboard;

/**
 * @author Jordan Kieltyka
 * @date March 16, 2017
 * @brief This class defines a location by its address.
 *        The address includes everything found in a 
 *        postal format.
 */

public class Address {
	
	private int number = 0;					//house number of the address
	private String street = new String();	//street of the address
	private String city = new String();		//city of the address
	private String state = new String();	//state of the address
	private int zip = 0;					//zip code of the address
	private String country = new String();	//the country of the address
	
	/**
	 * Used to help construct the Address object.
	 * 
	 * @param number - House number of the address.
	 * @param street - Street of the address.
	 * @param city - City of the address.
	 * @param state - State of the address.
	 * @param zip - Zip code of the address.
	 * @param country - Country of the address.
	 */
	private void addressConstructor(int number, String street, String city, String state, int zip, String country){
		setNumber(number);
		setStreet(street);
		setCity(city);
		setState(state);
		setZip(zip);
		setCountry(country);
	}
	
	//constructors
	public Address(){addressConstructor(number, street, city, state, zip, country);}
	public Address(int zip){addressConstructor(number, street, city, state, zip, country);}
	public Address(String city){addressConstructor(number, street, city, state, zip, country);}
	public Address(String city, int zip){addressConstructor(number, street, city, state, zip, country);}
	public Address(int number, String street){addressConstructor(number, street, city, state, zip, country);}
	public Address(String city, String state){addressConstructor(number, street, city, state, zip, country);}
	public Address(String city, String state, int zip){addressConstructor(number, street, city, state, zip, country);}
	public Address(String city, String state, String country){addressConstructor(number, street, city, state, zip, country);}
	public Address(String city, String state, int zip, String country){addressConstructor(number, street, city, state, zip, country);}
	public Address(int number, String street, String city, String state, int zip, String country){addressConstructor(number, street, city, state, zip, country);}
	
	//set methods
	public void setNumber(int number){this.number = number;}
	public void setStreet(String street){this.street = street;}
	public void setCity(String city){this.city = city;}
	public void setState(String state){this.state = state;}
	public void setZip(int zip){this.zip = zip;}
	public void setCountry(String country){this.country = country;}
	
	//get methods
	public int getNumber(){return number;}
	public String getStreet(){return street;}
	public String getCity(){return city;}
	public String getState(){return state;}
	public int getZip(){return zip;}
	public String getCountry(){return country;}
	
	/**
	 * Converts the Address into a string which is
	 * close to postal format.
	 */
	public String toString(){
		
		String address = new String(); //the address of the housing unit
		
		//add elements to the address
		if(number != 0)
			address += number;
		if(!street.isEmpty())
			address += " " + street + ", ";
		if(!city.isEmpty())
			address += " " + city;
		if(!state.isEmpty())
			address += " " + state;
		if(zip != 0)
			address += " " + zip;
		if(!country.isEmpty())
			address += " " + country;
		
		//cleanup unneeded characters in string
		if(address.charAt(0) == ' '){
			StringBuilder tmp = new StringBuilder(address);
			tmp.deleteCharAt(0);
			address = tmp.toString();
		}
		if(address.charAt(address.length() - 1) == ','){
			StringBuilder tmp = new StringBuilder(address);
			tmp.deleteCharAt(address.length() - 1);
			address = tmp.toString();
		}
		return address;
	}
}
