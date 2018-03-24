package cn.cslg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyCodeServlet
 */
@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public VerifyCodeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("image/jpg");
		 response.setHeader("Pragma", "No-cache");
		 response.setHeader("Cache-Control","No-cache");
		 response.setIntHeader("Expires", 0);
		 
		 String verifyCode = getCode();//获取验证码
		 //验证码存储到Session对象（会话对象）
		 request.getSession().setAttribute("VerifyCode", verifyCode);
		 
		 int width=100;
		 int height=50;
		 //创建了一个空图像对象
		 BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		 //获得一个画笔
		 Graphics g = image.getGraphics();
		 //设置颜色
		 g.setColor(Color.WHITE);
		 //画了白色背景
		 g.fillRect(0, 0, width, height);
		 
		 g.setColor(Color.BLUE);
		 
		 g.drawString(verifyCode, 5, 10);
		 
		 ServletOutputStream out = response.getOutputStream();
		 
		 ImageIO.write(image, "JPG", out);
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private String getCode(){
		StringBuilder sbr = new StringBuilder();
		Random rand = new Random();//负责产生随机数
		for(int i=0;i<4;i++){
			sbr.append(rand.nextInt(10));
		}
		return sbr.toString();
	}

}
