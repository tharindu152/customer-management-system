package lk.dce.interview.service.custom.impl;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.repository.custom.CustomerRepository;
import lk.dce.interview.service.custom.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {

        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return null;
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {

    }

    @Override
    public void deleteCustomer(CustomerDto customerDto) {

    }
}
