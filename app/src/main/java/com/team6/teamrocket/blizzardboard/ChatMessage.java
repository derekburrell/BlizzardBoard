package com.team6.teamrocket.blizzardboard;

import java.util.Date;

/**
 *
 * @author Jacob Gould
 */

public class ChatMessage {

    private String message; //message text
    private String user;    //user id
    private long time;      //time posted

    public ChatMessage( String message, String userEmail ) {
        this.message = message;
        String user = userEmail.substring( 0, userEmail.indexOf( '@' ) );
        this.user = user;
        time = new Date().getTime();
    }

    public ChatMessage() {}

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser( String user ) {
        this.user = user;
    }

    public long getTime() {
        return time;
    }

    public void setTime( long time ) {
        this.time = time;
    }

}
