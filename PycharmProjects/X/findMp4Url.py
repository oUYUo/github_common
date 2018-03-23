import requests
import re

url = "https://www.xvideos.com/video25532605/os_virgens_paranormais"
def getMp4Url(url):

    link =requests.get(url).text
    # print(link)
    mp4url=re.findall("'https://hls(.*?)'",link)
    url=''
    for i in mp4url:
        url='https://hls'+i
    return url