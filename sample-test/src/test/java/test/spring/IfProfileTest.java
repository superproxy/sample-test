package test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSource;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Hashtable;


@ProfileValueSourceConfiguration(IfProfileTest.TestProfileValueProvider.class)
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class IfProfileTest //extends AbstractTestNGSpringContextTests
{
    @Configuration
    public static class Config {
    }

    @Test
    @IfProfileValue(name = "java.vendor", value = "Sun Microsystems Inc")
    public void testProcessWhichRunsOnlyOnSunJvm() {
        System.out.println("sun.jvm");
    }

    @Test
    @IfProfileValue(name = "java.vendor", value = "open jdk")
    public void testProcessWhichRunsOnlyOnOpenJdk() {
        System.out.println("openjdk.jvm");
    }

    @Test
    @IfProfileValue(name = "java.vendor", values = {"Sun Microsystems Inc", "open jdk"})
    public void testProcessWhichRunsOnlyAll() {
        System.out.println("all.jvm");
    }


    public static class TestProfileValueProvider implements ProfileValueSource {

        private static Hashtable<String, String> properties = new Hashtable<String, String>();

        static {
            properties.put("java.vendor", "Sun Microsystems Inc");
        }

        public String get(String s) {
            return properties.get(s);
        }
    }

}
