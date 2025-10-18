package controlExample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InputHandleBox extends BaseTest {
    public void selectCheckbox(String value) {
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("Checkboxes found: " + allCheckboxes.size());

        boolean found = false;
        for (WebElement cb : allCheckboxes) {
            String cbValue = cb.getAttribute("value").trim();
            System.out.println("Found checkbox: " + cbValue);

            if (cbValue.equalsIgnoreCase(value)) {
                if (!cb.isSelected()) {  
                    cb.click();
                    System.out.println("Selected checkbox: " + cbValue);
                } else {
                    System.out.println("Checkbox already selected: " + cbValue);
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Checkbox with value '" + value + "' not found.");
        }
    }
    @Test
    public void testSelectCheckbox() {
        System.out.println("Running test...");
        selectCheckbox("Bike");
        selectCheckbox("Car");
    }
}
