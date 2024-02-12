package lk.dce.interview.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerHttpController {

    @GetMapping
    public String getAllCustomers(){
        return "<h1>Customers</h1>";
    }
}
