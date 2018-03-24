/*
1���������̶����ڹ����¼��������� Component �������С�
2��Component ��������������
	1������������¼���void addMouseListener(MouseListener l) 
	   ������MouseListener�ӿڣ� MouseAdapter���ԡ��շ�����ʵ��������
	   ���÷�ʽ������.addMouseListener( new MouseAdapter() { ��Ҫʲô�¼��͸��ǣ���ϸ�뿴������� })
	
	2���������ƶ��¼���void addMouseMotionListener(MouseMotionListener l) 
	   ������MouseMotionListener�ӿڣ�MouseMotionAdapter���ԡ��շ�����ʵ��������
	   ���÷�ʽ������.addMouseMotionListener( new MouseMotionAdapter(){ ������Ҫ��������ϸ�뿴������� })
	
	3������������¼���void addMouseWheelListener(MouseWheelListener l) 
	   ������MouseWheelListener�ӿڣ���ֻ��һ����������ο��������
	   ���÷�ʽ������.addMouseWheelListener( new MouseWheelListener(){ ���Ƿ���������ϸ�鿴������� }) 

3��MouseListener ����¼��ӿڣ�java.awt.event.*;
	1����갴��������ϵ��������²��ͷţ�ʱ���ã�void mouseClicked(MouseEvent e) 		  
	2�������뵽�����ʱ���ã�void mouseEntered(MouseEvent e) 		   
	3������뿪���ʱ���ã�void mouseExited(MouseEvent e) 		  
	4����갴��������ϰ���ʱ���ã�void mousePressed(MouseEvent e) 	   
	5.��갴ť��������ͷ�ʱ���ã�void mouseReleased(MouseEvent e) 

4��MouseAdapter���ԡ��շ�����ʵ����MouseListener�ӿڡ�MouseAdapter������¼��շ����������¼���java.awt.event.*;
	1����갴��������ϰ��²��϶�ʱ���ã�void mouseDragged(MouseEvent e)         
	2��������ƶ�������ϵ��ް�������ʱ���ã�void mouseMoved(MouseEvent e) 
	3����������תʱ���ã�void mouseWheelMoved(MouseWheelEvent e) 

5��MouseMotionAdapter����ƶ��¼����ԡ��շ�����ʵ����MouseMotionListener����ƶ��¼��ӿڣ�java.awt.event.*;
	1����갴��������ϰ��²��϶�ʱ���ã�void mouseDragged(MouseEvent e) 
	2��������ƶ�������ϵ��ް�������ʱ���ã�void mouseMoved(MouseEvent e) 

6��MouseWheelListener�ӿڣ��������¼���java.awt.event.*;
	1����������תʱ���ã�void mouseWheelMoved(MouseWheelEvent e) 

7��MouseEvent�������ϸ�¼���java.awt.event.*;
	1��ȡ��굥��������int getClickCount()  
	   ���÷�ʽ����ο����� ��˫��ʾ�������롣
*/
import java.awt.*;
import java.awt.event.*;
class Mouse
{
	private Frame fra;
	private Button but;
	Mouse()
	{
		fra = new Frame( "���Դ���");
		but = new Button( "��ť");

		init();
	}

	private void init()
	{		
		fra.setSize(500,400);	//���ô��ڳ���
		fra.setLocation(300,200);//���ô���λ��
		fra.setLayout(new FlowLayout());	//���ô��ڲ���
		fra.add( but);

		myEvent();

		fra.setVisible(true);	//���ڿ��ӡ�
	}

	private void myEvent()
	{
		but.addMouseListener( new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				System.out.println( "�����뵽�����ʱ���á�");
			}

			public void mouseClicked(MouseEvent e)	// ˫��ʾ��
			{
				if( e.getClickCount() == 2)
				{
					System.out.println( "˫����");
				}
			}
		});
	}

	public static void main(String[] args) 
	{
		new Mouse();
	}
}