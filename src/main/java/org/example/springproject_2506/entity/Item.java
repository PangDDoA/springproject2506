package org.example.springproject_2506.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "items")  // 실제 DB 테이블명
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemNo;

    @Column(length = 100, nullable = false)
    @NotBlank
    private String itemName;

    @Column(nullable = false)
    @PositiveOrZero
    private int price;

    @Column(nullable = false)
    @PositiveOrZero
    private int inventory;

    @Column(length = 5000)
    private String info;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DisplayStatus displayStatus; // 판매중, 재고없음, 판매중지

    // 이미지 연관관계
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemImage> images = new ArrayList<>();

    // 주문 상세와의 연관관계
    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();
}
