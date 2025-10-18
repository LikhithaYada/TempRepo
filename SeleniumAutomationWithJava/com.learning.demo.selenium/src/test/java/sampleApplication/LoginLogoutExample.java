package sampleApplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class LoginLogoutExample {

    WebDriver driver; // class-level driver

    @Before
    public void launchApp() throws InterruptedException {
        System.out.println("Launch Browser and App");

        // Set the path to your EdgeDriver executable
        System.setProperty("webdriver.edge.driver",
            "C:\\Users\\jaisriram\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        // Edge options
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        driver = new EdgeDriver(options);

        // Open the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Wait 2 seconds to see the browser
        Thread.sleep(2000);
    }

    @Test
    public void verify() throws InterruptedException {
        System.out.println("Login and logout test steps");

        // Enter username
        driver.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(1000);

        // Enter password
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(1000);

        // Click login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        System.out.println("Logged in successfully");

        // Click logout (from top-right profile menu)
        driver.findElement(By.cssSelector(".oxd-userdropdown-name")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);

        System.out.println("Logged out successfully");
    }

    @After
    public void closeApp() {
        System.out.println("Close Browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
