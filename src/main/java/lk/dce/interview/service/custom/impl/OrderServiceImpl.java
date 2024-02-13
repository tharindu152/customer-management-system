package lk.dce.interview.service.custom.impl;

import lk.dce.interview.dto.OrderDto;
import lk.dce.interview.dto.res.OrderResDto;
import lk.dce.interview.entity.Customer;
import lk.dce.interview.entity.Order;
import lk.dce.interview.repository.custom.CustomerRepository;
import lk.dce.interview.repository.custom.OrderRepository;
import lk.dce.interview.service.custom.OrderService;
import lk.dce.interview.service.util.Transformer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final Transformer transformer;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, Transformer transformer) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.transformer = transformer;
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        Order order = transformer.fromOrderDto(orderDto);
        System.out.println(orderDto);
        System.out.println(order);
        Order o = orderRepository.save(order);
        orderDto.setOrderId(o.getOrderId());
        orderDto.setOrderedOn(o.getOrderedOn());
        orderDto.setShippedOn(o.getShippedOn());
        return orderDto;
    }

    @Override
    public List<OrderResDto> getActiveOrdersByCustomerId(Integer id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        List<OrderResDto> activeOrderDtoList;
        if(optCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No customers found for the given id");
        }else {
            try {
                System.out.println(id);
                List<Order> activeOrderList = orderRepository.findActiveOrdersByCustomerID(id);
                System.out.println(activeOrderList);
                activeOrderDtoList = transformer.toOrderResDtoList(activeOrderList);
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
        return activeOrderDtoList;
    }
}
