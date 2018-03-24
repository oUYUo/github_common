class 多态的主板示例
{
	public static void main(String[] args) 
	{
		mainboard mb = new mainboard();
		mb.run();// usePCI pci = new NetCard();
		mb.usepci( new NetCard());
	}
}

class mainboard//主板
{
	public  void run() //运行
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

interface usePCI//国际标准插槽
{
	public abstract void open();//打开
	public abstract void close();//关闭
}

class NetCard implements usePCI//网卡
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