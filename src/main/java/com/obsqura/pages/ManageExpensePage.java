package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageExpensePage {
	public WebDriver driver;
	public ManageExpensePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Expense']") WebElement manageExpenseElement;
	@FindBy(xpath="//p[text()='Expense Category']") WebElement expenseCategoryElement;
}
