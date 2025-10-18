package hrmAppExample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LocatorExample extends BaseTest {

    @Test
    public void HRMLoginLocator() {

        System.out.println("Verify login page");

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locator - name
        WebElement txt_userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        txt_userName.sendKeys("admin");
        txt_userName.clear();
        txt_userName.sendKeys("admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

        // Click login button
        driver.findElement(By.tagName("button")).click();

        // Wait for the dropdown to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-dropdown-link")));

        List<WebElement> eleList = driver.findElements(By.className("oxd-dropdown-link"));

        for (WebElement ele : eleList) {
            String text = ele.getText();
            System.out.println("Text value: " + text);

            if (text.contains("Logout")) {
                System.out.println("_____________Logout__________");
            }
        }
    }
}
