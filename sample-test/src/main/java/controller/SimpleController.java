package controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class SimpleController {

    @RequestMapping(value = "/testModelAndView", method = RequestMethod.GET)
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView("test2");
        modelAndView.addObject("ss");
        return modelAndView;
    }

    @RequestMapping(value = "/testVoid", method = RequestMethod.GET)
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            PrintWriter writer = response.getWriter();
            writer.write("hello");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/testHello", method = RequestMethod.GET)
    public String testHello(String msg, Model model) {
        model.addAttribute("msg", "hi");
        return "index";
    }

    @RequestMapping(value = "/testEcho", method = RequestMethod.GET)
    public String testEcho(String msg, ModelMap model) {
        model.addAttribute("msg", msg);
        return "index";
    }


    @RequestMapping(value = "/testResponseBody", method = RequestMethod.GET)
    @ResponseBody
    public String testResponseBody() {
        return "{json:\"abc\"}";
    }

    @RequestMapping(value = "/testReponseEntity", method = RequestMethod.GET)
    public ResponseEntity<String> testReponseEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/plain",
                headers, HttpStatus.OK);
    }


}
