import re
def get(filename):
    f=open(filename+"职业要求.txt","r")
    brake=["<span style=",""]
    k=open(filename+".txt","w")
    for i in f:
        if(i.__len__()>=10):
            # print(i.__len__())
            # print(re.findall('''([1-9].*?)</''',i))
            for j in re.findall('''>([1-9].*?)</''',i):
                if(j.__len__()>15):
                    if((j.find('''<span style='''))==-1):
                        k.write(j[2:].replace('''&nbsp''',"").replace('''br''',"").replace("<","").replace(">","").replace("/",""))
    k.close()

if __name__=="__main__":
    name = ['''java''', "python", "net", "php", "android", "Web前端", "人工智能", "大数据", "软件工程师"]
    for i in name:
        get(i)
