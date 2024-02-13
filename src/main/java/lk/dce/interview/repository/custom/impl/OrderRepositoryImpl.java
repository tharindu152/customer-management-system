package lk.dce.interview.repository.custom.impl;

import lk.dce.interview.entity.Order;
import lk.dce.interview.repository.CrudRepositoryImpl;
import lk.dce.interview.repository.custom.OrderRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class OrderRepositoryImpl extends CrudRepositoryImpl<Order, Integer> implements OrderRepository {

    @Override
    public List<Order> findActiveOrdersByCustomerID(Integer cusId) {
        return getEntityManager().createNativeQuery("SELECT o.order_id, p.product_name ,o.is_active, c.user_name FROM `order` o INNER JOIN customer c on o.order_by = c.user_id INNER JOIN product p on o.product_id = p.product_id WHERE o.is_active = true AND c.user_id = " + cusId.toString(), Order.class).getResultList();
    }
}
