import unittest
from selenium.webdriver.common.by import By
from basic_test import BasicTest

class LocatorExample(BasicTest):
    def test_HRMLoginLocator(self):
        print("launch the application")
        driver = self.driver

        print("Verify login page")


        search_boxes = driver.find_elements(By.ID, "twotabsearchtextbox")
        print(f"Total search boxes found: {len(search_boxes)}")


        search_buttons = driver.find_elements(By.ID, "nav-search-submit-button")
        print(f"Total search buttons found: {len(search_buttons)}")


        if search_boxes:
            search_boxes[0].send_keys("iphone16")


        if search_buttons:
            search_buttons[0].click()

        print("Search operation done")

if __name__ == "__main__":
    unittest.main()
