from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Chrome()
driver.maximize_window()


driver.get("https://www.amazon.in")


links = driver.find_elements(By.TAG_NAME, "a")
print("Total links on page:", len(links))

driver.quit()
