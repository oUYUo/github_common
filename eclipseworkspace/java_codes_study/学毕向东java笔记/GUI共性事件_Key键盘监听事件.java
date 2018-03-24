/*
1���������̶����ڹ����¼��������� Component �������С�
2��Component����̼���������
	1����Ӽ��̼�������void addKeyListener(KeyListener l)
	   ������KeyListener�Ǹ��ӿڡ� KeyAdapter�ԡ��շ�����ʵ��������
	   ���÷�ʽ������.addKeyListener( new KeyAdapter(){ �¼����� }); ��ο� myEvent() ���롣

3��KeyListener�Ǹ��ӿڡ� KeyAdapter�ԡ��շ�����ʵ��������
	1������ĳ����ʱ���ô˷�����void keyPressed(KeyEvent e)   
	2���ͷ�ĳ����ʱ���ô˷�����void keyReleased(KeyEvent e)      
	3������ĳ����ʱ���ô˷�����void keyTyped(KeyEvent e)

4��KeyEvent�࣬�����¼�����
	1��ȡ�����������ַ���char getKeyChar() 
	2��ȡ����������������int getKeyCode() 
	3��ͨ������ȡ��Ӧ�ļ�����static String getKeyText(int keyCode) 
	   ���⣺ȡ�Ķ��Ǵ�д�ַ�����������ţ��������ֱ�����ʽ��
	   ���÷�ʽ��KeyEvent.getKeyText( e.getKeyCode());

5��InputEvent����KeyEvent�ĸ��࣬��Ҳ�Ǽ����¼���
	1���жϰ���Alt����boolean isAltDown()
	2���жϰ���Ctrl����boolean isControlDown()
	3���жϰ���Shift����boolean isShiftDown()
	4��ֹͣ�����¼���void consume()	�����ı���׼������ĸ��

*/
import java.awt.*;
import java.awt.event.*;
class KeyDome
{
	private Frame fra;
	private Button but;
	private TextField tf;

	KeyDome()
	{
		fra = new Frame( "���Դ���");
		but = new Button( "��ť");
		tf = new TextField( 20);	//�����ı�����Ϊ10

		init();
	}

	private void init()
	{		
		fra.setSize(500,400);	//���ô��ڳ���
		fra.setLocation(300,200);//���ô���λ��
		fra.setLayout(new FlowLayout());	//���ô��ڲ���
		fra.add( but);
		fra.add( tf);

		myEvent();

		fra.setVisible(true);	//���ڿ��ӡ�
	}

	private void myEvent()
	{
		but.addKeyListener( new KeyAdapter()	//��ť�����¼�
		{
			int x = 0;
			//����ĳ����ʱ���ô˷�����
			public void keyPressed(KeyEvent e) 
			{
				if( e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
					System.out.println( "hlloe"+x++);
			}
		});

		tf.addKeyListener( new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int code = e.getKeyCode();
				if( !( code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)
				{
					System.out.println( "consume");	//ֹͣ�����������ַ��¼�
					e.consume();
				}
			}
		});
	}

	public static void main(String[] args) 
	{
		new KeyDome();
	}
}