package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void initialization() {
		initialize();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO" , "Home Page Expected and Atual text does not match");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest() {
		homePage.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyUserName(), "User Name label does display correct username");
	}
	
	@Test(priority=3)
	public void verifyContactsPageTest() {
		homePage.switchToFrame("mainpanel");
		contactPage=homePage.clickOnContactsTab();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
