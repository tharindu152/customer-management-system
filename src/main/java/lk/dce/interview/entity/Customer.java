package lk.dce.interview.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(nullable = false, length = 30, name = "user_name")
    private String userName;
    @Column(nullable = false, length = 20)
    private String email;
    @Column(nullable = false, length = 20, name = "first_name")
    private String firstName;
    @Column(nullable = false, length = 20, name = "last_name")
    private String lastName;
    @Column(name = "created_on", updatable = false, nullable = false)
    private LocalDateTime createdOn;
    @Column(nullable = false, name = "is_active")
    private boolean isActive;

    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "customer")
    private Set<Order> orderSet;

    public Customer(String userName, String email, String firstName, String lastName, LocalDateTime createdOn, boolean isActive) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdOn = createdOn;
        this.isActive = isActive;
    }

    public void addOrder(Order order){
        orderSet.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(Order order){
        throw new RuntimeException("Unsupported Operation");
    }

    @PrePersist
    protected void onCreate(){
        this.createdOn = LocalDateTime.now();
    }
}
