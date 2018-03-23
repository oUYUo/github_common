'''

|   Author:zhuob
|
|   date:2017/7/17
|
|   Description:scrapy zol for zhangzongyuan
|   the zol don't have robot's txt about img
|   so it is easy to scrapy wallpaper.
|   but i failed firstly. Because i think the finally html web is img
|   
|
|   then i use phantomjs and selenimus to prt sc
|   it's wasting time and i also meet some problems that i can't solve.
|   it is how to cut a threading while the threading use too much time.
|
|   finally,i don't solve it .
|
|   fortunately, i find the img-http under the html web,
|   so i finally the small porject.
|   
|
|   and i learn how to git my project.
|
|   so ,this is my first time to git my formal project. 
'''


import os
import re
import requests
import random
from bs4 import BeautifulSoup
from selenium import webdriver
#第一层页面即中关村壁纸的首页
#第二层页面即壁纸相册的页面
#第三层页面即完整图片的html页面
#第四层页面即完整图片的img页面


def get_second_page_url(type,page):
    original_url="http://desk.zol.com.cn/"
    kind_url=original_url+type+"/"+str(page)+".html"   

    re_1 = '''\<li class="photo-list-padding"\>(.*)\<div'''#先筛选出属于这个type的相册
    re_2 = '''[0-9]{3,4}[_][0-9]{3,5}[_][0-9]{1}[.]html'''#再筛选出这个相册的id
    print(kind_url)
    r = requests.get(kind_url)
    r.encoding = r.apparent_encoding
    
    html = r.text
    HTML = re.findall(re_1, html)
    
    second_page_url=[]
    
    for i in HTML:
        url = re.findall(re_2, i)
        for i in url:
            second_page_url.append("http://desk.zol.com.cn/bizhi/"+i)

    return second_page_url

    

def get_second_img_id(url):#这个url是第二层页面的url
    list=[]
    r = requests.get(url)
    all_ip=re.findall('''\<li class=\"show\d\"\>\s*\<a href=\"(.*)\"\>''',r.text)
    for i in all_ip:
        list.append(i.split("_")[1])
    return list
#得到每张图片的id，在第二层页面的
def get_num(url):#这个url是第二层页面的url
    r = requests.get(url)
    all_num = re.findall('''href=\"\/showpic\/1920x1080(.*?)\"''', r.text)
    num= all_num[0].split("_")[-1]
    return num
#因为每张图片后面加了一个随机数字，找出这个随机数字，最后生成html网址

def get_third_url(url):#这个url是第二层页面的url



    list=[]
    page_url=get_second_img_id(url)
    num=get_num(url)
    for i in  page_url:
        list.append("http://desk.zol.com.cn/showpic/1920x1080_"+str(i)+"_"+str(num))
    return list

def get_third_img(url):#这个url是第三层的htmlulr
    html=re.findall("http\:(.*).jpg",requests.get(url).text)
    URL="http:"+html[0]+".jpg"
    return URL

def download(file_name,r):
    
    
    q= requests.get(r,proxies={'https': '116.28.116.84:808'})
    q.encoding=q.apparent_encoding
    f=open(file_name,"wb")
    f.write(q.content)
    f.close



if __name__ == "__main__":
    

    second_url=[]
    for i in range(1,2):
        for i in get_second_page_url("mingxing/p4",i):
            second_url.append(i)
            print(i)
   
    
    
    third_url=[]
    for i in second_url:
        try:
            for i in get_third_url(i):
                third_url.append(i)
                print(i)            
        except Exception:
            pass


    third_img=[]
    for i in third_url:
        third_img.append(get_third_img(i))

    num=1
    for i in third_img:
        download("D:\python_codes\\try\img\\"+str(num)+".jpg",i)
        print("===================="+str(num)+"*************"+"success"+"=================")
        num+=1

