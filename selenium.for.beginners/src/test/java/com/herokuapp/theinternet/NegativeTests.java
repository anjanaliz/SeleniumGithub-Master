package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {
	@Test
	public void invalidusernameTests() {
//Create Driver
		System.out.println("Selecting chrome to run the tests");
		WebDriver driver = new FirefoxDriver();

//Using driver, open the URL or the test page
		System.out.println("Opening the maximised browser page");
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		driver.manage().window().maximize();
		sleep(1);
		System.out.println("Page is opened");

//Enter user name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("invalidusername");
		sleep(1);

//Enter Password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		sleep(1);

//Submit button
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();
		sleep(1);
//verifications
		// logged in URL comparison
		String actualURL = "https://the-internet.herokuapp.com/login";
		String expectedURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL, "Actual URL is not same as Expected URL");

//Login successful message
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "Your username is invalid!";
		String actualMessage = successMessage.getText();
		// Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not
		// same as Expected URL");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actaul message is not contained in expected message. /n Actual Message: " + actualMessage
						+ " /n Expected Message: " + expectedMessage + "");

//Close browser	

		driver.quit();

	}
@Test
		public void invalidpasswordTests() {
			// Create Driver
			System.out.println("Selecting chrome to run the tests");
			WebDriver driver = new ChromeDriver();

			// Using driver, open the URL or the test page
			System.out.println("Opening the maximised browser page");
			String url = "https://the-internet.herokuapp.com/login";
			driver.get(url);
			driver.manage().window().maximize();
			sleep(1);
			System.out.println("Page is opened");

			// Enter user name
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("tomsmith");
			sleep(1);

			// Enter Password
			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("InvalidPassword!");
			sleep(1);

			// Submit button
			WebElement logInButton = driver.findElement(By.tagName("button"));
			logInButton.click();
			sleep(1);
			// verifications
			// logged in URL comparison
			String actualURL = "https://the-internet.herokuapp.com/login";
			String expectedURL = driver.getCurrentUrl();
			Assert.assertEquals(actualURL, expectedURL, "Actual URL is not same as Expected URL");

			// Login successful message
			WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
			String expectedMessage = "Your password is invalid!";
			String actualMessage = successMessage.getText();
			// Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not
			// same as Expected URL");
			Assert.assertTrue(actualMessage.contains(expectedMessage),
					"Actaul message is not contained in expected message. /n Actual Message: " + actualMessage
							+ " /n Expected Message: " + expectedMessage + "");

			// Close browser

			driver.quit();
		}
	/**
		 * Stop execution for given amount of time
		 * 
		 * @param seconds
		 */
		private void sleep(int seconds) {
			try {
				Thread.sleep(seconds * 1000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
