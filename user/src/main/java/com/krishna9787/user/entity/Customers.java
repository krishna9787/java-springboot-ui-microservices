package com.krishna9787.user.entity;

import java.time.LocalDate;

import com.krishna9787.user.util.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customers extends BaseEntity {

    @Id
    @Column(name = "customer_id")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    private LocalDate dateOfBirth;
    private String profileImageUrl;

    @Column(columnDefinition = "varchar(255) default '0'")
    private Integer loyaltyPoints;

    @Enumerated(value = jakarta.persistence.EnumType.STRING)
    private StatusEnum status;
}
