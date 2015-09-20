package app;

import controller.SimpleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import service.BaseTest;

@EnableAutoConfiguration
//@ImportXml("classpath:sbeans.xml")
//@SpringApplicationConfiguration(classes = {HomeController.class, LoginController.class})
@SpringApplicationConfiguration(classes = {SimpleController.class})
@WebAppConfiguration
@WebIntegrationTest
@Test
public class AppTest extends BaseTest {

//    /**
//     * 定制 EmbeddedServletContainerFactory
//     *
//     * @return
//     */
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//        factory.setPort(9000);
//        factory.setSessionTimeout(10, TimeUnit.MINUTES);
////        factory.addErrorPages(new ErrorPage(HttpStatus.404, "/notfound.html"));
//        return factory;
//    }

    public static void main(String[] args) {
        // 必须是注解的类
//        Caused by: org.springframework.context.ApplicationContextException:
// Unable to start EmbeddedWebApplicationContext due to missing EmbeddedServletContainerFactory bean.
        SpringApplication.run(AppTest.class, args);
    }
}