package lk.dce.interview.repository.custom.impl;

import lk.dce.interview.entity.Customer;
import lk.dce.interview.entity.Supplier;
import lk.dce.interview.repository.CrudRepositoryImpl;
import lk.dce.interview.repository.custom.CustomerRepository;
import lk.dce.interview.repository.custom.SupplierRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierRepositoryImpl extends CrudRepositoryImpl<Supplier, Integer> implements SupplierRepository {
}
