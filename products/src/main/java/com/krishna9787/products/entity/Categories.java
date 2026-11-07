package com.krishna9787.products.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categories extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name="category_id")
    private Long id;

    private int parentCategoryId;

    @Column(unique = true, nullable = false)
    private String categoryName;
}
