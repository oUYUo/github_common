# 快速生成词云
from wordcloud import WordCloud
import matplotlib.pyplot as plt

def getPage(filename):
    f = open(filename+'.txt','r').read()
    wordcloud = WordCloud(background_color="white",width=1920, height=1080, margin=2,font_path=r"C:/Windows/Fonts/simfang.ttf").generate(f)
    wordcloud.to_file(filename+'.png')

if __name__=="__main__":
    name = ['''java''', "python", "net", "php", "android", "Web前端", "人工智能", "大数据", "软件工程师"]
    for i in name:
        getPage(i)
        print(i)