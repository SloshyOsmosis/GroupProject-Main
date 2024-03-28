package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase(); // Open the database for writing
    }

    @After
    public void tearDown() {
        database.close(); // Close the database after each test
    }

    @Test
    public void testInsertData() {
        assertTrue(dbHelper.insertData("test@example.com", "password"));
    }

    @Test
    public void testCheckEmailExists() {
        dbHelper.insertData("test@example.com", "password");
        assertTrue(dbHelper.checkEmailExists("test@example.com"));
        assertFalse(dbHelper.checkEmailExists("nonexistent@example.com"));
    }

    @Test
    public void testCheckUser() {
        dbHelper.insertData("test@example.com", "password");
        assertTrue(dbHelper.checkUser("test@example.com", "password"));
        assertFalse(dbHelper.checkUser("test@example.com", "wrongpassword"));
        assertFalse(dbHelper.checkUser("nonexistent@example.com", "password"));
    }

    @Test
    public void testCheckEmail() {
        dbHelper.insertData("test@example.com", "password");
        assertTrue(dbHelper.checkEmail("test@example.com"));
        assertFalse(dbHelper.checkEmail("nonexistent@example.com"));
    }
}


// add more to test functionality