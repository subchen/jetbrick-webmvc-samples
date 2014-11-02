/**
 * Copyright 2013-2014 Guoqiang Chen, Shanghai, China. All rights reserved.
 *
 * Email: subchen@gmail.com
 * URL: http://subchen.github.io/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrick.samples.order;

import jetbrick.ioc.annotation.Inject;
import jetbrick.web.mvc.Model;
import jetbrick.web.mvc.action.*;
import jetbrick.web.mvc.action.annotation.PathVariable;
import jetbrick.web.mvc.action.annotation.RequestForm;
import com.alibaba.fastjson.JSONAware;

@Controller(value = "/orders", singleton = true)
public class OrderController {
    @Inject
    private OrderDbService orderService;

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
