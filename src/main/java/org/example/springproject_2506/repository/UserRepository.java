package org.example.springproject_2506.repository;

import org.example.springproject_2506.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}