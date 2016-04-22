package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by user on 2016-04-22.
 */
public class JejuConnection extends UserDao{

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://db.skyserv.kr/jejunu?characterEncoding=utf-8", "jeju", "jejupw");

        return connection;
    }
}
