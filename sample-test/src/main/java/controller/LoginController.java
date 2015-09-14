package controller;

import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * @param validate
     * @param request
     * @return
     */
    @RequestMapping("/logon")
    public String logon(String userName, String password, String validate,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        ModelMap model = new ModelMap();
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);

        if (StringUtils.isEmpty(validate)) {
            model.put("message", "验证码不能为空");
            return "login";
        }

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            model.put("message", "用户名或密码不能为空");
            return "login";
        }

        User user;
        try {
            user = userService.queryUser(userName, password);
        } catch (Exception e) {
            return "error";
        }
        if (user != null) {
            return "index";
        } else {
            model.put("message", "用户名或密码不正确");
            return "login";
        }
    }
}