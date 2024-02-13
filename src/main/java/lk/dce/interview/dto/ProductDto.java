package lk.dce.interview.dto;

import lk.dce.interview.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {
    @Null(message = "Id should be empty. It is auto generated")
    private Integer productId;
    @NotBlank(message = "Product name can't be empty")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid product name")
    private String productName;
    @NotBlank
    @Positive
    private BigDecimal unitPrice;
    @Null(message = "Created date is autogenerated")
    private LocalDateTime createdOn;
    @Column(nullable = false, name = "is_active")
    private Boolean isActive;
    @Null(message = "Supplier should be empty. It is for the response only")
    private SupplierDto supplier;
}