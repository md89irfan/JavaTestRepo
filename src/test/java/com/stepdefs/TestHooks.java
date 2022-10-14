package com.stepdefs;

import org.openqa.selenium.WebDriver;

import com.pages.BasePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks {
	
	protected static WebDriver driver;
	
	@Before
	public void setup(){
		
		BasePage bp = new BasePage();
		bp.invokeDriver();
		
		this.driver = BasePage.driver;
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

}
