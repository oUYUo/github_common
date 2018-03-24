package cn.cslg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class F1Servlet
 */
@WebServlet("/F1Servlet")
public class F1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = "Tom";
		
		//处理结束，现在请求转发，跳转到f1.jsp页面，显示处理结果。
		request.setAttribute("F1",userName);//把数据存储到reuqest对象中并指定key
		RequestDispatcher rd = request.getRequestDispatcher("f1.jsp");//创建了一个跳转的对象
		rd.forward(request, response);
		//逻辑上不能出现其它代码
		
	}

}
