import time
import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

class TestMouseActions(unittest.TestCase):

    def setUp(self):
        print("===== Launching Application =====")
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()
        self.driver.get("https://demo.guru99.com/test/simple_context_menu.html")
        time.sleep(2)

    def tearDown(self):
        print("===== Closing Application =====")
        time.sleep(2)
        self.driver.quit()

    def test_context_and_double_click(self):
        driver = self.driver
        actions = ActionChains(driver)

        right_click_btn = driver.find_element(By.XPATH, "//span[text()='right click me']")
        actions.context_click(right_click_btn).perform()
        print("Right click done")
        time.sleep(1)


        edit_option = driver.find_element(By.XPATH, "//ul/li[contains(@class,'context-menu-icon-edit')]")
        edit_option.click()
        time.sleep(1)


        alert1 = driver.switch_to.alert
        print("Alert Text:", alert1.text)
        alert1.accept()

        double_click_btn = driver.find_element(By.XPATH, "//button[text()='Double-Click Me To See Alert']")
        actions.double_click(double_click_btn).perform()
        print("Double click done")
        time.sleep(1)

        alert2 = driver.switch_to.alert
        print("Alert Text:", alert2.text)
        alert2.accept()

if __name__ == "__main__":
    unittest.main()
