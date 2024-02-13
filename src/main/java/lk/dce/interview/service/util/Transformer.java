package lk.dce.interview.service.util;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.dto.OrderDto;
import lk.dce.interview.dto.ProductDto;
import lk.dce.interview.dto.SupplierDto;
import lk.dce.interview.dto.res.OrderResDto;
import lk.dce.interview.dto.res.ProductResDto;
import lk.dce.interview.entity.Customer;
import lk.dce.interview.entity.Order;
import lk.dce.interview.entity.Product;
import lk.dce.interview.entity.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Transformer {

    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
        mapper.typeMap(Integer.class, Customer.class)
                .setConverter(ctx -> {
                    Customer customer = new Customer();
                    customer.setUserId(ctx.getSource());
                    return customer;
                });
    }

    public Customer fromCustomerDto(CustomerDto customerDto){
        Customer customer = mapper.map(customerDto, Customer.class);
        return customer;
    }

    public CustomerDto toCustomerDto(Customer customer){
        CustomerDto customerDto = mapper.map(customer, CustomerDto.class);
        return customerDto;
    }

    public List<CustomerDto> toCustomerDtoList(List<Customer> customerList) {
        return customerList.stream().map(this::toCustomerDto).collect(Collectors.toList());
    }

    public Order fromOrderDto(OrderDto orderDto){
        Order order = mapper.map(orderDto, Order.class);
        return order;
    }

    public OrderResDto toOrderResDto(Order order){
        OrderResDto orderResDto = mapper.map(order, OrderResDto.class);
        return orderResDto;
    }

    public List<OrderResDto> toOrderResDtoList(List<Order> orderList) {
        if(orderList != null){
            return orderList.stream().map(this::toOrderResDto).collect(Collectors.toList());
        }else {
            return Collections.emptyList();
        }
    }

    public Product fromProductDto(ProductDto productDto){
        Product product = mapper.map(productDto, Product.class);
        return product;
    }

    public ProductResDto toProductResDto(Product product){
        ProductResDto productResDto = mapper.map(product, ProductResDto.class);
        return productResDto;
    }

    public Supplier fromSupplierDto(SupplierDto supplierDto){
        Supplier supplier = mapper.map(supplierDto, Supplier.class);
        return supplier;
    }

    public SupplierDto toSupplierDto(Supplier supplier){
        SupplierDto supplierDto = mapper.map(supplier, SupplierDto.class);
        return supplierDto;
    }


}
