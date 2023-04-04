package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;

import Utilities.ExcelUtility;


public class LoginTest extends Base{
	LoginPage loginpage;
	@Test
	public void loginTest() throws IOException
	{
		String value=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\TestData.xlsx", "Login");
		String value1=ExcelUtility.getString(1, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\TestData.xlsx", "Login");
		System.out.println(value);
		loginpage=new LoginPage(driver);
		loginpage.loginUname(value);
		loginpage.loginPass(value1);
		loginpage.toClickLoginbtn();
		
	}

}
