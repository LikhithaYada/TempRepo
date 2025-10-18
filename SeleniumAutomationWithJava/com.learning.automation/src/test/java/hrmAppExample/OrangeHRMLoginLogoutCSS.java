package hrmAppExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginLogoutCSS {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Opening Browser...");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        System.out.println("Logging in...");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        System.out.println("Login Done");

        System.out.println("Logging out...");
        driver.findElement(By.cssSelector("span.oxd-userdropdown-tab")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href*='logout']")).click();
        Thread.sleep(2000);
        System.out.println("Logout Done");

        driver.quit();
        System.out.println("Browser Closed");
    }
}
