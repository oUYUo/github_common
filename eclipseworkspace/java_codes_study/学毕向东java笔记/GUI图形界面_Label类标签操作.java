/*
1��Label��ǩ�࣬�̳���Component
2��Label��ǩ�ֶΣ�
	2.1��ָʾ��ǩ�ı�Ӧ���У�static int CENTER 
    2.2��ָʾ��ǩ�ı�Ӧ����룺static int LEFT  
    2.3��ָʾ��ǩ�ı�Ӧ�Ҷ��룺static int RIGHT

3��Label��ǩ�෽����
	1����������ݱ�ǩ��Label()

	2������ָ�����ݱ�ǩ��Label(String text)

	3������ָ�����ݡ�ָ�����뷽ʽ��ǩ��Label(String text, int alignment) 

	4��ȡ��ǩ�ı���String getText();

	5�����ñ�ǩ���뷽ʽ��void setAlignment(int alignment) 

	6�����ñ�ǩ�ı���void setText(String text)
*/

import java.awt.*;
import java.awt.event.*;
class LabelDome
{
	public static void main(String[] args) 
	{
		Frame fra = new Frame( "���Ա�ǩ");
		Label lab = new Label( "���ñ�ǩ");

		fra.setLayout( new FlowLayout());
		fra.setBounds( 300, 200, 400, 400);
		fra.add( lab);
		fra.setVisible( true);
	}
}