package controller;

import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Test
public class SimpleControllerTest extends BaseContorllerTest {

    @Resource
    SimpleController simpleController;
    private MockMvc mockMvc;

    @BeforeMethod
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(simpleController).build();

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testTestModelAndView() throws Exception {

    }

    @Test
    public void testTestVoid() throws Exception {
        MvcResult result = mockMvc.perform(get("/testVoid")).andReturn();
        MockHttpServletResponse mockHttpServletResponse = result.getResponse();
        String s = mockHttpServletResponse.getContentAsString();
        Assert.assertEquals(s, "hello");

    }

    @Test
    public void testTestHello() throws Exception {
        //  走controller逻辑，spring自动构造参数
        MvcResult result = mockMvc.perform(get("/testHello").param("msg", "hello")).andReturn();
        ModelAndView model = result.getModelAndView();

        ModelAndViewAssert.assertViewName(model, "index");
        ModelAndViewAssert.assertModelAttributeValue(model, "msg", "hi");

    }

    @Test
    public void testTestEcho() throws Exception {
        //  走controller逻辑，spring自动构造参数
        MvcResult result = mockMvc.perform(get("/testEcho").param("msg", "hello")).andReturn();
        ModelAndView model = result.getModelAndView();
        ModelAndViewAssert.assertViewName(model, "index");
        ModelAndViewAssert.assertModelAttributeValue(model, "msg", "hello");
    }

    @Test
    public void testTestResponseBody() throws Exception {

    }

    @Test
    public void testTestReponseEntity() throws Exception {

    }
}