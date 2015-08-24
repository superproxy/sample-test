package controller;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ModelMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.assertNotNull;


@Test
public class LoginControllerTest extends BaseTest {

    @Resource
    LoginController loginController;

    MockHttpServletRequest request;
    MockHttpServletResponse response;

    @BeforeMethod
    public void beforeMethod() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }


    /**
     * 模拟数据，桩
     *
     * @throws Exception
     */

    @Test
    public void testLogon() throws Exception {
        String userName = "admin";
        String password = "admin";
        String answer = "";
        String target = "";
        ModelMap model = new ModelMap();
        assertNotNull(loginController.logon(userName, password, answer, target, request, response, model));
    }
}