package lk.dce.interview.api;

import lk.dce.interview.dto.OrderDto;
import lk.dce.interview.dto.ProductDto;
import lk.dce.interview.service.custom.OrderService;
import lk.dce.interview.service.custom.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductHttpController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ProductDto createNewProduct(@RequestBody @Validated ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

}
