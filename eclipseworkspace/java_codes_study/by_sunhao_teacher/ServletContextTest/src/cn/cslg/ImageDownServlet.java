package cn.cslg;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageDownServlet
 */
@WebServlet("/ImageDownServlet")
public class ImageDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("image/jpg");//octet-stream
		response.setHeader("Content-Disposition","attachment;filename=Koala.jpg");
		ServletOutputStream out = response.getOutputStream();
		
		 
		
		ServletContext sc = this.getServletContext();
		InputStream in = sc.getResourceAsStream("/WEB-INF/Koala.jpg");
		
		
		
		byte[] buffer= new byte[1024];
		int len=0;
		while((len=in.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		in.close();
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
