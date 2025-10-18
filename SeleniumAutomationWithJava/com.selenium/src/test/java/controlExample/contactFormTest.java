package controlExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class contactFormTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("Opened OrangeHRM demo successfully!");
    }

    @Test
    public void testAddEmployee() {
        // 1️⃣ Login
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        username.sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Login successful.");

        // 2️⃣ Wait until Dashboard is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

        // 3️⃣ Navigate to PIM → Add Employee
        WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));
        pimMenu.click();

        WebElement addEmployee = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add Employee']")));
        addEmployee.click();
        System.out.println("Navigated to Add Employee page.");

        // 4️⃣ Fill Employee Details
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
        firstName.sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Doe");
        System.out.println("Filled employee first name and last name.");

        // 5️⃣ Click Save
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        saveBtn.click();

        // 6️⃣ Verify Employee Profile Page
        WebElement empNameHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[contains(text(),'John Doe')]")));
        assertTrue(empNameHeader.isDisplayed());
        System.out.println("✅ Employee added successfully: " + empNameHeader.getText());
    }

    @After
    public void teardown() {
        driver.quit();
        System.out.println("Browser closed successfully!");
    }
}
