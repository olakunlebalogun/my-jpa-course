package com.olakunle.myjpa.model.onetomany;

import javax.persistence.*;

@Entity
public class ShoppingBasket {
// id, customerEmail

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
//    @Column(name = "customer_email")
    @ManyToOne
    @JoinColumn(name="customer_email")
    private Customer customer;


}
