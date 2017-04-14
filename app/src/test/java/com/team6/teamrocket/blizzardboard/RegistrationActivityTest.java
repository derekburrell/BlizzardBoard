package com.team6.teamrocket.blizzardboard;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Jacob Gould
 */
public class RegistrationActivityTest {

    @Test
    public void isEmailValid_nonMTU() {
        assertFalse( new RegistrationActivity().isEmailValid( "jcgould@msu.edu" ) );
    }

    @Test
    public void isEmailValid_notEmail() {
        assertFalse( new RegistrationActivity().isEmailValid( "23242Sdfssd!$!@@" ) );
    }

    @Test
    public void isEmailValid_MTU() {
        assertTrue( new RegistrationActivity().isEmailValid( "jcgould@mtu.edu" ) );
    }

    @Test
    public void isPasswordValid_allowed() {
        assertTrue( new RegistrationActivity().isPasswordValid( "Password123!@#" ) );
    }

}