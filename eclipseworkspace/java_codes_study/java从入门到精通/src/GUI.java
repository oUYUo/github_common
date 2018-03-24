import java.awt.*;
import java.awt.event.KeyEvent;
class KeyDome
{
	private Frame fra;
	private Button but;
	private TextField tf;
	
	KeyDome()
	{
		fra = new Frame("²âÊÔ´°¿Ú");
		but = new Button("°´Å¥");
		tf = new TextField(20);
		
		init();
	}
	
	private void init()
	{
		fra.setSize(500,400);
		fra.setLocation(300, 200);
		fra.setLayout(new FlowLayout());
		fra.add(but);
		fra.add(tf);
		
		myEvent();
		
		fra.setVisible(true);
		
		
	}
	private void myEvent()
	{
		but.addKeyListener(new KeyAdapter()
		{
			int x = 0;
			
			public void keyPressed(KeyEvent e)
			{
				if (e.isControlDown()&&e.getKeyCode()==KeyEvent.Vk_Enter)
					System.out.println("hello"+x++);
				
			}
		});
	}
}
public class GUI extends AWTError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyDome();
	}

}
