package database;

import java.sql.*;

public class MySqlDB {
    private static Connection connect = null;
    private static final String URL = "jdbc:mysql://localhost/fish_db";
    private static final String USER = "pawel";
    private static final String PASSWORD = "pawel123";

    private MySqlDB() {
    }

    public static Connection getConnection() {
        try {
            if (connect == null) {
                Class.forName("com.mysql.jdbc.Driver");
                connect = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.out.println("MySqlDB.getConnection() SQLException! " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("MySqlDB.getConnection() ClassNotFoundException! " + e);
        }
        return connect;
    }

    public static void close() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            System.out.println("MySqlDB.close() SQLException! " + e);
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println("ResultSet MySqlDB.close() exception! " + e);
        }
    }

    public static void close(Statement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (Exception e) {
            System.out.println("Statement MySqlDB.close() exception! " + e);
        }
    }

    public static void close(PreparedStatement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (Exception e) {
            System.out.println("PreparedStatement MySqlDB.close() exception! " + e);
        }
    }
}
