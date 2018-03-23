# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import requests

for i in range(1,19):
    url="https://www.patest.cn/contests/pat-a-practise/1"
    if(i<10):
        url=url+"00"+str(i)
    else:
        url=url+"0"+str(i)
    print(url)
    text=requests.get(url).text
    text=text.replace("charset=UTF-8","")
    f=open(r"C:\Users\孙卓\Desktop\A-Level-练习集_\A_Level_"+str(i)+".html",'w')
    f.write(text)
    f.close()
