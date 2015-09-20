package controller;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

import java.util.Hashtable;
import java.util.Map;

@ContextConfiguration(locations = {
        "classpath:dao/datasource.xml",
        "classpath:dao/init-data.xml",
        "classpath:dao/dao.xml",
        "classpath:service/spring-service.xml",
        "classpath:dispatcher-servlet.xml",
})
public abstract class BaseContorllerTest extends AbstractTestNGSpringContextTests {

    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;

    protected Map<Object, Object> sessionMap;
    protected MockHttpSession session;

    @BeforeMethod
    public void beforeMethod() {
        request = mockRequest();
        response = mockResponse() ;
        sessionMap = new Hashtable<Object, Object>();
        session = mockSession();
        request.setSession(session);
    }

    protected MockHttpServletRequest mockRequest() {
        return new MockHttpServletRequest();
    }

    protected MockHttpServletResponse mockResponse() {
        return new MockHttpServletResponse();
    }

    protected MockHttpSession mockSession() {
        return new MockHttpSession();
    }
}
