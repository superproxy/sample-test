package service;

import dao.user.UserMapper;
import model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import service.user.UserService;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;

/**
 * 测试 UserService的内部逻辑，
 * 依赖dao部分使用mock对象
 */
@Test
public class UserServiceImplWithMockTest extends MockBaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplWithMockTest.class);

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

        User user = new User(5, "yxz");
        //mock
        when(userMapper.query(userName, password)).thenReturn(user);
        // 模拟调用
        User result = userService.queryUser(userName, password);
        LOGGER.debug("{}", result.toString());
        assertNotNull(result);
    }
}