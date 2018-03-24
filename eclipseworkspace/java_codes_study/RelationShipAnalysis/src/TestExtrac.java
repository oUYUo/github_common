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
		String FileDir = "E:/data";//��ȡ����Դ�ļ�
		Infodispatcher info = new Infodispatcher(new File(FileDir));//������Ϣ�ַ��࣬�����ݼ����д���
		info.StartToDealing();//��ʼ�����ݽ��д���
		System.out.println("End");//���ݴ�����ϱ�־
		IndexWord[] indexterms = info.getindexterms();//�����ĵ������дʻ������
		DataPoint[] datas = new DataPoint[indexterms.length];//�����ݳ���ΪDataPiont��
		int count = 0;

		IndexWord temp;
		for (int i = indexterms.length; i > 0; i--) {//�����ݳ���Ϊ�㣬���ݵ�����ʻ㣬��IDF��TFֵ
			for (int j = 0; j < i - 1; j++) {
				if (indexterms[j].getTF() < indexterms[j + 1].getTF()) {
					temp = indexterms[j];
					indexterms[j] = indexterms[j + 1];
					indexterms[j + 1] = temp;
				}
			}
		}
		indexterms[0].setRank(1);
		for (int i = 1; i < indexterms.length; i++) {//�����е������������TF��������
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
		System.out.println("abstract is over,start to draw Picture");//��ʾ���ݵĳ��󻯽�������ʼ��ͼ
		
		 Draw(datas);//���û�ͼ�������л�ͼ
		InsertToDataBase(datas);//���ò��뺯�������������ݲ���mysql���ݿ�

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
		g.drawString("O", x1 - 20, y1 + 25);// ����Բ��
		g.drawString("Value", x1 - 35, 75);// ����y���־
		g.drawString("Log(Rank)", 1130, y1 + 25);// ����x���־
		g.setFont(new Font("Courier", Font.ITALIC, 35));
		g.setColor(Color.BLUE);// ��־TF
		g.fillOval(1160, 150, 15, 15);
		g.drawString("TF", 1200, 165);
		g.setColor(Color.yellow);// ��־IDF
		g.fillOval(1160, 190, 15, 15);
		g.drawString("IDF", 1200, 205);
		g.setColor(Color.darkGray);// ��־TF-IDF
		g.fillOval(1160, 230, 15, 15);
		g.drawString("TF-IDF", 1200, 245);
		g.setFont(font);
		g.setColor(Color.GRAY);
		// ���Ʊ��
		g.drawLine(x1, y1, x1, y1 - 700);// ����y��
		g.drawLine(x1, y1, x1 + 1000, y1);// ����x��
		for (int i = 0; i < 10; i++) {
			x1 += 100;
			y2 -= 100;
			g.drawLine(x1, y1, x1, y1 - 700);// ��������
			g.drawString("" + (((double) i / 2) + 0.5), x1 - 5, y1 + 30);// ���ƺ�����
			if (i < 7) {
				g.drawString("" + (i + 1) * 10, x2 - 25, y2 + 10);// ����������
				g.drawLine(x2, y2, x2 + 1000, y2);// ���ƺ���

			}
		}
		// д������
		System.out.println("���ڻ�ͼ");
		for (DataPoint p : ds) {
			// ���ü�����ĺ�����
			int x = 100 + (int) (110 * p.getLogRank()) * 2;
			// д��TFֵ������ɫԲ���ʾ
			g.setColor(Color.BLUE);
			g.fillOval(x, (int) (800 - p.getTF() * 11), 15, 15);
			// д��IDFֵ���Ի�ɫԲ���ʾ
			g.setColor(Color.yellow);
			g.fillOval(x, (int) (800 - p.getIDF() * 11), 15, 15);
			// д��TF-IDF��ֵ���Ի�ɫԲ���ʾ
			g.setColor(Color.DARK_GRAY);
			g.fillOval(x, (int) (800 - p.getIDF() * p.getTF() * 11), 15, 15);
		}
		System.out.println("�������");
		File Filename = new File("E:/rep.txt");
		if (!Filename.isFile())
			try {
				Filename.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			System.out.println("����д��");
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(Filename));
			out.write("Log(Rank)  TF  IDF  TF-IDF\r\n");
			for (DataPoint p : ds) {
				out.write(p.getRank() + "  " + p.getTF() + "  " + p.getIDF() + "  " + p.getTF_IDF() + "\r\n");
			}
			System.out.println("д�����");
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

		System.out.println("����д�����ݿ⣺");
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
		System.out.println("д����ɣ�");
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
