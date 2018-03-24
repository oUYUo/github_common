/*
getLocalPort()��ȡ�����󶨶˿ڡ�
getHostAddress()��ȡ������IP��
*/
import java.net.*;
import java.io.*;
class WinQq
{
	public static void main(String[] args) throws Exception
	{
		Thread	t1 = new Thread(new UdpSend());
		t1.start();
		Thread	t2 = new Thread(new UdpRece());
		t2.start();
	}
}

class UdpSend implements Runnable
{
	public void run() //����
	{
		try
		{
			InetAddress ia = InetAddress.getLocalHost();

			DatagramSocket ds = new DatagramSocket();//���屾���˿�

			BufferedReader bur = new BufferedReader( new InputStreamReader( System.in));
			
			String s = null;
			byte[] b = null;

			while( ( s = bur.readLine()) != null)
			{
				b = s.getBytes();

				DatagramPacket dp = new DatagramPacket( b, b.length, ia, 4000);//����IP�Ͷ�Ӧ�Ķ˿�

				ds.send( dp);
			}

			ds.close();
		}
		catch( Exception e)
		{
			System.out.println( e.toString());
		}
	}
}

class UdpRece implements Runnable
{
	public void run()//����
	{
		try
		{
			DatagramSocket ds = new DatagramSocket(4000);//���屾���˿ڣ����ڽ�����Ϣ��

			while( true)
			{
				byte[] b = new byte[1024];

				DatagramPacket dp = new DatagramPacket( b, b.length);

				ds.receive( dp);//�������ݰ���Ȼ��������ǲ����ݰ���ȡ���ݡ�

				System.out.println( dp.getAddress().getHostAddress() + "��" + new String( dp.getData(), 0, dp.getLength()));
			}
		//	ds.close();
		}
		catch( Exception e)
		{
			System.out.println( e.toString());
		}
	}
}