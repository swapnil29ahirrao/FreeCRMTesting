package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	ContactsPage contactsPage;
	HomePage homePage;
	String sheetName="Contacts";
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void initialization() {
		initialize();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame("mainpanel");
		contactsPage=homePage.clickOnContactsTab();
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageDisplayedTest() {
		Assert.assertTrue(contactsPage.verifyContactsPageLabel(), "Contact Page missing on UI");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;	
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void createNewContactTest(String title,String firstName,String lastName,String company) {
		homePage.clickOnNewContactsTab();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
