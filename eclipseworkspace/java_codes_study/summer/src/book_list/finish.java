package book_list;

import juzheng.square;
import mysql.mysql;

/**
 * Created by lenovo on 2017/7/10.
 */

//finsh输入数据库表格名称，和数据所在的列数，可将数据排成矩阵，进行矩阵和转置矩阵的乘法，将结果表示出来，没有return
public class finish {
    public void DO(String sql,int j)
    {
        mysql MS = new mysql();
        String[] test;
        String sql1 ="select * from "+sql;
        test=MS.get_list(sql1,j);
        int row=test.length;
        int col=test[0].split(",").length;
        int[][] square_ = new int[row][col];
        int row_in_for=0;
        int col_in_for=0;
        for(String tmp:test)
        {
            col_in_for=0;
            String[] i = tmp.split(",");
            for(String tmp_in:i)
            {
                int num =Integer.parseInt(tmp_in);
                square_[row_in_for][col_in_for]=num;
                col_in_for+=1;
            }
            row_in_for+=1;
        }
        square a = new square();
        a.visualation(square_,"book");
    }
}
