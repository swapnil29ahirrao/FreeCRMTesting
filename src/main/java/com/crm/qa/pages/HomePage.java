package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Swapnil')]")
	WebElement usernameLable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsTab;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsTab;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsTab;
	
	@FindBy(xpath="//a[contains(text(),'Task')]")
	WebElement taskTab;
	
	//Initialize
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsTab() {
		contactsTab.click();
		return new ContactsPage();
	}
	
	public boolean verifyUserName() {
		return usernameLable.isDisplayed();
	}
	
	public DealsPage clickOnDealsTab() {
		dealsTab.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskTab() {
		taskTab.click();
		return new TaskPage();
	}
	
	public void switchToFrame(String frameName) {
		TestUtil.switchToFrame(frameName);
	}

	public void clickOnNewContactsTab() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsTab);
		action.build().perform();
		
		newContactsTab.click();
	}
}
