package dao;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = {
        "classpath:dao/datasource.xml",
        "classpath:dao/init-data.xml",
        "classpath:dao/dao.xml",

})
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

}
