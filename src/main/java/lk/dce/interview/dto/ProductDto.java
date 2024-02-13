package lk.dce.interview.dto;

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
    @Positive
    private BigDecimal unitPrice;
    @Null(message = "Created date is autogenerated")
    private LocalDateTime createdOn;
    private Boolean isActive;
    @NotNull(message = "Supplier Id must be provided to add the product")
    private Integer supplierId;
}
