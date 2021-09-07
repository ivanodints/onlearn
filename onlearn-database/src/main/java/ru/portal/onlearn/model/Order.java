package ru.portal.onlearn.model;

import javax.persistence.*;


// базис под корзину

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToMany
}
