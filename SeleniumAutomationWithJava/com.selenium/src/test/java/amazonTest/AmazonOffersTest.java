package amazonTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class AmazonOffersTest {

    WebDriver driver;

    @Before
    public void launchApp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Thread.sleep(3000);
        System.out.println("✅ Amazon app launched");
    }

    @Test
    public void verifySeeAllOffersPage() throws Exception {
        
        driver.findElement(By.linkText("See all offers")).click();
        Thread.sleep(3000);
        System.out.println("Clicked on 'See all offers'");

        
        String expectedUrlPart = "deals";
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrlPart));
        System.out.println("URL verified: " + actualUrl);

 
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.toLowerCase().contains("deals"));
        System.out.println("Title verified: " + actualTitle);
    }

    @After
    public void closeApp() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
