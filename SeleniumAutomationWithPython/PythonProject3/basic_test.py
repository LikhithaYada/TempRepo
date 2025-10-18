# basic_test.py
import unittest
import time
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

class BasicTest(unittest.TestCase):
    def setUp(self):
        print("launch the application")
        # webdriver-manager will download correct chromedriver automatically
        service = Service(ChromeDriverManager().install())
        self.driver = webdriver.Chrome(service=service)

        # open Amazon and maximize (same as your Java code)
        self.driver.get("https://www.amazon.in/")
        self.driver.maximize_window()
        time.sleep(3)

    def tearDown(self):
        print("close the application")
        time.sleep(7)
        self.driver.quit()

# Optional: when you run this file directly, unittest will run (no test methods in BasicTest)
if __name__ == "__main__":
    unittest.main()
