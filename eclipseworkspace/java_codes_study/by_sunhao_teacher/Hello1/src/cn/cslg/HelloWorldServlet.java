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
//注解（配置），Servlet的url-pattern，"/"必需
//必须继承HttpServlet
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	//初始化方法
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//config：存储和访问Servlet配置信息
	}

	/**
	 * @see Servlet#destroy()
	 */
	//销毁方法，释放在init申请的资源
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理Http GET请求 
		//request: 封装Http请求报文，同时提供了操作方法
		//response: 封装Http响应报文，同时提供了响应报文的操作方法
		
		response.setContentType("text/html;charset=UTF-8");//设置响应内容的类型(MIME)以及字符集。
		PrintWriter out = response.getWriter();//输出对象，向客户端输出指定信息。
		out.print("HelloWorld");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Post请求
		//request: 封装Http请求报文，同时提供了操作方法
		//response: 封装Http响应报文，同时提供了响应报文的操作方法
		response.setContentType("text/html;charset=UTF-8");//设置响应内容的类型(MIME)以及字符集。
		PrintWriter out = response.getWriter();//输出对象，向客户端输出指定信息。
		
		String userName = request.getParameter("userName");//获取客户端表单提交的值，
		out.println("UN:"+userName);
		
	}

}
