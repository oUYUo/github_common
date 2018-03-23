JobName=["Android.txt","java.txt","net.txt","PHP.txt","python.txt","Web前端.txt","人工智能.txt","会计.txt","大数据.txt","机动车司机.txt","软件工程师.txt","销售经理.txt","销售主管.txt"]

k=open("average.txt","w")
for i in JobName:
    num=[]
    try:
        f=open(i,"r")
        for j in f:
            num.append(int(j.replace("\n","")))
        k.write(str(int(sum(num)/len(num)))+"=="+i.replace(".txt","")+"\n")
        print(str(int(sum(num)/len(num)))+"=="+i.replace(".txt",""))
        f.close()

    except BaseException:
        pass
k.close()



#完成访问所有文件，下一步求每个文件的平均数