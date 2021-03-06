package kr.ac.jejunu.userdao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private UserDao userDao;
    @Before
    public void setup(){
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = (UserDao) applicationContext.getBean("userDao");
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

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "허윤호";
        String password = "1234";

        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);

        userDao.delete(id);

        User resultUser = userDao.get(id);

        assertThat(resultUser, nullValue());
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "허윤호";
        String password = "1234";

        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);

        name = "헐크";
        password = "2222";
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        userDao.update(user);

        User resultUser = userDao.get(id);

        assertThat(name, is(resultUser.getName()));
    }
}
