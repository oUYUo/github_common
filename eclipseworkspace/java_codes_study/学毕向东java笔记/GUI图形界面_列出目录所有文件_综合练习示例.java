import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MyWindowDome
{
	private Frame fra;
	private Button but;
	private TextField tf;
	private TextArea ta;

	MyWindowDome()
	{
		fra = new Frame( "MyWindowDome");
		but = new Button( "ת��");
		tf = new TextField(43);
		ta = new TextArea( 33, 50);

		init();
	}

	private void init()	//��������
	{
		fra.setBounds( 300, 200, 400, 600);
		fra.setLayout( new FlowLayout());
		fra.add( tf);
		fra.add( but);
		fra.add( ta);

		myEvent();

		fra.setVisible(true);
	}

	private void myEvent()//�¼�
	{
	    class ButEvent
		{
			ButEvent()
			{
				Dialog dia = new Dialog( fra,"��ʾ", true);
				Label lb = new Label( "������� " + tf.getText() + "·������", Label.CENTER);
				Button bt = new Button( "ȷ��");

				dia.setLayout( new FlowLayout());
				dia.setBounds( 350, 400, 200, 110);
									
				dia.add( lb);
				dia.add( bt);

				dia.addWindowListener( new WindowAdapter()
				{
					public void windowClosing(WindowEvent e)
					{
						dia.setVisible(false);
					}	
				});

				bt.addActionListener( new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dia.setVisible(false);
					}
				});

				bt.addKeyListener( new KeyAdapter()
				{ 
					public void keyPressed(KeyEvent e) 
					{
						if( e.getKeyCode() == KeyEvent.VK_ENTER)
							dia.setVisible(false);		
					}
				});

				dia.setVisible(true);
			}		
		}

		but.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				File f = new File(tf.getText());
				
				if( f.exists() && f.isDirectory())
				{
					String[] len = f.list();

					ta.setText( "");

					for( String s : len)
					{
						ta.append( s + "\r\n");
					}
				}
				else
				{
					new ButEvent();
				}
			}
		});

		tf.addKeyListener( new KeyAdapter()
		{ 
			public void keyPressed(KeyEvent e) 
			{
				if( e.getKeyCode() == KeyEvent.VK_ENTER)
					new ButEvent();
			}
		});
	}

	public static void main(String[] args) 
	{
		new MyWindowDome();
	}
}