/*
String字符串类：
1， String s1 = "abc";	s1是一个类类型变量，"abc"是一个对象。
2，字符串一旦被初始化就不可以被改变。当s1重新被赋值，s1指向的是一个新的对象。
3，String s2 = new String( "abc"); 此代码表面是和 String s1 = "abc"; 相同。
   s1和s2的区别：
		 s1在内存中有一个对象。
		 s2在内存中有两个对象：new String一个对象，"abc"又是一个对象。
		 s1 == s2;  比较的是对象，两个不是同一个对象。
		 s1.equals(s2); 比较的是字符串是否相同，因为String类复写了Object类equals方法。

4，String k =“”;这种格式定义变量时，当定义多个变量，且内容相同，所有变量指向的是同一个对象。
5，Stirng类方法：
	1，获取。
		1.1 字符串中的包含的字符数，也就是字符串的长度。
			int length():获取长度。
		1.2 根据位置获取位置上某个字符。
			char charAt(int index):
		1.3 根据字符获取该字符在字符串中位置。
			int indexOf(int ch):返回的是ch在字符串中第一次出现的位置。
			int indexOf(int ch, int fromIndex) :从fromIndex指定位置开始，获取ch在字符串中出现的位置。

			int indexOf(String str):返回的是str在字符串中第一次出现的位置。
			int indexOf(String str, int fromIndex) :从fromIndex指定位置开始，获取str在字符串中出现的位置。

			int lastIndexOf(int ch) ：
		1.4 子串，获取字符串中的一部分。
			String substring(begin);	从指定位置开始到结尾。
			String substring(begin,end); 包含头，不包含尾。

	2，判断。
		2.1 字符串中是否包含某一个子串。
			boolean contains(str)：
			特殊之处：indexOf(str):可以索引str第一次出现位置，如果返回-1.表示该str不在字符串中存在。
					所以，也可以用于对指定判断是否包含。
					if(str.indexOf("aa")!=-1)

					而且该方法即可以判断，又可以获取出现的位置。

		2.2 字符中是否有内容。
			boolean isEmpty(): 原理就是判断长度是否为0. 
		2.3 字符串是否是以指定内容开头。
			boolean startsWith(str);
		2.4 字符串是否是以指定内容结尾。 例：判断文件名是否是.java文件。
			boolean endsWith(str);
		2.5 判断字符串内容是否相同。复写了Object类中的equals方法。
			boolean equals(str);
		2.6 判断内容是否相同，并忽略大小写。
			boolean equalsIgnoreCase( String anotherString);
		
	3，转换。
		3.1 将字符数组转成字符串。
			构造函数：String(char[])
					  String(char[],offset,count):将字符数组中的一部分转成字符串。
						offset起始位；count个数；例：从第3位开始，共转换5个位。
			静态方法：
					static String copyValueOf(char[]);
					static String copyValueOf(char[] data, int offset, int count) 

					static String valueOf(char[]): 应用3.5

			
		3.2 将字符串转成字符数组。**
			char[] toCharArray():    String s1 = "abcd";  ---> char[] s2 = {'a','b','c','d'};

		3.3 将字节数组转成字符串。
				String(byte[])
				String(byte[],offset,count):将字节数组中的一部分转成字符串。

		3.4 将字符串转成字节数组。
				byte[]  getBytes():
		3.5 将基本数据类型转成字符串。
			static String valueOf(int)
			static String valueOf(double)

			//3+"";//String.valueOf(3);

			特殊：字符串和字节数组在转换过程中，是可以指定编码表的。

	4，替换
		String replace(char oldchar, char newchar); 替换字符
		例：replace('a','b'); 将字符串所有字符的a替换成b
		String replace(CharSequence taraget, CharSequence replacement); 替换字符串

	5，切割
		String[] split(regex); regex参数为分隔符。返回字符串数组。

	6，转换，去除空格，比较。
		6.1 将字符串转成大写或则小写。
			 String toUpperCase(); 转换小写。
			 String toLowerCase(); 转换大写。

		6.2 将字符串两端的多个空格去除。
			String trim(); 去除首尾空格。

		6.3 对两个字符串进行自然顺序的比较。
			int compareTo(string);
			比较字符串中不同字符的ASCII，返回差值ASCII，如果参数大于，返回负数。
*/