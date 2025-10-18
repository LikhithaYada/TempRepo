import time
from pages.home_page import HomePage

def test_click_register_button_using_descendant(driver):
    print("Opening page...")
    home_page = HomePage(driver)
    home_page.open()
    time.sleep(2)

    print("Locating Register button using descendant axis...")
    home_page.click_register_button()

    print("Register button clicked successfully.")
    time.sleep(2)
