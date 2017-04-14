package com.team6.teamrocket.blizzardboard;

import android.text.format.DateFormat;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 *
 * @author Jacob Gould
 */
public class ChatMessageTest {

    @Test
    public void getMessage_empty() throws Exception {
        ChatMessage cm = new ChatMessage();
        assertEquals( cm.getMessage(), null );
    }

    @Test
    public void getMessage_filled() throws Exception {
        ChatMessage cm = new ChatMessage( "Message", "Email@mtu.edu" );
        assertEquals( cm.getMessage(), "Message" );
    }

    @Test
    public void setMessage_empty() throws Exception {
        ChatMessage cm = new ChatMessage();
        cm.setMessage( "Message" );
        assertEquals( cm.getMessage(), "Message" );
    }

    @Test
    public void setMessage_overwrrite() throws Exception {
        ChatMessage cm = new ChatMessage( "Message", "Email@mtu.edu" );
        cm.setMessage( "Message2" );
        assertEquals( cm.getMessage(), "Message2" );
    }

    @Test
    public void getUser_empty() throws Exception {
        ChatMessage cm = new ChatMessage();
        assertEquals( cm.getUser(), null );
    }

    @Test
    public void getUser_filled() throws Exception {
        ChatMessage cm = new ChatMessage( "Message", "Email@mtu.edu" );
        assertEquals( cm.getUser(), "Email" );
    }

    @Test
    public void setUser_empty() throws Exception {
        ChatMessage cm = new ChatMessage();
        cm.setUser( "Email" );
        assertEquals( cm.getUser(), "Email" );
    }

    @Test
    public void setUser_overwrite() throws Exception {
        ChatMessage cm = new ChatMessage( "Message", "Email@mtu.edu" );
        cm.setUser( "Email2" );
        assertEquals( cm.getUser(), "Email2" );
    }

    @Test
    public void getTime() throws Exception {
        ChatMessage cm = new ChatMessage( "Message", "Email@mtu.edu" );
        assertTrue( cm.getTime() > 0 );
    }

    @Test
    public void setTime() throws Exception {
        ChatMessage cm = new ChatMessage();
        long time = new Date().getTime();
        cm.setTime( time );
        assertEquals( cm.getTime(), time );
    }

}