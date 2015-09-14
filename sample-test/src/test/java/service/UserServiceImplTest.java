package service;

import com.github.superproxy.dataprovider.entry.testng.CommonDataProvider;
import com.github.superproxy.dataprovider.support.csv.Csv;
import model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import service.user.UserService;

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

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Csv("src/test/resources/service/UserService/testCalRank.csv")
    public void testCalRank(String age, int expected) throws Exception {
        User user = new User();
        user.setAge(Integer.parseInt(age));
        assertEquals(userService.calRank(user), expected);
    }


}