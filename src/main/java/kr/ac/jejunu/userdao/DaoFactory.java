package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;

/**
 * Created by user on 2016-04-22.
 */
public class DaoFactory {

    @Bean
    public UserDao getUserDao(){
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new SimpleConnectionMaker();
    }
}
