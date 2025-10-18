package controlExample;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle2 {

    WebDriver driver;

    @Before
    public void launchApp() throws InterruptedException {
        System.out.println("===============launchApp=================");
        
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        
        Thread.sleep(4000);
    }

    @After
    public void closeApp() throws Exception {
        System.out.println("===============closeApp=================");
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
