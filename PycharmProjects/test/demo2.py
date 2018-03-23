import requests
f=open("1.jpg","wb")
f.write(requests.get("https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g5/M00/0A/0C/ChMkJ1gj6zKIOLX2AAFPWmlZBgQAAXn9wNZu8QAAU9y322.jpg").content)
f.close()