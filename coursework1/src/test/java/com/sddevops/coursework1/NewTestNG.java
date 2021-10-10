package com.sddevops.coursework1;

import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTestNG {
	//declare Selenium WebDriver
	  private WebDriver webDriver;	
	  
	  @Test
	  public void checkTitle() {
		  //Load Personal Shopper Login Page
		  webDriver.navigate().to("http://localhost:8081/coursework1/login.jsp");
		  
		  
		  //Assert the title to check that we are indeed in the correct website
		  Assert.assertEquals(webDriver.getTitle(), "Login Page");
		  System.out.println("title: "+ webDriver.getTitle());
		  
		  WebElement username = webDriver.findElement(By.name("username"));
		  WebElement password = webDriver.findElement(By.name("password"));
		  
		  username.sendKeys("hidayah");
		  password.sendKeys("123456");
		  
		  webDriver.findElement(By.name("submit")).click();
		  
		  //Assert the new title to check that the title contain RP360 and the button had successfully bring us to the new page
		  Assert.assertTrue(webDriver.getTitle().contains("Personal Shopper Management"));
		  System.out.println("new title: "+webDriver.getTitle());

	  }
	  @BeforeTest
	  public void beforeTest() {
		  //Setting system properties of ChromeDriver
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin1\\Desktop\\chromedriver_win32\\chromedriver.exe");

		  //initialize FirefoxDriver at the start of test
		  webDriver = new ChromeDriver();  
	  }

	  @AfterTest
	  public void afterTest() {
		  //Quit the ChromeDriver and close all associated window at the end of test
		  webDriver.quit();			
	  }

}
