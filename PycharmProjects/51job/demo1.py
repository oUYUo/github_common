import  requests
import re
def average(seq):     #求平均数
    try:
        num=float(sum(seq))/len(seq)
    except BaseException:
        num=0
    return num

def getPay(url):        #得到工资xxxx-xxxx格式
    list=re.findall('''<td class="zwyx">(.*?)</td>''',requests.get(url).text)
    return  list

def getPayabove6000(list): #用的到的工资做分析，把6000以下的除去，因为很多实习工资不算
    list2=[]
    for i in list:
        try:
            if(int(i.split("-")[0])>6000):
                list2.append(i)
        except BaseException:
            pass
    return list2

def getPayMid(list):      #把得到个工资xxxx-xxxx格式的，转为中间数，即(xxxx+xxxx)/2
    list2=[]
    for i in list:
        try:
            num1=int(i.split("-")[0])
            num2=int(i.split("-")[0])
            list2.append((num1+num2)/2)
        except BaseException:
            pass
    return list2

if __name__ =="__main__":
    url='''http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%e5%8d%97%e4%ba%ac&kw=%e4%ba%ba%e5%b7%a5%e6%99%ba%e8%83%bd&sm=0&sg=c9d933d12fd249e68dca61566acbaa5c&p='''
    f=open("人工智能.txt","w")
    for i in range(1,20):
        url_page=url+str(i)
        # print(int(average(getPayMid(getPayabove6000(getPay(url_page))))))
        string=int(average(getPayMid(getPayabove6000(getPay(url_page)))))
        # string = int(average(getPayMid((getPay(url_page)))))
        if(string!=0):
            print(string)
            f.write(str(string)+"\n")
    f.close()
