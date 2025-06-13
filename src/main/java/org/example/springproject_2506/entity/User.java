package org.example.springproject_2506.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")  // 실제 DB 테이블명
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(length = 20, nullable = false, unique = true)
    @NotBlank
    @Size(min = 10, max = 20)
    private String userId;

    @Column(length = 20, nullable = false)
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role; // 예: USER, ADMIN

    // 주문과의 연관관계
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();
}