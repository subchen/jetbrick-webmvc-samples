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

import java.util.List;
import jetbrick.dao.orm.*;
import jetbrick.dao.orm.tx.Transaction;
import jetbrick.ioc.annotation.Inject;
import jetbrick.ioc.annotation.IocBean;

@IocBean
public class OrderDbService {
    @Inject
    private DbHelper dao;

    public List<OrderInfo> getOrders() {
        return dao.queryAsList(OrderInfo.class, "select * from order_info");
    }

    public Pagelist<OrderInfo> getOrders(PageInfo page) {
        return dao.queryAsPagelist(page, OrderInfo.class, "select * from order_info");
    }

    public OrderInfo getOrder(Integer id) {
        return dao.queryAsObject(OrderInfo.class, "select * from order_info where id=?", id);
    }

    public void addOrder(OrderInfo order) {
        dao.execute("insert into order_info values (:id, :serialno, :price, :purchaseDate)", order);
    }

    public void deleteOrder(final Integer id) {
        Transaction tx = dao.transaction();
        try {
            dao.execute("delete from order_item where order_id=?", id);
            dao.execute("delete from order_info where id=?", id);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            tx.close();
        }
    }

    public List<OrderItem> getOrderItems(Integer orderId) {
        return dao.queryAsList(OrderItem.class, "select * from order_item where order_id=?", orderId);
    }

    public OrderItem getOrderItem(Integer id) {
        return dao.queryAsObject(OrderItem.class, "select * from order_item where id=?", id);
    }
}
