package service;

import model.User;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.*;

/**
 * 测试 UserService的内部逻辑，
 * 依赖dao部分使用mock对象
 */
@Test
public class UserServiceImplTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void testLogin() throws Exception {
        String userName = "";
        String password = "";
        assertNotNull(userService.queryUser(userName, password));
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        assertTrue(userService.addUser(user));
    }

    @Test
    public void testCalRank() throws Exception {
        User user = new User();
        user.setAge(9);
        assertEquals(userService.calRank(user), 0);
        user.setAge(10);
        assertEquals(userService.calRank(user), 1);
        user.setAge(20);
        assertEquals(userService.calRank(user), 2);
        user.setAge(30);
        assertEquals(userService.calRank(user), 3);

        //设计测试样例
        user.setAge(100);
        assertEquals(userService.calRank(user), 3);
    }
}