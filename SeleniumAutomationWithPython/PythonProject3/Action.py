import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
import time


@pytest.fixture
def setup():
    #
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get("https://www.amazon.in/")
    print("=== Step 1: Amazon application launched successfully ===")
    time.sleep(3)
    yield driver
    driver.quit()
    print("=== Step 5: Browser closed. Test completed successfully ===")


def test_verify_see_all_offers_page(setup):
    driver = setup
    try:
        print("=== Step 2: Trying to click offers/deals link ===")
        offers_link = driver.find_element(
            By.XPATH,
            "//a[contains(text(),'Deal') or contains(text(),'Offer') or contains(text(),'offer')]"
        )
        offers_link.click()
        time.sleep(3)
        print("Link clicked successfully")

        print("=== Step 3: Verifying URL ===")
        actual_url = driver.current_url
        assert "deal" in actual_url.lower() or "offer" in actual_url.lower(), \
            "URL does not contain deals/offers"
        print(f"URL verification passed: {actual_url}")

        print("=== Step 4: Verifying Page Title ===")
        actual_title = driver.title
        print(f"Captured Title: {actual_title}")
        assert "deal" in actual_title.lower() or "offer" in actual_title.lower(), \
            "Title does not contain expected text"
        print(f"Title verification passed: {actual_title}")

    except Exception as e:
        print(f"Test failed: {str(e)}")
        raise e
