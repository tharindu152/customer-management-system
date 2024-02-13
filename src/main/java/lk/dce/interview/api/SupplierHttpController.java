package lk.dce.interview.api;

import lk.dce.interview.dto.SupplierDto;
import lk.dce.interview.service.custom.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suppliers")
@CrossOrigin
public class SupplierHttpController {

    @Autowired
    private SupplierService supplierService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public SupplierDto createNewProduct(@RequestBody @Validated SupplierDto supplierDto) {
        return supplierService.saveSupplier(supplierDto);
    }

}
