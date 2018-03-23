from selenium import webdriver
import time
driver =webdriver.Chrome()
driver.get(r"E:\github\HTML\demo\baidu.html")
while(True):
    driver.refresh()
    time.sleep(5)
driver.close()