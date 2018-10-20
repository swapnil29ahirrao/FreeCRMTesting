package com.crm.qa.pages;

import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath= "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//img[@alt='free crm logo']")
	WebElement crmLogo;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMlogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		password.sendKeys(Keys.ENTER);
		//loginBtn.click();
		
		return new HomePage();
	}
}
