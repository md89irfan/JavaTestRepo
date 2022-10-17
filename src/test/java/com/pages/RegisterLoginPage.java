package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import junit.framework.Assert;


public class RegisterLoginPage extends BasePage{
	
	static String firstName, lastName;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	public void launchApplication(){
		driver.get("http://automationpractice.com/index.php");
	}
	
	public void clickSignIn(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sign in')]")));
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
	}
	
	public void clickCreateAccount(String email){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
		driver.findElement(By.id("email_create")).sendKeys(email);
		
		driver.findElement(By.xpath("//*[@id='SubmitCreate']/span")).click();
		
	}
	
	
	public void enterPersonalDetails(DataTable userDetails){
		
		List<Map<String,String>> data = userDetails.asMaps(String.class,String.class);
		
		Map<String, String> userData = data.get(0);
		
		firstName = userData.get("First Name");
		lastName = userData.get("Last Name");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		
		driver.findElement(By.xpath("//*[@name='id_gender' and @id='id_gender1']")).click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys(firstName);	
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
		driver.findElement(By.id("passwd")).sendKeys(userData.get("Password"));
		driver.findElement(By.id("company")).sendKeys(userData.get("Company"));
		driver.findElement(By.id("address1")).sendKeys(userData.get("Address"));
		driver.findElement(By.id("city")).sendKeys(userData.get("City"));
		
		Select s = new Select(driver.findElement(By.id("id_state")));
		s.selectByVisibleText(userData.get("State"));
		
		driver.findElement(By.id("postcode")).sendKeys(userData.get("Zip Code"));
		driver.findElement(By.id("phone_mobile")).sendKeys(userData.get("Mobile Phone"));
		driver.findElement(By.id("alias")).sendKeys(userData.get("Address Alias"));		
		
	}
	
	public void clickRegisterButton(){
		
		driver.findElement(By.id("submitAccount")).click();
	}
	
	public void verifyAccountCreation(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='View my customer account']/span")));
		String fullName = driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText();
		
		Assert.assertEquals("Verify Account Name", firstName+" "+lastName, fullName);
		
	}
	
	public void logout(){
		driver.findElement(By.xpath("//a[contains(text(),'Sign out') and @class='logout']")).click();
	}
	
	
	public void login(String email, String passwd){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(passwd);
		
		driver.findElement(By.id("SubmitLogin")).click();
	}

}





