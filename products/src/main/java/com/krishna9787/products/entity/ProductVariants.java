package com.krishna9787.products.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariants extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name="variant_id")
    private Long id;

//    @ManyToMany(mappedBy = "productVariants")
//    private List<Products> products;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="pricing_id", referencedColumnName = "id")
    private List<Pricing> pricings = new ArrayList<>();

    @Size(max=50)
    private String sku;

    private Double weight;

    private String barcode;
}
