package jetbrick.samples.controller;

import jetbrick.ioc.annotation.Inject;
import jetbrick.web.mvc.Model;
import jetbrick.web.mvc.action.*;
import jetbrick.web.mvc.action.annotation.PathVariable;
import jetbrick.web.mvc.action.annotation.RequestForm;
import com.alibaba.fastjson.JSONAware;

@Controller(value = "/orders", singleton = true)
public class OrderController {
    @Inject
    private OrderService orderService;

    @Action("/")
    public String list(Model model) {
        model.put("orders", orderService.getOrders());
        return "index.jetx";
    }

    @Action("/{id}")
    public JSONAware get(@PathVariable("id") int id, Model model) {
        model.put("order", orderService.getOrder(id));
        return null;
    }

    @Action(method = HttpMethod.POST)
    public String add(@RequestForm OrderInfo order) {
        orderService.addOrder(order);
        return "redirect:/orders/";
    }

    @Action(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return "redirect:/orders/";
    }
}
