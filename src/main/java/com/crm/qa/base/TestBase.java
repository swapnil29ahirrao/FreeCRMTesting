package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;
	
	public TestBase() {
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("D:\\Selenium Classes\\eclipse-workspace\\FreeCRMTesting\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
				prop.load(ip);
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public void initialize() {
		
		//Initialization code for Chrome browser
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Classes\\Selenium\\Browsers Drivers\\Chrome\\chromedriver.exe");
		driver=new ChromeDriver();
		
		e_driver=new EventFiringWebDriver(driver);
		eventListner=new WebEventListener();
		e_driver.register(eventListner);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		}
		
		//Initialization code for IE browser
		else if(prop.getProperty("browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Classes\\Selenium\\Browsers Drivers\\IE\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
			driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
		
		//Initialization code for FireFox browser
		else if(prop.getProperty("browser").equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Classes\\Selenium\\Browsers Drivers\\Firefox\\geckodriver-v0.20.0-win32\\geckodriver.exe");
			driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
	}

}
