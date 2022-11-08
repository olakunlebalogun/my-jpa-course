package com.olakunle.myjpa.repository;

import com.olakunle.myjpa.model.onetomany.ShoppingBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Integer> {
}
