package book_list;
import mysql.mysql;

import java.util.Random;

/**
 * Created by lenovo on 2017/7/10.
 */
//将随机数输入进数据库
public class write_in_mysql {
    public void write(int num) {
        int i = 0;
        mysql a = new mysql();
        Random first = new Random();
        Random second = new Random();
        Random third = new Random();
        Random forth = new Random();
        Random fifth = new Random();
        while (i < num) {
            int a_1 = first.nextInt(6);
            int a_2 = second.nextInt(6);
            int a_3 = third.nextInt(6);
            int a_4 = forth.nextInt(6);
            int a_5 = fifth.nextInt(6);
            String a__1 = String.valueOf(a_1);
            String a__2 = String.valueOf(a_2);
            String a__3 = String.valueOf(a_3);
            String a__4 = String.valueOf(a_4);
            String a__5 = String.valueOf(a_5);
            String sql = "insert into hello(grade) values('" + a__1 + "," + a__2 + "," + a__3 + "," + a__4 + "," + a__5 + "'" + ")";
            System.out.println(sql);
            a.operate(sql);
            i += 1;
        }
    }
}


