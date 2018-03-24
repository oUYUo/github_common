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
		
		//�����������������ת������ת��f1.jspҳ�棬��ʾ��������
		request.setAttribute("F1",userName);//�����ݴ洢��reuqest�����в�ָ��key
		RequestDispatcher rd = request.getRequestDispatcher("f1.jsp");//������һ����ת�Ķ���
		rd.forward(request, response);
		//�߼��ϲ��ܳ�����������
		
	}

}
