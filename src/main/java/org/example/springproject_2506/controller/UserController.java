package org.example.springproject_2506.controller;

import lombok.RequiredArgsConstructor;
import org.example.springproject_2506.entity.User;
import org.example.springproject_2506.repository.UserRepository;
import org.example.springproject_2506.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 등록
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // 유저 한 명 조회
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 유저 전체 조회
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}