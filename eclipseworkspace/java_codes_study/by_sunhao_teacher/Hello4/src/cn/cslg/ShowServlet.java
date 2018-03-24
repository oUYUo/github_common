package cn.cslg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//通过Request对象获取表单提交的值
		String userName = request.getParameter("userName");//参数名称必须要与<input>的name属性值要一致
		String gender = request.getParameter("gender");
		String favor[] = request.getParameterValues("favor");
		String grade = request.getParameter("grade");
		
		out.print("UserName: "+ userName);
		out.println("<br/>");
		
		out.println("Gender:");
		String gr = gender.equals("M")?"男":"女";
		out.println(gr);
		out.println("<br/>");
		String r="";
		for(String s:favor){
			if(s.equals("1"))r=r+"足球";
			else if(s.equals("2"))r+="篮球";
			else if(s.equals("3"))r+="乒乓球";
		}
		out.println("Favor:"+r);
		
		out.println("<br/>");
		out.println("Grade: "+grade);
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println(request.getMethod()+"<br/>");
		out.println(request.getQueryString()+"<br/>");
		out.println(request.getRemoteAddr()+"<br/>");
		out.println(request.getRequestURI()+"<br/>");
	    
		out.println("<hr/>");
		out.println(request.getHeader("User-Agent")+"<br/>");
		out.println(request.getHeader("Accept")+"<br/>");
		
	
	}

}
