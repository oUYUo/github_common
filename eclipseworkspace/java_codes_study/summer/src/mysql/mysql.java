package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//		a.search_1("select * from tb", 1);
//		a.operate("update tb1 set username = 'fuck_you' where id =9");
//		a.operate("delete from tb1 where id =9");
//		a.insert_("insert into test_book(reader_name,books,grade) values('fuck_you','{python}','{4,3,5}')");

public class mysql {
	private String url="jdbc:mysql://127.0.0.1:3306/test";
	private String username="root";
	private String passward="sz869993410";
	Connection con =null;
	Statement stmt =null;
	ResultSet rs   =null;
	
	public mysql()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,passward);
//			System.out.println(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

    public String[] get_list(String sql,int i)
    {

        int lon =0;
        try {
            stmt=con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while(rs.next())
            {
                String str  = rs.getString(i);
//                System.out.print(str+'\n');
                lon+=1;
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] arr=new String[lon];
        int j =0;
        try {
            stmt=con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while(rs.next())
            {
                String str  = rs.getString(i);
                arr[j]=str;
                j+=1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.print("lon=");
//        System.out.print(lon);
//        System.out.print("\n");
//        System.out.print("j=");
//        System.out.print(j);
        return arr;

    }

	public void search_1(String sql,int i)
	{
		
		try {
			stmt=con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
					String str  = rs.getString(i);
					System.out.print(str+'\n');				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void search_2(String sql,int i,int j)
	{
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String str  = rs.getString(i);
				String str2 = rs.getString(j);
				System.out.printf("%20s%20s",str,str2);
				System.out.println("");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void search_3(String sql,int i,int j,int k)
	{
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String str  = rs.getString(i);
				String str2 = rs.getString(j);
				String str3 = rs.getString(k);
				System.out.printf("%20s%20s%20s",str,str2,str3);
				System.out.println("");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void search_4(String sql,int i,int j,int k,int l)
	{
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String str  = rs.getString(i);
				String str2 = rs.getString(j);
				String str3 = rs.getString(k);
				String str4 = rs.getString(l);
				System.out.printf("%20s%20s%20s%20s",str,str2,str3,str4);
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void operate(String sql)
	{
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
