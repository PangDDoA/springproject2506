package org.example.springproject_2506.service;

import lombok.RequiredArgsConstructor;
import org.example.springproject_2506.entity.Order;
import org.example.springproject_2506.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // 주문 저장
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // 주문 전체 조회
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 주문 ID로 조회
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // 주문 삭제
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
