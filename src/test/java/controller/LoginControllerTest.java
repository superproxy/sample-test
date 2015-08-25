package controller;

import org.springframework.ui.ModelMap;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotNull;


@Test
public class LoginControllerTest extends ContorllerBaseTest {

    @Resource
    LoginController loginController;

    /**
     * 模拟数据，桩
     *
     * @throws Exception
     */

    @Test
    public void testLogon() throws Exception {
        //  设计良好的测试用例，测试各种情况，表格来说明相关的输入和对应的输出
        List<String[]> testData = new ArrayList<String[]>();

//        构造json串，动态构建内容
//        testData.add(new String["", "", "", "", ]);
        // 类似spring的机制，构建Model
        String userName = "admin";
        String password = "admin";
        String answer = "";
        String target = "";
        ModelMap model = new ModelMap();
        assertNotNull(loginController.logon(userName, password, answer, target, request, response, model));

        //  规则1
//        String userName = "admin";
//        String password = "admin";
//        String answer = "";
//        String target = "";
//        ModelMap model = new ModelMap();
        assertNotNull(loginController.logon(userName, password, answer, target, request, response, model));

        // 规则2
//        String userName = "admin";
//        String password = "admin";
//        String answer = "";
//        String target = "";
//        ModelMap model = new ModelMap();
        assertNotNull(loginController.logon(userName, password, answer, target, request, response, model));

        // 规则3
    }
}