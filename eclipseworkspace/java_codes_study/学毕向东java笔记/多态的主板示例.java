class ��̬������ʾ��
{
	public static void main(String[] args) 
	{
		mainboard mb = new mainboard();
		mb.run();// usePCI pci = new NetCard();
		mb.usepci( new NetCard());
	}
}

class mainboard//����
{
	public  void run() //����
	{
		System.out.println("mainboard run");
	}

	public void usepci( usePCI p)
	{
		if (p != null)
		{
			 p.open();
			 p.close();
		}
	}
}

interface usePCI//���ʱ�׼���
{
	public abstract void open();//��
	public abstract void close();//�ر�
}

class NetCard implements usePCI//����
{
	public void open()
	{
		System.out.println("NetCard open");
	}
	public void close()
	{
		System.out.println("NetCard close");
	}

}