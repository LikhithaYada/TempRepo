package hrmAppExample;
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
import java.util.List;

public class LocatorExampleJava {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void amazonSearchFindElements() {
        System.out.println("Launch the application");

        // Wait for search box to be visible and get all elements
        List<WebElement> searchBoxes = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("twotabsearchtextbox"))
        );
        System.out.println("Total search boxes found: " + searchBoxes.size());

        // Wait for search button to be clickable and get all elements
        List<WebElement> searchButtons = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("nav-search-submit-button"))
        );
        System.out.println("Total search buttons found: " + searchButtons.size());

        // Perform search if elements exist
        if (!searchBoxes.isEmpty()) {
            searchBoxes.get(0).sendKeys("iphone16");
        }

        if (!searchButtons.isEmpty()) {
            searchButtons.get(0).click();
        }

        System.out.println("Search operation done");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}