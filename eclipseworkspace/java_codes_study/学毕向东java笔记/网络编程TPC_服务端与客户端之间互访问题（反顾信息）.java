/*
����������˷�����д��Ϣ��
���⣺�ͻ��˺ͷ���˶���Ī���ĵȴ���
ԭ����Ϊ�ͻ��˺ͷ���˶���������������Щ����û�ж���������ǣ���һֱ�ȡ����������˶��ڵȴ���
�������������Ҫˢ�¡�ˢ�º󣬿ͻ��˺ͷ���˲��ܶ������ݡ�
�ڶ��ֽ��������PrintWriter ---		�������������
				PeintStream ---		��������������

ϸ�ڣ��ڿͻ���sock.close(),������߷���˽����ˣ����� -1 ������� read()��������readLine()�ĵײ������read()
*/
import java.io.*;
import java.net.*;

class TPCSocket 
{
	public static void main(String[] args) throws Exception	//�ͻ���
	{
		Socket sock = new Socket( InetAddress.getLocalHost(), 10000);

		//BufferedWriter outbuf = new BufferedWriter( new OutputStreamWriter( sock.getOutputStream()));
		PrintWriter outbuf = new PrintWriter( sock.getOutputStream(), true);

		BufferedReader isbur = new BufferedReader( new InputStreamReader( sock.getInputStream()));

		BufferedReader inbur = new BufferedReader( new InputStreamReader( System.in));

		String buf = null;

		while( ( buf = inbur.readLine()) != null)
		{
			if( "over".equals( buf))
				break;

			//outbuf.write( buf);
			//outbuf.newLine();
			//outbuf.flush();
			outbuf.println( buf);

			System.out.println( isbur.readLine());
		}

		sock.close();
		System.out.println( "����");
	}
}


class TPCServerSocket
{
	public static void main( String[] args) throws Exception	//�����
	{
		ServerSocket ss = new ServerSocket( 10000);

		Socket sock = ss.accept();

		//BufferedWriter outbuf = new BufferedWriter( new OutputStreamWriter( sock.getOutputStream()));
		PrintWriter outbuf = new PrintWriter( sock.getOutputStream(), true);

		BufferedReader isbur = new BufferedReader( new InputStreamReader( sock.getInputStream()));

		String buf = null;

		while( ( buf = isbur.readLine()) != null )
		{
			//outbuf.write( buf.toUpperCase());
			//outbuf.newLine();
			//outbuf.flush();
			outbuf.println( buf.toUpperCase());
		}

		sock.close();
		ss.close();
		System.out.println( "����");
	}
}