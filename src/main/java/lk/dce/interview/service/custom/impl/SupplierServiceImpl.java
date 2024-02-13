package lk.dce.interview.service.custom.impl;

import lk.dce.interview.dto.ProductDto;
import lk.dce.interview.dto.SupplierDto;
import lk.dce.interview.entity.Supplier;
import lk.dce.interview.repository.custom.SupplierRepository;
import lk.dce.interview.service.custom.SupplierService;
import lk.dce.interview.service.util.Transformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final Transformer transformer;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Transformer transformer) {
        this.supplierRepository = supplierRepository;
        this.transformer = transformer;
    }


    @Override
    public SupplierDto saveSupplier(SupplierDto supplierDto) {
        Supplier supplier = transformer.fromSupplierDto(supplierDto);
        Supplier sup = supplierRepository.save(supplier);
        supplierDto.setSupplierId(sup.getSupplierId());
        supplierDto.setCreatedOn(sup.getCreatedOn());
        supplierDto.setIsActive(sup.getIsActive());
        return supplierDto;
    }
}
