package com.krishna9787.user.dto;

import com.krishna9787.user.entity.CustomerWishlist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerWishlistItemsDto {
    private CustomerWishlist wishlist;
    private Long productId;
}
