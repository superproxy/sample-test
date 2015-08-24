package service;

import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class UserServiceImplTest {

    private UserService userService;

    @BeforeMethod
    public void setUp() throws Exception {
        userService = new UserServiceImpl();
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        assertTrue(userService.addUser(user));
    }

    @Test
    public void testCalRank() throws Exception {
        User user = new User();
        user.setAge(10);
        assertEquals(userService.calRank(user), 1);
//        assertEquals(userService.calRank(user), 0);
    }
}