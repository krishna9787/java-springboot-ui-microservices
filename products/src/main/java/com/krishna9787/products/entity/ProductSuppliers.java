package com.krishna9787.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSuppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Products products;

    @OneToOne
    @JoinColumn(name="supplier_id", referencedColumnName = "id")
    private Suppliers suppliers;

    private double supplierPrice;
}
