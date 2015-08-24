package service;

import dao.UserMapper;
import model.User;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;

/**
 * 测试 UserService的内部逻辑，
 * 依赖dao部分使用mock对象
 */
@Test
//@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplWithMockTest extends MockBaseTest {

    @Resource
    private UserService userService;

    /**
     * mock userMapper桩，为userService提供服务
     */
    @Resource
    private UserMapper userMapper;

    @Test
    public void testLogin() throws Exception {
        String userName = "";
        String password = "";
        // 创建对象
        User user = new User(5, "yxz");
        when(userMapper.getUser(userName, password)).thenReturn(user);
        User result = userService.login(userName, password);
        System.out.println(result);
        assertNotNull(result);
    }
}