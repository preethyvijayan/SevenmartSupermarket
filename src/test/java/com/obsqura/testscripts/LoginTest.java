package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;

import Utilities.ExcelUtility;


public class LoginTest extends Base{
	LoginPage loginpage;
	@Test(dataProvider="LoginProvider")
	public void loginwithValidusernameandPassword(String username,String password) throws IOException
	{
    		loginpage=new LoginPage(driver);
    		assertTrue((loginpage.loginUname()==true), "Username Text field is not displayed");
    		loginpage.loginUnameEnterText(username);
    		assertTrue((loginpage.loginPass()==true), "Password Text field is not displayed");
    		loginpage.loginPassenterText(password);
    		assertEquals(password.equals("admin"), username.equals("admin"), "Wrong username and password");
    		assertTrue(loginpage.Loginbtn()==true, "Sign in button is not displayed");
    		loginpage.toClickLoginbtn();
	}
    		
    		@DataProvider(name="LoginProvider")
    	    public Object[][] getDataFromTestData() throws IOException
    		{
    	    return new Object[][] 
    	    		{
                { "admin", "admin" },
                { "admin", "admin123" },
                { "admin111", "admin" },
                { "admin111", "admin123"}
        	};
        		
    		}
        	
	}
	


