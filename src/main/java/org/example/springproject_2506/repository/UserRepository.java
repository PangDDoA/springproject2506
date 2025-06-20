package org.example.springproject_2506.repository;

import org.example.springproject_2506.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
} // JpaRepository 를 상속받으면서 자동으로 CRDU가 작성됐기 떄문에 해당

// 코드는 다 작성함.