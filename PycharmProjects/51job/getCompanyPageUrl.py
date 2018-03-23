import requests
import re
def getPageUrl(url):#传入公司列表页面
    list2=[]
    list=re.findall('''http://jobs.zhaopin.com/(.*?).htm''',requests.get(url).text)
    for i in list:
        list2.append('''http://jobs.zhaopin.com/'''+i+".htm")
    return list2

def getPageUrl20(url):#url为公司列表页面网址，去掉page页
    list=[]
    for i in range(1,20):
        url2=url+str(i)
        try:
            for j in getPageUrl(url2):
                list.append(j)
        except BaseException:
            pass
    return list

def getPageUrl5(url):#url为公司列表页面网址，去掉page页
    list=[]
    for i in range(1,5):
        url2=url+str(i)
        try:
            for j in getPageUrl(url2):
                list.append(j)
        except BaseException:
            pass
    return list

def getPageUrlBynum(url,num):#url为公司列表页面网址，去掉page页
    list=[]
    for i in range(1,num):
        url2=url+str(i)
        try:
            for j in getPageUrl(url2):
                list.append(j)
        except BaseException:
            pass
    return list

def download(filename,url):
    load=0
    list=getPageUrl5(url)
    f=open(filename+".txt","w")
    for i in list:
        f.write(i+"\n")
        load=load+1
    f.close()
def downloadbyNum(filename,url,num):
    load=0
    list=getPageUrlBynum(url,num)
    f=open(filename+".txt","w")
    for i in list:
        f.write(i+"\n")
        load=load+1
    f.close()

if __name__=="__main__":#page往后的话，有的职位不想关，只搜索前5个页面
    downloadbyNum("软件工程师CompanyUrl","http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%8D%97%E4%BA%AC&kw=软件工程师&sm=0&p=",5)