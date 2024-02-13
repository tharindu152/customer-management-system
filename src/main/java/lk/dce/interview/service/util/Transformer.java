package lk.dce.interview.service.util;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.dto.OrderDto;
import lk.dce.interview.dto.ProductDto;
import lk.dce.interview.dto.SupplierDto;
import lk.dce.interview.entity.Customer;
import lk.dce.interview.entity.Order;
import lk.dce.interview.entity.Product;
import lk.dce.interview.entity.Supplier;
import org.modelmapper.ModelMapper;

public class Transformer {

    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Customer fromCustomerDto(CustomerDto customerDto){
        Customer customer = mapper.map(customerDto, Customer.class);
        return customer;
    }

    public CustomerDto toCustomerDto(Customer customer){
        CustomerDto customerDto = mapper.map(customer, CustomerDto.class);
        return customerDto;
    }

    public Order fromOrderDto(OrderDto orderDto){
        Order order = mapper.map(orderDto, Order.class);
        return order;
    }

    public OrderDto toOrderDto(Order order){
        OrderDto orderDto = mapper.map(order, OrderDto.class);
        return orderDto;
    }

    public Product fromProductDto(ProductDto productDto){
        Product product = mapper.map(productDto, Product.class);
        return product;
    }

    public ProductDto toProductDto(Product product){
        ProductDto productDto = mapper.map(product, ProductDto.class);
        return productDto;
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
