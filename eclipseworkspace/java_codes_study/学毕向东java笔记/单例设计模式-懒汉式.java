/*
����ʽ���ڰ�ȫ������ͨ��������ʽ�������
*/
class  
{
	public static void main(String[] args) 
	{
		Single s = Single.getInstance();
	}
}

class Single
{
	private Single(){};
	private static Single s = null;

	public static Single getInstance()
	{
		if( s == null)
			s == new Single();

/* �����ȫ�����������������ˣ����������ˣ�����ͨ����ʵ�ʿ���ʱʹ�ö���ʽ��
		if(s==null) 
        { 
            synchronized(Single.class) 
            { 
                if(s==null) 
                    s = new Single(); 
            } 
        } 
*/
		return s;
	}
}