package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by user on 2016-04-22.
 */
public class addStrategyStatement implements MakeStrategyStatement {
    private User user;
    public addStrategyStatement(User user){
        this.user = user;
    }

    @Override
    public PreparedStatement StrategyStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo (name, password) values (?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());

        return preparedStatement;
    }
}
