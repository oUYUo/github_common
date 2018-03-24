/**
 * Created by lenovo on 2017/7/10.
 */
import mysql.mysql;
import java.util.Random;
import book_list.finish;
import juzheng.square;
public class test {
    public static void main(String[] args) {
        Random a = new Random();
        int b = a.nextInt(5);
//        System.out.print(b);
        mysql c = new mysql();
        square sq = new square();
        int[][] li = new int[][]{{5, 4, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, {1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 4, 5}};
//        sq.visualation(li, "book");
        finish fi = new finish();
        fi.DO("hello",2);
    }


//        c.search_1("select * from test_grade",2);
//        int[][] cc= new int[1000][1000];
//        mysql cc= new mysql();
//        for(int i=65535;i<65536;i++)
//        {
//            cc.operate("delete from test_grade where id ="+String.valueOf(i));
//            System.out.println(i);
//        }
//
//
//    }


}

