package service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@ContextConfiguration(locations = {"classpath:service/spring-service.xml", "classpath:dao/mockdao.xml"})
public abstract class MockBaseTest extends AbstractTestNGSpringContextTests {
}
