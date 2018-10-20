package com.crm.qa.pages;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsPageLabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement titleDropdown;
	
	@FindBy(id="first_name")
	WebElement firstNameTextBox;
	
	@FindBy(id="surname")
	WebElement lastNameTextBox;
	
	@FindBy(name="client_lookup")
	WebElement companyTextBox;
	
	@FindBy(xpath="//form[@name='contactForm']//input[@value='Save' and @type='submit']")
	WebElement contactsPageSaveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPageLabel() {
		return contactsPageLabel.isDisplayed();
	}
	
	public void createNewContact(String title,String firstName,String lastName,String comp) {
		Select select  = new Select(titleDropdown);
		select.selectByVisibleText(title);
		
		firstNameTextBox.sendKeys(firstName);
		lastNameTextBox.sendKeys(lastName);
		companyTextBox.sendKeys(comp);
		contactsPageSaveBtn.click();
	}

}
