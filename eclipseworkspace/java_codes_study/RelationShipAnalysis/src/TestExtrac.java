import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;
import java.io.*;
import javax.imageio.ImageIO;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.mysql.jdbc.Connection;

public class TestExtrac {

	public static void main(String[] args) throws Exception {
		String FileDir = "E:/data";//读取数据源文件
		Infodispatcher info = new Infodispatcher(new File(FileDir));//调用信息分发类，对数据集进行处理
		info.StartToDealing();//开始对数据进行处理
		System.out.println("End");//数据处理完毕标志
		IndexWord[] indexterms = info.getindexterms();//返回文档集所有词汇的数组
		DataPoint[] datas = new DataPoint[indexterms.length];//将数据抽象化为DataPiont点
		int count = 0;

		IndexWord temp;
		for (int i = indexterms.length; i > 0; i--) {//将数据抽象为点，数据点包括词汇，其IDF、TF值
			for (int j = 0; j < i - 1; j++) {
				if (indexterms[j].getTF() < indexterms[j + 1].getTF()) {
					temp = indexterms[j];
					indexterms[j] = indexterms[j + 1];
					indexterms[j + 1] = temp;
				}
			}
		}
		indexterms[0].setRank(1);
		for (int i = 1; i < indexterms.length; i++) {//对所有的索引项根据其TF进行排序
			if (indexterms[i].getTF() == indexterms[i - 1].getTF())
				indexterms[i].setRank(indexterms[i - 1].getRank());
			else
				indexterms[i].setRank(i + 1);
		}
		for (IndexWord w : indexterms) {
			datas[count] = new DataPoint(w.getWord(), (float) (1 + Math.log(w.getTF())),
					(float) (Math.log(4702/w.getIDF())/Math.log(2)), w.getRank());
			count++;
		}
		System.out.println("abstract is over,start to draw Picture");//显示数据的抽象化结束，开始画图
		
		 Draw(datas);//调用画图函数进行画图
		InsertToDataBase(datas);//调用插入函数，将所有数据插入mysql数据库

	}

	private static void Draw(DataPoint[] ds) throws IOException {
		BufferedImage pic = new BufferedImage(1350, 1000, BufferedImage.TYPE_INT_RGB);
		int x1 = 100;
		int y1 = 800;
		int x2 = x1;
		int y2 = y1;
		Graphics2D g = (Graphics2D) pic.getGraphics();
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1350, 1000);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier", Font.ITALIC, 25));
		g.drawString("O", x1 - 20, y1 + 25);// 绘制圆点
		g.drawString("Value", x1 - 35, 75);// 绘制y轴标志
		g.drawString("Log(Rank)", 1130, y1 + 25);// 绘制x轴标志
		g.setFont(new Font("Courier", Font.ITALIC, 35));
		g.setColor(Color.BLUE);// 标志TF
		g.fillOval(1160, 150, 15, 15);
		g.drawString("TF", 1200, 165);
		g.setColor(Color.yellow);// 标志IDF
		g.fillOval(1160, 190, 15, 15);
		g.drawString("IDF", 1200, 205);
		g.setColor(Color.darkGray);// 标志TF-IDF
		g.fillOval(1160, 230, 15, 15);
		g.drawString("TF-IDF", 1200, 245);
		g.setFont(font);
		g.setColor(Color.GRAY);
		// 绘制表格
		g.drawLine(x1, y1, x1, y1 - 700);// 绘制y轴
		g.drawLine(x1, y1, x1 + 1000, y1);// 绘制x轴
		for (int i = 0; i < 10; i++) {
			x1 += 100;
			y2 -= 100;
			g.drawLine(x1, y1, x1, y1 - 700);// 绘制竖线
			g.drawString("" + (((double) i / 2) + 0.5), x1 - 5, y1 + 30);// 绘制横坐标
			if (i < 7) {
				g.drawString("" + (i + 1) * 10, x2 - 25, y2 + 10);// 绘制纵坐标
				g.drawLine(x2, y2, x2 + 1000, y2);// 绘制横线

			}
		}
		// 写入数据
		System.out.println("正在绘图");
		for (DataPoint p : ds) {
			// 设置几个点的横坐标
			int x = 100 + (int) (110 * p.getLogRank()) * 2;
			// 写入TF值，以蓝色圆点表示
			g.setColor(Color.BLUE);
			g.fillOval(x, (int) (800 - p.getTF() * 11), 15, 15);
			// 写入IDF值，以黄色圆点表示
			g.setColor(Color.yellow);
			g.fillOval(x, (int) (800 - p.getIDF() * 11), 15, 15);
			// 写入TF-IDF的值，以灰色圆点表示
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, (int) (800 - p.getIDF() * p.getTF() * 11), 15, 15);
		}
		System.out.println("绘制完毕");
		File Filename = new File("E:/rep.txt");
		if (!Filename.isFile())
			try {
				Filename.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			System.out.println("正在写入");
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(Filename));
			out.write("Log(Rank)  TF  IDF  TF-IDF\r\n");
			for (DataPoint p : ds) {
				out.write(p.getRank() + "  " + p.getTF() + "  " + p.getIDF() + "  " + p.getTF_IDF() + "\r\n");
			}
			System.out.println("写入完成");
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File temp = new File("E:/pic1.jpg");
		if (!temp.exists())
			temp.createNewFile();
		ImageIO.write(pic, "jpg", temp);
	}

	private static void InsertToDataBase(DataPoint[] ds) throws Exception {
		String dbUrl = "jdbc:mysql://localhost:3306/bookdb";
		String dbuser = "dbuser";
		String dbpsd = "1234";
		int count=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.getMessage();
		}
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = getConnection(dbUrl, dbuser, dbpsd);
		PreparedStatement prep = null;
		String insertStatement = "insert into WordInfo(WORD,TF,IDF,Rank,TF_IDF) values(?,?,?,?,?)";
		prep = con.prepareStatement(insertStatement);

		System.out.println("正在写入数据库：");
		for (DataPoint d : ds) {
			if(count!=9317){
			String word = d.getWord();
			if(d.getWord()==null)
				d.setWord("undefine");
			float TF = d.getTF();
			float IDF = d.getIDF();
			int Rank = d.getRank();
			float TF_IDF = d.getTF_IDF();
			prep.setString(1, word);
			prep.setFloat(2, TF);
			prep.setFloat(3, IDF);
			prep.setInt(4, Rank);
			prep.setFloat(5, TF_IDF);
			prep.executeUpdate();
			}
			count++;
		}
		prep.close();
		con.close();
		System.out.println("写入完成！");
	}

	public static Connection getConnection(String dbUrl, String dbuser, String dbpsd) throws Exception {
		return (Connection) java.sql.DriverManager.getConnection(dbUrl, dbuser, dbpsd);
	}

	public static String editNum(int n) {
		String num = Integer.toString(n);
		while (num.length() < 4) {
			num = "0" + num;
		}
		return num;

	}
}
