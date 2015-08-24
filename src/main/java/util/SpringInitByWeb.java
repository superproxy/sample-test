package util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringInitByWeb implements ServletContextListener {
    private static WebApplicationContext springContext;

    public static ApplicationContext getApplicationContext() {
        return springContext;
    }

    public void contextInitialized(ServletContextEvent event) {
        springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
    }

    public void contextDestroyed(ServletContextEvent event) {
    }


}
