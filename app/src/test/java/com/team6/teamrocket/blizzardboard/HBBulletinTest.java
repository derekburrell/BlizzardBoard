package com.team6.teamrocket.blizzardboard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gould on 2017/04/13.
 */
public class HBBulletinTest {

    @Test
    public void getTitle_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        assertEquals( hb.getTitle(), null );
    }

    @Test
    public void getTitle_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        assertEquals( hb.getTitle(), "Title" );
    }

    @Test
    public void setTitle_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        hb.setTitle( "Title" );
        assertEquals( hb.getTitle(), "Title" );
    }

    @Test
    public void setTitle_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        hb.setTitle( "Title2" );
        assertEquals( hb.getTitle(), "Title2" );
    }

    @Test
    public void getUser_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        assertEquals( hb.getUser(), null );
    }

    @Test
    public void getUser_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        assertEquals( hb.getUser(), "Email" );
    }

    @Test
    public void setUser_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        hb.setUser( "Email" );
        assertEquals( hb.getUser(), "Email" );
    }

    @Test
    public void setUser_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        hb.setUser( "Email2" );
        assertEquals( hb.getUser(), "Email2" );
    }

    @Test
    public void getDescription_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        assertEquals( hb.getDescription(), null );
    }

    @Test
    public void getDescription_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        assertEquals( hb.getDescription(), "description" );
    }

    @Test
    public void setDescription_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        hb.setDescription( "description" );
        assertEquals( hb.getDescription(), "description" );
    }

    @Test
    public void setDescription_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        hb.setDescription( "description2" );
        assertEquals( hb.getDescription(), "description2" );
    }

    @Test
    public void getSubject_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        assertEquals( hb.getSubject(), null );
    }

    @Test
    public void getSubject_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        assertEquals( hb.getSubject(), "subject" );
    }

    @Test
    public void setSubject_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        hb.setSubject( "subject" );
        assertEquals( hb.getSubject(), "subject" );
    }

    @Test
    public void setSubject_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        hb.setSubject( "subject2" );
        assertEquals( hb.getSubject(), "subject2" );
    }

    @Test
    public void getPostTime_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        assertTrue( hb.getPostTime() > 0 );
    }

    @Test
    public void getPostTime_filled() throws Exception {
        HBBulletin hb = new HBBulletin( "Title", "Email@mtu.edu", "description", "subject" );
        assertTrue( hb.getPostTime() > 0 );
    }

    @Test
    public void setPostTime_empty() throws Exception {
        HBBulletin hb = new HBBulletin();
        hb.setPostTime( 255 );
        assertEquals( hb.getPostTime(), 255 );
    }

    @Test
    public void getRating() throws Exception {
        HBBulletin hb = new HBBulletin();
        assertTrue( hb.getRating() == 0 );
    }

    @Test
    public void setRating() throws Exception {
        HBBulletin hb = new HBBulletin();
        hb.setRating( 25 );
        assertTrue( hb.getRating() == 25 );
    }

}