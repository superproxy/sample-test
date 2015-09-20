package controller;

import com.github.superproxy.testdataprovider.entry.testng.CommonDataProvider;
import com.github.superproxy.testdataprovider.support.csv.Csv;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.testng.Assert.assertEquals;


@Test
public class LoginControllerTest extends BaseContorllerTest {

    @Resource
    LoginController loginController;

    private MockMvc mockMvc;

    @BeforeMethod()
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }


    @Test
    public void testLogon() throws Exception {

        String userName = "admin";
        String password = "admin";
        String answer = "pwd";
        assertEquals(loginController.logon(userName, password, answer, request, response, null), "index");

        // 规则1   没有校验码
        answer = "";
        userName = "";
        password = "";
        assertEquals(loginController.logon(userName, password, answer, request, response, null), "login");

        //  规则2  没有用户名
        answer = "answer";
        userName = "";
        password = "";
        assertEquals(loginController.logon(userName, password, answer, request, response, null), "login");

        // 规则3   用户名不存在
        answer = "pwd";
        userName = "admin2";
        password = "";
        assertEquals(loginController.logon(userName, password, answer, request, response, null), "login");

        // 规则4   没有密码
        answer = "answer";
        userName = "admin";
        password = "";
        assertEquals(loginController.logon(userName, password, answer, request, response, null), "login");

        // 规则5    密码不对
        answer = "pwd";
        userName = "admin";
        password = "admin2";
        assertEquals(loginController.logon(userName, password, answer, request, response, null), "login");
    }

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Csv("/controller/LoginController/testLogin.csv")
    public void testLogin(String userName, String password, String answer, String expected) throws Exception {
        assertEquals(loginController.logon(userName, password, answer, request, response, null), expected);
    }

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Csv("/controller/LoginController/testLogin.csv")
    public void testLoginByModelAssert(String userName, String password, String answer, String expected) throws Exception {
        ModelMap modelMap = new ExtendedModelMap();
        String result = loginController.logon(userName, password, answer, request, response, modelMap);
        ModelAndView modelAndView = new ModelAndView(result, modelMap);
        ModelAndViewAssert.assertViewName(modelAndView, expected);
    }

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Csv("/controller/LoginController/testLogin.csv")
    public void testLoginByMockMvc(String userName, String password, String answer, String expected) throws Exception {
        MvcResult result = mockMvc.perform(post("/logon")
                .param("userName", userName).param("password", password).param("validate", answer)).andReturn();
        ModelAndView modelAndView = result.getModelAndView();
        ModelAndViewAssert.assertViewName(modelAndView, expected);

    }
}