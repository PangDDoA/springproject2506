package org.example.springproject_2506.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_no")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_no")
    private Item item;

    @Column(nullable = false)
    @Min(1)
    private int quantity;

    @Column(nullable = false)
    private int unitPrice; // 주문 시점의 개당 가격
}
