package test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotaionTest  //extends AbstractTestNGSpringContextTests
{

    @Configuration
    public static class Config {

        /**
         * 不起作用
         *
         * @return
         */
        @Bean
        @Scope("prototype")
        public List<String> list() {
            List<String> list = new ArrayList<String>();
            list.add("abc");
            return list;
        }

        @Bean(initMethod = "setup", destroyMethod = "cleanup")
        @Scope("prototype")
        public Course course() {
            return new Course();
        }
    }

    @Autowired(required = false)
    List<String> list;

    @Test
    public void test() {
        System.out.println(list.get(0));
    }


    @Autowired(required = false)
    Course course;

    @Test
    public void testCourse() {
        System.out.println(course.getName());
    }


}
