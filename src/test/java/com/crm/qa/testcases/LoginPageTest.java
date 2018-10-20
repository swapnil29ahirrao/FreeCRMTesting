package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void initialization() {
		initialize();
		loginPage=new LoginPage();		
	}
	
	@Test(priority=1)
	public void validateLoginPageTitleTest() {
		String loginTitle=loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginTitle, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void validateCRMloginPageLogoTest() {
		boolean logoPresent=loginPage.validateCRMlogo();
		Assert.assertTrue(logoPresent);
	}
	
	@Test(priority=3)
	public void loginTest() {
		HomePage homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String homePageTitle=homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
