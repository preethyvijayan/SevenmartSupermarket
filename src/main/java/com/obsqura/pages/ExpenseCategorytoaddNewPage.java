package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ExpenseCategorytoaddNewPage {
	public WebDriver driver;
	public ExpenseCategorytoaddNewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-widget='pushmenu']//child::i") WebElement menuElement;
	@FindBy(xpath="//p[text()='Expense Category']") WebElement expenseCategoryElement;
	@FindBy(xpath="//a[text()=' New']") WebElement newButtonElement;
	@FindBy(xpath="//a[@onclick=\'click_button(2)\']") WebElement searchButtonElement;
	@FindBy(xpath="//a[text()=' Reset']") WebElement resetButtoncolorElement;
	
	@FindBy(css="input#name") WebElement titleElement;
	@FindBy(xpath="//button[@name='Create']") WebElement saveButtonElement;
	@FindBy(xpath="//button[@name='Create']//following::a[text()='Reset']") WebElement resetButtonElement;
	@FindBy(xpath="//div[@class='card']//td")WebElement expenseCategorylistElement;
	
	public void toClickNewButton()
	{
		WaitUtility.waitForElementClickable(driver, newButtonElement);
		PageUtility.isElementDisplayed(newButtonElement);
		PageUtility.clickOnElement(newButtonElement);
	}
	public String toEnterTitle(String input)
	{
		PageUtility.isElementDisplayed(titleElement);
		PageUtility.enterText(titleElement, input);
		String s=titleElement.getText();
		return s;
	}
	public void toClickSavebutton()
	{
		WaitUtility.waitForElementClickable(driver, saveButtonElement);
		PageUtility.isElementDisplayed(saveButtonElement);
		PageUtility.clickOnElement(saveButtonElement);
	}
	public void toClickResetbutton()
	{
		WaitUtility.waitForElementClickable(driver, resetButtonElement);
		PageUtility.isElementDisplayed(resetButtonElement);
		PageUtility.clickOnElement(resetButtonElement);
	}
	public String toverifytheCategoryListafteraddingnewCategory()
	{
		PageUtility.isElementDisplayed(expenseCategorylistElement);
		String output=PageUtility.getElementText(expenseCategorylistElement);
		return output;
	}
	public void colorofButtonsNewSearchReset()
	{
		PageUtility.getbackgroundcolorofButton(newButtonElement);
		PageUtility.getbackgroundcolorofButton(searchButtonElement);
		PageUtility.getbackgroundcolorofButton(resetButtoncolorElement);
		
	}


}
