package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.onetomany.ShoppingBasket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Integer> {
}
