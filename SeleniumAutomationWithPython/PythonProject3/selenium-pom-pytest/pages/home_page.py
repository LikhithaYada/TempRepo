from selenium.webdriver.common.by import By
from .base_page import BasePage

class HomePage(BasePage):
    REGISTER_BTN = (By.XPATH, "//div[@class='buttons']/descendant::button[normalize-space()='Register']")

    def __init__(self, driver):
        super().__init__(driver)

    def open(self):
        self.go_to("https://www.hyrtutorials.com/p/add-padding-to-containers.html")

    def click_register_button(self):
        self.click(*self.REGISTER_BTN)
