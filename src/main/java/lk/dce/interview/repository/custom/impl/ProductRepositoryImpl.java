package lk.dce.interview.repository.custom.impl;

import lk.dce.interview.entity.Product;
import lk.dce.interview.repository.CrudRepositoryImpl;
import lk.dce.interview.repository.custom.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends CrudRepositoryImpl<Product, Integer> implements ProductRepository {
}
