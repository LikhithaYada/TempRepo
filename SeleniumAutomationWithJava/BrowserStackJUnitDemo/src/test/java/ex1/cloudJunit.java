package ex1;
 
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class cloudJunit {
 
    WebDriver driver;
 
    // ✅ BrowserStack credentials
    public static final String USERNAME = "likhithayada_mqiX6V";
    public static final String AUTOMATE_KEY = "Msp6eTZtF8CCQpNAxoKq";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
 
    @Before
    public void setUp() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
 
            Map<String, Object> bstackOptions = new HashMap<>();
            bstackOptions.put("deviceName", "iPhone 12 Pro");
            bstackOptions.put("osVersion", "14");
            bstackOptions.put("projectName", "Cognixia Cloud Project");
            bstackOptions.put("buildName", "Cognixia Cloud Test Build");
            bstackOptions.put("sessionName", "OrangeHRM Login Test on BrowserStack");
 
            caps.setCapability("browserName", "safari");
            caps.setCapability("bstack:options", bstackOptions);
 
            driver = new RemoteWebDriver(new URL(URL), caps);
 
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 
        } catch (Exception e) {
            e.printStackTrace(); // 🔴 This will print the real cause of the skip
        }
    }
 
    @Test
    public void testcaseCloud() {
        System.out.println("✅ Connected to BrowserStack successfully and launched OrangeHRM!");
        System.out.println("Page Title: " + driver.getTitle());
    }
 
    @After
    public void closeSession() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }
}