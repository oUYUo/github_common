/*
IO流基本概述：
1，java.io包。
2，IO操作只有两种：读 或 写。
3，IO流基本分类：
		字节流的抽象基类：读InputStream, 写OutputStream
		字节流的缓冲区类：读BufferedInputStream, 写BufferedOutputStream

		字符流的抽象基类：读Reader, 写Writ
		字符流的缓冲区类：读BufferedReader, 写BufferedWriter

4，由这四个类派生出来的子类名称都是以其父类名作为子类名后缀。

5，明确流对象操作：
	1，明确源和目的：
		源：输入流。InputStream  Reader
		目的：输出流。OutputStream Writ

	2，操作的数据是否是纯文本？
	   是：字符流。
	   不是：字节流。

	3，当体系明确后，在明确要使用哪个具体对象。
	   通过设备来进行区分：
	   源设备：内存、硬盘、键盘
	   目的设备：内存、硬盘、控制台

6，所学流对象类：
	字符流：
		Reader					读
		Writer					写
		BufferedReader			缓冲区读
		BufferedWriter			缓冲区写
		---------------------------------------
		FileReader				文件读取字符流	---> InputStreamReader的子类
		FileWriter				文件写入字符流	---> OutputStreamWriter的子类
		PrintWriter

	字节流：
		InputStream				读
		OutputStream			写
		BufferedInputStream		缓冲区读
		BufferedOutputStream	缓冲区写
		---------------------------------------
		FileInputStream			文件读取字节流
		FileOutputStream		文件写入字节流

	转换流：
		InputStreamReader		读 字节流类转换字符流类
		OutputStreamWriter		写 字符流转换字节流

	键盘录入，输出控制台：
		System.out		输出控制台
		System.in		键盘输入

	传入任意流：
		PrintWriter ---		传入任意输出流
		PrintStream ---		传入任意输入流

	序列流：
		SequenceInputStream		对多个流进行合并

	对象存储流：
		ObjectInputStream		读 对象流
		ObjectOutputStream		存 对象流
		------------------------------------------
		Serializable			标记接口：被存储的对象需要实现 Serializable

	管道流：
		PipedInputStream        读 管道流
		PipedOutputStream		写 管道流

	随机读写流：
		RandomAccessFile		只能对文件读写操作

	基本数据类型操作流：
		DataOutputStream       输出流
		DataInputStream        输入流

	操作字节数组流：
		ByteArrayInputStream	读字节数组流
		ByteArrayOutputStream	写字节数组流

	操作字符数组流：
		CharArrayReader			读字符数组流
		CharArrayWriter			写字符数组流

	操作字符串流：
		StringReader			读字符串数组流
		StringWriter			写字符串数组流

7，父类作用划分：
	源设备：
		键盘 System.in，硬盘 FileStream，内存 ArrayStream
	目的设备：
		控制台 System.out，硬盘 FileStream，内存 ArrayStream
*/