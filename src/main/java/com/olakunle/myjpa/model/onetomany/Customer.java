package com.olakunle.myjpa.model.onetomany;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Customer{

    @Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "customer_name")
    private String name;

    private String phone;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<ShoppingBasket> shoppingBasketList;

}
