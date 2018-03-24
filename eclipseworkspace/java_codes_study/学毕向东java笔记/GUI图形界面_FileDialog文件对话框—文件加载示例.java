/*
1��FileDialog�� --> �ļ��Ի���, �̳���Dioalog
2��FileDialog�����������
	1������ָ�����⣬���󶨸����ڣ�FileDialog(Frame parent, String title, int mode) 
	   ������parent --> ���ļ��Ի���Ϊ�����棬parentָ���ĸ����ڲ��ɲ���
	          tirle --> �ļ��Ի���Ĵ��ڱ���
			  mode -->  ģʽ��FileDialog.LOAD���򿪣� �� FileDialog.SAVE�����棩 

	2������Ƿ���ӣ�void setVisible(boolean b)
	   ����������Ϊ�棬���������еġ��򿪡���

	3����ȡ���ļ��Ի����Ŀ¼��String getDirectory()

	4����ȡ���ļ��Ի����ѡ���ļ���String getFile()

	5�������ļ��Ի���ģʽ��void setMode(int mode)  
	   ������mode -->  ģʽ��FileDialog.LOAD���򿪣� �� FileDialog.SAVE�����棩
*/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class FileDia
{
	private Frame fra;
	private Button but;
	private FileDialog fd;
	private TextArea ta;

	FileDia()
	{
		init();
	}

	private void init()
	{
		fra = new Frame( "FileDia");
		but = new Button( "���ļ�");
		ta = new TextArea( 20, 60);

		fra.setBounds( 400, 300, 500, 400);
		fra.setLayout( new FlowLayout());
		fra.add( but);
		fra.add( ta);

		myEvent();

		fra.setVisible(true);
	}

	private void myEvent() 
	{
		but.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fd = new FileDialog( fra, "���ļ�");

				fd.setVisible(true);

				String phts = fd.getDirectory() + fd.getFile();

				ta.setText( "");

				try
				{
					BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( phts)));

					String s = null;

					while( ( s = br.readLine()) != null)
					{
						ta.append( s +"\r\n");	
					}

					br.close();
				}
				catch( IOException es)
				{
					System.out.println( es.toString());
				}
			}
		}); 
	}

	public static void main(String[] args) 
	{
		new FileDia();
	}
}