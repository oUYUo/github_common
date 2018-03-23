from selenium import  webdriver
import time
driver = webdriver.Chrome()
driver.get("https://github.com/login")
driver.find_element_by_name("login").send_keys("1548314601@qq.com")
time.sleep(3)
driver.find_element_by_name("password").send_keys("sz869993410")
time.sleep(3)
driver.find_element_by_name("commit").click()