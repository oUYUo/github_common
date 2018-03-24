package cn.cslg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginCheckServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();
		
		  String userName = request.getParameter("userName");
		  String password = request.getParameter("password");
		  //�õ�users.properties�ļ��ľ�������·��
		  String filePath = this.getServletContext().getRealPath("/WEB-INF/users.properties");
		  //�ļ�������
		  FileInputStream fis = new FileInputStream(filePath);
		  Properties props = new Properties();//���������ļ�
		  props.load(fis);//���ļ����ݼ��ص��ڴ�
		  String pass = props.getProperty(userName, "NO");//(1)key ,(2)��key������ʱ�򣬷��صڶ���������ֵ
		  if(pass.equals("NO")){
			  //out.print("�û���"+userName+"�����ڣ�");
			  request.setAttribute("ErrMsg", "�û���"+userName+"�����ڣ�");
			  RequestDispatcher rd = request.getRequestDispatcher("ErrorServlet");
			  rd.forward(request, response);
			  
		  }else if(pass.equals(password)){
			  //out.println("�û���¼�ɹ���");
			  response.sendRedirect("SuccessServlet");
			  
		  }else{
			  //out.println("���벻��ȷ��");
			  request.setAttribute("ErrMsg", "���벻��ȷ��");
			  RequestDispatcher rd = request.getRequestDispatcher("ErrorServlet");
			  rd.forward(request, response);
		  }
		 
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
