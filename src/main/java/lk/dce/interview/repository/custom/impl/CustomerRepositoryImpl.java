package lk.dce.interview.repository.custom.impl;

import lk.dce.interview.entity.Customer;
import lk.dce.interview.repository.CrudRepositoryImpl;
import lk.dce.interview.repository.custom.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl extends CrudRepositoryImpl<Customer, Integer> implements CustomerRepository {
}
