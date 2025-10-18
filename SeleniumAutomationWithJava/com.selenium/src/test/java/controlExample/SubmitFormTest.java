package controlExample;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitFormTest {

    WebDriver driver;

    @Before
    public void launchApp() throws InterruptedException {
        System.out.println("===== Launching Application =====");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @After
    public void closeApp() throws InterruptedException {
        System.out.println("===== Closing Application =====");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void clickSubmitButton() throws InterruptedException {
        driver.findElement(By.id("submit")).click();
        System.out.println("Submit button clicked");
    }
}
