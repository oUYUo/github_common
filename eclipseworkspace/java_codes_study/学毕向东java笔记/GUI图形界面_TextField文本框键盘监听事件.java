/*
1��TextField���ǵ����ı�����������TextComponent��
2��TextField�෽����
	1������һ�������ı���TextField()
	2������ָ�����������ı���TextField(int columns)
	3������ָ�����ݵ����ı���TextField(String text)
	4������ָ�����������ݵ����ı���TextField(String text, int columns)
	5����Ӽ��̼�������void addKeyListener(KeyListener l) ��Component�ࡿ
	   ��������ϸ�鿴��GUI�����¼�_Key���̼����¼���
	   ���÷�ʽ��tex.addKeyListener( new KeyAdapter() { �¼����� });
*/
import java.awt.*;
import java.awt.event.*;
class TextFie
{
	private Frame fra;
	private TextField tex;
	TextFie()
	{
		fra = new Frame( "�����ı���");//��������
		tex = new TextField( 20);//�����ı���

		init();
		myEvent();
	}

	private void init()	//��������
	{
		fra.setBounds( 400, 300, 500, 400);
		fra.setLayout( new FlowLayout());
		fra.add( tex);
		fra.setVisible(true);
	}

	private void myEvent()//�¼�
	{
		tex.addKeyListener( new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int code = e.getKeyCode();

				if( !( code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9))
					e.consume();
			}
		});
	}

	public static void main( String[] args)
	{
		new TextFie();
	}
}