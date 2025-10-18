import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
import time

@pytest.fixture(scope="function")
def driver():
    print("\n[SETUP] Launching browser...")
    options = Options()
    options.add_argument("--start-maximized")
    # Uncomment for headless mode:
    # options.add_argument("--headless=new")

    service = ChromeService(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service, options=options)
    driver.implicitly_wait(5)

    yield driver  # gives control to test

    print("\n[TEARDOWN] Closing browser...")
    time.sleep(2)
    driver.quit()
    print("Browser closed successfully.")
