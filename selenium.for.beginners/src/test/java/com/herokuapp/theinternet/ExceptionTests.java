package com.herokuapp.theinternet;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExceptionTests {
	@SuppressWarnings("deprecation")
	@Test
	public void exceptionTest1()
	{
		//driver delclaration and open URL
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		
		//Click Add button
		WebElement clickAdd = driver.findElement(By.id("add_btn" ));
		clickAdd.click();
		sleep(9);
		//Loading element
		//WebElement loading =driver.findElement(By.xpath("//html//div[@id='loading']"));
		sleep(10);
		//verify Row2 input field is displayed
		WebElement row2Input = driver.findElement(By.xpath("//div[@id= 'row2']/input"));
		Assert.assertTrue(row2Input.isDisplayed(),"Row2 is not dispalyed");
		
}
	/**
	 * Stop execution for given amount of time
	 * 
	 * @param seconds
	 */
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
