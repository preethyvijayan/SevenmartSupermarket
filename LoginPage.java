package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username") WebElement usernameElement;
	@FindBy(name="password") WebElement passwordElement;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signinButtonElement;
	@FindBy(xpath="//label[@for='remember']") WebElement remembermeElement;
	public void loginUname(String uname)
	{
		PageUtility.enterText(usernameElement, uname);
	}
	public void loginPass(String pass)
	{
		PageUtility.enterText(passwordElement, pass);
	
	}
	public void toClickLoginbtn()
	{
		PageUtility.clickOnElement(signinButtonElement);
	
	}


}
