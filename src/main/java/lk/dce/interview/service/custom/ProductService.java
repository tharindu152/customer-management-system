package lk.dce.interview.service.custom;

import lk.dce.interview.dto.CustomerDto;
import lk.dce.interview.dto.ProductDto;
import lk.dce.interview.service.SuperService;

import java.util.List;

public interface ProductService extends SuperService {
    ProductDto saveProduct(ProductDto productDto);

}
