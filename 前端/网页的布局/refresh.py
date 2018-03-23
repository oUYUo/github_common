from selenium import webdriver
import time
url =input("Enter your input: ")
driver = webdriver.Chrome()
driver.get(url)
while(True):
    driver.refresh()
    time.sleep(3)
driver.close()