package lk.dce.interview.dto;

import lk.dce.interview.entity.Customer;
import lk.dce.interview.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {
    @Null(message = "Id should be empty. It is auto generated")
    private Integer orderId;
    @NotNull(message = "Order status can not be empty")
    @PositiveOrZero(message = "Invalid order status")
    private Integer orderStatus;
    @NotNull(message = "Order type can not be empty")
    @PositiveOrZero(message = "Invalid order type")
    private Integer orderType;
    @Null(message = "Ordered date is autogenerated")
    private LocalDateTime orderedOn;
    @Null(message = "Shipped date is autogenerated")
    private LocalDateTime shippedOn;
    @NotBlank(message = "Active status should not be empty")
    @Pattern(regexp = "^(?i)(true|false)$", message = "Invalid boolean value")
    private Boolean isActive;
    @Null(message = "Product should be empty. It is for the response only")
    private ProductDto product;

}
