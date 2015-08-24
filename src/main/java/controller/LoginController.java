package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆服务
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录验证
     *
     * @param userName
     * @param password
     * @param answer
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/logon")
    public String logon(String userName, String password, String answer,
                        String target, HttpServletRequest request,
                        HttpServletResponse response, ModelMap model) {
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);

        HttpSession session = request.getSession();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            model.put("message", "用户名或密码不能为空");
            model.put("target", target); // 跳转页面
            return "login";
        }
        if (StringUtils.isEmpty(answer)) {
            model.put("message", "验证码不能为空");
            model.put("target", target); // 跳转页面
            return "login";
        }

        User user = userService.login(userName, password);
        if (user != null) {

            if (StringUtils.isEmpty(target)) {
                return "index";
            }
        } else {
            model.put("message", "用户名或密码不正确");
            model.put("target", target); // 跳转页面
            return "login";
        }
        return "";
    }
}