package lk.dce.interview.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")
public class Order implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_status", nullable = false)
    private Integer orderStatus;
    @Column(name = "order_type", nullable = false)
    private Integer orderType;
    @Column(name = "ordered_on", updatable = false, nullable = false)
    private LocalDateTime orderedOn;
    @Column(name = "shipped_on", updatable = false, nullable = false)
    private LocalDateTime shippedOn;
    @Column(nullable = false, name = "is_active")
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "order_by", referencedColumnName = "user_id", nullable = false)
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, unique = true)
    private Product product;


    @PrePersist
    protected void onCreate(){
        this.orderedOn = LocalDateTime.now();
        //For testing purposes shipped date is entered as two days after the order
        this.shippedOn = LocalDateTime.now().plusDays(2);
    }
}
