package framework;

import com.alibaba.fastjson.JSON;
import framework.cvs.Csv;
import framework.json.Json;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertNotNull;

public class CommonDataProviderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDataProviderTest.class);

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Json
    @Path("src\\test\\resources\\controller\\LoginController\\2.json")
    public void test1(User user, User user1, int expected) {
        LOGGER.debug("user:{}, User1:{}", user, user1);
        assertNotNull(user);
        assertNotNull(user1);
        assertNotNull(expected);
    }

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Json
    @Path("src\\test\\resources\\controller\\LoginController\\3.json")
    public void test3(User user, int real) {
        assertNotNull(user);
        assertNotNull(real);
    }


    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Csv
    @Path("src\\test\\resources\\controller\\LoginController\\2.csv")
    public void test4(String userName, String password, String expected) {
             assertNotNull(userName);
             assertNotNull(password);
             assertNotNull(expected);
    }


    @Test
    public void test() {
        User user = new User("yxz", "yxz", 9);
        String s = JSON.toJSONString(user);
        LOGGER.debug("{}", s);
        Object object = JSON.parse(s);  //  hash
        // {"input":{"age":9,"name":"yxz","password":"yxz","rank":0}, "expected":{"1"}}


        Input input = new Input();
        input.setExpected(0);
        input.setUser(user);
        input.setUser1(user);
        s = JSON.toJSONString(input);


        LOGGER.debug("{}", s);
        s = "{\"expected\":0,\"user\":{\"age\":9,\"name\":\"yxz\",\"password\":\"yxz\",\"rank\":0},\"user1\":{\"age\":9,\"name\":\"yxz\",\"password\":\"yxz\",\"rank\":0}";
        List<Object> list = JSON.parseArray(s, new Type[]{User.class, User.class, int.class});
    }
}