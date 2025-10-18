package hrmAppExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTest {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void loginLogoutTest() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

    
        WebElement loginMsg = driver.findElement(By.id("flash"));
        System.out.println("Login Message: " + loginMsg.getText());

        driver.findElement(By.cssSelector("a.button")).click();

        WebElement logoutMsg = driver.findElement(By.id("flash"));
        System.out.println("Logout Message: " + logoutMsg.getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
