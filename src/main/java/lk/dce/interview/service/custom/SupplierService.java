package lk.dce.interview.service.custom;

import lk.dce.interview.dto.SupplierDto;
import lk.dce.interview.service.SuperService;

import java.util.List;

public interface SupplierService extends SuperService {
    SupplierDto saveSupplier(SupplierDto supplierDto);
}
