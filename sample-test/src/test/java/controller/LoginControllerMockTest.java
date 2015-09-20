package controller;

import org.springframework.ui.ExtendedModelMap;
import org.testng.annotations.Test;
import service.user.UserService;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;


@Test
public class LoginControllerMockTest extends BaseContorllerMockTest {

    @Resource
    private LoginController loginController;

    @Resource
    private UserService userService;

    /**
     * 模拟数据，桩
     *
     * @throws Exception
     */

    @Test
    public void testLogon() throws Exception {
        // service异常情况
        String userName = "admin";
        String password = "admin";
        String answer = "pwd";
        when(userService.queryUser(userName, password)).thenThrow(new RuntimeException("dao access error"));
        assertEquals(loginController.logon(userName, password, answer, request, response, new ExtendedModelMap()), "error");
    }
}