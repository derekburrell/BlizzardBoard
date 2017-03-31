package com.team6.teamrocket.blizzardboard;

import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jacob Gould
 */
public abstract class Bulletin implements Bulletinable {

    protected String title;
    protected String subject;
    protected String description;
    protected String[] tags;
    protected Date dateCreated;
    protected Date dateExpires;
    protected String author;
    protected int rating;
    protected DoublyLinkedList flags;
    protected Address address;
    
    public Bulletin() {
        rating = 0;
        flags = new DoublyLinkedList();
    }
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getDesc() {
        return description;
    }

    @Override
    public void setDesc(String desc) {
        this.description = desc;
    }

    @Override
    public String[] getTags() {
        return tags;
    }

    @Override
    public void setTags(String tags) {
        this.tags = tags.split( "," );
    }

    @Override
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public Date getDate() {
        return dateCreated;
    }

    @Override
    public void setDate(Date date) {
        this.dateCreated = date;
    }

    @Override
    public Date getExpDate() {
        return dateExpires;
    }

    @Override
    public void setExpDate(Date date) {
        this.dateExpires = date;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void downvote() {
        rating--;
    }

    @Override
    public void upvote() {
        rating++;
    }

    @Override
    public boolean isFlagged() {
        return !flags.isEmpty();
    }

    @Override
    public void flag(Flag flag) {
        flags.add( flag );
    }

    @Override
    public void setLocation(Address address) { this.address = address; }

    /**
     * Converts the bulletin into a map.
     * @return The bulletin in map form.
     */
    @Exclude
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
        return result;
    }
}
