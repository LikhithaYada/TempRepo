from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.edge.service import Service as EdgeService
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.chrome.options import Options as ChromeOptions
from selenium.webdriver.edge.options import Options as EdgeOptions
from selenium.webdriver.firefox.options import Options as FirefoxOptions
import time

# ========== CONFIGURATION ==========
BROWSER = "edge"  # change to "chrome", "firefox", or "edge"
URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

# Paths to your browser drivers
CHROME_DRIVER_PATH = r"C:\path\to\chromedriver.exe"   # update if using Chrome
EDGE_DRIVER_PATH = r"C:\Users\jaisriram\Downloads\edgedriver_win64\msedgedriver.exe"
FIREFOX_DRIVER_PATH = r"C:\path\to\geckodriver.exe"   # update if using Firefox
# ====================================


def launch_browser():
    """Launch selected browser and return driver instance"""
    if BROWSER.lower() == "chrome":
        print("Launching Chrome browser...")
        options = ChromeOptions()
        options.add_argument("--start-maximized")
        service = ChromeService(executable_path=CHROME_DRIVER_PATH)
        driver = webdriver.Chrome(service=service, options=options)

    elif BROWSER.lower() == "edge":
        print("Launching Edge browser...")
        options = EdgeOptions()
        options.add_argument("--start-maximized")
        service = EdgeService(executable_path=EDGE_DRIVER_PATH)
        driver = webdriver.Edge(service=service, options=options)

    elif BROWSER.lower() == "firefox":
        print("Launching Firefox browser...")
        options = FirefoxOptions()
        service = FirefoxService(executable_path=FIREFOX_DRIVER_PATH)
        driver = webdriver.Firefox(service=service, options=options)

    else:
        raise ValueError("Unsupported browser! Use chrome, edge, or firefox.")

    return driver


def login_logout_test():
    """Perform login and logout on OrangeHRM"""
    driver = launch_browser()
    driver.get(URL)
    print("Opened OrangeHRM login page")
    time.sleep(2)

    # --- Login ---
    driver.find_element(By.NAME, "username").send_keys("Admin")
    time.sleep(1)
    driver.find_element(By.NAME, "password").send_keys("admin123")
    time.sleep(1)
    driver.find_element(By.CSS_SELECTOR, "button[type='submit']").click()
    print("✅ Logged in successfully")
    time.sleep(2)

    # --- Logout ---
    driver.find_element(By.CSS_SELECTOR, ".oxd-userdropdown-name").click()
    time.sleep(1)
    driver.find_element(By.LINK_TEXT, "Logout").click()
    print("✅ Logged out successfully")
    time.sleep(1)

    driver.quit()
    print("Browser closed.")


# ======= RUN TEST =======
if __name__ == "__main__":
    print("===================== SETUP =====================")
    login_logout_test()
    print("===================== TEST COMPLETED =====================")
