package com.krishna9787.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="product_attributes")
public class ProductAttributes extends BaseEntity{

    @Id
//    @Column(name="attribute_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String attributeName;
}
