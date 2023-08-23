package ru.werest.hibernatetask.dao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ORDERS", schema = "PUBLIC")
public class Order {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "date", nullable = false)
    private String name;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToOne(optional = false)
    private Customer customer;

}
