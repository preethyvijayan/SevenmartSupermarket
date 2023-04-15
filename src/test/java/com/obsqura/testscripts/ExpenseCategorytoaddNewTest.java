package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.pages.ExpenseCategorytoaddNewPage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.CategorySelectionPage;
import Utilities.ExcelUtility;


public class ExpenseCategorytoaddNewTest extends Base {

	LoginPage loginpage;
	LoginTest logintest;
	CategorySelectionPage categoryselectionpage;
	ExpenseCategorytoaddNewPage expensecategorytoaddnewpage;
	
	@Test
	public void addandVerifyNewExpenceCategory() throws IOException
	{
		prop=new Properties();
		try
		{
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.CONFIGfILE);

		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		try 
		{
			prop.load(fs);
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		String expectedurl=prop.getProperty("url");
		loginpage=new LoginPage(driver);
		loginpage.loginUnameEnterText(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Login"));
		loginpage.loginPassenterText(ExcelUtility.getString(1, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Login"));
		loginpage.toClickLoginbtn();
		String actualurl=driver.getCurrentUrl();
		assertEquals(actualurl,expectedurl , "Expected url and actual url are not same");
		categoryselectionpage=new CategorySelectionPage(driver);
		categoryselectionpage.toClickSelectCategory(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Categories"));
		categoryselectionpage.toClickSelectCategory(ExcelUtility.getString(2, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Categories"));
		expensecategorytoaddnewpage=new ExpenseCategorytoaddNewPage(driver);
		expensecategorytoaddnewpage.toClickNewButton();
		expensecategorytoaddnewpage.toEnterTitle(ExcelUtility.getString(1, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Categories"));
		expensecategorytoaddnewpage.toClickSavebutton();
		String newTitle=ExcelUtility.getString(1, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Categories");
		assertTrue((expensecategorytoaddnewpage.toverifytheCategoryListafteraddingnewCategory()).equals(newTitle), "Expected new category and actual new category is not same");
		assertTrue(expensecategorytoaddnewpage.toverifytheCategoryListafteraddingnewCategory().contains(newTitle),"Item is not existed");
		expensecategorytoaddnewpage.toClickResetbutton();
	}
	@Test
	public void VerifycolorofNewSearchResetbutton() throws IOException
	{
		logintest.loginwithValidusernameandPassword(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Login"), ExcelUtility.getString(1, 1, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Login"));
		categoryselectionpage=new CategorySelectionPage(driver);
		categoryselectionpage.toClickSelectCategory(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Categories"));
		categoryselectionpage.toClickSelectCategory(ExcelUtility.getString(2, 0, System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testdata.xlsx", "Categories"));
		expensecategorytoaddnewpage=new ExpenseCategorytoaddNewPage(driver);
		expensecategorytoaddnewpage.colorofButtonsNewSearchReset();
		String expectedcolorofnew="";
		String expectedcolorofSearch="";
		String expectedcoolorofRest="";
		//assertEquals(expensecategorytoaddnewpage.colorofButtonsNewSearchReset(), null, null);
	}
	
	
}
