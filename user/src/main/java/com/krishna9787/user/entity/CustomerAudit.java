package com.krishna9787.user.entity;

import com.krishna9787.user.util.ActionEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerAudit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customers customer;

    private ActionEnum action;

    private String fieldName;
    private String oldValue;
    private String newValue;

}
