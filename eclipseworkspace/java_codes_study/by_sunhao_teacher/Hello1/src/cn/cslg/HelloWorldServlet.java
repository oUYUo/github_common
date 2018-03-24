package cn.cslg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")  
//ע�⣨���ã���Servlet��url-pattern��"/"����
//����̳�HttpServlet
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	//��ʼ������
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//config���洢�ͷ���Servlet������Ϣ
	}

	/**
	 * @see Servlet#destroy()
	 */
	//���ٷ������ͷ���init�������Դ
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����Http GET���� 
		//request: ��װHttp�����ģ�ͬʱ�ṩ�˲�������
		//response: ��װHttp��Ӧ���ģ�ͬʱ�ṩ����Ӧ���ĵĲ�������
		
		response.setContentType("text/html;charset=UTF-8");//������Ӧ���ݵ�����(MIME)�Լ��ַ�����
		PrintWriter out = response.getWriter();//���������ͻ������ָ����Ϣ��
		out.print("HelloWorld");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Post����
		//request: ��װHttp�����ģ�ͬʱ�ṩ�˲�������
		//response: ��װHttp��Ӧ���ģ�ͬʱ�ṩ����Ӧ���ĵĲ�������
		response.setContentType("text/html;charset=UTF-8");//������Ӧ���ݵ�����(MIME)�Լ��ַ�����
		PrintWriter out = response.getWriter();//���������ͻ������ָ����Ϣ��
		
		String userName = request.getParameter("userName");//��ȡ�ͻ��˱��ύ��ֵ��
		out.println("UN:"+userName);
		
	}

}
