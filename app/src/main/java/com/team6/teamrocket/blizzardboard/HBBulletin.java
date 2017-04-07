package com.team6.teamrocket.blizzardboard;

import java.util.Date;

/**
 *
 * @author Jacob Gould
 */

public class HBBulletin {

    private String title;
    private String user;
    private String description;
    private long postTime;
    private int rating;

    public HBBulletin( String title, String userEmail, String description ) {
        this();
        this.title = title;
        this.description = description;
        String user = userEmail.substring( 0, userEmail.indexOf( '@' ) );
        this.user = user;
    }

    public HBBulletin() {
        postTime = new Date().getTime();
        rating = 0;
    }

    public String getTitle() { return title; }
    public void setTitle( String title ) { this.title = title; }

    public String getUser() { return user; }
    public void setUser( String user ) { this.user = user; }

    public String getDescription() { return description; }
    public void setDescription( String description ) { this.description = description; }

    public long getPostTime() { return postTime; }
    public void setPostTime( long postTime ) { this.postTime = postTime; }

    public int getRating() { return rating; }
    public void setRating( int rating ) { this.rating = rating; }

}
