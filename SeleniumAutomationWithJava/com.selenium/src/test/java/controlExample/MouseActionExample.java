package controlExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionExample {

    WebDriver driver;

    @Before
    public void launchApp() throws InterruptedException {
        System.out.println("===== Launching Application =====");
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @After
    public void closeApp() throws InterruptedException {
        System.out.println("===== Closing Application =====");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testContextAndDoubleClick() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));
        actions.contextClick(rightClickButton).perform();
        System.out.println("Right click done");

       
        WebElement editOption = driver.findElement(By.xpath("//ul/li[contains(@class,'context-menu-icon-edit')]"));
        editOption.click();
        Thread.sleep(1000);

      
        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert1.getText());
        alert1.accept();

      
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClickButton).perform();
        System.out.println("Double click done");

        
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert2.getText());
        alert2.accept();
    }
}
