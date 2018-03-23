import requests
import urllib.request

def downloadmp4(url):
    urllib.request.urlretrieve(url,filename="test1.mp4")
