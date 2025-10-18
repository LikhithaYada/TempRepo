package controlExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkChecker{

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Opened test website successfully!\n");
    }

    @Test
    public void checkBrokenLinks() throws InterruptedException {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size() + "\n");

        int brokenCount = 0;
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            Thread.sleep(3000);

            try {
                if (url != null && !url.isEmpty() && url.startsWith("http")) {
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    conn.setRequestMethod("HEAD");
                    conn.connect();
                    int code = conn.getResponseCode();

                    if (code >= 400) {
                        System.out.println("❌ Broken Link: " + url + " → HTTP Code: " + code);
                        brokenCount++;
                    } else {
                        System.out.println("✅ Valid Link: " + url + " → HTTP Code: " + code);
                    }
                }
            } catch (Exception e) {
                System.out.println("⚠️ Invalid or Unreachable Link: " + url);
                brokenCount++;
            }
        }

        System.out.println("\nTotal Broken Links Found: " + brokenCount);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("\nBrowser closed successfully!");
        }
    }
}
