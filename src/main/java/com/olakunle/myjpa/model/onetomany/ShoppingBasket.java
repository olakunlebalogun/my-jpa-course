package com.olakunle.myjpa.model.onetomany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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
