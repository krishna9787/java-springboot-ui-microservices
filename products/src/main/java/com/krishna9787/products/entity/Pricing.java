package com.krishna9787.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pricing extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name="pricing_id")
    private Long id;

    private Double price;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
