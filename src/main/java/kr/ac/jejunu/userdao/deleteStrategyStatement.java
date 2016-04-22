package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by user on 2016-04-22.
 */
public class deleteStrategyStatement implements MakeStrategyStatement {
    private Long id;
    public deleteStrategyStatement(Long id){
        this.id = id;
    }

    @Override
    public PreparedStatement StrategyStatement(Connection connection) throws SQLException {
        String sql = "Delete from userinfo where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        return  preparedStatement;
    }
}
