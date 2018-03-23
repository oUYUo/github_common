import  requests
import re
from selenium import webdriver
url='''https://s.taobao.com/search?q=%E8%A3%99%E5%AD%90&imgfile=&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20180322&ie=utf8&bcoffset=4&ntoffset=4&p4ppushleft=1%2C48&s=44'''

# html=requests.get(url)
# print(html.text)
driver = webdriver.PhantomJS()
driver.get(url)
print(re.findall('''<span>¥</span><strong>(.*?)</strong>''',driver.page_source))