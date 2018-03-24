/*
�ļ��Ի���

Frame�����
FileDialog���ļ��Ի���
Button����ť
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

	private MenuBar mb;
	private Menu m;
	private MenuItem mi, mil;

	private File file;

	FileDia()
	{
		init();
	}

	private void init()
	{
		mb = new MenuBar();
		m = new Menu( "�ļ�");
		mi = new MenuItem( "��");
		mil = new MenuItem( "����");

		m.add( mi);
		m.add( mil);
		mb.add( m);

		fra = new Frame( "FileDia");
		ta = new TextArea( 20, 60);

		fra.setBounds( 400, 300, 700, 600);

		fra.add( ta);
		fra.setMenuBar( mb);

		myEvent();

		fra.setVisible(true);
	}

	private void myEvent() 
	{
		mi.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fd = new FileDialog( fra, "���ļ�");

				fd.setVisible(true);

				String phts = fd.getDirectory();
				String name = fd.getFile();

				if( phts == null || name == null)
					return;
				
				file = new File( phts, name);
				ta.setText( "");

				try
				{
					BufferedReader br = new BufferedReader( new FileReader( file));

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

		mil.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if( file == null || !file.exists())
				{
					FileDialog fd = new FileDialog( fra, "�����ļ�", FileDialog.SAVE);

					fd.setVisible(true);

					String phts = fd.getDirectory();
					String name = fd.getFile();

					if( phts == null || name == null)
						return;

					file = new File( phts, name);
				}

				try
				{
					BufferedWriter bufw  = new BufferedWriter( new FileWriter(file));
					
					bufw.write( ta.getText());
					bufw.close();
				}
				catch( IOException ew)
				{
					System.out.println( ew.toString());
				}
			
			}
		});
	}

	public static void main(String[] args) 
	{
		new FileDia();
	}
}