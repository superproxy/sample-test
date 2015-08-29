package controller;

import framework.CommonDataProvider;
import framework.support.csv.Csv;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.assertEquals;


@Test
public class LoginControllerTest extends BaseContorllerTest {

    @Resource
    LoginController loginController;

    /**
     * 模拟数据，桩
     * <p/>
     * //  设计良好的测试用例，测试各种情况，表格来说明相关的输入和对应的输出
     * List<String[]> genData = new ArrayList<String[]>();
     * <p/>
     * //        构造json串，动态构建内容
     * //        genData.add(new String["", "", "", "", ]);
     * // 类似spring的机制，构建Model
     *
     * @throws Exception
     */

    @Test
    public void testLogon() throws Exception {

        String userName = "admin";
        String password = "admin";
        String answer = "pwd";
        assertEquals(loginController.logon(userName, password, answer, request, response), "index");

        // 规则1   没有校验码
        answer = "";
        userName = "";
        password = "";
        assertEquals(loginController.logon(userName, password, answer, request, response), "login");

        //  规则2  没有用户名
        answer = "answer";
        userName = "";
        password = "";
        assertEquals(loginController.logon(userName, password, answer, request, response), "login");

        // 规则3   用户名不存在
        answer = "pwd";
        userName = "admin2";
        password = "";
        assertEquals(loginController.logon(userName, password, answer, request, response), "login");

        // 规则4   没有密码
        answer = "answer";
        userName = "admin";
        password = "";
        assertEquals(loginController.logon(userName, password, answer, request, response), "login");

        // 规则5    密码不对
        answer = "pwd";
        userName = "admin";
        password = "admin2";
        assertEquals(loginController.logon(userName, password, answer, request, response), "login");
    }

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Csv("src/test/resources/controller/LoginController/testLogin.csv")
    public void testLogin(String userName, String password, String answer, String expected) throws Exception {
        assertEquals(loginController.logon(userName, password, answer, request, response), expected);
    }
}