/*
1，FileDialog类 --> 文件对话框, 继承了Dioalog
2，FileDialog类基本方法：
	1，构造指定标题，并绑定父窗口：FileDialog(Frame parent, String title, int mode) 
	   参数：parent --> 当文件对话框为可视真，parent指定的父窗口不可操作
	          tirle --> 文件对话框的窗口标题
			  mode -->  模式：FileDialog.LOAD（打开） 或 FileDialog.SAVE（保存） 

	2，组件是否可视：void setVisible(boolean b)
	   参数：可视为真，如易语言中的“打开”。

	3，获取此文件对话框的目录：String getDirectory()

	4，获取此文件对话框的选定文件：String getFile()

	5，设置文件对话框模式：void setMode(int mode)  
	   参数：mode -->  模式：FileDialog.LOAD（打开） 或 FileDialog.SAVE（保存）
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
		but = new Button( "打开文件");
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
				fd = new FileDialog( fra, "打开文件");

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