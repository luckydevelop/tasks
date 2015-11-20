
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lucky on 26.06.2015.
 */
public class JDBC
{
    static Statement stmt = null;
    static ResultSet rs = null;
    static Connection con = null;
    static String url = "jdbc:mysql://localhost:3306/parsing";
    static HashMap<String, String> map = new HashMap<String, String>();

    public static Connection connect()
    {
        try
        {
          Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        try
        {
            con = DriverManager.getConnection(url, "admin", "admin");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return con;
    }


    public static void main(String[] args)
    {
        JDBC jdbc = new JDBC();
        HashMap<String, String> map1 = jdbc.executeQuery();
        for (Map.Entry<String, String> pair : map1.entrySet())
        {
            System.out.println(pair.getKey() +" "+ pair.getValue());
        }

    }

    public static HashMap<String, String> executeQuery()
    {
        try
        {
            con = connect();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM snpch");
            while (rs.next())
            {
                map.put(rs.getString("tm"), rs.getString("goods"));
               // System.out.println(rs.getString("tm") + rs.getString("goods"));
            }
        } catch (Exception e)
        {
            System.out.println("SQLException");
            e.printStackTrace();
        }

        closeQuery();

        return map;
    }

    public static void execute(String tableValue)
    {
        try
        {
            con = connect();
           // PreparedStatement pstmt  = con.prepareStatement("DELETE FROM snpch WHERE tm=?") ;
            stmt = con.createStatement();

            stmt.execute(tableValue);

        } catch (Exception e)

        {
            System.out.println("SQLException");
            e.printStackTrace();
        }

        closeQuery();

    }


    static void closeQuery()
    {
        try
        {
            con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
