package framework;

import com.alibaba.fastjson.JSON;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class CommonDataProviderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDataProviderTest.class);

    @Test(dataProvider = "testData", dataProviderClass = CommonDataProvider.class)
    @Json
    @Path("E:\\projects\\testng-test\\src\\test\\resources\\controller\\LoginController\\2.json")
    public void test2(User user, User user1, int expected) {
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
    }
}