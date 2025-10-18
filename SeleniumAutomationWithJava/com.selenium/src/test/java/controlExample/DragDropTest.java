package controlExample;
import org.junit.After;

import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
 
public class DragDropTest{


WebDriver driver;

	@Before

	public void launchApp() throws InterruptedException {

		System.out.println("===============launchApp=================");

		//launch browser and application

		driver = new ChromeDriver();

		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

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

		WebElement photoFrame = driver.findElement(By.cssSelector("iframe[src*=\"photo\"]"));

		driver.switchTo().frame(photoFrame);



		//inside a frame


		WebElement img3 = driver.findElement(By.cssSelector("[src*='tatras3']"));

		WebElement trash = driver.findElement(By.cssSelector("div#trash"));

		WebElement img4 = driver.findElement(By.cssSelector("[src*='tatras4']"));


		Actions act = new Actions(driver);


		//app1

		act.dragAndDrop(img3, trash).perform();


		Thread.sleep(2000);

		//A convenience method that performs click-and-hold at the location of the source element, 

		//moves to the location of the target element, then releases the mouse.


		act.clickAndHold(img4).moveToElement(trash).release().build().perform();

	}
}
