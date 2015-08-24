package controller;

import model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {

    @RequestMapping("/order/create")
    public String addOrder(Model model, String item, HttpServletRequest request) {
        Object order = request.getSession().getAttribute("order");
        if (order == null) {
            order = new Order();
            request.getSession().setAttribute("order", order);
        }
        ((Order) order).addItem(item);
        return "order/index";
    }


    /**
     * 界面
     *
     * @return
     */
    @RequestMapping("/order/")
    public String index() {
        return "order/index";
    }


    /**
     * 界面
     *
     * @return
     */
    @RequestMapping("/order/add")
    public String add() {
        return "order/add";
    }
}
