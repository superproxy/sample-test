package dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:dao/datasource-prod.xml",
        "classpath:dao/datasource-dev.xml",
        "classpath:dao/init-data.xml",
        "classpath:dao/dao.xml",
})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public abstract class BaseDaoTest extends AbstractTestNGSpringContextTests {

}
