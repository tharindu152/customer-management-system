package lk.dce.interview.repository.custom.impl;

import lk.dce.interview.entity.Order;
import lk.dce.interview.repository.CrudRepositoryImpl;
import lk.dce.interview.repository.custom.OrderRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public class OrderRepositoryImpl extends CrudRepositoryImpl<Order, Integer> implements OrderRepository {

    @Override
    public List<Order> findActiveOrdersByCustomerID(@Param("cusId") Integer id) {
        return getEntityManager().createNativeQuery("SELECT * FROM order o INNER JOIN customer c ON o.order_by = c.user_id WHERE o.is_active = true AND c.user_id = :cusID", Order.class).getResultList();
    }
}