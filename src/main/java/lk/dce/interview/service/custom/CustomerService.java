package lk.dce.interview.service.custom;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService {
    CustomerDto saveCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomers();
    void updateCustomer(CustomerDto customerDto);
    void deleteCustomer(CustomerDto customerDto);

}
