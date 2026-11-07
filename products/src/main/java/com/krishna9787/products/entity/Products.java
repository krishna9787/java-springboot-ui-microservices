package com.krishna9787.products.entity;

import com.krishna9787.products.util.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String sku;

    @Column(name = "product_name")
    private String name;

    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="brand_id", referencedColumnName = "id")
    private Brands brandId;

    private double basePrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name="product_categories", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="category_id", referencedColumnName = "id"))
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Categories categoryId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_images_id", referencedColumnName = "id")
    private List<ProductImages> productImagesId = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="variant_id", referencedColumnName = "id")
    private List<ProductVariants> productVariants;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="discount_id", referencedColumnName = "id")
    private List<Discounts> discounts = new ArrayList<>();
}
