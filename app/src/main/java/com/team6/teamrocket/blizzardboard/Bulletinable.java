package com.team6.teamrocket.blizzardboard;

import java.util.Date;

/**
 * |-------------------------
 * | Title vUser
 * |-------------------------
 * |
 * |         Image
 * |
 * | ------------------------
 * | Desc....................
 * | ........................
 * | Date       ^vRating Flag
 * |-------------------------
 * 
 * 
 * @author Jacob Gould
 */
public interface Bulletinable {
    
    /**
     * Gets the title of the post.
     * @return the title. 
     */
    public String getTitle();
    
    /**
     * Sets the title of the post.
     * @param title the new title.
     */
    public void setTitle( String title );
    
    /**
     * Gets the subject of the post.
     * EX: In a sales post, subject is electronics, sports
     * @return the subject.
     */
    public String getSubject();
    
    /**
     * Sets the subject of the post.
     * @param subject the new subject.
     */
    public void setSubject( String subject );
    
    /**
     * Get the description text of the post.
     * @return the description.
     */
    public String getDesc();
    
    /**
     * Sets the description text of the post.
     * @param desc the new description.
     */
    public void setDesc( String desc );
    
    /**
     * Gets the tags of the post.
     * Example of event post for going skiing this weekend.
     * Tags: Weekend, Skiing, Mt Ripley, Free Food
     * @return the tags.
     */
    public String[] getTags();
    
    /**
     * Sets the tags of the post.
     * @param tags the new tags as one string separated by ','.
     */
    public void setTags( String tags );
    
    /**
     * Sets the tags of the post.
     * @param tags the new tags as an array.
     */
    public void setTags( String[] tags );
    
    /**
     * Gets the date the post was made.
     * @return the date of posting.
     */
    public long getDate();
    
    /**
     * Sets the date the post was made.
     * @param date the new date of posting.
     */
    public void setDate( long date );
    
    /**
     * Gets the expiration date of the post.
     * @return the expiration date.
     */
    public long getExpDate();
    
    /**
     * Sets the expiration date of the post.
     * @param date the new expiration date.
     */
    public void setExpDate( long date );
    
    /**
     * Gets the author of the post.
     * @return the author.
     */
    public String getAuthor();
    
    /**
     * Sets the author of the post.
     * @param author the new author.
     */
    public void setAuthor( String author );
    
    /**
     * Gets the rating of the post.
     * @return the rating.
     */
    public int getRating();
    
    /**
     * Decrement the rating by one.
     */
    public void downvote();
    
    /**
     * Increment the rating by one.
     */
    public void upvote();
    
    /**
     * Allows mods to know if a post has been flagged.
     * @return true if the post is flagged, false if not.
     */
    public boolean isFlagged();
    
    /**
     * Flags the post for moderators attention.
     * @param flag the flag that is reported.
     */
    public void flag( Flag flag );
    
    /**
     * Gets the Image of the post.
     * @return the image.
     */
    //public Image getImage();
    
    /**
     * Sets the Image of the post.
     * @param img the new image.
     */
    //public void setImage( Image img );
    
    /**
     * Gets an XML representation of the post for display in scrolling.
     * @return XML for tile view.
     */
    public String toXMLTile();
    
    /**
     * Gets an XML representation of the post for full display.
     * @return XML for page view.
     */
    public String toXMLFullPage();
    
    /**
     * Gets an SQL representation of the post to send back to the database.
     * @return SQL for database.
     */
    public String toSQL();

    public void setLocation( Address address );

}