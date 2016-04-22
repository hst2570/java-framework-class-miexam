package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by user on 2016-04-22.
 */
public class updateStrategyStatement implements MakeStrategyStatement {
    private User user;
    public updateStrategyStatement(User user){
        this.user = user;
    }

    @Override
    public PreparedStatement StrategyStatement(Connection connection) throws SQLException {
        String sql = "update userinfo set name = ?, password = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setLong(3, user.getId());
        return preparedStatement;
    }
}
