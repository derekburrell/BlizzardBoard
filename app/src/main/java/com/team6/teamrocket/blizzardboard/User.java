package com.team6.teamrocket.blizzardboard;

/**
 * This class defines attributes and methods for a standard user;
 * it may be extended as necessary for specialized user types.
 * @author Derek Burrell
 * @date 2017/03/14
 * @modified 2017/03/15 by Jordan Kieltyka
 */

public class User
{

    // instance data
    private String name;         //A simple login name
    private String email;        //the email address of the user (@mtu.edu)
    private String password;     //the user login password
    private boolean loggedIn;	 //flag for if the user is currently logged in and active

    // class constructor
    User(String name, String email, String password)
    {
        setName(name);
        setEmail(email);
        setPassword(password);
    }
    
    // class constructor (no name)
    User(String email, String password)
    {
    	setName(email);
        setEmail(email);
        setPassword(password);
    }

    // methods
    /**
     * retrieves user's registered email address
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * sets user's registered name
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * retrieves user's registered password
     * @return password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * sets user's registered password
     * @return password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * retrieves user's registered name
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * sets user's registered name
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * sets user's status to logged
     * in or logged out.
     * @param status
     */
    public void setLoginStatus(boolean status)
    {
    	loggedIn = status;
    }
    
    /**
     * retrieves user's login status
     * true if logged in; false if logged out
     * @return isLoggedIn
     */
    public boolean isLoggedIn()
    {
        return loggedIn;
    }
}
