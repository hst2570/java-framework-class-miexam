package kr.ac.jejunu.userdao;

/**
 * Created by user on 2016-04-22.
 */
public class DaoFactory {

    public UserDao getUserDao(){
        return new UserDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker(){
        return new SimpleConnectionMaker();
    }
}
