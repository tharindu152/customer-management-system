package lk.dce.interview.repository.custom;

import lk.dce.interview.entity.Order;
import lk.dce.interview.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findActiveOrdersByCustomerID(Integer id);
}
