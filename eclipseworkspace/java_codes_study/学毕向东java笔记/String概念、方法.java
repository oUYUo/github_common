/*
String�ַ����ࣺ
1�� String s1 = "abc";	s1��һ�������ͱ�����"abc"��һ������
2���ַ���һ������ʼ���Ͳ����Ա��ı䡣��s1���±���ֵ��s1ָ�����һ���µĶ���
3��String s2 = new String( "abc"); �˴�������Ǻ� String s1 = "abc"; ��ͬ��
   s1��s2������
		 s1���ڴ�����һ������
		 s2���ڴ�������������new Stringһ������"abc"����һ������
		 s1 == s2;  �Ƚϵ��Ƕ�����������ͬһ������
		 s1.equals(s2); �Ƚϵ����ַ����Ƿ���ͬ����ΪString�ิд��Object��equals������

4��String k =����;���ָ�ʽ�������ʱ������������������������ͬ�����б���ָ�����ͬһ������
5��Stirng�෽����
	1����ȡ��
		1.1 �ַ����еİ������ַ�����Ҳ�����ַ����ĳ��ȡ�
			int length():��ȡ���ȡ�
		1.2 ����λ�û�ȡλ����ĳ���ַ���
			char charAt(int index):
		1.3 �����ַ���ȡ���ַ����ַ�����λ�á�
			int indexOf(int ch):���ص���ch���ַ����е�һ�γ��ֵ�λ�á�
			int indexOf(int ch, int fromIndex) :��fromIndexָ��λ�ÿ�ʼ����ȡch���ַ����г��ֵ�λ�á�

			int indexOf(String str):���ص���str���ַ����е�һ�γ��ֵ�λ�á�
			int indexOf(String str, int fromIndex) :��fromIndexָ��λ�ÿ�ʼ����ȡstr���ַ����г��ֵ�λ�á�

			int lastIndexOf(int ch) ��
		1.4 �Ӵ�����ȡ�ַ����е�һ���֡�
			String substring(begin);	��ָ��λ�ÿ�ʼ����β��
			String substring(begin,end); ����ͷ��������β��

	2���жϡ�
		2.1 �ַ������Ƿ����ĳһ���Ӵ���
			boolean contains(str)��
			����֮����indexOf(str):��������str��һ�γ���λ�ã��������-1.��ʾ��str�����ַ����д��ڡ�
					���ԣ�Ҳ�������ڶ�ָ���ж��Ƿ������
					if(str.indexOf("aa")!=-1)

					���Ҹ÷����������жϣ��ֿ��Ի�ȡ���ֵ�λ�á�

		2.2 �ַ����Ƿ������ݡ�
			boolean isEmpty(): ԭ������жϳ����Ƿ�Ϊ0. 
		2.3 �ַ����Ƿ�����ָ�����ݿ�ͷ��
			boolean startsWith(str);
		2.4 �ַ����Ƿ�����ָ�����ݽ�β�� �����ж��ļ����Ƿ���.java�ļ���
			boolean endsWith(str);
		2.5 �ж��ַ��������Ƿ���ͬ����д��Object���е�equals������
			boolean equals(str);
		2.6 �ж������Ƿ���ͬ�������Դ�Сд��
			boolean equalsIgnoreCase( String anotherString);
		
	3��ת����
		3.1 ���ַ�����ת���ַ�����
			���캯����String(char[])
					  String(char[],offset,count):���ַ������е�һ����ת���ַ�����
						offset��ʼλ��count�����������ӵ�3λ��ʼ����ת��5��λ��
			��̬������
					static String copyValueOf(char[]);
					static String copyValueOf(char[] data, int offset, int count) 

					static String valueOf(char[]): Ӧ��3.5

			
		3.2 ���ַ���ת���ַ����顣**
			char[] toCharArray():    String s1 = "abcd";  ---> char[] s2 = {'a','b','c','d'};

		3.3 ���ֽ�����ת���ַ�����
				String(byte[])
				String(byte[],offset,count):���ֽ������е�һ����ת���ַ�����

		3.4 ���ַ���ת���ֽ����顣
				byte[]  getBytes():
		3.5 ��������������ת���ַ�����
			static String valueOf(int)
			static String valueOf(double)

			//3+"";//String.valueOf(3);

			���⣺�ַ������ֽ�������ת�������У��ǿ���ָ�������ġ�

	4���滻
		String replace(char oldchar, char newchar); �滻�ַ�
		����replace('a','b'); ���ַ��������ַ���a�滻��b
		String replace(CharSequence taraget, CharSequence replacement); �滻�ַ���

	5���и�
		String[] split(regex); regex����Ϊ�ָ����������ַ������顣

	6��ת����ȥ���ո񣬱Ƚϡ�
		6.1 ���ַ���ת�ɴ�д����Сд��
			 String toUpperCase(); ת��Сд��
			 String toLowerCase(); ת����д��

		6.2 ���ַ������˵Ķ���ո�ȥ����
			String trim(); ȥ����β�ո�

		6.3 �������ַ���������Ȼ˳��ıȽϡ�
			int compareTo(string);
			�Ƚ��ַ����в�ͬ�ַ���ASCII�����ز�ֵASCII������������ڣ����ظ�����
*/