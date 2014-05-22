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

import java.util.*;
import java.util.Map.Entry;
import jetbrick.ioc.annotations.IocBean;
import jetbrick.template.utils.DateUtils;

@IocBean
public class OrderService {
    private final Map<Integer, OrderInfo> orders = new TreeMap<Integer, OrderInfo>();
    private final Map<Integer, OrderItem> orderItems = new TreeMap<Integer, OrderItem>();

    public OrderService() {
        addOrder(new OrderInfo(101, "A-0458-1726", 82.91, DateUtils.asDate("2013-05-16 12:00:09")));
        addOrder(new OrderInfo(102, "A-9478-3456", 48.81, DateUtils.asDate("2013-05-17 13:00:08")));
        addOrder(new OrderInfo(103, "A-0384-0958", 18.83, DateUtils.asDate("2013-05-18 14:00:07")));
        addOrder(new OrderInfo(104, "A-8472-8092", 30.47, DateUtils.asDate("2013-05-17 15:00:06")));
        addOrder(new OrderInfo(105, "A-1267-6932", 19.98, DateUtils.asDate("2013-05-16 16:00:05")));

        addOrderItem(new OrderItem(9101, 101, "Despicable Me 2 ", 19.98));
        addOrderItem(new OrderItem(9102, 101, "The Hunger Games: Catching Fire", 29.95));
        addOrderItem(new OrderItem(9103, 101, "Saving Mr. Banks", 17.99));
        addOrderItem(new OrderItem(9104, 101, "The Hobbit: The Desolation of Smaug", 14.99));
        addOrderItem(new OrderItem(9105, 102, "Thor: The Dark World", 18.83));
        addOrderItem(new OrderItem(9106, 102, "Despicable Me 2 ", 19.98));
        addOrderItem(new OrderItem(9107, 102, "The Veronica Mars Movie ", 10.00));
        addOrderItem(new OrderItem(9108, 103, "Thor: The Dark World", 18.83));
        addOrderItem(new OrderItem(9109, 104, "Despicable Me (Single-Disc Edition) ", 10.49));
        addOrderItem(new OrderItem(9110, 104, "Despicable Me 2 ", 19.98));
        addOrderItem(new OrderItem(9111, 105, "Despicable Me 2 ", 19.98));
    }

    public List<OrderInfo> getOrders() {
        return new ArrayList<OrderInfo>(orders.values());
    }

    public OrderInfo getOrder(Integer id) {
        return orders.get(id);
    }

    public void addOrder(OrderInfo order) {
        orders.put(order.getId(), order);
    }

    public void deleteOrder(Integer id) {
        orders.remove(id);

        Iterator<Entry<Integer, OrderItem>> it = orderItems.entrySet().iterator();
        while (it.hasNext()) {
            OrderItem item = it.next().getValue();
            if (item.getOrderId().equals(id)) {
                it.remove();
            }
        }
    }

    public List<OrderItem> getOrderItems(Integer orderId) {
        List<OrderItem> items = new ArrayList<OrderItem>();
        for (OrderItem item : orderItems.values()) {
            if (item.getOrderId().equals(orderId)) {
                items.add(item);
            }
        }
        return items;
    }

    public OrderItem getOrderItem(Integer id) {
        return orderItems.get(id);
    }

    public void addOrderItem(OrderItem item) {
        orderItems.put(item.getId(), item);
    }

    public void deleteOrderItem(Integer id) {
        orderItems.remove(id);
    }
}
