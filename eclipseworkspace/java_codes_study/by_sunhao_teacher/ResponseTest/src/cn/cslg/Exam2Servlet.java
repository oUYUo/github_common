package cn.cslg;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class Exam2Servlet
 */
@WebServlet("/Exam2Servlet")
public class Exam2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=test.pdf");
		
		ServletOutputStream out = response.getOutputStream();//
		
		FileInputStream  fis = new FileInputStream("C:\\down.pdf");
		
		byte buffer[] = new byte[1024];
		int len=0;//记录实际读取的字节数
		while((len=fis.read(buffer))!=-1){//-1表示文件读完
			out.write(buffer, 0, len);
		}
		fis.close();//关闭输入流
		out.flush();//刷新缓存 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
