package service;

import com.alibaba.fastjson.JSON;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * 测试 UserService的内部逻辑，
 * 依赖dao部分使用mock对象
 */
@Test
public class UserServiceImplTest extends BaseTest {

    @Resource
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplTest.class);

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

    @Test(dataProvider = "testCalRank2Data")
    public void testCalRank2(User user, int expected) throws Exception {
        LOGGER.debug("user:{}, expected:{}", user, expected);
        assertEquals(userService.calRank(user), expected);


    }

    @Test(dataProvider = "testCalRank3Json", dataProviderClass = UserServiceImplTest.class)
    public void testCalRank3(User user, int expected) throws Exception {
        LOGGER.debug("user:{}, expected:{}", user, expected);
        assertEquals(userService.calRank(user), expected);
    }



    @DataProvider(name = "testCalRank2Data")
    public Object[][] testCalRank2Data(Method method) {
        LOGGER.debug("{}", method.getName());
        List<Object[]> objectList = new ArrayList<Object[]>();
        User user = new User("yxz", "yxz", 9);
        int expected = 0;
        objectList.add(new Object[]{user, expected});
        user = new User("yxz", "yxz", 10);
        expected = 1;
        objectList.add(new Object[]{user, expected});

        user = new User("yxz", "yxz", 20);
        expected = 2;
        objectList.add(new Object[]{user, expected});

        user = new User("yxz", "yxz", 30);
        expected = 3;
        objectList.add(new Object[]{user, expected});

        user = new User("yxz", "yxz", 2);
        expected = 3;
        objectList.add(new Object[]{user, expected});

        return objectList.toArray(new Object[0][0]);
    }
}