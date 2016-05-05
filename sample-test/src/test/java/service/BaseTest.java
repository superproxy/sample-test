package service;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:dao/datasource-prod.xml",
        "classpath:dao/datasource-dev.xml",
        "classpath:dao/init-data.xml",
        "classpath:dao/dao.xml",
        "classpath:service/spring-service.xml",
        "classpath:cache/spring-cache.xml",
})
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

}
