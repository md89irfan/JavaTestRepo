package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class AddItemToCart extends BasePage{
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public void clickTShirt(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='T-shirts'])[2]")));
		
		driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]")).click();
		
	}
	
	public void addTShirtToCart(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Faded Short Sleeve T-shirts'])[1]")));
		driver.findElement(By.xpath("(//a[@title='Faded Short Sleeve T-shirts'])[1]")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='fancybox-iframe']")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Add to cart']")));
		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Proceed to checkout')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		
	}
	
	public void verifyProductAndAddress(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shopping-cart summary')]")));
		
		Assert.assertTrue("Verify T-Shirt product is added", driver.findElement(By.xpath("//table[@id='cart_summary']//a[contains(text(),'Faded Short Sleeve T-shirts')]")).isDisplayed());
		
	}
	
	public void proceedToCheckout(){
		driver.findElement(By.xpath("(//*[contains(text(),'Proceed to checkout')])[2]")).click();
	}
	
	public void verifyAddressAndProceed(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Proceed to checkout')])[2]")));
		driver.findElement(By.xpath("(//*[contains(text(),'Proceed to checkout')])[2]")).click();
	
	}
	
	public void acceptTermsConditions(){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cgv']/..")));
		
		driver.findElement(By.xpath("//input[@id='cgv']/..")).click();
		driver.findElement(By.xpath("(//*[contains(text(),'Proceed to checkout')])[2]")).click();
	}
	
	public void verifyPaymentsPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Please choose your payment method')]")));
		
		Assert.assertTrue("Verify Payment Page", driver.findElement(By.xpath("//*[contains(text(),'Please choose your payment method')]")).isDisplayed());
	}
	
	

}
