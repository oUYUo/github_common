import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class FileDia {
	private Frame fra;
	private Button but;
	private FileDialog fd;
	private TextArea ta;
	
	private MenuBar mb;
	private Menu m;
	private MenuItem mi,mil;
	
	private File file;
	
	FileDia()
	{
		init();
	}
	private void init()
	{
		mb   =new MenuBar();
		m 	 =new Menu("�ļ�");
		mi   =new MenuItem("��");
		mil  =new MenuItem("����");
		
		m.add(mi);
		m.add(mil);
		mb.add(m);
		
		fra = new Frame("FileDia");
		ta = new TextArea(20,60);
		
		fra.setBounds(400,300,700,600);
		
		fra.add(ta);
		fra.setMenuBar(mb);
		
		myEvent();
		
		fra.setVisible(true);
		
	}
	private void myEvent()
	{
		mi.addActionListener(new ActionListener());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
