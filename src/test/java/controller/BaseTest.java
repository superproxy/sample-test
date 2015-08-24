package controller;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = {
        "classpath:dao/datasource.xml",
        "classpath:dao/init-data.xml",
        "classpath:dao/dao.xml",
        "classpath:service/spring-service.xml",
        "classpath:dispatcher-servlet.xml",
})
public abstract class BaseTest extends AbstractTestNGSpringContextTests {
}
