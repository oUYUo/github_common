import requests
import findMp4Url
import re
url="https://www.xvideos.com/best/2018-01/"
link=[]
for i in range(1,20):
    URL=url+str(i)
    response= requests.get(URL)
# while True:
    if response.status_code==200:
        txt=response.text
        link_behind = re.findall('''a href="/video(.*?)"''',txt)
        for i in link_behind:
            link.append("https://www.xvideos.com/video"+i)
            print("https://www.xvideos.com/video"+i)
    else:
        print(URL)
# link.remove("https://www.xvideos.com/videos-i-like")
# link = list(set(link))
# f=open("mp4.txt","a")
# for i in link:
#     f.write(findMp4Url.getMp4Url(i))
#     print(findMp4Url.getMp4Url(i))
# f.close()

