package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@IntegrationTest
@Controller
public class SimpleController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "s";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleController.class, args);
    }
}