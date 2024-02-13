package lk.dce.interview.api;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.dto.OrderDto;
import lk.dce.interview.dto.res.OrderResDto;
import lk.dce.interview.service.custom.CustomerService;
import lk.dce.interview.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin
public class OrderHttpController {

    @Autowired
    private OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public OrderDto createNewOrder(@RequestBody @Validated OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{customer-id}", produces = "application/json")
    public List<OrderResDto> getActiveOrdersByCustomerId(@PathVariable("customer-id") Integer customerId) {
        return orderService.getActiveOrdersByCustomerId(customerId);
    }

}
