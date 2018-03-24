package cn.cslg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(
		urlPatterns = { "/InitParamServlet" }, 
		initParams = { 
				@WebInitParam(name = "p1", value = "CSLG"), 
				@WebInitParam(name = "p2", value = "CSE")
		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String p3;
    private String p4;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String p1 = config.getInitParameter("p1");
		String p2 = config.getInitParameter("p2");
		p3=p1;
		p4=p2;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("p1="+p3);
		out.println("p2="+p4);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
