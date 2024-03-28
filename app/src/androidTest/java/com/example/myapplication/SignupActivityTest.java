package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SignupActivityTest {

    private SignupActivity signupActivity;

    @Before
    public void setUp() {
        signupActivity = new SignupActivity();
    }

    @Test
    public void testIsValidEmail_ValidEmail_ReturnsTrue() {
        assertTrue(signupActivity.isValidEmail("test@example.com"));
    }

    @Test
    public void testIsValidEmail_InvalidEmail_ReturnsFalse() {
        assertFalse(signupActivity.isValidEmail("invalid-email"));
    }

    @Test
    public void testIsValidPassword_ValidPassword_ReturnsTrue() {
        assertTrue(signupActivity.isValidPassword("password"));
    }

    @Test
    public void testIsValidPassword_InvalidPassword_ReturnsFalse() {
        assertFalse(signupActivity.isValidPassword("pass"));
    }
}