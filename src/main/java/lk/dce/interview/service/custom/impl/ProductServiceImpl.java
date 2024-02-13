package lk.dce.interview.service.custom.impl;

import lk.dce.interview.dto.ProductDto;
import lk.dce.interview.entity.Product;
import lk.dce.interview.repository.custom.ProductRepository;
import lk.dce.interview.service.custom.ProductService;
import lk.dce.interview.service.util.Transformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Transformer transformer;

    public ProductServiceImpl(ProductRepository productRepository, Transformer transformer) {
        this.productRepository = productRepository;
        this.transformer = transformer;
    }


    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = transformer.fromProductDto(productDto);
        Product pdt = productRepository.save(product);
        productDto.setProductId(pdt.getProductId());
        productDto.setCreatedOn(pdt.getCreatedOn());
        return productDto;
    }
}
