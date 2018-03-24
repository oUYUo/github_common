/*
jar包：将package包压缩jar包
1，cmd命令行查看jar命令：
		A)指定jar目录：如，D:\java\jdk\bin
		B) cmd运行jar，如：D:\java\jdk\bin>jar

2，jar命令：用法: jar {ctxui}[vfmn0Me] [jar-file] [manifest-file] [entry-point] [-C dir] files ...
			选项:
				-c  创建新档案
				-t  列出档案目录
				-x  从档案中提取指定的 (或所有) 文件
				-u  更新现有档案
				-v  在标准输出中生成详细输出
				-f  指定档案文件名
				-m  包含指定清单文件中的清单信息
				-n  创建新档案后执行 Pack200 规范化
				-e  为绑定到可执行 jar 文件的独立应用程序
					指定应用程序入口点
				-0  仅存储; 不使用任何 ZIP 压缩
				-M  不创建条目的清单文件
				-i  为指定的 jar 文件生成索引信息
				-C  更改为指定的目录并包含以下文件
			如果任何文件为目录, 则对其进行递归处理。
			清单文件名, 档案文件名和入口点名称的指定顺序
			与 'm', 'f' 和 'e' 标记的指定顺序相同。

			示例 1: 将两个类文件归档到一个名为 classes.jar 的档案中:
				   jar cvf classes.jar Foo.class Bar.class
			示例 2: 使用现有的清单文件 'mymanifest' 并
					   将 foo/ 目录中的所有文件归档到 'classes.jar' 中:
				   jar cvfm classes.jar mymanifest -C foo/ .

3，创建jar包用法：a）cmd切换到文件夹中的package包。
				  b）jar -cf jar包名.jar package包名 package包名

			详解：A）c 创建jar包、f指定jar包名。--> 创建jar，那么就要给包起名。后缀.jar
				  B）要给package包压缩jar包，那么就要指定package包名。”a“命令行已切换到所存放package包的目录
				  C）多个package压缩jar 命令行用空格隔开。

			实例：e:\编译区>jar -cf haha.jar bm1 bm2 


4，查看jar包：a）cmd切换到文件夹中的jar包。
			  b）jar -tf jar包名.jar
			  C）也可直接用压缩软件打开查看。
		
		详解：A）t列出jar包中目录、f指定jar包名。 --> 指定jar的包并列出包中目录。
		
		实例：e:\编译区>jar -tf haha.jar


5，运行jar包：a）cmd 目录切换到jar包  ---> jar也是一个文件夹。
			  b）执行jar包中类
		实例：e:\编译区\haha.jar>java bm1.main


-------------------------------------------------------------------------------------------------

如何制作可以双击执行的jar包呢？
1，将多个类封装到了一个包(package)中。
2，定义一个jar包的配置信息。
	定义一个文件a.txt 。文件内容内容为：
	Main-Class:(空格)包名.类名(回车)
3，打jar包。
	jar -cvfm my.jar a.txt 包名
4，通过winrar程序进行验证，查看该jar的配置文件中是否有自定义的配置信息。

5，通过工具--文件夹选项--文件类型--jar类型文件，通过高级，定义该jar类型文件的打开动作的关联程序。
	jdk\bin\javaw.exe -jar

6，双击试试！。哦了。

*/