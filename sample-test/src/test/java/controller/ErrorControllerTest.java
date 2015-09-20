package controller;

import org.springframework.mock.web.MockHttpServletRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class ErrorControllerTest extends BaseContorllerTest {

    @Resource
    private ErrorController errorController;


    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testError() throws Exception {
        request = new MockHttpServletRequest();
        errorController.error(request);
    }
}