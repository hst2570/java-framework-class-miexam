package kr.ac.jejunu.userdao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private UserDao userDao;
    @Before
    public void setup(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        userDao = (UserDao) annotationConfigApplicationContext.getBean("getUserDao");
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {

        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "허윤호";
        String password = "1234";

        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);
        User resultSet = userDao.get(id);

        assertEquals(id, resultSet.getId());
        assertEquals(name, resultSet.getName());
        assertEquals(password, resultSet.getPassword());
    }
}
