import download_mp4
import findMp4Url
# import 抓取主页url
if __name__ =="__main__":
    url="https://hls-hw.xvideos-cdn.com/videos/hls/34/cc/78/34cc78cdcd93024b657e0c8fa01f65ec/hls.m3u8?e=1515850824&l=0&h=6ee3802a29800e4a25412bc34c9571a7"
    filename="2.mp4"
    download_mp4.downloadmp4(url)