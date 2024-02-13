package lk.dce.interview.repository.custom.impl;

import lk.dce.interview.entity.Customer;
import lk.dce.interview.entity.Product;
import lk.dce.interview.repository.CrudRepositoryImpl;
import lk.dce.interview.repository.custom.CustomerRepository;
import lk.dce.interview.repository.custom.ProductRepository;

public class ProductRepositoryImpl extends CrudRepositoryImpl<Product, Integer> implements ProductRepository {
}
