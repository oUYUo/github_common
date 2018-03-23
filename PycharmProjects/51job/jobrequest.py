import requests
import re

def getRequest(url):
    return (re.findall('''<!-- SWSStringCutStart -->([\s\S]*)<!-- SWSStringCutEnd -->''',requests.get(url).text))

def openFile(filename):
    list=[]
    f = open("公司主页/"+filename+"CompanyUrl.txt", "r")
    for i in f:
        list.append(i.replace("\n", ""))
    f.close()
    return  list




if __name__=="__main__":
    #传入公司招聘主页
    JobName = ["android", "java", "net", "php", "python", "Web前端", "人工智能","大数据", "软件工程师"]
    for i in JobName:
        num=0
        list=openFile(i)
        f=open(i+"职业要求.txt","w")
        for j in list:
            num=num+1
            print(i+"   load  "+str(int((num/list.__len__())*100))+"%")
            try:
                f.write(getRequest(j)[0])
            except BaseException:
                pass
        f.close()
