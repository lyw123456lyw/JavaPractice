package database;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class MySqlConnection {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        try{
//        //1.加载驱动
//         Class.forName("com.mysql.jdbc.Driver");
//        //2.得到连接
//        DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlpractice2","root","admin123");
//        //3.创建PreparedStatement对象
//        conn.prepareStatement("select * from department where id = ?;");
//        //4.为预编译的参数设置值
//        ps.setInt(1,10001);
//
//        rs = ps.executeQuery();
//        while (rs.next()){
//            System.out.println(rs.getObject(1));
//        }
//        rs.close();
//        ps.close();
//        conn.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
             conn = DBUtils.getConnection();
             ps = conn.prepareStatement("select * from department where id in (?,?) ");
             ps.setInt(1,10001);
            ps.setInt(2,10002);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(conn,ps,rs);
        }

    }
}
