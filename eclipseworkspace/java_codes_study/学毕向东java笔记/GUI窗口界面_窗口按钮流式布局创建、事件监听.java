/*
1���¼��������Ƶ��ص㣺
	1���¼�Դ������awt������swing���е���Щͼ�ν��������
	2���¼���ÿһ���¼�Դ�����Լ����еĶ�Ӧ�¼��͹����¼���
	3���������������Դ���ĳһ���¼��Ķ�������ֻһ�����������Ѿ���װ���˼������С�
	4���¼�����

2��Window��������Frame�����ĸ��ࡣ
3��Frame����������ʾ��
	1������һ�����б���Ĵ��壺Frame(String title)
	   ���÷�ʽ��Frame frame = new Frame( "my awt");

	2�����������С��void setSize( int width, int height)��window�෽����
	   ���������Ϊ width���߶�Ϊ height��
	   ���÷�ʽ������.setSize( 500, 400);

	3���������λ�ã�void setLocation( int left, int top)��������Դ������
	   ������left --- ��ߣ� top ---����
	   ���÷�ʽ������.setLocation(300,200);

	4�������������ֹ�������void setLayout(LayoutManager mgr)  ��Container��
	   ������LayoutManager�ǲ��ֹ������ӿ� ---> FlowLayout ��ʽ����Ϊʾ��
	   ���÷�ʽ������.setLayout(new FlowLayout());

	5����������β����Component add(Component comp)  ��Container��
	   ���÷�ʽ������.add( new Button("����һ����ť")); //�����һ����ť��

	6������Ƿ���ӣ� void setVisible(boolean b)	 ��window��
	   ���÷�ʽ������.setVisible(true);  //Ϊtrue���ӣ�Ϊfalse����

	7�����������Сλ�ã�void setBounds( int x, int y, int width, int height) ��Container��
	   ������x -- ��ߡ�y -- ���ߡ�width -- ��ȡ�height-- �߶�

	8����Ӵ��ڼ�������void addWindowListener(WindowListener l)  ��window�෽����
	   ������WindowListener���ǽӿ��ࡣWindowAdapter ���ǳ����࣬�á��շ�����ʵ����WindowListener�������ڳ���ĸ��ǡ�
	   ���÷�ʽ��f.addWindowListener( new WindowAdapter()
				{
					//�رմ����¼�
					public void windowClosing(WindowEvent e)	
					{
						System.out.println("�ҹ�");
						System.exit(0);	//�رոý��̡�
					}
					
					//������¼�
					public void windowActivated(WindowEvent e)	
					{
						System.out.println("�һ��ˡ�");

					}
					
					//���������¼�
					public void windowOpened(WindowEvent e)		
					{
						System.out.println("�ұ�����,hahahhahah");
					}
				});

-------------------------------------------------------------------------------------
	
*/
import java.awt.*;
import java.awt.event.*;
class  AwtDemo
{
/*	����ͼ�λ����棺
	1������frame���塣
	2���Դ�����л������á�
		�����С��λ�ã����֡�
	3�����������
	4�������ͨ�������add������ӵ������С�
	5���ô�����ʾ��ͨ��setVisible(true)*/

	public static void main(String[] args) 
	{
		Frame f = new Frame("my awt");
		f.setSize(500,400);	//���ô��ڳ���
		f.setLocation(300,200);//���ô���λ��
		f.setLayout(new FlowLayout());	//���ô��ڲ���


		Button b = new Button("����һ����ť");	//�½���ť
		
		f.add(b);	//����ť��ӵ������С�


		f.addWindowListener(new WindowAdapter()	//���ڼ����¼�
		{
			//�رմ����¼�
			public void windowClosing(WindowEvent e)
			{
				System.out.println("�ҹ�");
				System.exit(0);
			}

			//������¼�
			public void windowActivated(WindowEvent e) 
			{
				System.out.println("�һ��ˡ�");

			}
			
			//���������¼�
			public void windowOpened(WindowEvent e) 
			{
				System.out.println("�ұ�����,hahahhahah");
			}

		});
		
		f.setVisible(true);	//���ڿ��ӡ�
	}
}
/*
class MyWin implements WindowListener
{
	//����7��������������ֻ�õ��˹رյĶ�����
	//����������û���õ�������ȴ���븴д��

}

//��ΪWindowListener������WindowAdapter�Ѿ�ʵ����WindowListener�ӿڡ�
//�����������е����з�������ô��ֻҪ�̳���Windowadapter��������Ҫ�ķ������ɡ�
class MyWin extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		//System.out.println("window closing---"+e.toString());
		System.exit(0);
	}
}

*/

//��ϰ������һ�����壬�ڴ��������һ����ť�߱��رոô���Ĺ��ܡ�
