/*
getLocalPort()获取本机绑定端口。
getHostAddress()获取本机绑定IP。
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
	public void run() //发送
	{
		try
		{
			InetAddress ia = InetAddress.getLocalHost();

			DatagramSocket ds = new DatagramSocket();//定义本机端口

			BufferedReader bur = new BufferedReader( new InputStreamReader( System.in));
			
			String s = null;
			byte[] b = null;

			while( ( s = bur.readLine()) != null)
			{
				b = s.getBytes();

				DatagramPacket dp = new DatagramPacket( b, b.length, ia, 4000);//发送IP和对应的端口

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
	public void run()//接受
	{
		try
		{
			DatagramSocket ds = new DatagramSocket(4000);//定义本机端口，用于接受信息。

			while( true)
			{
				byte[] b = new byte[1024];

				DatagramPacket dp = new DatagramPacket( b, b.length);

				ds.receive( dp);//接受数据包，然后下面就是拆数据包获取数据。

				System.out.println( dp.getAddress().getHostAddress() + "：" + new String( dp.getData(), 0, dp.getLength()));
			}
		//	ds.close();
		}
		catch( Exception e)
		{
			System.out.println( e.toString());
		}
	}
}