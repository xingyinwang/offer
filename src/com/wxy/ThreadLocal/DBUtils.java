package com.wxy.ThreadLocal;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Cser_W on 2018/5/9.
 */
public class DBUtils {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static final String user = "root";
    private static final String password = "root";
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    public static Connection getConnection() {
        Connection connection = connectionThreadLocal.get();
        try {
            Class.forName(driver);
              connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionThreadLocal.set(connection);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            Connection connection = connectionThreadLocal.get();
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionThreadLocal.remove();
        }
    }
}
