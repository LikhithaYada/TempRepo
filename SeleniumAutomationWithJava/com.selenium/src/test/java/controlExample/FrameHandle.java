package controlExample;



import org.junit.After;

import org.junit.Before;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
 
public class FrameHandle{


WebDriver driver;

	@Before

	public void launchApp() throws InterruptedException {

		System.out.println("===============launchApp=================");

		//launch browser and application

		driver = new ChromeDriver();

		driver.get("https://paytm.com/");

		driver.manage().window().maximize();


		Thread.sleep(5000);

	}

	@After

	public void closeApp() throws Exception {

		System.out.println("===============closeApp=================");

		Thread.sleep(7000);

		driver.close();

		driver.quit();

	}
 
	

	@Test

	public void verifyImageProperty() throws Exception {

		//click on Sign Button

		WebElement btn_SignIn = driver.findElement(By.cssSelector("[title=\"Sign In\"]"));

		btn_SignIn.click();

		Thread.sleep(1000);


		WebElement webframe = driver.findElement(By.cssSelector("[src*='paytm-web']"));



		driver.switchTo().frame(webframe);

		Thread.sleep(1000);


		driver.switchTo().frame("oauth-iframe");




		WebElement header = driver.findElement(By.cssSelector("[oauth-id=\"signInTab\"]"));

		System.out.println("Header text: " + header.getText());
 
		

	}
 
}

