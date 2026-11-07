package com.krishna9787.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerWishlistItems extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "wishlist_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id")
    private CustomerWishlist wishlist;

    private Long productId;
}
