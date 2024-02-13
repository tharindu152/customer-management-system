package lk.dce.interview.service.custom.impl;

import lk.dce.interview.dto.ProductDto;
import lk.dce.interview.service.custom.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return null;
    }
}
