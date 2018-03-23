import requests
from selenium import webdriver
from bs4 import BeautifulSoup
url="https://www.5252b.com/"
html=requests.get(url)
print(html.text)
# html.encoding=html.apparent_encoding
# HTML=html.text
# # HTML.encode("gbk").decode("gbk")
# # print(str(HTML))
# # soup=BeautifulSoup(HTML)
# # print(soup.prettify())
# # f=open("baidu.com","w")
# # f.write(soup.prettify())
# # f.close()
# driver = webdriver.Chrome()
# driver.get("http://tool.oschina.net/codeformat/html")
# driver.find_element_by_id("htmldata").send_keys(str(HTML))
# driver.find_element_by_id("format").click()
# HTML=driver.find_element_by_id("fhtml").
# print(HTML)