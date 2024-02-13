package lk.dce.interview.api;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.service.custom.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerHttpController {

    private CustomerService customerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CustomerDto createNewCustomer(@RequestBody @Validated CustomerDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = "application/json")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{customer-id}", consumes = "application/json")
    public void updateCustomer(@PathVariable("customer-id") Integer customerId,
                                             @RequestBody @Validated CustomerDto customerDto) {
        customerDto.setUserId(customerId);
        customerService.updateCustomer(customerDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{customer-id}")
    public void deleteCustomer(@PathVariable("customer-id") Integer customerId) {
        customerService.deleteCustomer(customerId);
    }
}
