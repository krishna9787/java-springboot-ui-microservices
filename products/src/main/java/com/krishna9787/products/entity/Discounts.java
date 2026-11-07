package com.krishna9787.products.entity;

import com.krishna9787.products.util.DiscountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="Discounts")
public class Discounts extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name="discount_id")
    private Long id;

    private String discountName;

    @Column(name="discount_value")
    private Double discountValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type", nullable = false)
    private DiscountType discountType;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

//    @ManyToMany(mappedBy = "discounts")
//    private List<Products> products = new ArrayList<>();
}
