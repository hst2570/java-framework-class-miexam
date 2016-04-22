package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by user on 2016-04-22.
 */
public class getStrategyStatement implements MakeStrategyStatement {
    private Long id;
    public getStrategyStatement(Long id){
        this.id = id;
    }

    @Override
    public PreparedStatement StrategyStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id = ?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }
}
