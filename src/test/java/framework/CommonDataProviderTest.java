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
}