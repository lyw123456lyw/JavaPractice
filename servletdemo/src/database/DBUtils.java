package database;

import java.sql.*;

public class DBUtils {
    public static String URL = "jdbc:mysql://localhost:3306/sqlpractice2";
    public static String USER = "root";
    public static String PASSWORD = "admin123";
    public static String DRIVERCLASS = "com.mysql.jdbc.Driver";
    static {
        try{
            Class.forName(DRIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    /**
     * 关闭资源
     * @param conn
     * @param statement
     * @param resultSet
     */
    public static void closeAll(Connection conn, Statement statement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
