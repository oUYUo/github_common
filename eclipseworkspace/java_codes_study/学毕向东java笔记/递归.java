/*
�ݹ飺������������������ֱ�����ʽ�����߱���ַ�����Ϊ�ݹ顣
�ݹ�Ҫע�⣺
1���޶�������������ѭ����
2��Ҫע��ݹ�Ĵ��������������ڴ������
*/
class  
{
	public static void main(String[] args) 
	{
		//list( new File( "E:\\ѧϰ��\\java\\java�ʼ�"));
	}

	public static void list( File file)	//�г�Ŀ¼�µ������ļ�
	{
		/*
		�г�ָ��Ŀ¼���ļ������ļ��У�������Ŀ¼�е����ݡ�
		Ҳ�����г�ָ��Ŀ¼���������ݡ�

		��ΪĿ¼�л���Ŀ¼��ֻҪʹ��ͬһ���г�Ŀ¼���ܵĺ�����ɼ��ɡ�
		���г������г��ֵĻ���Ŀ¼�Ļ����������ٴε��ñ����ܡ�
		Ҳ���Ǻ��������������
		���ֱ�����ʽ�����߱���ַ�����Ϊ�ݹ顣
		*/
		File[] f = file.listFiles();
		System.out.println("--------------" + file + "-----------" + f.length);

		for( File fi : f)
		{
			System.out.println( fi.getName());
		}

		for( int x =  f.length-1; x >= 0; x--)
		{
			if( f[x].isDirectory())
			{
				file_5( f[x]);
			}
		}	
	}

	public static void toBin( int num)	//ʮ����ת������
	{
		if( num > 0)
		{
			toBin( num / 2);
			System.out.println( num % 2);
		}
	}

	public static int getSum( int sum)	//���
	{
		if( sum == 1)
			return 1;

		return sum + getSum(sum-1);
	}

	public static void delete( File f)	// ��ʾɾ���������ݵ��ļ��С�
	{
		File[] fi = f.listFiles();

		for( int x = 0; x < fi.length; x++)
		{
			if( fi[x].isDirectory())
				delete( fi[x]);
			else
				fi[x].delete();
		}
		f.delete();
	}
}