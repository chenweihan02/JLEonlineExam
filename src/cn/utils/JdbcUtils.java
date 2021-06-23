package cn.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author xiaochen
 * @create 2021-06-16 19:48
 */

public class JdbcUtils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");

    // 获取数据库连接池对象
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 从连接池中获取连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
