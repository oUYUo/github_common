//客户端登录，服务端效验，如果3次登录失败，程序结束。
import java.io.*;
import java.net.*;

class TheloginSocket
{
	public static void main(String[] args) throws Exception
	{
		Socket sock = new Socket( InetAddress.getLocalHost(), 10008);

		OutputStream out = sock.getOutputStream();

		BufferedReader burin = new BufferedReader( new InputStreamReader( System.in));

		BufferedReader bursock = new BufferedReader( new InputStreamReader( sock.getInputStream()));
		
		for( int x = 0; x < 3; x++)
		{
			String name = burin.readLine();
			out.write( name.getBytes());
			name = bursock.readLine();
			
			System.out.println( name);
			if( ! ( name.equals( "登录失败")))
				break;	
		}
		burin.close();
		sock.close();
	}
}

class TheloginServerSocket

{
	public static void main(String[] args) throws Exception
	{
		BufferedReader bufname = new BufferedReader( new InputStreamReader( new FileInputStream( "Thelogin.txt")));

		StringBuilder sbuf = new StringBuilder();

		String buf = null;
		
		while( ( buf = bufname.readLine()) != null)
		{
			sbuf.append( buf + "--");
		}	
		String[] name = sbuf.toString().split( "--");

		bufname.close();


		ServerSocket ss = new ServerSocket( 10008);
		
		while( true)
		{
			Socket sock = ss.accept();
			new Thread( new LoginServer( name, sock)).start();
		}
	}
}

class LoginServer implements Runnable
{
	private String[] name;
	private Socket sock;

	LoginServer( String[] name, Socket sock)
	{
		this.name = name;
		this.sock = sock;
	}
	public void run()
	{
		try
		{
			InputStream ia = sock.getInputStream();
			PrintWriter out = new PrintWriter( sock.getOutputStream(),true);

			byte[] bufs = new byte[1024];

			for( int y = 0; y < 3; y++)
			{
				int len = ia.read( bufs);
				String s = new String( bufs, 0, len);

				boolean bool = false;

				for( int x = 0; x < name.length; x++)
				{		
					if( name[x].equals( s))
					{
						bool = true;				
						break;
					}
				}

				if( bool)
				{
					out.println( "登录成功");
					break;
				}
				else
				{
					out.println( "登录失败");
				}
			}

			sock.close();
		}
		catch( Exception e)
		{}
	}
}