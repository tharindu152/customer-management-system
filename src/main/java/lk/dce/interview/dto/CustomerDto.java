package lk.dce.interview.dto;

import com.sun.istack.NotNull;
import lk.dce.interview.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable {
    @Null(message = "Id should be empty. It is auto generated")
    private Integer userId;
    @NotBlank(message = "User name can't be empty")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Invalid user name")
    private String userName;
    @NotBlank(message = "Email should not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email")
    private String email;
    @NotBlank(message = "First name can't be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid first name")
    private String firstName;
    @NotBlank(message = "Last name can't be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid last name")
    private String lastName;
    @Null(message = "Created date is autogenerated")
    private LocalDateTime createdOn;
    @NotBlank(message = "Active status can not be empty")
    @Pattern(regexp = "^(?i)(true|false)$", message = "Invalid boolean value")
    private Boolean isActive;
    @Null(message = "Order set should be empty. It is for the response only")
    private Set<OrderDto> orderSet;
}