package controlExample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FrameHandle3 extends FrameHandle2 {

    @Test
    public void verifyImagesInFrame() {

 
        WebElement myFrame = driver.findElement(By.cssSelector("[src*='photo']"));

      
        driver.switchTo().frame(myFrame);

        
        List<WebElement> images = driver.findElements(By.tagName("img"));

        System.out.println("Total Images in Frame: " + images.size());

        for (WebElement img : images) {
            System.out.println("Image src: " + img.getAttribute("src"));
        }
        driver.switchTo().defaultContent();
    }
}
