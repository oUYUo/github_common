package cn.cslg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

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
		  //得到users.properties文件的绝对物理路径
		  String filePath = this.getServletContext().getRealPath("/WEB-INF/users.properties");
		  //文件输入流
		  FileInputStream fis = new FileInputStream(filePath);
		  Properties props = new Properties();//操作属性文件
		  props.load(fis);//把文件内容加载到内存
		  String pass = props.getProperty(userName, "NO");//(1)key ,(2)若key不存在时候，返回第二个参数的值
		  if(pass.equals("NO")){
			  out.print("用户名"+userName+"不存在！");
		  }else if(pass.equals(password)){
			  out.println("用户登录成功！");
		  }else{
			  out.println("密码不正确！");
		  }
		  out.flush();
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
