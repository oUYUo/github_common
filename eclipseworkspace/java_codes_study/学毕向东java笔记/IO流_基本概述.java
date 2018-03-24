/*
IO������������
1��java.io����
2��IO����ֻ�����֣��� �� д��
3��IO���������ࣺ
		�ֽ����ĳ�����ࣺ��InputStream, дOutputStream
		�ֽ����Ļ������ࣺ��BufferedInputStream, дBufferedOutputStream

		�ַ����ĳ�����ࣺ��Reader, дWrit
		�ַ����Ļ������ࣺ��BufferedReader, дBufferedWriter

4�������ĸ��������������������ƶ������丸������Ϊ��������׺��

5����ȷ�����������
	1����ȷԴ��Ŀ�ģ�
		Դ����������InputStream  Reader
		Ŀ�ģ��������OutputStream Writ

	2�������������Ƿ��Ǵ��ı���
	   �ǣ��ַ�����
	   ���ǣ��ֽ�����

	3������ϵ��ȷ������ȷҪʹ���ĸ��������
	   ͨ���豸���������֣�
	   Դ�豸���ڴ桢Ӳ�̡�����
	   Ŀ���豸���ڴ桢Ӳ�̡�����̨

6����ѧ�������ࣺ
	�ַ�����
		Reader					��
		Writer					д
		BufferedReader			��������
		BufferedWriter			������д
		---------------------------------------
		FileReader				�ļ���ȡ�ַ���	---> InputStreamReader������
		FileWriter				�ļ�д���ַ���	---> OutputStreamWriter������
		PrintWriter

	�ֽ�����
		InputStream				��
		OutputStream			д
		BufferedInputStream		��������
		BufferedOutputStream	������д
		---------------------------------------
		FileInputStream			�ļ���ȡ�ֽ���
		FileOutputStream		�ļ�д���ֽ���

	ת������
		InputStreamReader		�� �ֽ�����ת���ַ�����
		OutputStreamWriter		д �ַ���ת���ֽ���

	����¼�룬�������̨��
		System.out		�������̨
		System.in		��������

	������������
		PrintWriter ---		�������������
		PrintStream ---		��������������

	��������
		SequenceInputStream		�Զ�������кϲ�

	����洢����
		ObjectInputStream		�� ������
		ObjectOutputStream		�� ������
		------------------------------------------
		Serializable			��ǽӿڣ����洢�Ķ�����Ҫʵ�� Serializable

	�ܵ�����
		PipedInputStream        �� �ܵ���
		PipedOutputStream		д �ܵ���

	�����д����
		RandomAccessFile		ֻ�ܶ��ļ���д����

	�����������Ͳ�������
		DataOutputStream       �����
		DataInputStream        ������

	�����ֽ���������
		ByteArrayInputStream	���ֽ�������
		ByteArrayOutputStream	д�ֽ�������

	�����ַ���������
		CharArrayReader			���ַ�������
		CharArrayWriter			д�ַ�������

	�����ַ�������
		StringReader			���ַ���������
		StringWriter			д�ַ���������

7���������û��֣�
	Դ�豸��
		���� System.in��Ӳ�� FileStream���ڴ� ArrayStream
	Ŀ���豸��
		����̨ System.out��Ӳ�� FileStream���ڴ� ArrayStream
*/