package dao.user;

import dao.BaseDaoTest;
import model.user.User;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.*;

public class UserMapperTest extends BaseDaoTest {


    @Resource
    private UserMapper userMapper;


    @Test(expectedExceptions = Exception.class)
    public void test() {
        userMapper.create(new User("admin", "admin", 1));
    }

    @Test
    @Transactional
    public void testUpdate() throws Exception {
        User user = userMapper.queryByUserName("admin");
        user.setAge(99);
        assertEquals(userMapper.update(user), 1);
    }


    @Test
    public void testGetUser() throws Exception {
        assertNotNull(userMapper.query("admin", "admin"));
    }

    @Test
    public void testCreate() throws Exception {
        User user = new User("yxz", "yxz", 1);
        assertEquals(userMapper.create(user), 1);
    }

    @Test
    public void testQuery() throws Exception {
        User user = new User("yxz", "yxz", 1);
        assertEquals(userMapper.create(user), 1);
        assertNotNull(userMapper.query("yxz", "yxz"));
        assertEquals(userMapper.delete("yxz"), 1);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetAllUsers() throws Exception {
        assertTrue(userMapper.getAllUsers().size() == 2);
    }


    @Test(dependsOnMethods = "testCreate")
    public void testDelete() throws Exception {
        assertEquals(userMapper.delete("yxz"), 1);
    }


}