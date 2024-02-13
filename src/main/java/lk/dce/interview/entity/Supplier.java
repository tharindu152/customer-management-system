package lk.dce.interview.entity;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(nullable = false, length = 50, name = "supplier_name")
    private String supplierName;
    @Column(name = "created_on", updatable = false, nullable = false)
    private LocalDateTime createdOn;
    @Column(nullable = false, name = "is_active")
    private Boolean isActive;

    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "supplier")
    private Set<Product> productSet;

    public Supplier(String supplierName, LocalDateTime createdOn, boolean isActive) {
        this.supplierName = supplierName;
        this.createdOn = createdOn;
        this.isActive = isActive;
    }

    public void addProduct(Product product){
        productSet.add(product);
        product.setSupplier(this);
    }

    public void removeProduct(Product product){
        throw new RuntimeException("Unsupported Operation");
    }

    @PrePersist
    protected void onCreate(){
        this.createdOn = LocalDateTime.now();
    }
}
