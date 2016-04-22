package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private ConnectionMaker connectionMaker;

    public void setConnectionMaker(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();

        MakeStrategyStatement getStrategyStatement = new getStrategyStatement(id);
        PreparedStatement preparedStatement = getStrategyStatement.StrategyStatement(connection);
        ResultSet resultSet = null;
        User user = null;

        getStrategyStatementBody(connection, user, preparedStatement, resultSet);

        return user;
    }

    public Long add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();

        MakeStrategyStatement addStrategyStatement = new addStrategyStatement(user);
        PreparedStatement preparedStatement = addStrategyStatement.StrategyStatement(connection);

        Long id = null;

        addStrategyStatementBody(connection, id, preparedStatement);
        return id;
    }

    public void delete(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        MakeStrategyStatement deleteStrategyStatement = new deleteStrategyStatement(id);
        PreparedStatement preparedStatement = deleteStrategyStatement.StrategyStatement(connection);

        updateStategyStatementBody(connection, preparedStatement);
    }

    public void update(User user) throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        MakeStrategyStatement updateStrategyStatement = new updateStrategyStatement(user);
        PreparedStatement preparedStatement = updateStrategyStatement.StrategyStatement(connection);

        updateStategyStatementBody(connection, preparedStatement);
    }

    public void getStrategyStatementBody(Connection connection, User user, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        try {
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = new User();

            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
    }

    public void addStrategyStatementBody(Connection connection, Long id, PreparedStatement preparedStatement) throws SQLException {
        try {
            preparedStatement.executeUpdate();
            id = getLastInsertId(connection);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            preparedStatement.close();
            connection.close();
        }
    }

    private void updateStategyStatementBody(Connection connection, PreparedStatement preparedStatement) throws SQLException {
        try {
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            preparedStatement.close();
            connection.close();
        }
    }

    private Long getLastInsertId(Connection connection) throws ClassNotFoundException, SQLException{
        PreparedStatement preparedStatement2 = connection.prepareStatement("select last_insert_id()");

        ResultSet resultSet = preparedStatement2.executeQuery();
        resultSet.next();

        Long id = resultSet.getLong(1);

        resultSet.close();
        preparedStatement2.close();
        return id;
    }
}
