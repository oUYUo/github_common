package cn.cslg;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownServlet
 */
@WebServlet(
		urlPatterns = { "/FileDownServlet" }, 
		initParams = { 
				@WebInitParam(name = "file", value = "C:\\exp2.pdf")
		})
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition","attachment;filename=test.pdf");
		String filePath = this.getInitParameter("file");
		//定义文件输入流对象
		FileInputStream fis = new FileInputStream(filePath);
		ServletOutputStream  out = response.getOutputStream();
		
		byte []buffer = new byte[1024];
		int len=0;
		while((len=fis.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		fis.close();
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
