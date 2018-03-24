package cn.cslg;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GBServlet
 */
@WebServlet("/GBServlet")
public class GBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GBServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//IE  默认传输数据使用ISO-8859-1
		//第一种方式所
		//request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("userName");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Name:"+convert(name));
        
		
	}
	
	private String convert(String s) {

		try {
			return new String(s.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			
			throw new RuntimeException(e);
		}

	}


}
