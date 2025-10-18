package controlExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleAlertDemo {

    WebDriver driver;

    @Before
    public void launchApp() throws InterruptedException {
        System.out.println("===== Launching Browser =====");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        Thread.sleep(2000);
    }

    @Test
    public void handleSimpleAlert() throws InterruptedException {
        System.out.println("===== Handling Simple Alert =====");

        
        System.out.println("Clicking on 'Alert with OK' tab...");
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK')]")).click();
        Thread.sleep(2000);

       
        System.out.println("Clicking button to trigger alert...");
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]")).click();
        Thread.sleep(2000);

     
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("✅ Alert appeared!");

        
        String alertText = simpleAlert.getText();
        System.out.println("📢 Alert Message: " + alertText);

        // Validate
        Assert.assertEquals("I am an alert box!", alertText);

        // Accept
        System.out.println("✅ Clicking OK...");
        simpleAlert.accept();
        System.out.println("✅ Alert closed!");
    }

    @After
    public void closeApp() throws InterruptedException {
        System.out.println("===== Closing Browser =====");
        Thread.sleep(2000);
        driver.quit();
    }
}
