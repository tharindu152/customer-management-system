package lk.dce.interview.service.custom.impl;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.dto.OrderDto;
import lk.dce.interview.service.custom.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public List<CustomerDto> getActiveOrdersByCustomerId(Integer id) {
        return null;
    }
}
