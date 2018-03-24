/*
1，C:\Windows\System32\drivers\etc目录下的 hosts 文件
2，输入新浪网址回车，会根据你所设置的 DNS 服务器发送到对应的服务器（比如，我的DNS是电信的）。然后通过服务器解析返回IP地址。
3，会先找本地hosts文件是否有对应的IP/主机名，效果如下：
	1，127.0.0.1     localhost
	   输入：localhost网址，会打开127.0.0.1，当然提前是打开Tomcat服务器，因为这个ip是本机的。

	2，127.0.0.1	qwa.com
	   输入：qwa.com，效果如第一项相同。

	3，127.0.0.1	www.baidu.com
	   输入：www.baidu.com，网页会无法连接，可以说是屏蔽掉了该网页。
	   原因：www.baidu.com 不是项目名。网址未带 www 的不可屏蔽。

*/