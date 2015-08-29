package framework;

import framework.support.csv.Csv;
import framework.support.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

@Test
public class CommonDataProviderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDataProviderTest.class);

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Json
    @Path("src/test/resources/framework/3.json")
    public void test3(TestModel user, int real) {
        assertNotNull(user);
        assertNotNull(real);
    }

    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Json
    @Path("src/test/resources/framework/2.json")
    public void test1(TestModel user, TestModel user1, int expected) {
        LOGGER.debug("user:{}, user1:{}", user, user1);
        assertNotNull(user);
        assertNotNull(user1);
        assertNotNull(expected);
    }


    @Test(dataProvider = "genData", dataProviderClass = CommonDataProvider.class)
    @Csv("src/test/resources/framework/2.csv")
    @Path("src/test/resources/framework/2.csv")
    public void test4(String userName, String password, String expected) {
        assertNotNull(userName);
        assertNotNull(password);
        assertNotNull(expected);
    }
}