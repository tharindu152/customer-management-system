package lk.dce.interview.service.custom.impl;

import lk.dce.interview.dto.SupplierDto;
import lk.dce.interview.service.custom.SupplierService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Override
    public SupplierDto saveSupplier(SupplierDto supplierDto) {
        return null;
    }
}
