package book_list;
import mysql.mysql;
import juzheng.square;

/**
 * Created by lenovo on 2017/7/10.
 */
public class THE_MAIN {
    public static void main(String[] args){
        write_in_mysql n = new write_in_mysql();
        String a ="hello";
        finish f = new finish();
        f.DO("hello",2);
//        mysql MS = new mysql();
//        String[] test;
//        test=MS.get_list("select * from hello",2);
//        int row=test.length;
//        int col=test[0].split(",").length;
//
//
//
//        int[][] square_ = new int[row][col];
//
//        System.out.println(row);//////////////////////////////////////////////////////////////////////////////////////////
//
//        int row_in_for=0;
//        int col_in_for=0;
//        for(String tmp:test)
//        {
//            col_in_for=0;
//            String[] i = tmp.split(",");
//            for(String tmp_in:i)
//            {
//                int num =Integer.parseInt(tmp_in);
//                square_[row_in_for][col_in_for]=num;
//                col_in_for+=1;
//            }
//            row_in_for+=1;
//        }
//        square a = new square();
//        a.visualation(square_,"book");

//        System.out.print("\n");
//        for(String tmp:test)
//        {
//            System.out.println(tmp);
//        }
//        MS.operate("insert into test_grade(grade) values('5,4,2,3,1')");
//        MS.search_2("select * from test_grade",1,2);

    }

}
