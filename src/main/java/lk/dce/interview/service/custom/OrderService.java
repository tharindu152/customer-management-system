package lk.dce.interview.service.custom;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.dto.OrderDto;
import lk.dce.interview.service.SuperService;

import java.util.List;

public interface OrderService extends SuperService {
    OrderDto saveOrder(OrderDto orderDto);
    List<CustomerDto> getActiveOrdersByCustomerId(Integer id);

}
