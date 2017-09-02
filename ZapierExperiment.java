package com.TestLio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ZapierExperiment {
	public static WebDriver driver;
	public static String expectedTitle = "The best apps. Better together. - Zapier";
	
	 @BeforeClass
	 public void setUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/shale/OneDrive/Documents/Libraries/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://zapier.com/");
		

	 }
		@Test(enabled=false)
		 public void createAccount() throws Exception {
			
		
		if(expectedTitle.equals(driver.getTitle())){
			System.out.println("Titles match");
		}else
		
		System.out.println(driver.getTitle());
		
		WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));
		firstName.sendKeys("Maya");
		
		WebElement lastName = driver.findElement(By.cssSelector("input[name='last_name']"));
		lastName.sendKeys("Zapier");
		
		WebElement email = driver.findElement(By.cssSelector("input[type='email']"));
		email.sendKeys("mariaefaran@gmail.com");
		
		WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
		password.sendKeys("[put different password here]");
		
		WebElement submit = driver.findElement(By.className("async-button__text"));
		submit.click();
				/*<span class="async-button__text">Sign Up</span>*/
		
	 }
		/*Testing to see if you get email error message if use same email from another
		Zapier Account for a new sign-up. You can do this manually, but I thought it would
		be more fun to automate it :-) */
		@Test
		 public void sameEmail() throws InterruptedException {
			WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));
			firstName.clear();
			firstName.sendKeys("Sarah");
			
			WebElement lastName = driver.findElement(By.cssSelector("input[name='last_name']"));
			lastName.clear();
			lastName.sendKeys("Victor");
			
			WebElement email = driver.findElement(By.cssSelector("input[type='email']"));
			email.clear();
			email.sendKeys("mariaefaran@gmail.com");
			
			WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
			password.clear();
			password.sendKeys("apples2386");
			
			WebElement submit = driver.findElement(By.className("async-button__text"));
			submit.click();
			
			Thread.sleep(2000);
		
		/*<p class="signup-form__error-message error">A user with that email already exists.</p>*/
		String expectedErrorMess = "A user with that email already exists.";
		
		WebElement actualErrorMessage = driver.findElement(By.cssSelector("p[class*='form__error-message error']"));
		
		String message = actualErrorMessage.getText();
		System.out.println(message);
		
		
		if(message.equals(expectedErrorMess)){
			System.out.println("Create New Account");
		}else
			System.out.println("Account Not Created");
		
		driver.close();
	
	}

	
	
		
	}
	
