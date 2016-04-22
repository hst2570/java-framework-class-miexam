package kr.ac.jejunu.userdao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    @Test
    public void jejuget() throws SQLException, ClassNotFoundException {
        UserDao userDao = new JejuConnection();
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void hanllaget() throws SQLException, ClassNotFoundException {
        UserDao userDao = new HanllaConnection();
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void jejuadd() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "허윤호";
        String password = "1234";

        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new JejuConnection();

        Long id = userDao.add(user);
        User resultSet = userDao.get(id);

        assertEquals(id, resultSet.getId());
        assertEquals(name, resultSet.getName());
        assertEquals(password, resultSet.getPassword());
    }

    @Test
    public void hanllaadd() throws SQLException, ClassNotFoundException {
        User user = new User();

        String name = "허윤호";
        String password = "1234";

        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new HanllaConnection();

        Long id = userDao.add(user);
        User resultSet = userDao.get(id);

        assertEquals(id, resultSet.getId());
        assertEquals(name, resultSet.getName());
        assertEquals(password, resultSet.getPassword());
    }
}
