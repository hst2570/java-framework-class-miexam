package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by user on 2016-04-22.
 */
public interface MakeStrategyStatement {
    public PreparedStatement StrategyStatement(Connection connection) throws SQLException;
}
