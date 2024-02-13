package lk.dce.interview.service.custom.impl;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.dto.OrderDto;
import lk.dce.interview.dto.res.OrderResDto;
import lk.dce.interview.entity.Customer;
import lk.dce.interview.repository.custom.CustomerRepository;
import lk.dce.interview.service.custom.CustomerService;
import lk.dce.interview.service.util.Transformer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final Transformer transformer;

    public CustomerServiceImpl(CustomerRepository customerRepository, Transformer transformer) {
        this.customerRepository = customerRepository;
        this.transformer = transformer;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = transformer.fromCustomerDto(customerDto);
        Customer cus = customerRepository.save(customer);
        customerDto.setUserId(cus.getUserId());
        customerDto.setCreatedOn(cus.getCreatedOn());
        customerDto.setIsActive(cus.getIsActive());
        List<OrderResDto> orderDtoList = transformer.toOrderResDtoList(cus.getOrderList());
        customerDto.setOrderList(orderDtoList);
        return customerDto;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return transformer.toCustomerDtoList(customerList);
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Optional<Customer> optCustomer = customerRepository.findById(customerDto.getUserId());
        Customer customer;
        if(optCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No customers found for the given id");
        }else {
            customer = optCustomer.get();
            customer.setIsActive(customerDto.getIsActive());
            customer.setEmail(customerDto.getEmail());
            customer.setUserName(customerDto.getUserName());
            customer.setFirstName(customerDto.getFirstName());
            customer.setLastName(customerDto.getLastName());
            try {
                customerRepository.update(customer);
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }

    }

    @Override
    public void deleteCustomer(Integer id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        Customer customer;
        if(optCustomer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No customers found for the given id");
        }else {
            try {
                customerRepository.deleteById(id);
            }catch (Exception e){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
    }
}
