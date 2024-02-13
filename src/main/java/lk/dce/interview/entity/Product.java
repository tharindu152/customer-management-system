package lk.dce.interview.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Column(nullable = false, length = 50, name = "product_name")
    private String productName;
    @Column(nullable = false, name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "created_on", updatable = false, nullable = false)
    private LocalDateTime createdOn;
    @Column(nullable = false, name = "is_active")
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id", nullable = false)
    private Supplier supplier;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    @OneToOne(mappedBy = "product")
    private Order order;

    public Product(String productName, BigDecimal unitPrice, LocalDateTime createdOn, boolean isActive, Supplier supplier) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.createdOn = createdOn;
        this.isActive = isActive;
        this.supplier = supplier;
    }

    @PrePersist
    protected void onCreate(){
        this.createdOn = LocalDateTime.now();
    }
}
